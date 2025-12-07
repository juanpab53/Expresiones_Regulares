package com.regex.regexevaluator.views;

import com.regex.regexevaluator.controller.RegexController;

import java.util.Scanner;

public class ClientView {
    private final RegexController controller;
    private final Scanner scan;

    public ClientView(RegexController controller) {
        this.controller = controller;
        this.scan = new Scanner(System.in);
    }

    public void iniciar() {
        boolean continuar = true;
        do {
            mostrarMenu();
            try {
                int opcion = Integer.parseInt(scan.nextLine());
                continuar = procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
            }
            if (continuar) {
                System.out.println("\nPresione Enter para continuar...");
                scan.nextLine();
            }
        } while (continuar);
        scan.close();
    }

    private void mostrarMenu() {
        System.out.println("\n--- Validador de Expresiones Regulares ---");
        System.out.println("1. Placa de carro (Colombia)");
        System.out.println("2. Código postal (Medellín)");
        System.out.println("3. Teléfono fijo (Medellín)");
        System.out.println("4. Teléfono celular (Colombia)");
        System.out.println("5. Correo electrónico");
        System.out.println("6. Fecha (dd/mm/aaaa)");
        System.out.println("7. Hora (24h hh:mm:ss)");
        System.out.println("8. Hora (12h hh:mm:ss AM/PM)");
        System.out.println("9. Nombre de variable en Java");
        System.out.println("10. URL");
        System.out.println("11. Código ISBN (10 o 13)");
        System.out.println("12. Código de barras (Colombia EAN-13)");
        System.out.println("13. Nombre y/o Apellido");
        System.out.println("14. Contraseña segura");
        System.out.println("15. Estructura de ciclo 'for' en Java");
        System.out.println("16. Número double");
        System.out.println("17. Ley, Decreto o Artículo");
        System.out.println("18. Referencia de libro (IEEE)");
        System.out.println("19. Referencia de libro (APA 7ma ed.)");
        System.out.println("20. Precio de producto");
        System.out.println("21. Clasificar Diptongo/Hiato");
        System.out.println("0. Salir");
        System.out.println("------------------------------------------");
        System.out.print("Digite la opción deseada: ");
    }

    private boolean procesarOpcion(int opcion) {
        switch (opcion) {
            case 0:
                System.out.println("¡Hasta luego!");
                return false;
            case 1:
                solicitarYValidar("Ingrese la placa de carro (ej. ABC123):", controller::validarPlacaDeCarro);
                break;
            case 2:
                solicitarYValidar("Ingrese el código postal (ej. 050001):", controller::validarCodPostal);
                break;
            case 3:
                solicitarYValidar("Ingrese el número de teléfono fijo (ej. 6041234567):", controller::validarNumFijo);
                break;
            case 4:
                solicitarYValidar("Ingrese el número de celular (ej. 3001234567):", controller::validarNumCelular);
                break;
            case 5:
                solicitarYValidar("Ingrese el correo electrónico:", controller::validarEmail);
                break;
            case 6:
                solicitarYValidar("Ingrese la fecha (dd/mm/aaaa):", controller::validarFecha);
                break;
            case 7:
                solicitarYValidar("Ingrese la hora en formato 24h (hh:mm:ss):", controller::validarHora24);
                break;
            case 8:
                solicitarYValidar("Ingrese la hora en formato 12h (hh:mm:ss AM/PM):", controller::validarHora12);
                break;
            case 9:
                solicitarYValidar("Ingrese el nombre de la variable Java:", controller::validarVariableJava);
                break;
            case 10:
                solicitarYValidar("Ingrese la URL:", controller::validarURL);
                break;
            case 11:
                solicitarYClasificar("Ingrese el código ISBN:", controller::validarTipoISBN);
                break;
            case 12:
                solicitarYValidar("Ingrese el código de barras (EAN-13):", controller::validarCodigoBarrasColombia);
                break;
            case 13:
                solicitarYValidar("Ingrese el nombre y/o apellido:", controller::validarNombreApellido);
                break;
            case 14:
                solicitarYValidar("Ingrese la contraseña:", controller::validarContrasenaSegura);
                break;
            case 15:
                solicitarYValidar("Ingrese la estructura del ciclo for:", controller::validarCicloFor);
                break;
            case 16:
                solicitarYValidar("Ingrese el número double:", controller::validarNumeroDouble);
                break;
            case 17:
                solicitarYValidar("Ingrese el texto legal (Ley/Decreto/Artículo):", controller::validarLeyDecretoArticulo);
                break;
            case 18:
                solicitarYValidar("Ingrese la referencia IEEE:", controller::validarReferenciaIeee);
                break;
            case 19:
                solicitarYValidar("Ingrese la referencia APA:", controller::validarReferenciaApa);
                break;
            case 20:
                solicitarYValidar("Ingrese el precio del producto:", controller::validarPrecioProducto);
                break;
            case 21:
                solicitarYClasificar("Ingrese la palabra a analizar:", controller::clasificarDiptongoHiato);
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                break;
        }
        return true;
    }

    /**
     * Método genérico para solicitar un dato, validarlo con una función que devuelve un booleano
     * y mostrar el resultado.
     * @param mensaje El texto a mostrar al usuario para solicitar el dato.
     * @param validador La función de validación del controlador a ejecutar (ej. controller::esPlacaValida).
     */
    private void solicitarYValidar(String mensaje, java.util.function.Function<String, Boolean> validador) {
        System.out.println(mensaje);
        String entrada = scan.nextLine();
        boolean esValido = validador.apply(entrada);

        if (esValido) {
            System.out.println("--> Resultado: La entrada '" + entrada + "' es VÁLIDA.");
        } else {
            System.out.println("--> Resultado: La entrada '" + entrada + "' NO es válida.");
        }
    }

    /**
     * Método genérico para solicitar un dato, clasificarlo con una función que devuelve un String
     * y mostrar el resultado.
     * @param mensaje El texto a mostrar al usuario para solicitar el dato.
     * @param clasificador La función de clasificación del controlador a ejecutar (ej. controller::validarTipoISBN).
     */
    private void solicitarYClasificar(String mensaje, java.util.function.Function<String, String> clasificador) {
        System.out.println(mensaje);
        String entrada = scan.nextLine();
        String resultado = clasificador.apply(entrada);
        System.out.println("--> Resultado: " + resultado);
    }
}