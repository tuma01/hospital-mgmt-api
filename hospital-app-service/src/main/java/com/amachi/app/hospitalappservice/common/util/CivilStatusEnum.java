package com.amachi.app.hospitalappservice.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//@AllArgsConstructor
public enum CivilStatusEnum {
	
	SOLTERO("Soltero/a"),
	CASADO("Casado/a"),
	UNION_LIBRE("Unión libre o unión de hecho"),
	SEPARADO("Separado/a"),
	DIVORCIADO("Divorciado/a"),
	VIUDO("Viudo/a");
	
	public final String label;
	CivilStatusEnum(String label) {
		this.label = label;
	}

}
