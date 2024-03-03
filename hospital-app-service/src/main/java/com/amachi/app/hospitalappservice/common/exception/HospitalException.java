package com.amachi.app.hospitalappservice.common.exception;

import com.amachi.app.hospitalappservice.common.util.Error;

/**
 * Exception principale du projet SIB
 */
public class HospitalException extends RuntimeException {
	private final Error error;

	public HospitalException() {
		this(Error.UNHANDLED_ERROR, "Aucun message pour cette exception");
	}

	public HospitalException(final Exception e) {
		this(Error.UNHANDLED_ERROR, e);
	}

	public HospitalException(Error error, Exception e) {
		super(String.format(error.getMessage(), e));
		this.error = error;
	}


	public HospitalException(Error error, Object... args) {
		super(String.format(error.getMessage(), args));
		this.error = error;
	}

	public Error getError() {
		return error;
	}
}
