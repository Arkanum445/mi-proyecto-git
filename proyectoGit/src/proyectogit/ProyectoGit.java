/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogit;

import java.util.Scanner;

/**
 *
 * @author edgar
 */
public class ProyectoGit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner sc = new Scanner(System.in);
        ControladorAsistentes controlador = new ControladorAsistentes();
        int opcion = 0;

        do {
            try {
                System.out.println("\n========== SISTEMA DE ASISTENTES XYZ ==========");
                System.out.println("1. Registrar asistente completo");
                System.out.println("2. Registrar asistente sin contacto");
                System.out.println("3. Listar todos los asistentes");
                System.out.println("4. Listar asistentes por categoría");
                System.out.println("5. Listar asistentes sin mostrar contacto");
                System.out.println("6. Ver cantidad de asistentes");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        registrarCompleto(sc, controlador);
                        break;

                    case 2:
                        registrarSinContacto(sc, controlador);
                        break;

                    case 3:
                        controlador.listarAsistentes();
                        break;

                    case 4:
                        System.out.print("Ingrese categoría (Niño, Adolescente, Adulto): ");
                        String categoria = sc.nextLine();
                        controlador.listarAsistentes(categoria);
                        break;

                    case 5:
                        controlador.listarAsistentes(false);
                        break;

                    case 6:
                        System.out.println("Cantidad de asistentes: " + controlador.cantidadAsistentes());
                        break;

                    case 7:
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println("Opción incorrecta.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error de validación: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado.");
            }

        } while (opcion != 7);
         sc.close();
    }

    public static void registrarCompleto(Scanner sc, ControladorAsistentes controlador) {

    String tipoDocumento = "";
    while (true) {
        System.out.print("Tipo de documento (DNI/CE): ");
        tipoDocumento = sc.nextLine();

        if (tipoDocumento.equalsIgnoreCase("DNI") || tipoDocumento.equalsIgnoreCase("CE")) {
            break;
        } else {
            System.out.println("Error: debe ser DNI o CE");
        }
    }

    String numeroDocumento = "";
    while (true) {
        try {
            System.out.print("Número de documento: ");
            numeroDocumento = sc.nextLine();

            if (!numeroDocumento.matches("[0-9]+")) {
                throw new IllegalArgumentException("Solo números");
            }

            break;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    System.out.print("Nombres: ");
    String nombres = sc.nextLine();

    System.out.print("Apellido paterno: ");
    String apellidoPaterno = sc.nextLine();

    System.out.print("Apellido materno: ");
    String apellidoMaterno = sc.nextLine();

    int edad = 0;
    while (true) {
        try {
            System.out.print("Edad: ");
            edad = Integer.parseInt(sc.nextLine());

            if (edad < 0) {
                throw new IllegalArgumentException("Edad inválida");
            }

            break;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    String celular = "";
    while (true) {
        try {
            System.out.print("Celular: ");
            celular = sc.nextLine();

            if (!celular.matches("[0-9]{9}")) {
                throw new IllegalArgumentException("Debe tener 9 dígitos");
            }

            break;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    String correo = "";
    while (true) {
        try {
            System.out.print("Correo: ");
            correo = sc.nextLine();

            if (!correo.contains("@")) {
                throw new IllegalArgumentException("Correo inválido");
            }

            break;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    Asistente asistente = new Asistente(tipoDocumento,numeroDocumento,nombres,apellidoPaterno,
            apellidoMaterno,edad,celular,correo);

    controlador.agregarAsistente(asistente);
}

    public static void registrarSinContacto(Scanner sc, ControladorAsistentes controlador) {
        System.out.print("Tipo de documento (DNI/CE): ");
        String tipoDocumento = sc.nextLine();

        System.out.print("Número de documento: ");
        String numeroDocumento = sc.nextLine();

        System.out.print("Nombres: ");
        String nombres = sc.nextLine();

        System.out.print("Apellido paterno: ");
        String apellidoPaterno = sc.nextLine();

        System.out.print("Apellido materno: ");
        String apellidoMaterno = sc.nextLine();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());

        Asistente asistente = new Asistente(
                tipoDocumento,
                numeroDocumento,
                nombres,
                apellidoPaterno,
                apellidoMaterno,
                edad
        );

        controlador.agregarAsistente(asistente);
    }    
}
