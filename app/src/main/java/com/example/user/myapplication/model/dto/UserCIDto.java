package com.example.user.myapplication.model.dto;

public class UserCIDto {

    private String name;
    private String age;
    private String sex;
    private String leftStart;
    private String rightStart;
    private String leftDate;
    private String rightDate;
    private String leftDevice;
    private String rightDevice;

    public UserCIDto(String name, String age, String sex, String leftStart, String rightStart, String leftDate, String rightDate, String leftDevice, String rightDevice) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.leftStart = leftStart;
        this.rightStart = rightStart;
        this.leftDate = leftDate;
        this.rightDate = rightDate;
        this.leftDevice = leftDevice;
        this.rightDevice = rightDevice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLeftStart() {
        return leftStart;
    }

    public void setLeftStart(String leftStart) {
        this.leftStart = leftStart;
    }

    public String getRightStart() {
        return rightStart;
    }

    public void setRightStart(String rightStart) {
        this.rightStart = rightStart;
    }

    public String getLeftDate() {
        return leftDate;
    }

    public void setLeftDate(String leftDate) {
        this.leftDate = leftDate;
    }

    public String getRightDate() {
        return rightDate;
    }

    public void setRightDate(String rightDate) {
        this.rightDate = rightDate;
    }

    public String getLeftDevice() {
        return leftDevice;
    }

    public void setLeftDevice(String leftDevice) {
        this.leftDevice = leftDevice;
    }

    public String getRightDevice() {
        return rightDevice;
    }

    public void setRightDevice(String rightDevice) {
        this.rightDevice = rightDevice;
    }
}
