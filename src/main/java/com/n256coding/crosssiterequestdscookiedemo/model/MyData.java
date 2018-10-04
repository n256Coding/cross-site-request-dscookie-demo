package com.n256coding.crosssiterequestdscookiedemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyData {
    public String receiver_account_number;
    public double value;
    public String csrf_token;

    @JsonCreator
    public MyData(@JsonProperty("receiver_account_number") String receiver_account_number,
                  @JsonProperty("value") double value,
                  @JsonProperty("csrf_token") String csrf_token) {
        this.receiver_account_number = receiver_account_number;
        this.value = value;
        this.csrf_token = csrf_token;
    }
}
