class EmpleadoPlanta extends Empleado { private static final double SALARIO_FIJO = 2_100_000;

    public EmpleadoPlanta(String nombre, int edad) {
        super(nombre, edad);
    }
    @Override
    public double calcularSalario() {
        return SALARIO_FIJO;
    }

}