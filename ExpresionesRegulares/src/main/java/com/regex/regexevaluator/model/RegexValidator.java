package com.regex.regexevaluator.model;

import java.util.regex.Pattern;

public class RegexValidator {

    /**
     * Valida si una cadena corresponde al formato de una placa de carro en
     * Colombia.
     * El formato es tres letras seguidas de tres números (ej. ABC123).
     *
     * @param placa La cadena a validar.
     * @return true si la cadena es una placa válida, false en caso contrario.
     */
    public boolean esPlacaDeCarroValida(String placa) {
        String expresion = "^[A-Z]{3}\\d{3}$";
        return Pattern.matches(expresion, placa);
    }

    /**
     * Valida si una cadena corresponde al formato de codigos postales en Medellín.
     * El formato es un número de 6 digitos que comienza con "05".
     * 
     * @param codPostal La cadena a validar.
     * @return true si la cadena es un codigo postal válido para Medellín, false en caso contrario.
     */
    public boolean esCodPostalValido(String codPostal){
        String expresion = "^05\\d{4}$";
        return Pattern.matches(codPostal, expresion);
    }

    /**
     * Valida números de teléfonos fijos en Medellín.
     * El formato es un número de 10 digitos que comienza con "604".
     * 
     * @param numFijo La cadena a validar.
     * @return true si la cadena es un número fijo valido en Medellín, false en caso contrario.
    */ 
    public boolean esNumFijoValido(String numFijo){
        String expresion = "^604\\d{7}$";
        return Pattern.matches(numFijo, expresion);
    }

    /** 
     * Valida números de teléfonos celulares en Colombia. 
     * El formato es un número de 10 dígitos que comienza con '3'.
     * 
     * @param numCelular La cadena a validar.
     * @return true si la cadena es un número de celular valido en Colombia, false en caso contrario.
    */
    public boolean esNumCelularValido(String numCelular){
        String expresion = "^3\\d{9}$";
        return Pattern.matches(numCelular, expresion);
    }

    /** 
     * Valida si una cadena corresponde a un formato general de correo electronico.
     * Formato : example@domain
     * 
     * @param email La cadena a validar.
     * @return true si la cadena es un correo electronico valido, false en caso contrario.
    */
    public boolean esEmailValido(String email){
        // [a-zA-Z0-9._%+-]+ - Es la parte de example: uno o mas caracteres de letras, números o ._%+-
        // [a-zA-Z0-9.-]+ - Es la parte de domain: uno o más caracteres de letras, números, punto o guion.
        // [a-zA-Z]{2,} - Al menos dos caracteres de letras
        String expresion = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(email, expresion);
    }

    /**  
     * Valida si una cadena corresponde a una fecha en formato dd/mm/aaaa.
     * Esta validación se centra en el formato y los rangos numéricos básicos.
     * 
     * @param fecha La cadena a validar.
     * @return true si la cadena tiene el formato de fecha valido, false en caso contrario. 
    */
    public boolean esFechaValida(String fecha){
        // El metódo valida los rangos numéricos, pero no valida la lógica del calendarip.
        String expresion = "^(0[1-9]|[12]\\d|3[01])\\/(0[1-9]|1[0-2])\\/\\d{4}$";
        return Pattern.matches(expresion, fecha);
    }

    /**
     * Valida si una cadena corresponde a un formato de 24 horas.
     * 
     * @param hora Cadena a validar.
     * @return  True si la cadena es valida, flase en caso contrario.
    */

    public boolean esHoraValida24(String hora){
        String expresion = "^([01]\\d|2[0-3]):([0-5]\\d):[0-5]\\d$";
        return Pattern.matches(expresion, hora);
    }

    /**
     * Valida si una cadena corresponde a un formato de 12 horas.
     * 
     * @param hora Cadena a validar.
     * @return True si la cadena es valida, flase en caso contrario.
     */
    public boolean esHoraValida12(String hora){
        String expresion = "^(0[1-9]|1[0-2]):([0-5]\\d):[0-5]\\d (AM|PM)$";
        return Pattern.matches(expresion, hora);
    }

    /**
     * Valida si una cadena corresponde a la declaración de una variable en Java
     * 
     * @param variable Cadena a validar
     * @return True si la cadena es valida, false en caso contrario.
     */
    public boolean esVarJava(String variable){
        String expresion = "^[a-zA-Z_][a-zA-Z0-9_]*$";
        return Pattern.matches(expresion, variable);
    }

    /**
     * Valida si una cadena corresponde al formato general de una URL, incluyendo
     * protocolo, dominio/IP, puerto opcional y ruta opcional.
     * 
     * @param url Cadena a validar.
     * @return True si la cadena es valida, false en caso contrario.
    */
    public boolean esURLValida(String url){
        // Valida protocolo, dominio (con subdominios) o IP, puerto opcional, y ruta/query/fragmento opcional.
        String expresion = "^((https?://)|(www\\.)?)([\\dA-Za-z\\.-]+)\\.([A-Za-z\\.]{2,6})([/\\w \\.-]*)*\\/?$";
        return Pattern.matches(expresion, url);
    }
    

    /**
     * Valida si una cadena corresponde a un formato ISBN-10 o ISBN-13 y especifica cuál es.
     * Puede incluir un prefijo opcional como "ISBN: ".
     *
     * @param isbn La cadena a validar.
     * @return "ISBN-13", "ISBN-10", o "No válido" según corresponda.
     */
    public String validarTipoISBN(String isbn) {
        // Expresión para ISBN-13: opcionalmente prefijo ISBN, seguido de 13 dígitos, con o sin guiones/espacios.
        // Ejemplo: 978-3-16-148410-0
        String expresionISBN13 = "^(?:ISBN(?:-13)?:?\\s)?(?:97[89][ -]?)?\\d{1,5}[- ]?\\d{1,7}[- ]?\\d{1,6}[- ]?\\d$";
        
        // Expresión para ISBN-10: opcionalmente prefijo ISBN, seguido de 10 dígitos (último puede ser X), con o sin guiones/espacios.
        // Ejemplo: 0-306-40615-2
        String expresionISBN10 = "^(?:ISBN(?:-10)?:?\\s)?\\d{1,5}[- ]?\\d{1,7}[- ]?\\d{1,6}[- ]?[0-9X]$";

        // Primero validamos el formato de 13 dígitos, que es más específico.
        if (Pattern.matches(expresionISBN13, isbn.replaceAll("[- ]", ""))) return "ISBN-13";
        if (Pattern.matches(expresionISBN10, isbn.replaceAll("[- ]", ""))) return "ISBN-10";

        return "No válido";
    }

}
