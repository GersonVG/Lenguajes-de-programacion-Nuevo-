public class Contacto {
    private String nombre;
    private String direccion;

    public Contacto() {
        this.nombre = "Nombre Default";
        this.direccion = "Dirección Default";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Contacto - Nombre: " + nombre + ", Dirección: " + direccion;
    }
}


