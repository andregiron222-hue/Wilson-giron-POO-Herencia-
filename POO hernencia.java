class Empleado {
    protected String nombre;
    protected String id;
    protected double salarioBase;

    public Empleado(String nombre, String id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }

    public String getNombre() {
        return nombre;
    }
}

class Piloto extends Empleado {
    private int horasVuelo;
    private static final double BONO_POR_HORA = 25.0;

    public Piloto(String nombre, String id, double salarioBase, int horasVuelo) {
        super(nombre, id, salarioBase);
        this.horasVuelo = horasVuelo;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (horasVuelo * BONO_POR_HORA);
    }
}

class TecnicoMantenimiento extends Empleado {
    private int certificaciones;

    public TecnicoMantenimiento(String nombre, String id,
                                double salarioBase, int certificaciones) {
        super(nombre, id, salarioBase);
        this.certificaciones = certificaciones;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (certificaciones * 150.0);
    }
}

class AgenteVentas extends Empleado {
    private double comisionVentas;

    public AgenteVentas(String nombre, String id,
                        double salarioBase, double comisionVentas) {
        super(nombre, id, salarioBase);
        this.comisionVentas = comisionVentas;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + comisionVentas;
    }
}

// Ejercicio de la última diapositiva.
class Supervisor extends Empleado {
    private int equiposSupervisados;
    private static final double BONO_POR_EQUIPO = 500.0;

    public Supervisor(String nombre, String id,
                      double salarioBase, int equiposSupervisados) {
        super(nombre, id, salarioBase);
        this.equiposSupervisados = equiposSupervisados;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario()
                + (equiposSupervisados * BONO_POR_EQUIPO);
    }
}

public class Main {
    public static void main(String[] args) {
        Empleado[] equipo = {
            new Piloto("Ana Gómez", "E-101", 4500.0, 60),
            new TecnicoMantenimiento("Luis Rivas", "E-102", 3800.0, 3),
            new AgenteVentas("Carla Mux", "E-103", 3200.0, 900.0),
            new Supervisor("Pedro López", "E-104", 5000.0, 4)
        };

        for (Empleado e : equipo) {
            System.out.println(
                e.getNombre() + ": Q" + e.calcularSalario()
            );
        }
    }
}