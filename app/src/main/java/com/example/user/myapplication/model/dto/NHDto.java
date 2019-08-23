package com.example.user.myapplication.model.dto;

public class NHDto {

    private String name;
    private String age;
    private String sex;
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

    public NHDto(String name, String age, String sex, String type, int number, String answer, String choice, Long score, String incorrect, Long timer) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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
