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
                                    
                    if(false==boton){
                        if(contador<=9){
                            ubicacionA.get(contador).add(serial2);
                            int ubi=contador+1;
                            System.out.println("La cola del vehiculo quedo ubicada en la posicion: "+ubi);
                            if(ubicacionA.get(contador).size()==9){
                                contador+=1;
                            }
                            System.out.println(ubicacionA);
                            ocupados=0;
                            break;
                        }
                    }
            }
                else{
                    System.out.println("No es posible realizar este tramite,puerto lleno de automoviles");
                    ocupados=0;
                }
            }
            else if("2".equals(valores1)){   
                    System.out.println("Digite el serial del Automovil a ser entregado(extraido)");
                    int serials=entrada.nextInt();//Requisito 3
                    for(int h=0;h<ubicacionA.size();h++){
                    if(ubicacionA.get(h).contains(serials)){ //Busqueda de lugar
                            lugar=h;
                            boton=true;
                            break;
                        }
                    else{
                        boton=false;
                    }
                }
                if(boton==true){
                posicion=ubicacionA.get(lugar).indexOf(serials)+1;
                lugar+=1;
                System.out.println("Actualmente el automovil "+serials+" se encuentra en la cola "+lugar+" en la ubicacion de salida de "+posicion);
                contador=lugar-1;
                if(posicion==1 && contador>=0){
                    ubicacionA.get(contador).removeFirst();
                    System.out.println(contador);
                }
                if(posicion>1 && contador<9){
                    System.out.println("Proceso a hacer con los automoviles: ");//proceso que se hace dentro del puerto
                    System.out.println("Los vehiculos fueron seran movidos a colas y devueltos a la posicion inicial a ser parte de la cola ubicada en "+(contador+1));
                    for(int i=0;i<posicion-1;i++){
                        int a=ubicacionA.get(contador).get(i); //internamente la operacion por eficiencia distribuye la cola
                        ubicacionA.get(contador).add(a);
                    }
                    for(int i=0;i<posicion;i++){
                        ubicacionA.get(contador).removeFirst();
                    }
                    System.out.println(ubicacionA);
                    System.out.println("finalmente los indices respetado la entrada de colas y los oredenes de salida(FIFO) son :");
                    for(int yita=0;yita<ubicacionA.get(contador).size();yita++){
                        System.out.println("serial : "+ubicacionA.get(contador).get(yita));
                    }
                }
                if(contador==9 && posicion!=1){
                  System.out.println("Proceso a hacer con los automoviles: ");//proceso que se hace dentro del puerto
                    System.out.println("Los vehiculos seran movidos a colas auxiliares y devueltos a la posicion inicial a ser parte de la cola ubicada en "+(contador+1));
                    for(int i=0;i<posicion-1;i++){
                        int a=ubicacionA.get(contador).get(i); //internamente la operacion por eficiencia distribuye la cola e
                        ubicacionA.get(contador).add(a);
                    }
                    for(int i=0;i<posicion;i++){
                        ubicacionA.get(contador).removeFirst();
                    }
                    System.out.println("finalmente los indices respetado la entrada de colas y los oredenes de salida(FIFO) son :");
                    for(int yita=0;yita<ubicacionA.get(contador).size();yita++){
                        System.out.println("serial : "+ubicacionA.get(contador).get(yita));
                    }
                }                
                }
                else if(boton==false){
                    System.out.println("El serial introducido no pertenece a ningun contenedor en el puerto");
                }
        }
            else if("3".equals(valores1)){
                //requisito 6
                for(int g=0; g<ubicacionA.size();g++){
                    ocupados+= ubicacionA.get(g).size();
                }
                int disponibles= 100-ocupados; 
                System.out.println("El puerto actualmente cuenta con capacidad diponible de "+disponibles+" automoviles");
                System.out.println("El puerto actulmente tiene un ocupamiento de "+ocupados+" automoviles");
                disponibles=0;
                ocupados=0;
                break;
            }
            else if("4".equals(valores1)){
                System.out.println("Digite la cola donde desea hacer la busuqueda");
                int indice=entrada.nextInt();
                System.out.println("Los indices respetado las colas y los oredenes de salida(FIFO) son :");
                if(indice>=1 && indice<=10){
                    for(int y=0;y<ubicacionA.get(indice-1).size();y++){
                        System.out.println("serial : "+ubicacionA.get(indice-1).get(y));
                    }
                }
                break;
            }
            else if("5".equals(valores1)){
                System.out.println("Digite el serial del Automovil a ser buscado");
                int seriala=entrada.nextInt();//Requisito 10
                for(int h=0;h<ubicacionA.size();h++){
                    if(ubicacionA.get(h).contains(seriala)){ //Busqueda de luga
                            lugar=h;
                            boton=true;
                            break;
                        }
                    else{
                        boton=false;
                    }
                }
                if(boton==true){
                posicion=ubicacionA.get(lugar).indexOf(seriala)+1;
                lugar+=1;
                System.out.println("Actualmente el automovil "+seriala+" se encuentra en la cola "+lugar+" en la ubicacion de salida de "+posicion);
            }
                else if(boton==false){
                    System.out.println("El serial introducido no pertenece a ningun contenedor en el puerto");
                }
                break;
            }
            else if("6".equals(valores1)){
                break;
            }
        }
        else{
            System.out.println("Este tramite aun no esta hablitado por el sistema, por favor elige entre las opciones 1,2,3,4,5 o 6");
        }
    }
    }
            if("2".equals(valores)){
                while(true){
        System.out.println("¿Que operación deseas realizar?(1,2,3,4,5 o 6)");
        System.out.println("1. recibir un Contenedor");
        System.out.println("2. entregar(extraer) un contenedor");
        System.out.println("3. numero de contenedor(disponibles y llenos)");
        System.out.println("4. conocer los elementos de una cola de contenedor");
        System.out.println("5. Buscar algun contenedor");
        System.out.println("6. Volver al panel inicial");
        String valores2=entrada.next();
        if("1".equals(valores2) || "2".equals(valores2) || "3".equals(valores2) || "4".equals(valores2)|| "5".equals(valores2)|| "6".equals(valores2) ){
            if("1".equals(valores2)){
                for(int j=0;j<ubicacionC.size();j++){
                    if(ubicacionC.get(j).size()<5){
                        contador1=j;
                        break;
                    }
                }
for(int g=0; g<ubicacionC.size();g++){
                    ocupados+= ubicacionC.get(g).size();
                }
                if(ocupados<500){
                    System.out.println("Digite el serial del Contenedor");
                    int serialc=entrada.nextInt();
                    for(int k=0;k<ubicacionC.size();k++){
                        if(ubicacionC.get(k).contains(serialc)){ //Busqueda de elementos repetidos
                            System.out.println("Atención,El serial del Contenedor ya esta en el sistema");
                            boton= true;
                            break;
                        }
                        else{
                            boton=false;
                        }
                    }
                    if(false==boton){
                        if(contador1<=99){
                            ubicacionC.get(contador1).add(serialc);
                            int ubi=contador1+1;
                            System.out.println("La pila de contenedores quedo ubicada en la posicion: "+ubi);
                            if(ubicacionC.get(contador1).size()==5){
                                contador1+=1;
                            }
                            System.out.println(ubicacionC);
                            ocupados=0;
                            break;
                        }
                    }
                }
                else{
                    System.out.println("No es posible realizar este tramite,puerto lleno de Contenedores");
                    ocupados=0;
                }
            }
            else if("2".equals(valores2)){
                System.out.println("Digite el serial del Contenedor a ser entregado(extraido)");
                    int serialf=entrada.nextInt();//Requisito 3
                    for(int h=0;h<ubicacionC.size();h++){
                    if(ubicacionC.get(h).contains(serialf)){ //Busqueda de lugar
                            lugar=h;
                            boton=true;
                            break;
                        }
                    else{
                        boton=false;
                    }
                }
                if(boton==true){
                posicion=ubicacionC.get(lugar).size()-ubicacionC.get(lugar).indexOf(serialf);
                lugar+=1;
                System.out.println("Actualmente el Contenedores "+serialf+" se encuentra en la pila "+lugar+" en la ubicacion de salida de "+posicion);
                contador1=lugar-1;
                System.out.println(posicion);
                System.out.println(contador1);
                if(posicion==1 && contador1>=0){
                    ubicacionC.get(contador1).removeLast();
                    System.out.println(contador1);
                    System.out.println(ubicacionC);
                }
                if(posicion>1 && contador1<100){
                    System.out.println("Proceso a hacer con los Contenedores: ");//proceso que se hace dentro del puerto
                    System.out.println("Los contenedores seran movidos a pilas y devueltos a la posicion inicial a ser parte de la pila ubicada en "+(contador+1));
                    int correccion=ubicacionC.get(contador1).size();
                    ubicacionC.get(contador1).remove(correccion-posicion);// proceso que hace la pila manteniendo el orden de entrada LIFO de la pila
                    System.out.println(ubicacionC);
                    System.out.println("finalmente cambiando los inidices respetando la entrada de pilas y los oredenes de salida(LIFO) son :");
                    for(int yi=ubicacionC.get(contador1).size()-1;yi>=0;yi--){
                        System.out.println("serial : "+ubicacionC.get(contador1).get(yi));
                    }
                }
                if(contador1==100 && posicion!=1){
                  System.out.println("Proceso a hacer con los Contenedores: ");//proceso que se hace dentro del puerto
                    System.out.println("Los contenedores seran movidos a pila auxiliar y devueltos a la posicion inicial a ser parte de la pila ubicada en "+(contador+1));
                    int correccion=ubicacionC.get(contador1).size();
                    ubicacionC.get(contador1).remove(correccion-posicion);// proceso que hace la pila manteniendo el orden de entrada LIFO de la pila
                    System.out.println(ubicacionC);
                    System.out.println("finalmente cambiando los inidices respetando la entrada de pilas y los oredenes de salida(LIFO) son :");
                    for(int yi=ubicacionC.get(contador1).size()-1;yi>=0;yi--){
                        System.out.println("serial : "+ubicacionC.get(contador1).get(yi));
                    }
