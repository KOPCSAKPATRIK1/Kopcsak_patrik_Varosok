package com.example.kopcsak_patrik_varosok;


public class Response {
    private final int responseCode;
    private final String content;

    public Response(int responseCode, String content) {
        this.responseCode = responseCode;
        this.content = content;
    }
    public int getResponseCode() {
        return responseCode;
    }
    public String getContent() {
        return content;
    }
}