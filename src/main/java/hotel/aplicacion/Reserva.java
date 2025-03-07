/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.aplicacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Javier
 */
public class Reserva {
    private static int contadorReservas = 0;
    private int CODIGO_RESERVA;
    private Cliente cliente;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private TipoHabitacion tipoHabitacion;
    private boolean CamaSupletoria;
    private double costeTotal;
    
    // Constantes fijas para el precio
    private static final double PRECIODOBLE = 50.0;
    private static final double PRECIOSUITE = 100.0;
    private static final double RECARGOCAMASUPLETORIA = 20.0;

       public Reserva(Cliente cliente, LocalDate fechaEntrada, LocalDate fechaSalida,
                   TipoHabitacion tipoHabitacion, boolean camaSupletoria) throws Exception {
        if (!fechaSalida.isAfter(fechaEntrada)) {
            throw new Exception("La fecha de salida debe ser posterior a la de entrada.");
        }
        this.CODIGO_RESERVA = obtenerCodigoReserva();
        this.cliente = cliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.tipoHabitacion = tipoHabitacion;
        this.CamaSupletoria = camaSupletoria;
        this.costeTotal = calcularCosteTotal();
    }

    
    private static int obtenerCodigoReserva() {
        contadorReservas++;
        return contadorReservas;
    }

    /**
     * Calcula el coste total de una reserva en función de la cantidad de noches, el tipo de habitación, 
     * y si se ha solicitado una cama supletoria. Además, aplica un descuento del 10% si la estancia es mayor a 7 noches.
     * 
     * @return El coste total de la reserva después de aplicar posibles recargos y descuentos.
     */
    
    public double calcularCosteTotal() {
    	  // Calcula la cantidad de noches entre las fechas de entrada y salida
        long noches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
        double precioNoche = (tipoHabitacion == TipoHabitacion.DOBLE) ? PRECIODOBLE : PRECIOSUITE;
        // Determina el precio por noche en función del tipo de habitación
        if (CamaSupletoria) {
            precioNoche += RECARGOCAMASUPLETORIA;
        }
        // Si se ha solicitado una cama supletoria, se añade un recargo
        // Calcula el coste total de la reserva
        double total = noches * precioNoche;
     // Si la estancia es mayor a 7 noches, aplica un descuento del 10%
        if (noches > 7) {
            total *= 0.9; // Aplica un descuento del 10%
        }
        return total;
    }

    
    public String mostrarDetalles() {
        String detalles = "Código Reserva: " + CODIGO_RESERVA + "\n" +
                          "Cliente: " + cliente.mostrarInformacion() + "\n" +
                          "Fecha de Entrada: " + fechaEntrada + "\n" +
                          "Fecha de Salida: " + fechaSalida + "\n" +
                          "Tipo de Habitación: " + tipoHabitacion + "\n" +
                          "Cama Supletoria: " + (CamaSupletoria ? "Sí" : "No") + "\n" +
                          "Coste Total: " + costeTotal + "Euros";
        return detalles;
    }

    public int getCodigoReserva() {
        return CODIGO_RESERVA;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public boolean isCamaSupletoria() {
        return CamaSupletoria;
    }

    public double getCosteTotal() {
        return costeTotal;
    }
    
    public void setFechaEntrada(LocalDate fechaEntrada) throws Exception {
        if (fechaSalida != null && !fechaSalida.isAfter(fechaEntrada)) {
            throw new Exception("La fecha de salida debe ser posterior a la de entrada.");
        }
        this.fechaEntrada = fechaEntrada;
        this.costeTotal = calcularCosteTotal();
    }

   
    public void setFechaSalida(LocalDate fechaSalida) throws Exception {
        if (fechaEntrada != null && !fechaSalida.isAfter(fechaEntrada)) {
            throw new Exception("La fecha de salida debe ser posterior a la de entrada.");
        }
        this.fechaSalida = fechaSalida;
        this.costeTotal = calcularCosteTotal();
    }
}