/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.aplicacion;

/**
 * Esta clase representa a un cliente en el sistema de hotel. 
 * Contiene la información básica de un cliente como su nombre, DNI, teléfono y un código único asignado automáticamente.
 * Además, gestiona la validación del DNI y la asignación de un código único para cada cliente.
 * 
 * @author Javier
 */
public class Cliente {
    /** Contador estático para generar códigos únicos de cliente. */
    private static int contadorClientes = 0; 

    /** Código único asignado al cliente. */
    private int codigo;

    /** Nombre del cliente. */
    private String nombre;

    /** DNI del cliente, utilizado para la validación. */
    private String dni;

    /** Teléfono de contacto del cliente. */
    private String telefono;

    /**
     * Constructor de la clase Cliente que inicializa el nombre, DNI y teléfono del cliente.
     * Además, valida el DNI antes de crear el objeto y asigna un código único al cliente.
     * 
     * @param nombre El nombre del cliente.
     * @param dni El DNI del cliente, que será validado antes de crear el objeto.
     * @param telefono El teléfono de contacto del cliente.
     * @throws Exception Si el DNI no es válido, se lanza una excepción.
     */
    public Cliente(String nombre, String dni, String telefono) throws Exception {
        // Validación del DNI, si no es correcto no creará el objeto
        Utilidades.validarDNI(dni); 
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.codigo = obtenerNumeroCliente();
    }

    /**
     * Obtiene el código único del cliente.
     * Este código es asignado automáticamente al cliente cuando es creado.
     * 
     * @return El código único del cliente.
     */
    private static int obtenerNumeroCliente() {
        contadorClientes++;
        return contadorClientes;
    }

    /**
     * Muestra la información completa del cliente en formato de texto.
     * 
     * @return Una cadena que representa la información del cliente: código, nombre, DNI y teléfono.
     */
    public String mostrarInformacion() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", DNI: " + dni + ", Teléfono: " + telefono;
    }

    // Métodos generados por encapsulación (getters y setters) no tienen JavaDoc
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
