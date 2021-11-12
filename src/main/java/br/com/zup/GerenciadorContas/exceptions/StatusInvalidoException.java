package br.com.zup.GerenciadorContas.exceptions;

public class StatusInvalidoException extends RuntimeException{
    public StatusInvalidoException(String message) {
        super(message);
    }
}
