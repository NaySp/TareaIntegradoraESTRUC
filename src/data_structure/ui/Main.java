package data_structure.ui;

import java.util.Scanner;
// importamos el controller
import data_structure.model.*;


public class Main {

    //definimos el tipo de dato del lector
    private Scanner reader;
    // definimos el dato de la clase controller
    private Controller controller;


    public Main() {
        reader = new Scanner(System.in);
        //definimos nombre del controller
        controller = new Controller();


    }
    //returns the class, that is, the class becomes visible to the main method.
    public Scanner getReader(){
        return reader;
    }

    //hacemos visible el controller
    public Controller getController(){
        return controller;
    }

    public static void main(String[] args) {

        // creación del objeto.
        Main main = new Main();
        main.lectorTxt(); 
        // llamdo a uno de los metodos de la clase.
        int option = 0;

        do{

            option = main.getOptionShowMenu();
            main.executeOption(option);

        }while(option != 0);

        main.getReader().close();

    }

    public int getOptionShowMenu(){
        int option = 0;
        System.out.println("\n<<<<< Sistema de entrada y salida ^==^ Aerolinea FlyFast >>>>>");
        System.out.println(
                "1. Orden de llegada de los pasajeros \n" +
                "2. Orden correcto de entrada de los pasajeros.\n" +
                "3. Orden correcto de salida de los pasajeros.\n" +
                "0.  Exit.");

        option =  validateIntegerInput();
        return option;
    }

    public void executeOption(int option){

        switch(option){
            case 1:
            // C:\\Users\\sergi\\OneDrive\\Documentos\\TareaIntegradoraESTRUC\\data\\OrdenLlegada.csv por ejemplo asi xd 

            System.out.println("orden de los pasajeros, ingrese la direccion del txt donde estan los pasajeros por orden de llegada.");
            String archivo= reader.next();
            controller.orderPassenger(archivo); 
            

                break;

            case 2:
            controller.showOrder(); 

                
                break;
            case 3:

                
            
                break;
         
            case 0:
                System.out.println("Exit program.");
                break;

            default:
                System.out.println("Invalid Option");
                break;
        }
    }
    /**
     * validateIntegerInput: this method validates that the option entered by the user is actually an integer data type
     * @return option: is a int option.
     */

    public int validateIntegerInput(){
        int option = 0;

        if(reader.hasNextInt()){
            option = reader.nextInt();
        }
        else{
            // clear reader.
            reader.nextLine();
            option = -1;
        }

        return option;
    }
    /**
     * validateDoubleInput: this method validates that the option entered by the user is actually an double data type
     * @return option: is a double or int  option.
     */

    public double validateDoubleInput(){
        double option = 0;

        if(reader.hasNextDouble()){
            option = reader.nextDouble();
        }
        else{
            // clear reader.
            reader.nextLine();
            option = -1;
        }

        return option;
    }
    public void lectorTxt(){

        // C:\\Users\\sergi\\OneDrive\\Documentos\\TareaIntegradoraESTRUC\\data\\info.csv 
        System.out.println("ingrese la direccion del archivo txt donde carga la informacion de los pasajeros ");
        String dir = reader.next();
        System.out.println("ingrese la cantidad de pasajeros.");
        int num = reader.nextInt();
        controller.uploadPassengers(dir, num);

    }


}