package com.example.practice.bean;

public class Result<T> {
 private String msg;
 private T detail;
 private boolean success;
 public  String getMsg(){
     return msg;
 }

    public boolean isSuccess() {
        return success;
    }
public T getDetail(){
     return detail;
}

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}
