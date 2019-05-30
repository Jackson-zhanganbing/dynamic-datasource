package com.changan.dynamicdatasource.common;

/**
 * @author zhang anbing
 * @date 2018/8/21
 */
public class GeneralResponse<T> {
    /**
     * 0表示正常，1表示异常
     */
    private String code;
    /**
     * 面向用户的消息
     */
    private String msg;
    /**
     * 返回给前端的数据
     */
    private T data;

    public GeneralResponse(String code, String msg,  T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static GeneralResponse success(String message, Object data) {
        return new GeneralResponse("0", message,data);
    }

    public static GeneralResponse fail(String message) {
        return new GeneralResponse("1", message,null);
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getMessage() {
        return msg;
    }


    public void setMessage(String message) {
        this.msg = message;
    }

    public T getData() {
        return data;
    }


    public void setData(T data) {
        this.data = data;
    }
}

