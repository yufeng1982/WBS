package com.wbs.base;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private static final long serialVersionUID = -750644833749014618L;
    private boolean success;
    private T result;
    private String error;

    public Response() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.success = false;
        this.error = error;
    }

//    public String toString() {
//        return Objects.toStringHelper(this).add("success", this.success).add("result", this.result).add("error", this.error).omitNullValues().toString();
//    }
}