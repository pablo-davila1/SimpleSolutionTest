package org.example;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);

        Integer userDessition = 1;

        Map<String, Map<String, Map<String, List<Double>>>> data = new HashMap<>();

        while (userDessition != 0){
            System.out.println("________________________________________________________");
            System.out.println("|                   Menu de opcciones                  |");
            System.out.println("--------------------------------------------------------");
            System.out.println("| 1 -> Ver estadisticas de una aplicacion              |");
            System.out.println("| 2 -> Crear aplicacion                                |");
            System.out.println("| 3 -> Agregar ciclos de prueba a aplicacion existente |");
            System.out.println("| 0 -> Salir                                           |");
            System.out.println("--------------------------------------------------------");
            System.out.println("|Ingrese su opccion:");

            userDessition = reader.nextInt();

            switch (userDessition){
                case 1:{
                    Scanner findOneByName = new Scanner(System.in);
                    System.out.print("Ingrese el nombre de la aplicacion: ");
                    String appFindName = findOneByName.nextLine();
                    System.out.print("Ingrese el nombre del ciclo de pruebas: ");
                    String cicleName = findOneByName.nextLine();
                    if ( !data.containsKey(appFindName) ) {
                        System.out.println(appFindName + " no existe");
                        break;
                    } else if ( !data.get(appFindName).containsKey(cicleName)) {
                        System.out.println("El ciclo "+cicleName+" no existe, ingrese la opcion 2 para crearlo.");
                        break;
                    }
                    System.out.println("| ESTA TABLA MUESTRA INFORMACION GENERAL DE LA APLICACION");
                    System.out.println("___________________________________________");
                    System.out.println("|Application name");
                    System.out.println("| " + appFindName);
                    System.out.println("-------------------------------------------");
                    System.out.println("|Ciclos de prueba");
                    System.out.println("| " + data.get(appFindName).keySet());
                    System.out.println("-------------------------------------------");
                    System.out.println("| Metricas ");
                    System.out.println("| Casos de exito , casos de fallo, tiempo de ejecucion, eficiencia : ");
                    data.get(appFindName).values().forEach(v -> System.out.println(v.values().toArray()[0]));
                    System.out.println();
                    System.out.println();
                    System.out.println("Ingrese el ciclo de pruebas del que necesita informacion");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("| INFORMACION ESPECIFICA DE LA APLICACION "+appFindName+" y ciclo "+ cicleName);
                    System.out.println("-----------------------------------------------------------------------------");
                    List<List<Double>> metrics = data.get(appFindName).get(cicleName).values().stream().toList();
                    System.out.println("| Casos de exito : " + metrics.get(0).get(0));
                    System.out.println("| Casos de fallo : " + metrics.get(0).get(1));
                    System.out.println("| Tiempo de ejecucuion en segundos : " + metrics.get(0).get(2));
                    System.out.println("| Eficiencia : " + metrics.get(0).get(3));
                    System.out.println("-----------------------------------------------------------------------------");

                break;}

                case 2:{
                    Scanner create = new Scanner(System.in);
                    System.out.print("Ingrese el nombre de la aplicacion: ");
                    String appName =  create.nextLine();
                    System.out.print("Ingrese el nombre del ciclo de puebas de esta aplicacion: ");
                    String testCycleName = create.nextLine();
                    System.out.print("Ingrese el nombre de la version de esta prueba: ");
                    String versionName = create.nextLine();

                    if(data.containsKey(appName) ){
                        System.out.println("Uno de los datos ingresados correspondes a una aplicaccion con ese ciclo o version ya existente.");
                        break;
                    }
                    ArrayList<Double> metrics = new ArrayList<>();
                    System.out.print("Ingrese la cantidad de casos de exito: ");
                    Double metric1 = create.nextDouble();
                    System.out.print("Ingrese la cantidad de casos de fallo: ");
                    Double metric2 = create.nextDouble();
                    System.out.print("Ingrese el tiempo de ejecucion : ");
                    Double metric3 = create.nextDouble();
                    metrics.add(metric1);
                    metrics.add(metric2);
                    metrics.add(metric3);
                    metrics.add(metric1/metric3);

                    Map<String, Map<String, List<Double>>> testInfo = new HashMap<>();

                    Map<String,List<Double>> versions = new HashMap<>();

                    versions.put(versionName, metrics);
                    testInfo.put(testCycleName, versions);
                    data.put(appName, testInfo);

                break;}

                case 3:{
                    Scanner updateByName = new Scanner(System.in);
                    System.out.println("Ingrese el nombre de la aplicacion existente: ");
                    String appName = updateByName.nextLine();
                    if( !data.containsKey(appName) ){
                        System.out.println(appName+" No existe, ingrese a la opcion 2 para crearla");
                        break;
                    }
                    System.out.print("Ingrese el nombre del ciclo de puebas que desea agregar: ");
                    String cicleName = updateByName.nextLine();
                    System.out.print("Ingrese el nombre de la version de esta prueba: ");
                    String versionName = updateByName.nextLine();
                    System.out.print("Ingrese la cantidad de casos de exito: ");
                    Double metric1 = updateByName.nextDouble();
                    System.out.print("Ingrese la cantidad de casos de fallo: ");
                    Double metric2 = updateByName.nextDouble();
                    System.out.print("Ingrese el tiempo de ejecucion : ");
                    Double metric3 = updateByName.nextDouble();
                    ArrayList<Double> newMetrics = new ArrayList<>();
                    newMetrics.add(metric1);
                    newMetrics.add(metric2);
                    newMetrics.add(metric3);
                    newMetrics.add(metric1/metric3);

                    Map<String, Map<String, List<Double>>> testInfo = new HashMap<>();
                    Map<String,List<Double>> versions = new HashMap<>();


                    versions.put(versionName,newMetrics);
                    testInfo.put(cicleName, versions);
                    data.put(appName,testInfo);
                break;}

                default:
                    System.out.println("Ingrese una opcion valida");
            }
        }

    }
}