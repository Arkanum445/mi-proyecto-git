/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogit;

/**
 *
 * @author Usuario
 */
public class Asistente {
   private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
    private String categoria;
    private String celular;
    private String correo; 
    public String getTipoDocumento() {
        return tipoDocumento;
    }

   public Asistente(String tipoDocumento, String numeroDocumento, String nombres, String apellidoPaterno, String apellidoMaterno, int edad, String celular, String correo) {
        setTipoDocumento(tipoDocumento);
        setNumeroDocumento(numeroDocumento);
        setNombres(nombres);
        setApellidoPaterno(apellidoPaterno);
        setApellidoMaterno(apellidoMaterno);
        setEdad(edad);
        setCelular(celular);
        setCorreo(correo);
        this.categoria = calcularCategoria(); 
    }

     public Asistente(String tipoDocumento, String numeroDocumento, String nombres,
                     String apellidoPaterno, String apellidoMaterno, int edad) {

        setTipoDocumento(tipoDocumento);
        setNumeroDocumento(numeroDocumento);
        setNombres(nombres);
        setApellidoPaterno(apellidoPaterno);
        setApellidoMaterno(apellidoMaterno);
        setEdad(edad);
        this.celular = "No registrado";
        this.correo = "No registrado";
        this.categoria = calcularCategoria();
    }

     public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        if (tipoDocumento == null || tipoDocumento.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de documento no puede estar vacío.");
        }

        if (!tipoDocumento.equalsIgnoreCase("DNI") &&
            !tipoDocumento.equalsIgnoreCase("CE")) {
            throw new IllegalArgumentException("El tipo de documento debe ser DNI o CE.");
        }

        this.tipoDocumento = tipoDocumento.toUpperCase();
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        if (numeroDocumento == null || numeroDocumento.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de documento no puede estar vacío.");
        }

        if (!numeroDocumento.matches("[0-9]+")) {
            throw new IllegalArgumentException("El documento solo debe contener números.");
        }

        if (tipoDocumento.equals("DNI") && numeroDocumento.length() != 8) {
            throw new IllegalArgumentException("El DNI debe tener 8 dígitos.");
        }

        if (tipoDocumento.equals("CE") && numeroDocumento.length() != 9) {
            throw new IllegalArgumentException("El Carnet de Extranjería debe tener 9 dígitos.");
        }

        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
         if (nombres == null || nombres.trim().isEmpty()) {
            throw new IllegalArgumentException("Los nombres no pueden estar vacíos.");
        }
        this.nombres = nombres.trim();
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        if (apellidoPaterno == null || apellidoPaterno.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido paterno no puede estar vacío.");
        }
        this.apellidoPaterno = apellidoPaterno.trim();
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
       if (apellidoMaterno == null || apellidoMaterno.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido materno no puede estar vacío.");
        }
        this.apellidoMaterno = apellidoMaterno.trim();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
         if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 120.");
        }
        this.edad = edad;
        this.categoria = calcularCategoria();
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        if (celular == null || celular.trim().isEmpty()) {
            this.celular = "No registrado";
            return;
        }

        if (!celular.matches("[0-9]{9}")) {
            throw new IllegalArgumentException("El celular debe tener 9 dígitos.");
        }

        this.celular = celular;
    }
     public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
       if (correo == null || correo.trim().isEmpty()) {
            this.correo = "No registrado";
            return;
        }

        if (!correo.contains("@") || !correo.contains(".")) {
            throw new IllegalArgumentException("El correo no tiene un formato válido.");
        }

        this.correo = correo;
    }
    public String calcularCategoria() {
        if (edad >= 0 && edad <= 10) {
            return "Niño";
        } else if (edad >= 11 && edad <= 17) {
            return "Adolescente";
        } else {
            return "Adulto";
        }
    }
    public void mostrarDatos() {
        System.out.println("----------------------------------");
        System.out.println("Tipo documento: " + tipoDocumento);
        System.out.println("Número documento: " + numeroDocumento);
        System.out.println("Nombres: " + nombres);
        System.out.println("Apellido paterno: " + apellidoPaterno);
        System.out.println("Apellido materno: " + apellidoMaterno);
        System.out.println("Edad: " + edad);
        System.out.println("Categoría: " + categoria);
        System.out.println("Celular: " + celular);
        System.out.println("Correo: " + correo);
    }
   public void mostrarDatos(boolean mostrarContacto) {
        System.out.println("----------------------------------");
        System.out.println("Documento: " + tipoDocumento + " - " + numeroDocumento);
        System.out.println("Nombre completo: " + nombres + " " + apellidoPaterno + " " + apellidoMaterno);
        System.out.println("Edad: " + edad);
        System.out.println("Categoría: " + categoria);

        if (mostrarContacto) {
            System.out.println("Celular: " + celular);
            System.out.println("Correo: " + correo);
        }
    }
}
