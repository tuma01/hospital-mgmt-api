package com.amachi.app.hospitalappservice.common.util;

import lombok.Getter;

@Getter
public enum ConsultationStatutEnum {
	
	EMERGENCY("Emergency consultation"),
	EXTERNAL("External consultation"),
	GENERAL("General consultation");

	public final String label;

	ConsultationStatutEnum(String label) {
		this.label = label;
	}
}
