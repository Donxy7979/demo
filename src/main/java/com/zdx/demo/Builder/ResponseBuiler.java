package com.zdx.demo.Builder;

import com.zdx.demo.utils.Response;

public class ResponseBuiler {
    public static <T> Response<T> buildSuccess(T data) {
        Response<T> rsp = new Response<>();
        rsp.setSuccess(true);
        rsp.setData(data);
        return rsp;

    }

    public static Response<Object> buildFailure(String detail) {
        Response<Object> rsp = new Response<>();
        rsp.setSuccess(false);
        rsp.setMsg("[" + detail + "]");
        rsp.setData(null);
        return rsp;
    }

    public static Response<Object> buildInstence(boolean success, String msg) {
        Response<Object> rsp = new Response<>();
        rsp.setSuccess(success);
        rsp.setMsg(msg);
        return rsp;
    }
}
