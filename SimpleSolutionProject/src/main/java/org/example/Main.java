package org.example;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map <String, Map<String, Map<String, ArrayList<Double>>>> data = new HashMap<>();
        String aplicationName = "Intellij";
        Map<String, Map <String, ArrayList<Double>>> testInfo = new  HashMap<>();
        Map<String,List<Double>> version = new HashMap<>();
        ArrayList<Double> metrics = new ArrayList<>();
        metrics.add(3.5);
        metrics.add(5.0);
        version.put("V1.0.0" , metrics );

        int userDessition = 1;
        while (userDessition != 0){
            System.out.println("___________________________________________");
            System.out.println("|            Menu de opcciones            |");
            System.out.println("-------------------------------------------");
            System.out.println("| 1 -> Ver estadisticas de una aplicacion |");
            System.out.println("| 2 -> Listar aplicaciones y estadisticas |");
            System.out.println("| 3 -> Crear aplicacion                   |");
            System.out.println("| 0 -> Salir                              |");
            System.out.println("-------------------------------------------");

            if (userDessition == 1){
                System.out.println("We are working in that :)");
            }
            else if (userDessition == 2){
                System.out.println("We are working in that too :)");
            }
            else if (userDessition == 3){
                System.out.println("thats the good one, please simple solutions, im a good one :)");
            }
            else if (userDessition == 0){
                break;
            }
            else {
                System.out.println("Ingrese una opccion valida");
            }
        }

    }
}