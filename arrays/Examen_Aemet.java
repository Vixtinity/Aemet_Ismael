package arrays;
import java.util.Scanner;

public class Examen_Aemet {
    public static Scanner entrada = new Scanner(System.in); 
    static int iflNCIUDADES = 8;
    static int iflNDIAS = 7;
    static String[] iflciudad = { "Almeria", "Granada", "Cadiz", "Malaga", "Jaen", "Cordoba", "Huelva", "Sevilla"};
    static String[] ifldia = { "Lunes", "Martes", "Miercoles",  "Jueves", "Viernes", "Sabado", "Domingo" };
    static double[][] ifltemp = new double[iflNCIUDADES][iflNDIAS];

    public static void main(String[] args){
        iflGenerarTemperaturas();
        iflImprimirNotasTabla();
        iflestadisitica(null);

    }
    public static double[] estadisitica(String Ciudades){
        double[] ifldatos = new double[3];
        double iflmax;
        double iflmin;
        double iflmedia=0;
        int iflJCiu = getIndexCiudades(Ciudades);
        iflmax = Examen_Aemet.ifltemp[iflJCiu][0];
        iflmin = Examen_Aemet.ifltemp[iflJCiu][0];
        for (int i=1; i<iflNDIAS; i++){
            if (Examen_Aemet.ifltemp[iflJCiu][i] > iflmax){
                iflmax = Examen_Aemet.ifltemp[iflJCiu][i];
            }
            if (Examen_Aemet.ifltemp[iflJCiu][i] < iflmin){
                iflmin = Examen_Aemet.ifltemp[iflJCiu][i];
            }
            iflmedia= iflmedia + Examen_Aemet.ifltemp[JCiu][i];
        }    
        ifldatos[0] = iflmax;
        datos[1] = min;
        datos[2] = media/NDIAS;
        System.out.println(datos[0] + " " + datos[1] + " " + datos[2]);
        return datos;
    }
    public static int getIndexCiudades(String Ciudades){
        int index = -1; // sup que no se encuentra
        for(int i=0; (i<NCIUDADES) && (index == -1); i++){ //ejecuto mientras no se encuentre
            if (Examen_Aemet.ciudad[i]== Ciudades){
                index = i;
            }
        }
        return index;
    }
    
    public static void iflGenerarTemperaturas(){
        double temp;
        for (int i=0; i<NCIUDADES; i++){
            for (int j=0; j<NDIAS; j++){
                temp = Math.random()*10;
                Examen_Aemet.temp[i][j]=Math.round(temp*100.00)/100.00;;
            }
        }
    }

    public static void ImprimirNotasTabla(){
        System.out.println("------ LISTADO DE NOTAS --------------");
        System.out.printf("%20s", " ");
        for (int i=0; i<NCIUDADES; i++){
            System.out.printf("%10s", ciudad[i]);
        };
        System.out.println();
        System.out.println();
        for (int j=0; j<NDIAS; j++){
            System.out.printf("%20s", Examen_Aemet.dia[j]);
            for (int i=0; i<NCIUDADES; i++){
                System.out.printf("%10.2f", Examen_Aemet.temp[i][j]);
            }
            System.out.println();
            System.out.println();
        }
    }

    

}
