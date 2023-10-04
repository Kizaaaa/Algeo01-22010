import java.util.Scanner;

public class Cramer {
    public static void f(Matrix m, Scanner sc){
        float det = Determinan.detCof(shrink(m));
        Matrix mtemp;
        mtemp = new Matrix(m.row, m.col-1);
        float[] x;
        x = new float[m.row];
        for(int i=0;i<m.col-1;i++){
            m.swapCol(i, m.col-1);
            mtemp = shrink(m);
            x[i] = Determinan.detCof(mtemp)/det;
            m.swapCol(i, m.col-1);
        }

        System.out.println("Hasil perhitungan menggunakan metode Cramer :");
        for(int i=0;i<m.row;i++){
            System.out.println("x" + (i+1) + " : " + x[i]);
        }

        System.out.print("Tulis hasil dalam file .txt? (y/n): ");
        String txt = sc.next();
        while(!txt.equals("y") && !txt.equals("Y") && !txt.equals("n") && !txt.equals("N")){
            System.out.print("Input tidak valid, silahkan input kembali: ");
            txt = sc.next();
        }
        if(txt.equals("y") || txt.equals("Y")){
            String output = "";
            for(int i=0;i<m.row;i++){
                output = output.concat("x");
                output = output.concat(Integer.toString(i+1));
                output = output.concat(" : ");
                output = output.concat(Float.toString(x[i]));
                output = output.concat("\n");
            }
            TXTReaderWriter.writeTXT(sc, output);
        }
    }

    public static Matrix shrink(Matrix m){
        // declare matrix
        Matrix m2 = new Matrix(m.row, m.col-1);

        // proses transfer matriks ke matriks baru, tanpa baris iex dan kolom jex
        for (int i = 0; i < m2.row; i++){
            for (int j = 0; j < m2.col; j++){
                m2.set(i, j, m.elmt(i, j));
            }
        }

        // janlup direturn
        return m2;
    }
}
