package model;

public class Passenger {
    Boolean firstClass;
    String row;
    int numChair;
    int priority;

    public Passenger(Boolean firstClass, String row, int numChair, int priority) {
        this.firstClass = firstClass;
        this.row = row;
        this.numChair = numChair;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }

    public String getRow() {
        return row;
    }

    public int getNumChair() {
        return numChair;
    }
}
