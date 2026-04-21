package co.edu.uniquindio.poo.model;

public class EmpleadoVentas extends Empleado {
    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase, float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado, Empresa ownedByEmpresa, float totalVentas, float porcentajeComision) {
        super(nombre, documento, edad, salarioBase, descuentoSalud, descuentoPension, categoriaEmpleado, ownedByEmpresa);
        validarComision(porcentajeComision);
        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }
   public static void validarComision(float comision) {
        if (comision < 0 || comision > 100) {
            throw new IllegalArgumentException("El porcentaje de comisión debe estar entre 0 y 100");
        }
    }

    public float getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(float totalVentas) {
        this.totalVentas = totalVentas;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public String toString() {
        return "EmpleadoVentas{" +
                "totalVentas=" + totalVentas +
                ", porcentajeComision=" + porcentajeComision +
                '}';
    }
    @Override
    public float calcularSalarioBruto (){
        float salarioBruto;
        float comision = totalVentas * porcentajeComision / 100;
        salarioBruto= salarioBase + calcularBonificacionCategoria() + comision;
        return salarioBruto;
    }
}
