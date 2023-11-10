import java.util.Date;

public class Prestamo {
    private int codigoLibro;
    private int numeroSocio;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(int codigoLibro, int numeroSocio, Date fechaPrestamo) {
        this.codigoLibro = codigoLibro;
        this.numeroSocio = numeroSocio;
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void devolverLibro(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
