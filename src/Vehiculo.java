
public class Vehiculo {
    private String matricula;
    private String color;
    private String marca;
    private int año;
    private double precio;
    private String modelo;
  
    
    public Vehiculo(){}

    //getters
    public String getMatricula() {
        return matricula;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public int getAño() {
        return año;
    }

    public double getPrecio() {
        return precio;
    }

    public String getModelo(){
        return modelo;
    }

    //setters
    public void setMatricula(String matricula) {
        matricula = matricula.toUpperCase();
        if(validarMatricula(matricula))
            this.matricula = matricula;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        marca = marca.toUpperCase();
        this.marca = marca;
    }

    public void setAño(int año) {
        this.año = (año >= 1908) ? año : 1908;
    }

    public void setPrecio(double precio) {
        this.precio = (precio >= 0) ? precio : 0.0;
    }

    public void setModelo(String modelo){
        modelo = modelo.toLowerCase();
        this.modelo = modelo;
    }

    private static boolean validarMatricula(String matricula){
        if(!matricula.matches("[AGKL]\\d{6}")){
            System.out.println("Matricula invalida. La matricula debe empezar con A, G, K o L seguido de 6 digitos.");
            return false;
        }
        return true;
    }

    public static boolean matriculaExistente(String matricula, Vehiculo [] arrayVehiculos){
        for(int i = 0; i < arrayVehiculos.length; i++){
            if(arrayVehiculos[i] != null){
                if(arrayVehiculos[i].getMatricula().equalsIgnoreCase(matricula)){
                    System.out.println("Esta matricula ya esta registrada. Pruebe con otra");
                    return true;
                }
            }
        }
        return false;
    }

    public static void BuscarPorMatricula(Vehiculo [] arrayVehiculos, String matriculaBuscada){
        matriculaBuscada = matriculaBuscada.toUpperCase();

        for(int i = 0; i < arrayVehiculos.length; i++){
            if(arrayVehiculos[i] != null && arrayVehiculos[i].getMatricula().equals(matriculaBuscada)){
                System.out.printf("""
                        \nMarca: %s\t Modelo: %s\tMatricula: %s\tColor: %s\tAño: %d\tPrecio: %.2f\n
                        """, arrayVehiculos[i].getMarca(), arrayVehiculos[i].getModelo(), arrayVehiculos[i].getMatricula(), 
                            arrayVehiculos[i].getColor(), arrayVehiculos[i].getAño(), arrayVehiculos[i].getPrecio());
            }
        }
    }

    public static void ImprimirPorMarca(Vehiculo [] arrayVehiculos, String marcaBuscada){
        for(int i = 0; i < arrayVehiculos.length; i++){
            if(arrayVehiculos[i] != null && arrayVehiculos[i].getMarca().equals(marcaBuscada)){
                System.out.printf("""
                        \nMarca: %s\t Modelo: %s\tMatricula: %s\tColor: %s\tAño: %d\tPrecio: %.2f\n
                        """, arrayVehiculos[i].getMarca(), arrayVehiculos[i].getModelo(), arrayVehiculos[i].getMatricula(), 
                            arrayVehiculos[i].getColor(), arrayVehiculos[i].getAño(), arrayVehiculos[i].getPrecio());
            }
        }
    }
    
}
