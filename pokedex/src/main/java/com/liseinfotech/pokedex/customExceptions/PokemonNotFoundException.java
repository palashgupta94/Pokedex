package com.liseinfotech.pokedex.customExceptions;

public class PokemonNotFoundException extends Exception {

    public PokemonNotFoundException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
