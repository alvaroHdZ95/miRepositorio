import java.util.Scanner;

/** 
 * @author �lvaro Hern�ndez Valero
 * @version 21/02/2022
 *
 */

/**
 * @brief	Este c�digo pide que se introduzca un precio por pantalla
 * 			y un tipo de impuesto para aplic�rselo al precio introducido.
 * 			Finalmente muestra por pantalla el precio tras aplicar el 
 * 			impuesto.
 */

public class Ej06_PrecioConIVA
{
    // DECLARACI�N DE CONSTANTES
	
	//Constante est�tica de tipo int con el porcentaje (expresado en tanto por uno) del impuesto general
	static final double IMP_GENERAL = 0.21;

	//Constante est�tica de tipo int con el porcentaje (expresado en tanto por uno) del impuesto reducido
    static final double IMP_REDUCIDO = 0.1;

	//Constante est�tica de tipo int con el porcentaje (expresado en tanto por uno) del impuesto super reducido
    static final double IMP_SUPERREDUCIDO = 0.04;

    /**
     * @brief	m�todo est�tico que recibe como par�metro un String, intenta convertirlo en un double y, en caso
     * 			de que no sea posible, atrapa la excepci�n que se producir�a y lo gestiona devolviendo un -1.
     * 
     *  @param	cadena: String que el usuario ha introducido previamente por teclado y no se sabe a�n si es un dato
     *  				v�lido para el prop�sito del programa.
     *  
     *  @return	si cadena puede convertirse en double, devolver� el valor num�rico de la cadena al convertirla a double.
     *  		Si no, devolver� un -1.
     */
    public static double esDouble(String cadena)
    {
    	/* Si el dato es v�lido devuelve ese precio, si es negativo, el while en el que se llama al
    	 * m�todo, vuelve a invalidar el dato
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
     * @brief	m�todo est�tico que recibe como par�metro un String, intenta convertirlo en un int y, en caso
     * 			de que no sea posible, atrapa la excepci�n que se producir�a y lo gestiona devolviendo un -1.
     * 
     *  @param	cadena: String que el usuario ha introducido previamente por teclado y no se sabe a�n si es un dato
     *  				v�lido para el prop�sito del programa.
     *  
     *  @return	si cadena puede convertirse en int, devolver� el valor num�rico de la cadena al convertirla a int.
     *  		Si no, devolver� un -1.
     */
    public static int esInt(String cadena)
    {
    	/* Si el dato es v�lido devuelve ese precio, si es negativo, el while en el que se llama al
    	 * m�todo, vuelve a invalidar el dato
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
        //DECLARACI�N DE VARIABLES
    	
    	//precio base y precio final (el �ltimo es el primero m�s los impuestos y el descuento aplicado)
    	double base_imponible, precio_final;

        int iva, cod_prom;

        String entrada;

        Scanner input = new Scanner(System.in);

        //Pide por pantalla que se introduzca el precio base por teclado
        System.out.print("Introduzca la base imponible: ");
        entrada = input.nextLine();
        
        //bucle en el que se verifica que el precio base introducido es v�lido
        while ((base_imponible = esDouble(entrada)) < 0) 
        {
            System.out.println("Introduce un número (positivo) para poder continuar");
            entrada = input.nextLine();
        }

        //Pide por pantalla que se introduzca por teclado el c�digo del impuesto aplicado 
        System.out.print("Introduzca el tipo de iva {[1]: IVA general; [2]: IVA reducido; [3]: IVA superreducido}: ");
        entrada = input.nextLine();
        
        //bucle en el que se verifica que el c�digo introducido por teclado es v�lido
        while (((iva = esInt(entrada)) <= 0) || (esInt(entrada)) > 3) //mientras el IVA no sea válido
        {
            System.out.println("Introduce una opción válida para poder continuar");
            entrada = input.nextLine();
        }
    }
}
