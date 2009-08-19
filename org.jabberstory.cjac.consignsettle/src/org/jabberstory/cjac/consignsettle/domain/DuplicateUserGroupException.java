package org.jabberstory.cjac.consignsettle.domain;

@SuppressWarnings("serial")
public class DuplicateUserGroupException extends Exception {

	public DuplicateUserGroupException() {
		super();
	}
	
	public DuplicateUserGroupException(String message) {
		super(message);
	}

}
