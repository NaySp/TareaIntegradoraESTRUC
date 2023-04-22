
package model;

import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Controller {
    
    private HashTable<String, Passenger> hashTable;
    private PriorityQueue<Passenger> firstClass;
    private Queue<Passenger> turistClass;

    public Controller(){
        firstClass = new PriorityQueue<>();
        turistClass = new Queue<>(); 
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

                hashTable.insert(atributs[0],passenger);
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
                Passenger passenger = hashTable.get(atribut[0]);
                if (passenger != null) {
                    passenger.toString();
                    
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


}
