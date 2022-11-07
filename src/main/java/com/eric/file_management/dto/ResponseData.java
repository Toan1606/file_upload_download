package com.eric.file_management.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseData {

    private Object data;

    private LocalDateTime date;

    public ResponseData(){}

    public ResponseData(Builder responseDataBuilder) {
        this.data = responseDataBuilder.data;
        this.date = responseDataBuilder.date;
    }

    public static class Builder {
        private Object data;
        private LocalDateTime date;

        public Builder() {}

        public Builder data(Object data) {
            this.data = data;
            return this;
        }

        public Builder date() {
            this.date = LocalDateTime.now();
            return this;
        }

        public ResponseData build() {
            ResponseData responseData = new ResponseData(this);
            return responseData;
        }
    }
}