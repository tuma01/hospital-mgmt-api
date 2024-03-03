package com.amachi.app.hospitalappservice.common.util;

import lombok.Getter;

@Getter
public enum ConsultationTypeEnum {

	EMERGENCY("Emergency consultation"),
	EXTERNAL("External consultation"),
	GENERAL("General consultation");

	public final String label;

    ConsultationTypeEnum(String label) {
		this.label = label;
    }

}
