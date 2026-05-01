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
    }
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

}
