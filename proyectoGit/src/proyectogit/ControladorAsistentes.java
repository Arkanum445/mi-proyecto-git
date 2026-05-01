/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogit;

import java.util.ArrayList;

/**
 *
 * @author edgar
 */
public class ControladorAsistentes {
     private ArrayList<Asistente> listaAsistentes;

    public ControladorAsistentes() {
        listaAsistentes = new ArrayList<>();
    }
      public boolean existeDocumento(String numeroDocumento) {
        for (Asistente a : listaAsistentes) {
            if (a.getNumeroDocumento().equals(numeroDocumento)) {
                return true;
            }
        }
        return false;
    }

    public void agregarAsistente(Asistente asistente) {
        if (existeDocumento(asistente.getNumeroDocumento())) {
            throw new IllegalArgumentException("Ya existe un asistente con ese documento.");
        }

        listaAsistentes.add(asistente);
        System.out.println("Asistente registrado correctamente.");
    }

}
