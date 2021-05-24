package com.allen.moments.v2.utils;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {

    private T data;
    private int err_no;
    private int isSuccess;
    private String err_tips;

    /**
     * constructs a JsonResult object representing successful operation
     * @param isSuccess
     */
    private JsonResult(boolean isSuccess) {
        this.isSuccess = isSuccess ? 1 : 0;
        this.err_no = isSuccess ? 0 : 1;
        this.err_tips = isSuccess ? "" : "unknown error";
    }

    /**
     * constructs a JsonResult object representing error
     * @param err_no
     * @param err_tips
     */
    private JsonResult(int err_no, String err_tips) {
        this.err_no = err_no;
        this.err_tips = err_tips;
    }

    /**
     * use generic data to construct a JsonResult Object
     * @param data
     */
    private JsonResult(T data) {
        this.data = data;
        this.err_no = 0;

        this.err_tips = "";
    }

    public static JsonResult<?> failure(int err_no, String err_tips) {
        return new JsonResult<>(err_no, err_tips);
    }

    public static JsonResult<?> unknownFailure() {
        return new JsonResult<>(false);
    }
    public static JsonResult<?> success() {
        return new JsonResult<>(true);
    }

    public static JsonResult<?> successWithData(Object data) {
        return new JsonResult<>(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErr_no() {
        return err_no;
    }

    public void setErr_no(int err_no) {
        this.err_no = err_no;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getErr_tips() {
        return err_tips;
    }

    public void setErr_tips(String err_tips) {
        this.err_tips = err_tips;
    }

}