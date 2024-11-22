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
        iflGenerarRegistroTemp();
        iflImprimirTempTabla();
        iflestadisitica(null);
    }
    public static double[] iflestadisitica(String Ciudades){
        double[] ifldatos = new double[3];
        double iflmax;
        double iflmin;
        double iflmedia=0;
        int iflJCiu = iflgetIndexCiudades(Ciudades);
        iflmax = Examen_Aemet.ifltemp[iflJCiu][0];
        iflmin = Examen_Aemet.ifltemp[iflJCiu][0];
        for (int i=1; i<iflNDIAS; i++){
            if (Examen_Aemet.ifltemp[iflJCiu][i] > iflmax){
                iflmax = Examen_Aemet.ifltemp[iflJCiu][i];
            }
            if (Examen_Aemet.ifltemp[iflJCiu][i] < iflmin){
                iflmin = Examen_Aemet.ifltemp[iflJCiu][i];
            }
            iflmedia= iflmedia + Examen_Aemet.ifltemp[iflJCiu][i];
        }    
        ifldatos[0] = iflmax;
        ifldatos[1] = iflmin;
        ifldatos[2] = iflmedia/iflNDIAS;
        System.out.println(ifldatos[0] + " " + ifldatos[1] + " " + ifldatos[2]);
        return ifldatos;
    }
    public static int iflgetIndexCiudades(String iflCiudades){
        int index = 1;
        for(int i=0; i<iflNCIUDADES; i++){ //ejecuto mientras no se encuentre
            if (Examen_Aemet.iflciudad[i]== iflCiudades){
                index = i;
            }
        }
        return index;
    }
    
    public static void iflGenerarRegistroTemp(){
        double temp;
        for (int i=0; i<iflNCIUDADES; i++){
            for (int j=0; j<iflNDIAS; j++){
                temp = Math.random()*40;
                Examen_Aemet.ifltemp[i][j]=Math.round(temp*100)/100;;
            }
        }
    }

    public static void iflImprimirTempTabla(){
        System.out.println("------ LISTADO DE TEMPERATURA --------------");
        System.out.printf("%20s", " ");
        for (int i=0; i<iflNCIUDADES; i++){
            System.out.printf("%10s", iflciudad[i]);
        };
        System.out.println();
        System.out.println();
        for (int j=0; j<iflNDIAS; j++){
            System.out.printf("%20s", Examen_Aemet.ifldia[j], Examen_Aemet.ifldia[j]);
            for (int i=0; i<iflNCIUDADES; i++){
                System.out.printf("%10.2f", Examen_Aemet.ifltemp[i][j], Examen_Aemet.ifltemp[i][j], Examen_Aemet.ifltemp[i][j]);
            }
            System.out.println();
            System.out.println();
        }
    }
}
