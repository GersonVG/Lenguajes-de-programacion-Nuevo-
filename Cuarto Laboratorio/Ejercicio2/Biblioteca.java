import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    public static void main(String[] args) {
        // Crear socios
        Socio socio1 = new Socio(1, "Juan", "Calle 123");
        Socio socio2 = new Socio(2, "Maria", "Avenida 456");

        // Crear libros
        Libro libro1 = new Libro(101, "Harry Potter", "J.K. Rowling");
        Libro libro2 = new Libro(102, "1984", "George Orwell");
        Libro libro3 = new Libro(103, "El Señor de los Anillos", "J.R.R. Tolkien");

        // Prestar libros
        socio1.prestarLibro(libro1, new Date());
        socio1.prestarLibro(libro2, new Date());
        socio1.prestarLibro(libro3, new Date());
        socio2.prestarLibro(libro1, new Date());
        socio2.prestarLibro(libro2, new Date());

        // Mostrar estado de libros
        System.out.println("Estado de libros después de préstamos:");
        System.out.println("Libro 1 disponible: " + libro1.isDisponible());
        System.out.println("Libro 2 disponible: " + libro2.isDisponible());
        System.out.println("Libro 3 disponible: " + libro3.isDisponible());

        // Mostrar socios con más de 3 libros prestados
        List<Socio> sociosConMasDeTresLibros = List.of(socio1, socio2)
                .stream()
                .filter(socio -> socio.librosPrestados() > 3)
                .collect(Collectors.toList());

        System.out.println("\nSocios con más de 3 libros prestados:");
        for (Socio socio : sociosConMasDeTresLibros) {
            System.out.println("Número de socio: " + socio.getNumeroSocio() +
                    ", Nombre: " + socio.getNombre() +
                    ", Libros prestados: " + socio.librosPrestados());
        }
    }
}
