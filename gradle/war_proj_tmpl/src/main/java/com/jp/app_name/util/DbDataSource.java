package com.jp.app_name.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

public class DbDataSource {
	private static final boolean connectionModeTomcatDs = true;
	private static final Logger log = Logger.getLogger(DbDataSource.class);

	public static DataSource getFromTomcatDs(String jndiName) throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup(jndiName);
		return ds;
	}	

	/**
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {
			log.error("Error while closing resultset", e);
		}
		try {
			if(ps != null) ps.close();
		} catch (Exception e) {
			log.error("Error while closing prepared statement", e);
		}
		try {
			if(conn != null) conn.close();
		} catch (Exception e) {
			log.error("Error while closing DB connections", e);
		}		
	}

	public static void closeConnectionWithCs(Connection conn, CallableStatement cs, ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {
			log.error("Error while closing resultset", e);
		}
		try {
			if(cs != null) cs.close();
		} catch (Exception e) {
			log.error("Error while closing prepared statement", e);
		}
		try {
			if(conn != null) conn.close();
		} catch (Exception e) {
			log.error("Error while closing DB connections", e);
		}		
	}	
	
	public static DataSource getMyDataSource() {
		DataSource conn = null;
		try {
			log.trace("Method entry - getDataSource()");
			if(connectionModeTomcatDs)
				conn = getFromTomcatDs("jdbc/mydb");
			else
				conn = getDataSource("jdbc:oracle:thin:@<db.server>:<db.port>:<db.sid>","<db.user>", "<db.password>"
						,"<db.driver>");
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return conn;
	}
		
	private static DataSource getDataSource(String url, String username, String password, String className) {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(url);
		ds.setDriverClassName(className);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

}
