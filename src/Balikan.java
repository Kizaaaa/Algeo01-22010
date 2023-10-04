import java.util.Scanner;

public class Balikan {
    public static void f(Matrix m, Scanner sc){
        Matrix m2 = new Matrix(m.row, m.col-1), m3 = new Matrix(m.row, 1), m4 = new Matrix(m.row, m.col-1);
        m2 = Cramer.shrink(m);
        for(int i=0;i<m.row;i++){
            m3.set(i, 0, m.elmt(i, m.col-1));
        }

        for(int i=0;i<m4.row;i++){
            for(int j=0;j<m4.col;j++){
                if((i+j) % 2 == 1){
                    m4.set(i, j, -1 * Determinan.detCof(Determinan.shrinkMatrix(m2, i, j)));
                } else {
                    m4.set(i, j, Determinan.detCof(Determinan.shrinkMatrix(m2, i, j)));
                }
            }
        }
        m4 = Matrix.transposeMatrix(m4);
        float det = Determinan.detOBE(m2);
        if(det == 0){
            System.out.println("Matriks tersebut tidak punya inverse!");
        } else {
            for(int i=0;i<m4.row;i++){
                m4.timeRow(i, 1/det);
            }
            Matrix x = Matrix.perkalianMatrix(m4,m3);
            System.out.println("Hasil perhitungan menggunakan metode matriks balikan :");
            for(int i=0;i<m.row;i++){
                System.out.println("x" + (i+1) + " : " + x.elmt(i, 0));
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
                    output = output.concat(Float.toString(x.elmt(i, 0)));
                    output = output.concat("\n");
                }
                TXTReaderWriter.writeTXT(sc, output);
            }
        }
    }
}