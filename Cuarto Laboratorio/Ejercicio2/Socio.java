import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Socio {
    private int numeroSocio;
    private String nombre;
    private String direccion;
    private List<Prestamo> prestamos;

    public Socio(int numeroSocio, String nombre, String direccion) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.prestamos = new ArrayList<>();
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void prestarLibro(Libro libro, Date fechaPrestamo) {
        if (libro.isDisponible()) {
            Prestamo prestamo = new Prestamo(libro.getCodigo(), this.numeroSocio, fechaPrestamo);
            prestamos.add(prestamo);
            libro.prestar();
            System.out.println("Libro prestado a " + this.nombre + ": " + libro.getTitulo());
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    public int librosPrestados() {
        return (int) prestamos.stream()
                .filter(prestamo -> prestamo.getFechaDevolucion() == null)
                .count();
    }
}
