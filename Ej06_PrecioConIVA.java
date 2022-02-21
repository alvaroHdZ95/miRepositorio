package Condicionales_y_comparadores;

import java.util.Scanner;

public class Ej06_PrecioConIVA
{
    static final double IMP_GENERAL = 0.21;

    static final double IMP_REDUCIDO = 0.1;

    static final double IMP_SUPERREDUCIDO = 0.04;

    public static double esDouble(String cadena)
    {
        try
        {
            return Double.parseDouble(cadena);  //Si el dato es válido devuelve ese precio
        }                                   //si es negativo, el while en el que se llama al
        catch(NumberFormatException exception) //método, vuelve a invalidar el dato
        {
            return -1; //Si no es válido devuelve -1
        }
    }

    public static int esInt(String cadena)
    {
        try
        {
            return Integer.parseInt(cadena); //Si el dato es válido devuelve ese precio
        }                                   //si es negativo, el while en el que se llama al
        catch(NumberFormatException exception) //método, vuelve a invalidar el dato
        {
            return -1; //Si no es válido devuelve -1
        }
    }

    public static void main(String[] args)
    {
        double base_imponible, precio_final;

        int iva, cod_promocional;

        String entrada;

        Scanner input = new Scanner(System.in);

        System.out.print("Introduzca la base imponible: ");
        entrada = input.nextLine();
        while ((base_imponible = esDouble(entrada)) < 0) //mientras el precio no se válido
        {
            System.out.println("Introduce un número (positivo) para poder continuar");
            entrada = input.nextLine();
        }

        System.out.print("Introduzca el tipo de iva {[1]: IVA general; [2]: IVA reducido; [3]: IVA superreducido}: ");
        entrada = input.nextLine();
        while (((iva = esInt(entrada)) <= 0) || (esInt(entrada)) > 3) //mientras el IVA no sea válido
        {
            System.out.println("Introduce una opción válida para poder continuar");
            entrada = input.nextLine();
        }

        System.out.print("Introduzca el código promocional del producto {[1]: nopro; [2]: mitad; [3]: meno5; [4]: 5porc}");
    }
}
