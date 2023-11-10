public class Evento {
    private String nombre;
    private String lugar;

    public Evento() {
        this.nombre = "Evento Default";
        this.lugar = "Lugar Default";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Evento - Nombre: " + nombre + ", Lugar: " + lugar;
    }
}

