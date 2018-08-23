package org.java2.lesson1;

import java.util.Random;

public class Team {
    private String name = "";
    private Sportsmen[] team = new Sportsmen[4];
    private Random random = new Random();

    public Team(){
        teamInit();
        setName(team[0].getCountry() + "'s team");
    }

    private void teamInit(){
        String country = randomCountry();
        for (int i = 0; i < team.length; i++){
            team[i] = new Sportsmen(randomName(), randomAge(), country, random.nextBoolean());
        }
        setTeam(team);
    }


    public void showResults(){
        for (int i = 0; i < team.length; i++){
            System.out.print("Team: " + this.getName() +
                    " Name: " + team[i].getName() +
                    " Age: " + team[i].getAge() +
                    " Country: " + team[i].getCountry() +
                    " Did he get to finish in " + team[i].getAnswer() +"\n");
        }
    }

    public void showWinResults(){
        for (int i = 0; i < team.length; i++){
            if (team[i].isGetToEnd()){
            System.out.print("Team: " + this.getName() +
                    " Name: " + team[i].getName() +
                    " Age: " + team[i].getAge() +
                    " Country: " + team[i].getCountry() + "\n");
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTeam(Sportsmen[] team) {
        this.team = team;
    }
    public String getName() {
        return name;
    }
    public Sportsmen[] getTeam() {
        return team;
    }

    private int randomAge(){
        int min = 18;
        int max = 30;
        max -= min;
        int age = (int)(Math.random() * ++max) + min;
        return age;
    }

    private String randomCountry(){
        String[] countries = {"Russia", "USA", "Canada"};
        return countries[random.nextInt(2)];
    }
    private String randomName(){
        String[] names = {"John", "Petya", "Anton", "Ilya", "Alex", "Sofia", "Porky", "Scott", "Andrey"};
        return names[random.nextInt(names.length)];
    }

}
