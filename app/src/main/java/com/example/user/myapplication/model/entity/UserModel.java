package com.example.user.myapplication.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserModel implements Serializable {

    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("age")
    private String age;
    @SerializedName("sex")
    private String sex;
    @SerializedName("leftStart")
    private String leftStart;
    @SerializedName("rightStart")
    private String rightStart;
    @SerializedName("leftDate")
    private String leftDate;
    @SerializedName("rightDate")
    private String rightDate;
    @SerializedName("leftDevice")
    private String leftDevice;
    @SerializedName("rightDevice")
    private String rightDevice;
    @SerializedName("type")
    private String type;
    @SerializedName("number")
    private int number;
    @SerializedName("answer")
    private String answer;
    @SerializedName("choice")
    private String choice;
    @SerializedName("score")
    private String score;
    @SerializedName("incorrect")
    private String incorrect;
    @SerializedName("titmer")
    private Long timer;

}
