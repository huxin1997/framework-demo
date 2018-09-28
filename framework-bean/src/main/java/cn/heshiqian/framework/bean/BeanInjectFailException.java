package cn.heshiqian.framework.bean;

public class BeanInjectFailException extends RuntimeException {

    public BeanInjectFailException(String message) {
        super(message);
    }

    public BeanInjectFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
