import java.util.Scanner;
import java.lang.Math;
@SuppressWarnings("unused")

public class DetCof {
    public static float detCof(Matrix m){
        // jika matriks persegi
        if (m.row == m.col){
            // jika matriks 1x1, determinannya adalah elemennya sendiri
            if (m.row == 1) return m.elmt(0, 0);

            // jika bukan 1x1
            else {
                float det = 0;

                // hasil jumlah (-1)^i*cofactor*determinan dari matrix yang lebih kecil
                for (int i = 0; i < m.row; i++)det += (Math.pow(-1, i))*m.elmt(i, 0)*detCof(shrinkMatrix(m, i, 0));
                
                // return hasil det
                return det;
            }

        // jika matriks bukan persegi
        } else {
            System.out.println("Determinan tidak bisa didapat dari matriks yang bukan persegi!");
            return 69;
        }
    }
    
    public static Matrix shrinkMatrix(Matrix m, int iex, int jex){
        // declare matrix
        Matrix m2 = new Matrix(m.row-1, m.col-1);
        
        // declare variabel
        int i2 = 0, j2 = 0;

        // proses transfer matriks ke matriks baru, tanpa baris iex dan kolom jex
        for (int i = 0; i < m.row; i++){
            for (int j = 0; j < m.col; j++){
                if ((i != iex) && (j != jex)){
                    m2.set(i2, j2, m.elmt(i, j));
                    j2++; if (j2 == m2.col){
                        j2 = 0; i2++;
                    }
                }
            }
        }

        // janlup direturn
        return m2;
    }
}