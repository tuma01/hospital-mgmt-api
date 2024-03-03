package com.amachi.app.hospitalappservice.common.util;

import com.amachi.app.hospitalappservice.config.Translator;
import com.amachi.app.hospitalappservice.util.AppConstants;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Error {

//	UNHANDLED_ERROR("00000", "[%s]"),
//	OBJECT_NOT_FOUND("00001", "Objet non trouvé [%s]"),
//	OBJECT_ALREADY_EXIST("00002", "Objet existe déjà [%s]"),
//	OBJECT_NULL_RECEIVED("00003", "Objet recu null [%s]"),
//	FEDE_NOT_VALID_ERROR("00004", "Le code federation est invalide[%s]");

	HEADER_MISSING("HEADER_MISSING",Translator.toLocale(AppConstants.HEADER_MISSING, null), HttpStatus.BAD_REQUEST, "R_HAS_001"),
	HEADER_FORMAT_ERROR("HEADER_FORMAT_ERROR", Translator.toLocale(AppConstants.HEADER_FORMAT_ERROR, null), HttpStatus.BAD_REQUEST, "R_HAS_002"),
	ACCEPT_VERSION_NOT_SUPPORTED("ACCEPT_VERSION_NOT_SUPPORTED", Translator.toLocale(AppConstants.ACCEPT_VERSION_NOT_SUPPORTED, null), HttpStatus.NOT_ACCEPTABLE, "R_HAS_003"),
	ACCEPT_NOT_SUPPORTED("ACCEPT_NOT_SUPPORTED", Translator.toLocale(AppConstants.ACCEPT_NOT_SUPPORTED, null), HttpStatus.NOT_ACCEPTABLE, "R_HAS_004"),
	PARAM_FORMAT_ERROR("PARAM_FORMAT_ERROR", Translator.toLocale(AppConstants.PARAM_FORMAT_ERROR, null), HttpStatus.BAD_REQUEST, "R_HAS_005"),
	INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", Translator.toLocale(AppConstants.INTERNAL_SERVER_ERROR, null), HttpStatus.INTERNAL_SERVER_ERROR, "R_HAS_006"),
	OBJECT_NOT_FOUND("OBJECT_NOT_FOUND",Translator.toLocale(AppConstants.OBJECT_NOT_FOUND, null), HttpStatus.NOT_FOUND, "R_HAS_001"),
	UNHANDLED_ERROR("UNHANDLED_ERROR",Translator.toLocale(AppConstants.UNHANDLED_ERROR, null), HttpStatus.NOT_IMPLEMENTED, "R_HAS_001");

	public final String code;
	public final String message;
	public final HttpStatus status;
	public String description;

    Error(String code, String message, HttpStatus status, String description) {
        this.code = code;
        this.message = message;
        this.status = status;
		this.description = description;
    }
//	private SibJobExitCode jobExitCode;

//	Error(String code, String description) {
//		this(code, description);
//	}
//
//	private static LoadingCache<String, Optional<Error>> errorByCodeCache = createCache(codeLookup -> {
//		for (Error currentError : values()) {
//			if (StringUtils.equals(codeLookup, currentError.getCode())) {
//				return Optional.of(currentError);
//			}
//		}
//		return Optional.empty();
//	});

//	private static LoadingCache<String, Optional<Error>> errorByDescriptionCache = createCache(descriptionLookup -> {
//		for (Error currentError : values()) {
//			if (StringUtils.equals(descriptionLookup, currentError.getDescription())) {
//				return Optional.of(currentError);
//			}
//		}
//		return Optional.empty();
//	});


//	public static Error getErrorByCode(String code) {
//		if (isBlank(code)) {
//			return null;
//		}
//		return errorByCodeCache.getUnchecked(code).orElse(null);
//	}
//
//	public static Error getErrorByDescription(String description) {
//		if (isBlank(description)) {
//			return null;
//		}
//		return errorByDescriptionCache.getUnchecked(description).orElse(null);
//	}
//
//	public ExitStatus getExitStatus() {
//		return new ExitStatus(jobExitCode == null ? "" : jobExitCode.getValue());
//	}
}
