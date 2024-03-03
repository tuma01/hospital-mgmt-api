package com.amachi.app.hospitalappservice.common.util;

import lombok.Getter;

@Getter
public enum StatusEnum {
	
	ACTIVE("Active"),
	INACTIVE("Inactive"),
	PENDING("Pending"),
	DELETED("Deleted");

	public final String label;

	StatusEnum(String label) {
		this.label = label;
	}

}
