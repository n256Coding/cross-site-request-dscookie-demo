package com.n256coding.crosssiterequestdscookiedemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyData {
    public String car_brand;
    public String drink;
    public String tv_show;
    public String csrf_token;

    @JsonCreator
    public MyData(@JsonProperty("car_brand") String car_brand,
                  @JsonProperty("drink") String drink,
                  @JsonProperty("tv_show") String tv_show,
                  @JsonProperty("csrf_token") String csrf_token) {
        this.car_brand = car_brand;
        this.drink = drink;
        this.tv_show = tv_show;
        this.csrf_token = csrf_token;
    }
}
