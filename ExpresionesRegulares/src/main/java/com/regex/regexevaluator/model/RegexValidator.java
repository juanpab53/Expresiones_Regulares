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

}
