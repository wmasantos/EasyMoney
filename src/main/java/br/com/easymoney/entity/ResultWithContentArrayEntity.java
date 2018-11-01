package br.com.easymoney.entity;

import java.util.List;

public class ResultWithContentArrayEntity<T> {
    private int code;
    private String message;
    private List<T> content;

    public ResultWithContentArrayEntity() {
    }

    public ResultWithContentArrayEntity(int code, String message, List<T> content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
