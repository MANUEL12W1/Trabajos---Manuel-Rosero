import javax.swing.JOptionPane;
public class Class3 {

    public static void main(String[] args) {
        int cantidad = Integer.valueOf(JOptionPane.showInputDialog(null, "Ingrese la cantidad de notas"));

        double[] notas = new double[cantidad];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = Double.valueOf(JOptionPane.showInputDialog(null, "Ingrese la nota " + (i + 1)));
            if (notas[i] < 0.0){
                JOptionPane.showMessageDialog(null, "Las notas no pueden ser menores a 0.0");
                notas[i] = Double.valueOf(JOptionPane.showInputDialog(null, "Ingrese la nota " + (i + 1)));
            } else if (notas[i] > 5.0){
                JOptionPane.showMessageDialog(null, "Las notas no pueden ser mayores a 5.0");
                notas[i] = Double.valueOf(JOptionPane.showInputDialog(null, "Ingrese la nota " + (i + 1)));

            }
        }
        double aux;
        for (int i = 0 ; i < (notas.length-1) ; i++){
            for (int j = 0 ; j < (notas.length-1-i) ; j++){
                if (notas[j] > notas [j+1]){
                    aux = notas[j];
                    notas [j] = notas [j+1];
                    notas[j+1] = aux;
                }
            }
        }
        double promedio = notaFinal(notas);
        JOptionPane.showMessageDialog(null, "El promedio de notas es " + promedio);
        double mayor = notaMayor(notas);
        JOptionPane.showMessageDialog(null, "La nota mayor es  " + mayor);
        double menor = notaMenor(notas);
        JOptionPane.showMessageDialog(null, "La nota menor es  " + menor);
        double masRepetida = notaMasRepetida(notas);
        JOptionPane.showMessageDialog(null, "La nota más repetida es  " + masRepetida);
        String aprobadosYReprobados = cantidadDeAprobadosYReprobados(notas);
        JOptionPane.showMessageDialog(null, aprobadosYReprobados);


    }

    public static double notaFinal(double[] notas) {

        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        double promedio = suma / notas.length;
        return promedio;
    }

    public static double notaMayor(double[] notas) {
        double notaMayor = notas[0];
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > notaMayor) {
                notaMayor = notas[i];
            }
        }
        return notaMayor;
    }

    public static double notaMenor(double[] notas) {
        double notaMenor = notas[0];
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < notaMenor) {
                notaMenor = notas[i];
            }
        }
        return notaMenor;

    }

    public static double notaMasRepetida(double[] notas) {
        double masRepetida = notas[0];
        int repeticiones = 0;
        for (int i = 0; i < notas.length; i++) {
            int contador = 0;
            for (int j = 0; j < notas.length; j++) {
                if (notas[i] == notas[j]) {
                    contador++;
                }
            }
            if (contador > repeticiones) {
                repeticiones = contador;
                masRepetida = notas[i];
            }
        }
        return masRepetida;
    }
    public static String cantidadDeAprobadosYReprobados (double [] notas){
        int aprobados = 0;
        int reprobados = 0;
        for (int i = 0 ; i < notas.length ; i++){
            if (notas[i] >= 3.0){
                aprobados++;
            }
            else {
                reprobados++;
            }
        }
        return "Estudiantes Aprobados: "+aprobados +"\nEstudiantes Desaprobados: "+ reprobados;

    }
}