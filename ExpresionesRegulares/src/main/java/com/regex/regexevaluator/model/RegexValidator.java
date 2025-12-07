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

    /**
     * Valida si una cadena corresponde a un código de barras de Colombia (EAN-13).
     * El formato son 13 dígitos que comienzan con el prefijo 770.
     *
     * @param codigoBarras La cadena a validar.
     * @return true si la cadena es un código de barras válido, false en caso contrario.
     */
    public boolean esCodigoBarrasColombiaValido(String codigoBarras) {
        String expresion = "^770\\d{10}$";
        return Pattern.matches(expresion, codigoBarras);
    }

    /**
     * Valida si una cadena corresponde a un nombre o apellido, permitiendo tildes, la letra 'ñ' y espacios.
     *
     * @param nombre La cadena a validar.
     * @return true si la cadena es un nombre válido, false en caso contrario.
     */
    public boolean esNombreApellidoValido(String nombre) {
        String expresion = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+(\\s[a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*$";
        return Pattern.matches(expresion, nombre);
    }

    /**
     * Valida si una contraseña cumple con criterios de seguridad:
     * Mínimo 8 caracteres, una mayúscula, una minúscula, un número y un carácter especial.
     *
     * @param contrasena La contraseña a validar.
     * @return true si la contraseña es segura, false en caso contrario.
     */
    public boolean esContrasenaSegura(String contrasena) {
        String expresion = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(expresion, contrasena);
    }

    /**
     * Valida si una cadena tiene la estructura básica de un ciclo 'for' en Java.
     *
     * @param cicloFor La cadena a validar.
     * @return true si la estructura es válida, false en caso contrario.
     */
    public boolean esCicloForValido(String cicloFor) {
        String expresion = "^for\\s*\\(.*?\\;.*?\\;.*?\\)\\s*\\{?.*$";
        return Pattern.matches(expresion, cicloFor);
    }

    /**
     * Valida si una cadena representa un número de tipo double, incluyendo signo y notación científica.
     *
     * @param numero La cadena a validar.
     * @return true si es un número double válido, false en caso contrario.
     */
    public boolean esNumeroDoubleValido(String numero) {
        String expresion = "^[+-]?(\\d+|\\d*\\.\\d+)([eE][+-]?\\d+)?$";
        return Pattern.matches(expresion, numero);
    }

    /**
     * Valida si una cadena corresponde a un formato de Ley, Decreto o Artículo en Colombia.
     * Ejemplos: "Ley 123 de 2023", "Decreto 456", "Artículo 7".
     *
     * @param textoLegal La cadena a validar.
     * @return true si el formato es válido, false en caso contrario.
     */
    public boolean esLeyDecretoArticuloValido(String textoLegal) {
        String expresion = "^(Ley|Decreto|Artículo)\\s+\\d+(\\s+de\\s+\\d{4})?([,\\s]+artículo\\s+\\d+)?$";
        return Pattern.matches(expresion, textoLegal);
    }

    /**
     * Valida si una cadena corresponde al formato de referencia de libro impreso en normas IEEE.
     * Formato: [1] A. Author, "Title of Book," City, State: Publisher, year.
     *
     * @param referencia La cadena a validar.
     * @return true si el formato es válido, false en caso contrario.
     */
    public boolean esReferenciaIeeeValida(String referencia) {
        String expresion = "^\\[\\d+\\]\\s+[A-Z]\\.\\s+[A-Za-z]+(?:,\\s+[A-Z]\\.\\s+[A-Za-z]+)*,\\s+\"[^\"]+\",\\s+[A-Za-z\\s]+,\\s+[A-Za-z\\s]+:\\s+[A-Za-z\\s]+,\\s+\\d{4}\\.$";
        return Pattern.matches(expresion, referencia);
    }

    /**
     * Valida si una cadena corresponde al formato de referencia de libro en normas APA 7ma ed.
     * Formato: Author, A. A. (Year). Title of work. Publisher.
     *
     * @param referencia La cadena a validar.
     * @return true si el formato es válido, false en caso contrario.
     */
    public boolean esReferenciaApaValida(String referencia) {
        String expresion = "^[A-Za-z]+,\\s+[A-Z]\\.(?:\\s+[A-Z]\\.)*\\s+\\(\\d{4}\\)\\.\\s+.+?\\.\\s+[A-Za-z\\s&]+(?:, Inc\\.)?\\.$";
        return Pattern.matches(expresion, referencia);
    }

    /**
     * Valida si una cadena corresponde a un formato de precio de producto.
     * Admite signo de peso opcional, separadores de miles (punto) y decimales (coma).
     *
     * @param precio La cadena a validar.
     * @return true si el formato es válido, false en caso contrario.
     */
    public boolean esPrecioProductoValido(String precio) {
        String expresion = "^\\$?(\\d{1,3}(\\.\\d{3})*|\\d+)(,\\d{1,2})?$";
        return Pattern.matches(expresion, precio);
    }
    
    /**
     * Analiza una palabra para clasificar secuencias de vocales como hiatos o posibles diptongos.
     *
     * @param palabra La palabra a analizar.
     * @return Una cadena que indica "Hiato Acentual", "Hiato Simple", "Posible Diptongo",
     *         o "No contiene secuencia vocálica relevante".
     */
    public String clasificarDiptongoHiato(String palabra) {
        // Regex 1: Hiato Simple (dos vocales abiertas juntas).
        // Ejemplos: "teatro", "caos", "poeta".
        String hiatoSimpleRegex = ".*[aáeéoó][aáeéoó].*";
        if (Pattern.compile(hiatoSimpleRegex, Pattern.CASE_INSENSITIVE).matcher(palabra).matches()) {
            return "Hiato Simple";
        }

        // Regex 2: Posible Diptongo (vocal abierta + cerrada átona, o dos cerradas).
        // Es una aproximación, ya que no podemos saber la tonicidad de una vocal sin tilde.
        // Ejemplos: "ciudad", "piano", "reina".
        String diptongoRegex = ".*([aáeéoó][iu]|[iu][aáeéoó]|[iu][iu]).*";
        if (Pattern.compile(diptongoRegex, Pattern.CASE_INSENSITIVE).matcher(palabra).matches()) {
            return "Posible Diptongo";
        }

        return "No contiene secuencia vocálica relevante";
    }
}
