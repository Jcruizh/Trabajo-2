import java.util.*;
public class imaginary_company {
    public static void main(String[] args) {
        //creacion de elementos necesarios utilizando listas como pilas y colas; 
        ArrayList<LinkedList<Integer>> ubicacionA;
        ubicacionA = new ArrayList<>();
        ArrayList<LinkedList<Integer>> ubicacionC;
        ubicacionC = new ArrayList<>();
        System.out.println("Bienvenidos a Imaginary Company");
        Scanner entrada = new Scanner(System.in);
        int contador=0, contador1=0,ocupados=0,lugar = 0,posicion=0;// contadores para que cambie de posicion y controlar las listas(controlador del ciclo)
        boolean boton = false;
        // creacion de pilas y colas desde un comienzo
        for(int i=0; i<10;i++){
            ubicacionA.add(new LinkedList<>());//Automoviles(colas)
        }
        for(int j=0; j<100;j++){
            ubicacionC.add(new LinkedList<>());// Contenedores(pilas)
        }
        // llenado, de vehiculos y contenedores dependiendo de donde se vaya a empezar
        int expo=0,alfa=0;
        for(int i=1;i<99;i++){
            ubicacionA.get(expo).add(i);
            if(i%10==0){
                expo+=1;
            }
        }
        for(int i=1;i<499;i++){
            ubicacionC.get(alfa).add(i);
            if(i%5==0){
                alfa+=1;
            }
        }
        System.out.println(ubicacionC);
        System.out.println(ubicacionA);
        // Interfaz de usuario 
        while(true){
        System.out.println("¿A qué elemento del puerto deseas realizar algun tramite o proceso?(elige entre 1,2 y 3)");
        System.out.println("1. vehiculos");
        System.out.println("2. contenedores");
        System.out.println("3. Salir del sistema");
        String valores=entrada.next();
        if("1".equals(valores) || "2".equals(valores) || "3".equals(valores) ){
            if("1".equals(valores)){
                while(true){
        System.out.println("¿Que operación deseas realizar?(1,2,3,4,5 o 6)");
        System.out.println("1. recibir un vehiculo");
        System.out.println("2. entregar(extraer) un vehiculo");
        System.out.println("3. numero de vehiculos(disponibles y llenos)");
        System.out.println("4. conocer los elementos de una cola de vehículos");
        System.out.println("5. Buscar algun vehiculo");
        System.out.println("6. Volver al panel inicial");
        String valores1=entrada.next();
        if("1".equals(valores1) || "2".equals(valores1) || "3".equals(valores1) || "4".equals(valores1) || "5".equals(valores1) || "6".equals(valores1)){
            if("1".equals(valores1)){
                // requisito 1,2,3,5 y 11
                for(int j=0;j<ubicacionA.size();j++){
                    if(ubicacionA.get(j).size()<10){
                        contador=j;
                        break;
                    }
                }
                for(int g=0; g<ubicacionA.size();g++){
                    ocupados+= ubicacionA.get(g).size();
                }
                if(ocupados<100){
                    System.out.println("Digite el serial del vehiculo");
                    int serial2=entrada.nextInt();
                    for(int k=0;k<ubicacionA.size();k++){
                        if(ubicacionA.get(k).contains(serial2)){ //Busqueda de elementos repetidos
                            System.out.println("Atención,El serial del vehiculo ya esta en el sistema");
                            boton= true;
                            break;
                        }
                        else{
                            boton=false;
                        }
                    }
                
