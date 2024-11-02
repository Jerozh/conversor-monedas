import java.util.Scanner;

public class Eleccion {
         public static String[] obtenerMonedas() {
         Scanner teclado = new Scanner(System.in);
            String[] monedas = new String[2];

            int eleccionUsuario = teclado.nextInt();
            teclado.nextLine();
            if(eleccionUsuario < 1){
               // System.out.println("Estas ingresando un valor negativo, intenta con una positivo");
                monedas[0] = "xdxd";
            }

               if(eleccionUsuario <=11) {

               switch (eleccionUsuario) {
                 case 1:
                     monedas[0] = "USD";
                     monedas[1] = "EUR";
                     break;
                 case 2:
                     monedas[0] = "EUR";
                     monedas[1] = "USD";
                     break;
                 case 3:
                     monedas[0] = "ARS";
                     monedas[1] = "USD";
                     break;
                 case 4:
                     monedas[0] = "USD";
                     monedas[1] = "ARS";
                     break;
                 case 5:
                     monedas[0] = "ARS";
                     monedas[1] = "BRL";
                     break;
                 case 6:
                     monedas[0] = "BRL";
                     monedas[1] = "ARS";
                     break;
                 case 7:
                     monedas[0] = "BRL";
                     monedas[1] = "USD";
                     break;
                 case 8:
                     monedas[0] = "USD";
                     monedas[1] = "BRL";
                     break;
                 case 9:
                     monedas[0] = "BRL";
                     monedas[1] = "EUR";
                     break;
                 case 10:
                     monedas[0] = "EUR";
                     monedas[1] = "BRL";
                     break;
                 case 11:
                    monedas[0] = null;
                     System.out.println("Hasta la proxima");
                     break;

             }
                 }else{

                 monedas[1] = "jjj";
             }
             return monedas;
         }
}



