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
        // La expresión regular ^[A-Z]{3}\d{3}$ valida:
        // ^ - Inicio de la cadena.
        // [A-Z]{3} - Exactamente tres letras mayúsculas.
        // \d{3} - Exactamente tres dígitos (equivalente a [0-9]{3}).
        // $ - Fin de la cadena.
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
        // La expresión regular ^05\d{4}$ valida:
        // ^ - Inicio de la cadena
        // 05 - Los caracteres iniciales que ha de tener 
        // \d{4} - Exactamente 4 digitos
        // $ - Fin de la cadena
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
        //La expresión regular ^604\\d{7} valida:
        // ^ - Inicio de la cadena
        // 604 - Los caracteres iniciales que ha de tener 
        // \d{7} - Exactamente 7 digitos
        // $ - Fin de la cadena
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
        // La expresión regular ^3\d{9}$ valida:
        // ^ - Inicio de la cadena
        // 3 - El caracter inicial
        // \d{9} - Exactamente 9 digitos
        // $ - Fin de la cadena
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
        // La expresión regular ^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$ valida:
        // ^ - Inicio de la cadena
        // [a-zA-Z0-9._%+-]+ - Es la parte de example: uno o mas caracteres de letras, números o ._%+-
        // @ - El caracter @
        // [a-zA-Z0-9.-]+ - Es la parte de domain: uno o más caracteres de letras, números, punto o guion.
        // \. - El caracter .
        // [a-zA-Z]{2,} - Al menos dos caracteres de letras
        // $ - Fin de la cadena
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
        // La expresión regular ^(0[1-9]|[12]\\d|3[01])\\/(0[1-9]|1[0-2])\\/\\d{4}$ valida:
        // ^ - Inicio de la cadena.
        // (0[1-9]|[12]\\d|3[01]) - Día : 01-09, 10-29, 30-31.
        // \/ - Separador '/'.
        // (0[1-9]|1[0-2]) - Mes : 01-09, 10-12.
        // \/ - Separador '/'.
        // \d{4} - Año : 4 dígitos.
        // $ - Fin de la cadena.
        // Nota: El metódo valida los rangos numéricos, pero no valida la lógica del calendarip.
        String expresion = "^(0[1-9]|[12]\\d|3[01])\\/(0[1-9]|1[0-2])\\/\\d{4}$";
        return Pattern.matches(expresion, fecha);
    }

}
