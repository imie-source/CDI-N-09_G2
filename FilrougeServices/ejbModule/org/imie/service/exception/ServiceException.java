/**
 * 
 */
package org.imie.service.exception;

/**
 * @author imie
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1454058303280162512L;

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}

}
