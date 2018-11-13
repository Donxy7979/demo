package com.zdx.demo.utils;

public class Response<T> {
    // 成功标记
    private boolean success;
    // 提示信息
    private String msg;
    // 错误码
    private int errorCode;
    // 返回的具体数据
    private T data;

    /**
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success :
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg :
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode :
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data :
     */
    public void setData(T data) {
        this.data = data;
    }

}