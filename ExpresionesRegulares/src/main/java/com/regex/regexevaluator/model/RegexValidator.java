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

}
