package data_structure.model;
import java.time.LocalTime;

public class Passenger implements Comparable<Passenger> {

    String name;
    int id;
    int age;
    int row;
    String column;
    Boolean firstClass;
    int miles;
    private LocalTime time;
    
    public Passenger(String name, int id, int age, int miles,int row, String column,Boolean firstClass) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.row = row;
        this.column = column;
        this.firstClass = firstClass;
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
    public int getMiles() {
        return miles;
    }
    public void setMiles(int miles) {
        this.miles = miles;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return "Passenger is :" + name + ".";
    }
  @Override
  public int compareTo(Passenger other){
    int forMiles = Integer.compare(this.miles, other.getMiles());

        if (forMiles != 0) {
            // Si las millas son diferentes, se devuelve la comparación por millas
            return forMiles;
        } else {
            // Si las millas son iguales, se compara por edad
            return Integer.compare(this.age, other.getAge());
        }

  }  
  public int compareTo1(Passenger other){
    // Primero comparamos por fila
    int comparationRow = Integer.compare(this.row, other.getRow());
    if (comparationRow != 0) {
        return comparationRow;
    }

    // Si las filas son iguales, comparamos por columna, con la peculiaridad dada
    int column1 = getColumnValue(this.column);
    int column2 = getColumnValue(other.getColumn());
    int comparationColumn = Integer.compare(column1, column2);
    if (comparationColumn != 0) {
        return comparationColumn;
    }

    // Si las columnas son iguales, comparamos por time
    return this.time.compareTo(other.getTime());
  }
  private int getColumnValue(String columna) {
    switch (columna) {
        case "C": case "D": return 1;
        case "B": case "E": return 2;
        case "A": case "F": return 3;
        default: throw new IllegalArgumentException("Columna inválida: " + columna);
    }
}

  
}
