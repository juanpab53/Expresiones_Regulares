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
}
