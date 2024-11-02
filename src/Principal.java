import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        int num = 0;
        try {
            while (num != 11) {
                System.out.println("""
                        *********************************************************************
                        Bienvenido al Conversor de Moneda!
                        """);
                System.out.println("""
                         1)Dolar >>> Euro
                         2)Euro >>> Dolar
                         3)Peso ARG >>> Dolar
                         4)USD >>> Peso ARG
                         5)Peso ARG >>> Real Brasil
                         6)Real Brasil >>> Peso ARG
                         7)Real Brasil >>> Dolar
                         8)Dolar >>> Real Brasil
                         9)Real Brasil >>> Euro
                         10)Euro >>> Real Brasil
                         11)Salir
                        """);

                System.out.println("Seleccione la opcion de monedas que desee obtener el cambio: ");
                try {
                    String[] monedas = Eleccion.obtenerMonedas();
                    String moneda1 = monedas[0];
                    String moneda2 = monedas[1];
                    if(moneda1 == "xdxd"){
                        System.out.println("Estas ingresando un numero negativo, por favor intenta de nuevo");
                    }else if (moneda1 != null && moneda2 != "jjj") {
                        System.out.println("ingrese la cantidad: ");
                        double cantidad = teclado.nextDouble();
                        if (cantidad <= 0) {
                            System.out.println("Error: La cantidad debe ser un número positivo.");
                        }else {
                            ConexionApi conexion = new ConexionApi(moneda1, moneda2, cantidad);
                            String respuesta = conexion.realizarPeticion();
                            System.out.println("Su conversion es: " + cantidad + " " + moneda1 + " " + "corresponde al valor final de: " + respuesta + " " + moneda2 + "\n");
                            System.out.println("*********************************************************************");
                        }

                    }else if (moneda2 == "jjj") {
                        System.out.println("numero incorrecto, intenta de nuevo");
                    }else{
                        break;
                    }
                    }catch(InputMismatchException e){
                    System.out.println("El valor ingresado, no es correcto, al parecer marcaste una letra.");
                    System.out.println("Intenta nuevamente");

                }

            }
        }catch (Exception e) {
            System.out.println("Error general" + e.getMessage());
        }
    }
}