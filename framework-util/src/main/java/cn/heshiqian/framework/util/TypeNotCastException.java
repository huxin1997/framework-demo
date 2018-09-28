package cn.heshiqian.framework.util;

public class TypeNotCastException extends RuntimeException {

    public TypeNotCastException(String message) {
        super(message);
    }

    public TypeNotCastException(String message, Throwable cause) {
        super(message, cause);
    }
}
