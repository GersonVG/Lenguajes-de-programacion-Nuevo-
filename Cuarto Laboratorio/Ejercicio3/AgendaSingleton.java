//Elegí el patrón de diseño Singleton Lazy porque la instancia AgendaSingleton se crea sólo cuando es necesario, haciendo que sea más
//eficiente si no se utiliza en todas las ejecuciones del programa

import java.util.ArrayList;
import java.util.List;

public class AgendaSingleton {
    private static AgendaSingleton instancia;

    private List<Contacto> contactos;
    private List<Evento> eventos;

    private AgendaSingleton() {
        contactos = new ArrayList<>();
        eventos = new ArrayList<>();
    }

    public static AgendaSingleton getInstancia() {
        if (instancia == null) {
            instancia = new AgendaSingleton();
        }
        return instancia;
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void mostrarAgenda() {
        System.out.println("Contactos:");
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }

        System.out.println("\nEventos:");
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }
}


