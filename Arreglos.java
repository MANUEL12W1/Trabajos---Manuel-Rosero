// Correción
package ArreglosYMatricesRepaso;
import javax.swing.JOptionPane;
public class Arreglos {

    public static void main(String[] args) {
        int cantidadNotas = Integer.valueOf(JOptionPane.showInputDialog(null, "Ingrese la cantidad de notas")); //pedir cantidad de notas
        double[] notas = new double[cantidadNotas];
        ordenarPorBurbuja(notas); // Llamar al método ordenarPor Burbuja para ordenar el arreglo de las notas por el método burbuja
        registroNotas (notas);
        double promedio = notaFinal(notas);
        double mayor = notaMayor(notas);
        double menor = notaMenor(notas);
        double masRepetida = notaMasRepetida(notas);
        String aprobadosYReprobados = cantidadDeAprobadosYReprobados(notas);  //mostrar resumen final
        mostrarResumen(promedio, mayor, menor, masRepetida, aprobadosYReprobados);


    }

    /**
     *Metodo que registra las notas de acuerdo al número de notas que proporcionó el usuario
     */
    public static void registroNotas (double[] notas){
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
    }

    /**
     * Metodo que ordena el arreglo de notas de acuerdo al "Método Burbuja", de menor a mayor)
     * @param notas
     */
    public static void ordenarPorBurbuja ( double [] notas){
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

    }

    /**
     * Metodo que saca el promedio de las notas, proporcionando la nota final
     * @param notas
     * @return un numero double positivo (promedio)
     */

    public static double notaFinal(double[] notas) {

        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        double promedio = suma / notas.length;
        return promedio;
    }

    /**
     * Método que proporciona la nota mayor de todas las notas
     * @param notas
     * @return un número double positivo (notaMayor)
     */

    public static double notaMayor(double[] notas) {
        double notaMayor = notas[0];
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > notaMayor) {
                notaMayor = notas[i];
            }
        }
        return notaMayor;
    }

    /**
     * Método que proporciona la nota menor de todas las notas
     * @param notas
     * @return un número double positivo (notaMenor)
     */

    public static double notaMenor(double[] notas) {
        double notaMenor = notas[0];
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < notaMenor) {
                notaMenor = notas[i];
            }
        }
        return notaMenor;

    }

    /**
     * Método que proporciona la nota más repetida de todas las notas
     * @param notas
     * @return un número double positivo (masRepetida)
     */

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

    /**
     * Método que, deacuerdo a las notas dadas, devuelve el número de estudiantes aprobados y reprobados
     * @param notas
     * @return Una cadena de texto con la cantidad de estudiantes aprobados, y otra cadena de texto con la cantidad de reprobados
     */
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
        return "Estudiantes Aprobados: "+aprobados +"\nEstudiantes Reprobados: "+ reprobados;

    }

    /**
     * Método que muestra un resumen de todos los métodos hechos anteriormente
     * @param promedio
     * @param mayor
     * @param menor
     * @param masRepetida
     * @param aprobadosYReprobados
     */
    public static void mostrarResumen (double promedio, double mayor, double menor, double masRepetida, String aprobadosYReprobados){

         JOptionPane.showMessageDialog(null, "El promedio de notas es: " + promedio + "\nLa nota Mayor fue: " + mayor +
                 "\nLa nota Menor fue: " + menor + "\n La nota Más Repetida fue: "+ masRepetida + "\n"+aprobadosYReprobados);

    }
}