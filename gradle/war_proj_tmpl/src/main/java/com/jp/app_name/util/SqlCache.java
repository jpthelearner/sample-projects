package com.jp.app_name.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SqlCache {

	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SqlCache.class);	

	private static HashMap<String, String> sqlCache = new HashMap<String, String>();

	public static String getSQL(String sqlFile){
		log.trace("getSQL: file name - "+sqlFile);
		String query = null;
		query = sqlCache.get(sqlFile);
		if(query == null){
			query =  readFile(sqlFile);
		}
		return query;
	}

	private static String readFile(String sqlFile){
		InputStream in = null;
		BufferedReader buffRead = null;
		String query = null;
		log.trace("readFile : file name - "+sqlFile);
		try{
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(sqlFile+".sql");
			buffRead = new BufferedReader(new InputStreamReader(in));
			StringBuffer sb = new StringBuffer();
			while(true){
				String line = buffRead.readLine();
				if(line == null)
					break;
				sb.append(" "+line);
			}
			query = sb.toString(); 
		}catch(Exception iex){
			log.error("Problem while parsing file "+File.separator+sqlFile,iex);
		}
		finally{
			if(buffRead != null) {
				try{
					buffRead.close();
					in.close();
				}catch(Exception clex){
					log.error("Problem while closing the stream",clex);
				}
			}
		}
		
		log.trace("the query is "+query);
		sqlCache.put(sqlFile,query);
		return query;
	}	
	
	public static void flush(){
		sqlCache = new HashMap<String, String>();
	}
}
