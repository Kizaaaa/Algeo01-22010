import java.util.Scanner;
import java.lang.Math;

public class Interpolasi{
    public static void polynomialInterpolation(Matrix m, float x){
        //pake gauss
    }

    public static Matrix keyInput(Scanner sc){
        System.out.println("Masukkan jumlah titik yang akan diinterpolasi (minimal 1): ");            
        int n = Main.cinMinCheck(sc, 1);
        sc.nextLine();
        Matrix m = new Matrix(n, n+1);
        System.out.println("Masukkan "+n+" titik: \n(Format: (x0,y0), (x1,y1), ..., (xn,yn))");
        String line=sc.nextLine(); 
        String[] points=line.split(", ");
        for (int i=0;i<m.row;i++){
            String[] xArr=points[i].split("[\\(||\\)||,]");
            Double x=Double.parseDouble(xArr[1]);
            for (int j=0;j<m.row;j++){
                m.set(i,j,(float)Math.pow(x,j));
            }
            m.set(i,n,Float.parseFloat(xArr[2]));
        }
        return m;
    }

    public static Matrix fileInput(float taksiran){
        Matrix m = TXTReaderWriter.readTXT();
        Matrix mret = new Matrix(m.row-1, m.row);
        for (int i=0;i<mret.row;i++){
            float x=m.element[i][0];
            for (int j=0;j<mret.row;j++){
                mret.set(i,j,(float)Math.pow(x,j));
            }
            mret.set(i,mret.col-1,m.element[i][1]);
        }
        m.displayMatrix();
        mret.displayMatrix();
        taksiran=m.elmt(m.row-1, 0);
        return mret;
    }

    public static void main(Scanner sc){
        Matrix interpolationMatrix;
        float taksiran=0;
        System.out.println("Masukkan pilihan input: (1) untuk input dari keyboard, dan (2) untuk input dari file.txt");
        int input = Main.cinCheck(sc,1,2);
        if (input==1){
            interpolationMatrix=keyInput(sc);
            System.out.println("Masukkan nilai x yang akan ditaksir nilai fungsinya: ");
            taksiran=sc.nextFloat();
        }
        else{
            interpolationMatrix=fileInput(taksiran);}
        
        polynomialInterpolation(interpolationMatrix,taksiran);

    }

}