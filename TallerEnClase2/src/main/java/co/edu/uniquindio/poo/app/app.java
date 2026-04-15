package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.awt.*;

public class app {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la empresa");
        Empresa empresa = new Empresa(nombre);

        boolean salir = false;
        while (!salir) {
            String menu = JOptionPane.showInputDialog(null, "Menú de Inicio" + "\n1. Agregar Empleado de Planta" + "\n2. Agregar Empleado de Ventas" +
                    "\n3. Agregar empleado temporal" + "\n4. Mostrar todos los empleados" + "\n5. Buscar empleado por documento" + "\n6. Mostrar el empleado con mayor salario neto" + "\n7. Mostrar nómina total" +
                    "\n8. Mostrar resumen de pagos" + "\n 9. Salir" + "\n" + "\nQue opcion desea elejir?");
            try {


                switch (menu) {
                    case "1":
                        String nombreE = JOptionPane.showInputDialog("Ingrese el nombre:");
                        String documentoE = JOptionPane.showInputDialog("Ingrese el documento:");
                        int edadE = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
                        float salarioBaseE = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario base:"));
                        float descuentoSaludE = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento salud:"));
                        float descuentoPensionE = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento pension:"));
                        String cargo = JOptionPane.showInputDialog("Ingrese el cargo del empleado");
                        int horasExtra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas extra del empleado:"));
                        float valorHoraExtra = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor por hora extra:"));
                        float auxilioTransporte = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el auxilio de transporte del empleado:"));
                        String catE = JOptionPane.showInputDialog("Ingrese la categoría:\n1. JUNIOR\n2. SEMI_SENIOR\n3. SENIOR");
                        CategoriaEmpleado categoriaE;
                        switch (catE) {
                            case "2":
                                categoriaE = CategoriaEmpleado.SEMI_SENIOR;
                                break;
                            case "3":
                                categoriaE = CategoriaEmpleado.SENIOR;
                                break;
                            default:
                                categoriaE = CategoriaEmpleado.JUNIOR;
                                break;
                        }

                            EmpleadoPlanta ep = new EmpleadoPlanta(nombreE, documentoE, edadE, salarioBaseE,
                                    descuentoSaludE, descuentoPensionE, categoriaE, empresa, cargo,
                                    horasExtra, valorHoraExtra, auxilioTransporte);
                            JOptionPane.showMessageDialog(null, empresa.registrarEmpleado(ep));
                        break;
                    case "2":
                        String nombreEV = JOptionPane.showInputDialog("Ingrese el nombre:");
                        String documentoEV = JOptionPane.showInputDialog("Ingrese el documento:");
                        int edadEV = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
                        float salarioBaseEV = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario base:"));
                        float descuentoSaludEV = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento salud:"));
                        float descuentoPensionEV = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento pension:"));
                        float totalVentas = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el total de ventas:"));
                        float porcentajeComision = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el porcentaje de comisión:"));
                        String catEV = JOptionPane.showInputDialog("Ingrese la categoría:\n1. JUNIOR\n2. SEMI_SENIOR\n3. SENIOR");
                        CategoriaEmpleado categoriaEV;
                        switch (catEV) {
                            case "2":
                                categoriaEV = CategoriaEmpleado.SEMI_SENIOR;
                                break;
                            case "3":
                                categoriaEV = CategoriaEmpleado.SENIOR;
                                break;
                            default:
                                categoriaEV = CategoriaEmpleado.JUNIOR;
                                break;
                        }
                            EmpleadoVentas ev = new EmpleadoVentas(nombreEV, documentoEV, edadEV, salarioBaseEV, descuentoSaludEV, descuentoPensionEV, categoriaEV, empresa, totalVentas, porcentajeComision);
                            JOptionPane.showMessageDialog(null, empresa.registrarEmpleado(ev));

                        break;
                    case "3":
                        String nombreET = JOptionPane.showInputDialog("Ingrese el nombre:");
                        String documentoET = JOptionPane.showInputDialog("Ingrese el documento:");
                        int edadET = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
                        float salarioBaseET = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario base:"));
                        float descuentoSaludET = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento salud:"));
                        float descuentoPensionET = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento pension:"));
                        int diasTrabajados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de dias trabajados:"));
                        ;
                        float valorDia = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor por día:"));
                        String catET = JOptionPane.showInputDialog("Ingrese la categoría:\n1. JUNIOR\n2. SEMI_SENIOR\n3. SENIOR");
                        CategoriaEmpleado categoriaET;
                        switch (catET) {
                            case "2":
                                categoriaET = CategoriaEmpleado.SEMI_SENIOR;
                                break;
                            case "3":
                                categoriaET = CategoriaEmpleado.SENIOR;
                                break;
                            default:
                                categoriaET = CategoriaEmpleado.JUNIOR;
                                break;
                        }
                            EmpleadoTemporal et = new EmpleadoTemporal(nombreET, documentoET, edadET, salarioBaseET, descuentoSaludET, descuentoPensionET, categoriaET, empresa, diasTrabajados, valorDia);
                            JOptionPane.showMessageDialog(null, empresa.registrarEmpleado(et));
                        break;
                    case "4":
                        empresa.mostrarTodosLosEmpleados();
                        break;
                    case "5":
                        String documento = JOptionPane.showInputDialog("Ingrese el documento");
                        Empleado encontrado = empresa.buscarEmpleado(documento);
                        if (encontrado != null) {
                            encontrado.mostrarInformacion();
                        } else {
                            JOptionPane.showMessageDialog(null, "El empleado no existe");
                        }
                        break;
                    case "6":
                        Empleado mayorSalario = empresa.obtenerMayorSalarioNeto();
                        if (mayorSalario != null) {
                            mayorSalario.mostrarInformacion();
                        } else {
                            JOptionPane.showMessageDialog(null, "no ay empleados registrados");
                        }
                        break;
                    case "7":
                        JOptionPane.showMessageDialog(null, "Nómina total:" + empresa.calcularNominaTotal());
                        break;
                    case "8":
                        empresa.mostrarResumenesPago();
                        break;
                    case "9":
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción Inválida");
                        break;
                }
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese datos validos");
            }
        }
    }
}