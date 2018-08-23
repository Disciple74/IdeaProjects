package org.java2.lesson1;

public class Course {
    private String[] barriers = new String[4];

    public Course(){
        setBarriers(barriers);
    }

    public void setBarriers(String[] barriers) {
        for (int i = 0; i < barriers.length; i++){
            barriers[i] = "barrier #" + (i + 1);
        }
        this.barriers = barriers;
    }

    public void doIt(Team team){
        for (int j = 0; j < barriers.length; j++) {
            for (int i = 0; i < team.getTeam().length; i++) {
                team.getTeam()[i].setAnswer(answer(team.getTeam()[i].isGetToEnd()));
            }
        }
    }
    private String answer(boolean getToEnd){
        if (getToEnd) return ": yes";
        return ": no";
    }
}
