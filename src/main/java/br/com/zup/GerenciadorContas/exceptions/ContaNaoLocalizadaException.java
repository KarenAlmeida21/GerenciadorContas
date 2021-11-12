package br.com.zup.GerenciadorContas.exceptions;

public class ContaNaoLocalizadaException extends  RuntimeException{
    public ContaNaoLocalizadaException(String message) {
        super(message);
    }
}
