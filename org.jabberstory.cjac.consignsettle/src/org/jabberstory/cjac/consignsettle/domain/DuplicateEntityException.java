package org.jabberstory.cjac.consignsettle.domain;

@SuppressWarnings("serial")
public class DuplicateEntityException extends Exception {

	public DuplicateEntityException() {
		super();
	}
	
	public DuplicateEntityException(String message) {
		super(message);
	}

}
