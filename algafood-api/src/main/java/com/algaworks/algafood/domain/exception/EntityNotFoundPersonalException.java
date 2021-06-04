package com.algaworks.algafood.domain.exception;

public class EntityNotFoundPersonalException  extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EntityNotFoundPersonalException(String message) {
		super(message);
	}
}