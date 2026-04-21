package co.edu.uniquindio.poo.model;

import javax.swing.*;

public abstract class Empleado{
    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected float descuentoSalud;
    protected float descuentoPension;

    private Empresa ownedByEmpresa;
    private CategoriaEmpleado categoriaEmpleado;

    public Empleado(String nombre, String documento, int edad, float salarioBase, float descuentoSalud, float descuentoPension,CategoriaEmpleado categoriaEmpleado, Empresa ownedByEmpresa) {
        validarDatos(salarioBase, descuentoSalud, descuentoPension);
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
        this.categoriaEmpleado = categoriaEmpleado;
        this.ownedByEmpresa = ownedByEmpresa;


    }
    public static void validarDatos(float salario, float salud, float pension) {
        if (salario < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo");
        }
        if (salud < 0 || salud > 100) {
            throw new IllegalArgumentException("El descuento de salud debe estar entre 0 y 100");
        }
        if (pension < 0 || pension > 100) {
            throw new IllegalArgumentException("El descuento de pensión debe estar entre 0 y 100");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getDescuentoSalud() {
        return descuentoSalud;
    }

    public void setDescuentoSalud(float descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    public float getDescuentoPension() {
        return descuentoPension;
    }

    public void setDescuentoPension(float descuentoPension) {
        this.descuentoPension = descuentoPension;
    }

    public Empresa getOwnedByEmpresa() {
        return ownedByEmpresa;
    }

    public void setOwnedByEmpresa(Empresa ownedByEmpresa) {
        this.ownedByEmpresa = ownedByEmpresa;
    }

    public CategoriaEmpleado getCategoriaEmpleado() {
        return categoriaEmpleado;
    }

    public void setCategoriaEmpleado(CategoriaEmpleado categoriaEmpleado) {
        this.categoriaEmpleado = categoriaEmpleado;
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", salarioBase=" + salarioBase +
                ", descuentoSalud=" + descuentoSalud +
                ", descuentoPension=" + descuentoPension +
                ", ownedByEmpresa=" + ownedByEmpresa +
                ", categoriaEmpleado=" + categoriaEmpleado +
                '}';
    }
    public abstract float calcularSalarioBruto();

    public float calcularBonificacionCategoria(){
        if (categoriaEmpleado == CategoriaEmpleado.JUNIOR){
            return salarioBase * 0.05f;
        }
        else if (categoriaEmpleado == CategoriaEmpleado.SEMI_SENIOR) {
            return salarioBase * 0.10f;
        }
        else if (categoriaEmpleado == CategoriaEmpleado.SENIOR) {
            return salarioBase * 0.15f;
        }
        return 0;
    }
    public float calcularDescuentos (){
        float descuentos = salarioBase * (descuentoSalud / 100) + salarioBase * (descuentoPension / 100);
        return descuentos;
    }
    public float calcularSalarioNeto () {
        float salarioNeto = calcularSalarioBruto() - calcularDescuentos();
        return salarioNeto;
    }
    public void mostrarInformacion(){
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\n Documento: " + documento +
                "\n Edad: " +edad + "\n Salario Base: " + salarioBase + "\n Categoria: " + categoriaEmpleado + "\n Salario Bruto: " + calcularSalarioBruto() + "\n Descuentos: " + calcularDescuentos() + "\n Salario Neto: " + calcularSalarioNeto());
    }
    public ResumenPago generarResumenPago() {
        return new ResumenPago(documento, nombre, getClass().getSimpleName(),
                calcularSalarioBruto(), calcularDescuentos(), calcularSalarioNeto());
    }


}
