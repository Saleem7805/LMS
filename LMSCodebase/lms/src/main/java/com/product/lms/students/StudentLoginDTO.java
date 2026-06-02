package com.product.lms.students;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentLoginDTO {

    private String pibId;

    private String password;

    private String sessionId;

    private String message;

    public String getPibId() {
        return pibId;
    }

    public void setPibId(String pibId) {
        this.pibId = pibId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}