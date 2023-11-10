//Aquí se crea la clase "class ObjetoRepresentable" 
//Gerson Vargas Gamboa 2020234629

import java.util.ArrayList;
import java.util.List;

// Clase base para objetos representables
class ObjetoRepresentable {
    private String nombre;

    public ObjetoRepresentable(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar() {
        // Método para mostrar información del objeto representable
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

// Clase para representar textos
class Texto extends ObjetoRepresentable {
    private String contenido;

    public Texto(String nombre, String contenido) {
        super(nombre);
        this.contenido = contenido;
    }

    @Override
    public void mostrar() {
        System.out.println("Texto: " + contenido);
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

// Clase base para objetos geométricos
class ObjetoGeometrico extends ObjetoRepresentable {
    private String tipo;

    public ObjetoGeometrico(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

// Clases para objetos geométricos específicos
class Circulo extends ObjetoGeometrico {
    private double radio;

    public Circulo(String nombre, double radio) {
        super(nombre, "Círculo");
        this.radio = radio;
    }

    @Override
    public void mostrar() {
        System.out.println("Círculo: Radio " + radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}

class Elipse extends ObjetoGeometrico {
    private double semiEjeA;
    private double semiEjeB;

    public Elipse(String nombre, double semiEjeA, double semiEjeB) {
        super(nombre, "Elipse");
        this.semiEjeA = semiEjeA;
        this.semiEjeB = semiEjeB;
    }

    @Override
    public void mostrar() {
        System.out.println("Elipse: Semi Eje A " + semiEjeA + ", Semi Eje B " + semiEjeB);
    }

    public double getSemiEjeA() {
        return semiEjeA;
    }

    public void setSemiEjeA(double semiEjeA) {
        this.semiEjeA = semiEjeA;
    }

    public double getSemiEjeB() {
        return semiEjeB;
    }

    public void setSemiEjeB(double semiEjeB) {
        this.semiEjeB = semiEjeB;
    }
}

class Rectangulo extends ObjetoGeometrico {
    private double ladoA;
    private double ladoB;

    public Rectangulo(String nombre, double ladoA, double ladoB) {
        super(nombre, "Rectángulo");
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    @Override
    public void mostrar() {
        System.out.println("Rectángulo: Lado A " + ladoA + ", Lado B " + ladoB);
    }

    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }
}

class Linea extends ObjetoGeometrico {
    private double longitud;

    public Linea(String nombre, double longitud) {
        super(nombre, "Línea");
        this.longitud = longitud;
    }

    @Override
    public void mostrar() {
        System.out.println("Línea: Longitud " + longitud);
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}

class Cuadrado extends Rectangulo {
    public Cuadrado(String nombre, double lado) {
        super(nombre, lado, lado);
    }

    @Override
    public void mostrar() {
        System.out.println("Cuadrado: Lado " + getLadoA());
    }
}

// Clase para representar grupos de objetos
class Grupo extends ObjetoRepresentable {
    private List<ObjetoRepresentable> objetos;

    public Grupo(String nombre) {
        super(nombre);
        this.objetos = new ArrayList<>();
    }

    public void agregarObjeto(ObjetoRepresentable objeto) {
        objetos.add(objeto);
    }

    @Override
    public void mostrar() {
        System.out.println("Grupo: " + getNombre());
        for (ObjetoRepresentable objeto : objetos) {
            objeto.mostrar();
        }
    }
}

// Clase que representa una hoja de documento
class HojaDocumento {
    private List<ObjetoRepresentable> objetos;

    public HojaDocumento() {
        this.objetos = new ArrayList<>();
    }

    public void agregarObjeto(ObjetoRepresentable objeto) {
        objetos.add(objeto);
    }

    public void mostrarContenido() {
        for (ObjetoRepresentable objeto : objetos) {
            objeto.mostrar();
        }
    }
}

// Clase principal para demostrar el uso del editor gráfico de documentos
public class EditorGrafico {
    public static void main(String[] args) {
        // Crear instancias para demostrar el uso exhaustivo
        Texto texto = new Texto("Texto1", "Hola, esto es un texto");
        Circulo circulo = new Circulo("Circulo1", 5);
        Elipse elipse = new Elipse("Elipse1", 3, 4);
        Cuadrado cuadrado = new Cuadrado("Cuadrado1", 6);
        Linea linea = new Linea("Linea1", 8);

        Grupo grupo1 = new Grupo("Grupo1");
        grupo1.agregarObjeto(circulo);
        grupo1.agregarObjeto(elipse);
        grupo1.agregarObjeto(cuadrado);

        Grupo grupo2 = new Grupo("Grupo2");
        grupo2.agregarObjeto(linea);
        grupo2.agregarObjeto(texto);

        HojaDocumento hoja = new HojaDocumento();
        hoja.agregarObjeto(grupo1);
        hoja.agregarObjeto(grupo2);

        // Mostrar contenido de la hoja de documento
        hoja.mostrarContenido();
    }
}
