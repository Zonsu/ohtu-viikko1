package ohtu;

public class Submission {

    private String student_number;
    private int week;
    private int exercises;
    private int hours;
    private boolean a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11;
    private String done = "";

    public void setA1(boolean a1) {
        this.a1 = a1;

    }

    public void setA2(boolean a2) {
        this.a2 = a2;

    }

    public void setA3(boolean a3) {
        this.a3 = a3;

    }

    public void setA4(boolean a4) {
        this.a4 = a4;

    }

    public void setA5(boolean a5) {
        this.a5 = a5;

    }

    public void setA6(boolean a6) {
        this.a6 = a6;

    }

    public void setA7(boolean a7) {
        this.a7 = a7;
        
    }

    public void setA8(boolean a8) {
        this.a8 = a8;

    }

    public void setA9(boolean a9) {
        this.a9 = a9;

    }

    public void setA10(boolean a10) {
        this.a10 = a10;

    }

    public void setA11(boolean a11) {
        this.a11 = a11;

    }

    public String getStudent_number() {
        return student_number;

    }

    public int getWeek() {
        return week;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return this.hours;
    }

    public int getExerciseCount() {
        this.exercises = 0;

        if (a1) {
            this.exercises++;
            done = done + "1 ";
            
        }
        if (a2) {
            this.exercises++;
            done = done + "2 ";
        }
        if (a3) {
            this.exercises++;
            done = done + "3 ";
        }
        if (a4) {
            this.exercises++;
            done = done + "4 ";
        }
        if (a5) {
            this.exercises++;
            done = done + "5 ";
        }
        if (a6) {
            this.exercises++;
            done = done + "6 ";
        }
        if (a7) {
            this.exercises++;
            done = done + "7 ";
        }
        if (a8) {
            this.exercises++;
            done = done + "8 ";
        }
        if (a9) {
            this.exercises++;
            done = done + "9 ";
        }
        if (a10) {
            this.exercises++;
            done = done + "10 ";
        }
        if (a11) {
            this.exercises++;
            done = done + "11 ";
        }
        return this.exercises;
    }
    
    public String tehdytTehtavat() {
 
        return this.done;
    }

    @Override
    public String toString() {
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + getExerciseCount() + " aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + tehdytTehtavat();
    }

}
