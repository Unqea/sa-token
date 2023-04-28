package com.traffic.exception;


import com.traffic.common.MyErrorCode;

/**
 * 自定义异常
 *
 * @date 2022-01-25
 */
public class MyGlobalException extends RuntimeException {
    private Integer errorCode;
    private String message;

    public MyGlobalException(String message) {
        super(message);
        this.message = message;
    }

    public MyGlobalException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public MyGlobalException(MyErrorCode myErrorCode) {
        super(myErrorCode.getMsg());
        this.errorCode = myErrorCode.getCode();
        this.message = myErrorCode.getMsg();
    }

    // <editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getErrorCode() {
        return this.errorCode;
    }

    @SuppressWarnings("all")
    public String getMessage() {
        return this.message;
    }

    @SuppressWarnings("all")
    public void setErrorCode(final Integer errorCode) {
        this.errorCode = errorCode;
    }

    @SuppressWarnings("all")
    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "MyGlobalException(errorCode=" + this.getErrorCode() + ", message=" + this.getMessage() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MyGlobalException))
            return false;
        final MyGlobalException other = (MyGlobalException) o;
        if (!other.canEqual((Object) this))
            return false;
        final Object this$errorCode = this.getErrorCode();
        final Object other$errorCode = other.getErrorCode();
        if (this$errorCode == null ? other$errorCode != null : !this$errorCode.equals(other$errorCode))
            return false;
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message))
            return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof MyGlobalException;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $errorCode = this.getErrorCode();
        result = result * PRIME + ($errorCode == null ? 43 : $errorCode.hashCode());
        final Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        return result;
    }
    // </editor-fold>
}
