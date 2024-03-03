package com.amachi.app.hospitalappservice.common.util;

public interface I18nEnum {
	default String getMessageKey(Enum<?> e) {
		return e.getClass().getSimpleName() + "." + e.name().toLowerCase();
	}
}
