package com.dataflue.cip.commons.exception;

/**
 * Helper class for implementing exception classes which are capable of
 * holding nested exceptions. Necessary because we can't share a base
 * class among different exception types.
 *
 * <p>Mainly for use within the framework.
 *
 * @author vishnu sankar
 * @since 2.0
 * @see NestedRuntimeException
 * @see NestedCheckedException
 * @see NestedIOException
 * @see org.springframework.web.util.NestedServletException
 */
public abstract class NestedExceptionUtils implements IExceptionStatus{

	/**
	 * Build a message for the given base message and root cause.
	 * @param message the base message
	 * @param cause the root cause
	 * @return the full exception message
	 */
	public static String buildMessage(String message, Throwable cause ,String errorCode) {
		if (cause != null) {
			StringBuffer buf = new StringBuffer();
			if (message != null) {
				
				buf.append(DATAFLUE_ERR+errorCode);
				buf.append(message).append(DATAFLUE_ERR_STACK);
			}
			buf.append(DATAFLUE_ERR_NESTED_EXP).append(cause);
			return buf.toString();
		}
		else {
			return message;
		}
	}
}