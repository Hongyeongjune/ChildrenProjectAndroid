package com.example.user.myapplication.model.dto;

public class CIDto {

    private String name;
    private String age;
    private String sex;
    private String leftStart;
    private String rightStart;
    private String leftDate;
    private String rightDate;
    private String leftDevice;
    private String rightDevice;
    private String type;
    private int number;
    private String answer;
    private String choice;
    private Long score;
    private String incorrect;
    private Long timer;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CIDto(String name, String age, String sex, String leftStart, String rightStart, String leftDate, String rightDate, String leftDevice, String rightDevice, String type, int number, String answer, String choice, Long score, String incorrect, Long timer) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.leftStart = leftStart;
        this.rightStart = rightStart;
        this.leftDate = leftDate;
        this.rightDate = rightDate;
        this.leftDevice = leftDevice;
        this.rightDevice = rightDevice;
        this.type = type;
        this.number = number;
        this.answer = answer;
        this.choice = choice;
        this.score = score;
        this.incorrect = incorrect;
        this.timer = timer;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(String incorrect) {
        this.incorrect = incorrect;
    }

    public Long getTimer() {
        return timer;
    }

    public void setTimer(Long timer) {
        this.timer = timer;
    }
}
