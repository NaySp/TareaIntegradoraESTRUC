package model;

public class Passenger {

    String name;
    int id;
    int age;
    String row;
    int numChair;
    Boolean firstClass;
    Boolean priority;

    int milles;

    Boolean comeFirst;
    public Passenger(String name, int id, int age, String row, int numChair, Boolean firstClass, Boolean priority, Boolean comeFirst, int mi) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.row = row;
        this.numChair = numChair;
        this.firstClass = firstClass;
        this.priority = priority;
        this.comeFirst = comeFirst;
        this.milles = milles;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getRow() {
        return row;
    }

    public int getNumChair() {
        return numChair;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(Boolean firstClass) {
        this.firstClass = firstClass;
    }

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }
}
