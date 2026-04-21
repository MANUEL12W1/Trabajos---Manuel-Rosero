package co.edu.uniquindio.poo.model;

public class EmpleadoPlanta extends  Empleado {
    private String cargo;
    private int horasExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlanta(String nombre, String documento, int edad, float salarioBase, float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado, Empresa ownedByEmpresa,  String cargo, int horasExtra, float valorHoraExtra, float auxilioTransporte) {
        super(nombre, documento, edad, salarioBase, descuentoSalud, descuentoPension , categoriaEmpleado, ownedByEmpresa );
        validarDatos(horasExtra, valorHoraExtra);
        this.cargo = cargo;
        this.horasExtra = horasExtra;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;

    }
    public static void validarDatos(int horasExtra, float valorHoraExtra) {
        if (horasExtra < 0) throw new IllegalArgumentException("Las horas extra no pueden ser negativas");
        if (valorHoraExtra < 0) throw new IllegalArgumentException("El valor de la hora extra no puede ser negativo");
    }
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public float getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(float valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    public float getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(float auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    @Override
    public String toString() {
        return "EmpleadoPlanta{" +
                "cargo='" + cargo + '\'' +
                ", horasExtra=" + horasExtra +
                ", valorHoraExtra=" + valorHoraExtra +
                ", auxilioTransporte=" + auxilioTransporte +
                '}';
    }
    @Override
    public float calcularSalarioBruto (){
        float salarioBruto;
        float pagoHorasExtra = horasExtra*valorHoraExtra;
        salarioBruto = salarioBase + calcularBonificacionCategoria() + (horasExtra * valorHoraExtra) + auxilioTransporte;
        return salarioBruto;
    }
}
