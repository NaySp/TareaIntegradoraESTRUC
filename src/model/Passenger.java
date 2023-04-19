package model;

public class Passenger {

    String name;
    int id;
    int age;
    int row;
    String column;
    Boolean firstClass;
    int miles;
    int comeFirst;
    public Passenger(String name, int id, int age, int miles,int row, String column,Boolean firstClass,  int comeFirst) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.row = row;
        this.column = column;
        this.firstClass = firstClass;
        this.comeFirst = comeFirst;
        this.miles = miles;
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

    public int getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(Boolean firstClass) {
        this.firstClass = firstClass;
    }

}
