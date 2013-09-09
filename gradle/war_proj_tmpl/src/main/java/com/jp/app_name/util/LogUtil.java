package com.jp.app_name.util;

import java.util.Hashtable;

import org.apache.log4j.MDC;


public class LogUtil {

	private static Hashtable<String, LogContext> identity = new Hashtable<String, LogContext>();
	private static LogUtil instance = null;

	private LogUtil() { // private constructor for Singleton
	}

	public static LogUtil getInstance() {
		if (instance == null) {
			instance = new LogUtil();
		}
		return instance;
	}

	public static LogContext getIdentity() {
		String threadName = Thread.currentThread().getName();
		return (LogContext) identity.get(threadName);
	}

	public void initLogContext(LogContext newLogContext) {
		LogContext logContext = getIdentity();
		if (logContext != null) {
			newLogContext.setAccountNumber(logContext.getAccountNumber());
			newLogContext.setUserId(logContext.getUserId());
		}
		updateMdc(newLogContext);
	}

	public void initLogContext(String userId, String accountNumber) {
		LogContext logContext = getIdentity();
		if(logContext == null) {
			logContext = new LogContext();
		}
		logContext.setAccountNumber(accountNumber);
		logContext.setUserId(userId);
		updateMdc(logContext);
	}

	private void updateMdc(LogContext logContext) {
		putInMdc("ACCOUNT_NUMBER", String.valueOf(logContext.getAccountNumber()));
		putInMdc("USER_ID", String.valueOf(logContext.getUserId()));
	}

	private void putInMdc(String key, String value) {
		if (value != null) {
			MDC.put(key, value);
		} else {
			MDC.put(key, "");
		}
	}
}