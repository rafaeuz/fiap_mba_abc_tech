package br.mba.fiap.abctech.abctechservice.handler.exception;

import lombok.Getter;

@Getter
public class MinimumAssistsRequiredException extends RuntimeException {
    private final String description;

    public MinimumAssistsRequiredException(String message, String description) {
        super(message);
        this.description = description;
    }
}
