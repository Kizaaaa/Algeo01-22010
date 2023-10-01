import java.util.Scanner;
@SuppressWarnings("unused")

public class LinearReg {
    public static void f(Scanner sc, Matrix m){
        int a = 0;
        if ((m.row == 0) || (m.col == 0)) System.out.println("Perhitungan gagal, matriks yang diberikan merupakan matriks kosong.");
        else if (m.col == 1) System.out.println("Perhitungan gagal, matriks yang diberikan bukan berupa persamaan."); 
        else{
            // membentuk matrix sesuai rumus regresi linear
            Matrix linreg = new Matrix(m.col, m.col+1);
            
            // menyusun elemen2nya
            for (int i = 0; i < linreg.row; i++){
                for (int j = 0; j < linreg.col; j++){
                    // declarasi sum
                    float sum = 0;

                    if ((i == 0) && (j == 0)) sum += linreg.row; // elemen ujung kiri atas (nb0)
                    else if (i == 0){
                        for (int k = 0; k < m.row; k++) sum += m.elmt(k, (j % m.col)); // elemen ujung atas
                    } else if (j == 0){
                        for (int k = 0; k < m.row; k++) sum += m.elmt(k, (i % m.col)); // elemen ujung kiri
                    } else {
                        for (int k = 0; k < m.row; k++) sum += (m.elmt(k, (i % m.col))*m.elmt(k, (j % m.col))); // selain.
                    } 
                    
                    // taruh ke matrix linreg
                    linreg.set(i, j, sum);
                }
            } 

            // print matrix linreg
            System.out.println("Dari matriks yang diinput, terbentuk matrix regresi linear: ");
            System.out.print(TXTReaderWriter.castMatrixString(linreg));

            //solving pake gauss
            

        }
    }   
}
