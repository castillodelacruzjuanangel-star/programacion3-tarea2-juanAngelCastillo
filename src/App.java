import java.util.Scanner;

public class App {

    //funcion para guardar los vehiculos registrados en un arreglo de tipo vehiculo
    public static void registrar(Vehiculo [] autos, Vehiculo nuevoAuto){
        for(int i = 0; i < autos.length; i++){
            //condicion para evitar sobreescribir un vehiculo
            if(autos[i] == null){
                autos[i] = nuevoAuto;
                System.out.println("Los datos del vehiculo se han registrado exitosamente.");
                return;
            }
        }
        //mensaje caso de alcanzar la capacidad maxima del arreglo
        System.out.println("No se pudo registrar el vehiculo. Capacidad maxima alcanzada");
    }

    //funcion para listar todos los vehiculos registrados
    public static void MostrarVehiculos(Vehiculo [] autos){
        System.out.println("""
                \n------------------------------------
                        VEHICULOS REGISTRADOS
                ------------------------------------
                MARCA\tMODELO\tMATRICULA\tCOLOR\tAÑO\tPRECIO
                """);
        for(int i = 0; i < autos.length; i++){
            //condicion para evitar salirse del arreglo
            if(autos[i] == null)
                break;

            System.out.printf("\n%s\t%s\t%s\t\t%s\t%d\t%.2f\n", autos[i].getMarca(), autos[i].getModelo(), autos[i].getMatricula(), autos[i].getColor(), autos[i].getAño(), autos[i].getPrecio());
        }
    }

    public static void main(String[] args) throws Exception {
        Vehiculo [] autos = new Vehiculo[100]; //declaracion del arreglo para guardar los vehiculos
        Scanner leer = new Scanner(System.in); 
        boolean salir = false; //declaracion de variable para iniciar y para el while 

        while (!salir) {
            System.out.println("""
                ====================================
                        REGISTRO DE VEHÍCULOS
                ====================================

                1. Registrar vehículo
                2. Mostrar vehículos
                3. Buscar vehículo por placa
                4. Mostrar vehículos por marca
                5. Salir
            """);

            System.out.print("Ingrese la opcion deseada: ");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:

                    Vehiculo nuevoAuto = new Vehiculo(); //crea un nuevo objeto vehiculo
                    System.out.println("\nRellene los siguientes datos del vehiculo.");

                    leer.nextLine();; //limpia el buffer antes de ingresar los datos
                    System.out.print("Marca: ");
                    nuevoAuto.setMarca(leer.nextLine());

                    System.out.print("Modelo: ");
                    nuevoAuto.setModelo(leer.nextLine());

                    String matricula = "";
                    do{ //bucle para asegurar que se registre una matricula valida{
                        System.out.print("Matricula EJ(A304612): ");
                        matricula = leer.nextLine();
                        nuevoAuto.setMatricula(matricula);
                    }while(nuevoAuto.getMatricula() == null || Vehiculo.matriculaExistente(matricula, autos));

                    System.out.print("Color: ");
                    nuevoAuto.setColor(leer.nextLine());

                    System.out.print("Año de fabricacion: ");
                    nuevoAuto.setAño(leer.nextInt());

                    System.out.print("Precio: ");
                    nuevoAuto.setPrecio(leer.nextDouble());

                    registrar(autos, nuevoAuto); //llama a la funcion registrar pasandole el arreglo y nuevoAuto como parametro
                    
                    break;
                case 2:

                    MostrarVehiculos(autos); //llama a la funcion mostrarVehiculos pasandole como parametro el arreglo
                    break;

                case 3:
                    System.out.print("\nIngrese la matricula del auto: ");
                    leer.nextLine(); //limpia el buffer
                    String matriculaBuscada = leer.nextLine(); //guarda la matricula que se desea buscar

                    Vehiculo.BuscarPorMatricula(autos, matriculaBuscada); //llama al metodo estatico ImprimirPorMatricula, de la clase vehiculo
                    break;

                case 4:

                    System.out.print("\nIngrese la marca deseada: ");
                    leer.nextLine(); //limpia el buffer
                    String marcaBuscada = leer.nextLine(); //guarda la marca que se desea buscar
                    marcaBuscada = marcaBuscada.toUpperCase();

                    System.out.printf("\nVehiculos %s registrados:\n", marcaBuscada);

                    Vehiculo.ImprimirPorMarca(autos, marcaBuscada); //llama al metodo estatico ImprimirPorMarca, de la clase vehiculo
                    break;
            
                case 5:
                    salir = true; //cambia el valor a true para terminar el bucle
                    leer.close(); //cierra el scanner
                    break;

                default:
                    System.out.println("\nOpcion invalida. Seleccione una de las opciones disponibles");
            }
        } 
    }
}
