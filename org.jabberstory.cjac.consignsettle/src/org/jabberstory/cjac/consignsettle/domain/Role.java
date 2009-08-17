package org.jabberstory.cjac.consignsettle.domain;

public class Role {
	public static final Role ADMIN_ROLE = new Role("admin");
	
	private String name;
	
	public Role() {
	}
	
	public Role(String name) {
		this.setName(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
