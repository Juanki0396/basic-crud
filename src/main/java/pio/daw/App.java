package pio.daw;

import java.nio.file.Path;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void printMenu(){
        System.out.println("---------ACIONES-----------");
        System.out.println("1.Crear cliente");
        System.out.println("2.Leer cliente");
        System.out.println("3.Leer todos");
        System.out.println("4.Actualizar cliente");
        System.out.println("5.Borrar cliente");
        System.out.println("6.Salir");
        System.out.print(">>>");
    }

    public static String askFor(Scanner sc, String msg){
        String result = "";
        while(!result.isEmpty()){
            System.out.print(msg + ": ");
            result = sc.nextLine();
        }
        return result;
    }

    public static Cliente askforClient(Scanner sc){
        String name = askFor(sc, "Nombre");
        String apellido = askFor(sc, "Apellido");
        String dni = askFor(sc, "DNI");
        String matricula = askFor(sc, "matricula");
        return new Cliente(name, apellido, dni, matricula);

    }

    public static void main(String[] args) throws Exception{
        Boolean run = true;
        Path filePath = Path.of(args[0]);
        ClienteManager manager = new ClienteManager(filePath);
        Scanner sc = new Scanner(System.in);
        
        while(run){
            printMenu();

            Integer action = 0;
            action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1:
                    Cliente c = askforClient(sc);
                    manager.create(c);
                    break;
                case 2:
                    String dni = askFor(sc, "DNI");
                    System.out.println(manager.read(dni));
                    break;
                case 3:
                    manager.readAll();
                default:
                    break;
            }
        }
    }
}
