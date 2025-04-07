class EmpleadoPorHoras extends Empleado { private double pagoPorHora; private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, int edad, double pagoPorHora, int horasTrabajadas) {
        super(nombre, edad);
        this.pagoPorHora = pagoPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }
    @Override
    public double calcularSalario() {
        return pagoPorHora * horasTrabajadas;
    }

}