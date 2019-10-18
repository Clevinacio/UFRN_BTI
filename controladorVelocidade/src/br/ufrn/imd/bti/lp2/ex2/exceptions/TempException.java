package br.ufrn.imd.bti.lp2.ex2.exceptions;

public class TempException extends Exception {
    public TempException(String message, Throwable cause) {
        super(message, cause);
    }

    public TempException(String message) {
        super(message);
    }
}
