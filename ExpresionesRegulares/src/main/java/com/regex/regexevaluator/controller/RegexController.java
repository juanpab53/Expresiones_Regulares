package com.regex.regexevaluator.controller;

import com.regex.regexevaluator.model.RegexValidator;

public class RegexController {

    private final RegexValidator validator;

    /**
     * Constructor que inicializa el validador de expresiones regulares.
     */
    public RegexController() {
        this.validator = new RegexValidator();
    }

    public boolean validarPlacaDeCarro(String placa) {
        return validator.esPlacaDeCarroValida(placa);
    }

    public boolean validarCodPostal(String codPostal) {
        return validator.esCodPostalValido(codPostal);
    }

    public boolean validarNumFijo(String numFijo) {
        return validator.esNumFijoValido(numFijo);
    }

    public boolean validarNumCelular(String numCelular) {
        return validator.esNumCelularValido(numCelular);
    }

    public boolean validarEmail(String email) {
        return validator.esEmailValido(email);
    }

    public boolean validarFecha(String fecha) {
        return validator.esFechaValida(fecha);
    }

    public boolean validarHora24(String hora) {
        return validator.esHoraValida24(hora);
    }

    public boolean validarHora12(String hora) {
        return validator.esHoraValida12(hora);
    }

    public boolean validarVariableJava(String variable) {
        return validator.esVarJava(variable);
    }

    public boolean validarURL(String url) {
        return validator.esURLValida(url);
    }

    /**
     * Valida un código ISBN y devuelve si es ISBN-10, ISBN-13 o no válido.
     * @param isbn La cadena a validar.
     * @return "ISBN-13", "ISBN-10", o "No válido".
     */
    public String validarTipoISBN(String isbn) {
        return validator.validarTipoISBN(isbn);
    }

    public boolean validarCodigoBarrasColombia(String codigoBarras) {
        return validator.esCodigoBarrasColombiaValido(codigoBarras);
    }

    public boolean validarNombreApellido(String nombre) {
        return validator.esNombreApellidoValido(nombre);
    }

    public boolean validarContrasenaSegura(String contrasena) {
        return validator.esContrasenaSegura(contrasena);
    }

    public boolean validarCicloFor(String cicloFor) {
        return validator.esCicloForValido(cicloFor);
    }

    public boolean validarNumeroDouble(String numero) {
        return validator.esNumeroDoubleValido(numero);
    }

    public boolean validarLeyDecretoArticulo(String textoLegal) {
        return validator.esLeyDecretoArticuloValido(textoLegal);
    }

    public boolean validarReferenciaIeee(String referencia) {
        return validator.esReferenciaIeeeValida(referencia);
    }

    public boolean validarReferenciaApa(String referencia) {
        return validator.esReferenciaApaValida(referencia);
    }

    public boolean validarPrecioProducto(String precio) {
        return validator.esPrecioProductoValido(precio);
    }

    /**
     * Clasifica una secuencia de vocales en una palabra.
     * @param palabra La palabra a analizar.
     * @return Una cadena indicando el tipo de secuencia vocálica.
     */
    public String clasificarDiptongoHiato(String palabra) {
        return validator.clasificarDiptongoHiato(palabra);
    }
}
