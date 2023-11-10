//Gerson Vargas Gamboa 2020234629

public class Main {
    public static void main(String[] args) {
        // Uso del patrón Singleton y Abstract Factory (Lazy Singleton)
        AgendaFactory factory = new SimpleAgendaFactory();
        AgendaSingleton agenda = AgendaSingleton.getInstancia();

        // Crear contactos y eventos utilizando la fábrica
        Contacto contacto1 = factory.crearContacto();
        contacto1.setNombre("Juan");
        contacto1.setDireccion("Ruta 32");

        Contacto contacto2 = factory.crearContacto();
        contacto2.setNombre("Maria");
        contacto2.setDireccion("Avenida Central");

        Evento evento1 = factory.crearEvento();
        evento1.setNombre("Reunión de trabajo");
        evento1.setLugar("Sala de conferencias");
        
        Evento evento2 = factory.crearEvento();
        evento2.setNombre("Fiesta de cumpleaños");
        evento2.setLugar("Salón de eventos");

        // Agregar contactos y eventos a la AgendaSingleton
        agenda.agregarContacto(contacto1);
        agenda.agregarContacto(contacto2);
        agenda.agregarEvento(evento1);
        agenda.agregarEvento(evento2);

        // Mostrar la agenda
        agenda.mostrarAgenda();
    }
}

