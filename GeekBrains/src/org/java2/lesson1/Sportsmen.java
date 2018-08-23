package org.java2.lesson1;



public class Sportsmen {
    private String name = "";
    private int age;
    private String country = "";
    private boolean getToEnd = false;
    private String answer = "";


    public Sportsmen(String name, int age, String country, boolean getToEnd){
        setName(name);
        setAge(age);
        setCountry(country);
        setGetToEnd(getToEnd);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public void setGetToEnd(boolean getToEnd) {
        this.getToEnd = getToEnd;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isGetToEnd() {
        return getToEnd;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCountry() {
        return country;
    }





}
