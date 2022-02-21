import java.util.Scanner;

/** 
 * @author Álvaro Hernández Valero
 * @version 21/02/2022
 *
 */

/**
 * @brief	Este código pide que se introduzca un precio por pantalla
 * 			y un tipo de impuesto para aplicárselo al precio introducido.
 * 			Finalmente muestra por pantalla el precio tras aplicar el 
 * 			impuesto.
 */

public class Ej06_PrecioConIVA
{
    // DECLARACIÓN DE CONSTANTES
	
	//Constante estática de tipo int con el porcentaje (expresado en tanto por uno) del impuesto general
	static final double IMP_GENERAL = 0.21;

	//Constante estática de tipo int con el porcentaje (expresado en tanto por uno) del impuesto reducido
    static final double IMP_REDUCIDO = 0.1;

	//Constante estática de tipo int con el porcentaje (expresado en tanto por uno) del impuesto super reducido
    static final double IMP_SUPERREDUCIDO = 0.04;

    /**
     * @brief	método estático que recibe como parámetro un String, intenta convertirlo en un double y, en caso
     * 			de que no sea posible, atrapa la excepción que se produciría y lo gestiona devolviendo un -1.
     * 
     *  @param	cadena: String que el usuario ha introducido previamente por teclado y no se sabe aún si es un dato
     *  				válido para el propósito del programa.
     *  
     *  @return	si cadena puede convertirse en double, devolverá el valor numérico de la cadena al convertirla a double.
     *  		Si no, devolverá un -1.
     */
    public static double esDouble(String cadena)
    {
    	/* Si el dato es válido devuelve ese precio, si es negativo, el while en el que se llama al
    	 * método, vuelve a invalidar el dato
    	 */
    	try
        {
            return Double.parseDouble(cadena);
        }
        catch(NumberFormatException exception)
        {
            return -1;
        }
    }

    /**
     * @brief	método estático que recibe como parámetro un String, intenta convertirlo en un int y, en caso
     * 			de que no sea posible, atrapa la excepción que se produciría y lo gestiona devolviendo un -1.
     * 
     *  @param	cadena: String que el usuario ha introducido previamente por teclado y no se sabe aún si es un dato
     *  				válido para el propósito del programa.
     *  
     *  @return	si cadena puede convertirse en int, devolverá el valor numérico de la cadena al convertirla a int.
     *  		Si no, devolverá un -1.
     */
    public static int esInt(String cadena)
    {
    	/* Si el dato es válido devuelve ese precio, si es negativo, el while en el que se llama al
    	 * método, vuelve a invalidar el dato
    	 */
    	try
        {
            return Integer.parseInt(cadena);	
        }                                   	
        catch(NumberFormatException exception) 
        {
            return -1;
        }
    }

    public static void main(String[] args)
    {
        //DECLARACIÓN DE VARIABLES
    	
    	//precio base y precio final (el último es el primero más los impuestos y el descuento aplicado)
    	double base_imponible, precio_final;

        int iva, cod_prom;

        String entrada;

        Scanner input = new Scanner(System.in);

        //Pide por pantalla que se introduzca el precio base por teclado
        System.out.print("Introduzca la base imponible: ");
        entrada = input.nextLine();
        
        //bucle en el que se verifica que el precio base introducido es válido
        while ((base_imponible = esDouble(entrada)) < 0) 
        {
            System.out.println("Introduce un nÃºmero (positivo) para poder continuar");
            entrada = input.nextLine();
        }

        //Pide por pantalla que se introduzca por teclado el código del impuesto aplicado 
        System.out.print("Introduzca el tipo de iva {[1]: IVA general; [2]: IVA reducido; [3]: IVA superreducido}: ");
        entrada = input.nextLine();
        
        //bucle en el que se verifica que el código introducido por teclado es válido
        while (((iva = esInt(entrada)) <= 0) || (esInt(entrada)) > 3) //mientras el IVA no sea vÃ¡lido
        {
            System.out.println("Introduce una opciÃ³n vÃ¡lida para poder continuar");
            entrada = input.nextLine();
        }
    }
}
