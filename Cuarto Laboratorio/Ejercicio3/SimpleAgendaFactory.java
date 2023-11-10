public class SimpleAgendaFactory implements AgendaFactory {
    @Override
    public Contacto crearContacto() {
        return new Contacto();
    }

    @Override
    public Evento crearEvento() {
        return new Evento();
    }
}
