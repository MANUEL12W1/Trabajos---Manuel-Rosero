package co.edu.uniquindio.poo.model;

public class EmpleadoTemporal extends Empleado {
    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase, float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado, Empresa ownedByEmpresa, int diasTrabajados, float valorDia) {
        super(nombre, documento, edad, salarioBase, descuentoSalud, descuentoPension, categoriaEmpleado,ownedByEmpresa);
        validarDatos (diasTrabajados,valorDia);
        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }
    public static void validarDatos(int diasTrabajados, float valorDia){
        if (diasTrabajados < 0)throw new IllegalArgumentException("Los dias trabajados no pueden ser negativos");
        if (valorDia < 0)throw new IllegalArgumentException("Los valor por dia no puede ser negativo");
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public float getValorDia() {
        return valorDia;
    }

    public void setValorDia(float valorDia) {
        this.valorDia = valorDia;
    }

    @Override
    public String toString() {
        return "EmpleadoTemporal{" +
                "diasTrabajados=" + diasTrabajados +
                ", valorDia=" + valorDia +
                '}';
    }
    @Override
    public float calcularSalarioBruto (){
        float salarioBruto;
        float pagoDiasTrabajados = diasTrabajados * valorDia;
        salarioBruto = calcularBonificacionCategoria() + pagoDiasTrabajados;
        return salarioBruto;
    }
}