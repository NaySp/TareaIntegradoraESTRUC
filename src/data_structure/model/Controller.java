package data_structure.model;
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

public class Controller {
    
    private HashTable<Integer, Passenger> hashTable;
    private PriorityQueue<Passenger> firstClass;
    private PriorityQueueOut<Passenger> out;
    private Queue<Passenger> turistClass;
    private LocalTime  timePlane; 

    public Controller(){
        firstClass = new PriorityQueue<>();
        turistClass = new Queue<>(); 
        out = new PriorityQueueOut<>(); 
        timePlane = LocalTime.now();
    }

    public LocalTime getTimePlane() {
        return timePlane;
    }

    public void setTimePlane(LocalTime timePlane) {
        this.timePlane = timePlane;
    }

    public void uploadPassengers(String archivo, int num) {
        File file = new File(archivo);
        hashTable = new HashTable<>(num);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] atributs = line.split(";");
                Passenger passenger = new Passenger(atributs[0], Integer.parseInt(atributs[1]), Integer.parseInt(atributs[2]),Integer.parseInt(atributs[3]),
                        Integer.parseInt(atributs[4]),atributs[5],Boolean.parseBoolean(atributs[6]));

                hashTable.insert(Integer.parseInt(atributs[1]),passenger);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void orderPassenger(String archivo) {
        File file = new File(archivo);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] atribut = line.split(" ");
                Passenger passenger = hashTable.get(Integer.parseInt(atribut[0]));
                if (passenger != null) {
                    passenger.toString();
                    passenger.setTime(LocalTime.now());
                    out.insert(passenger);
                    if(passenger.getTime().isBefore(getTimePlane())){
                        //se premia puntualidad. xddd
                        // una idea. 
                        // passenger.setMiles(passenger.getMiles()+ 100);
                    }

                    if (passenger.getFirstClass() == true) {
                        firstClass.insert(passenger);        
        
                    } else {
                        turistClass.enqueue(passenger);
                       
                    }
                }
                else{
                    System.out.println("no se encontro el pasajero :C");
                }

            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    public void showOrder(){
        firstClass.print();
        turistClass.print();
    }
    public void showOut(){
        out.print();
    }


}
