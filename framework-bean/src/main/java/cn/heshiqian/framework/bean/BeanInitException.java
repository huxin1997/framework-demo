package cn.heshiqian.framework.bean;

public class BeanInitException extends RuntimeException {

    public BeanInitException(String message) {
        super(message);
    }

    public BeanInitException(String message, Throwable cause) {
        super(message, cause);
    }
}
