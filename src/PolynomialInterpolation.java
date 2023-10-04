import java.util.Scanner;
import java.lang.Math;

public class PolynomialInterpolation{
    public static void interpolation(Matrix m, float x, Scanner sc){
        float result = 0;
        float[] aVals=Gauss.gaussNoText(m, sc);
        float[] failRet={6,9}; //dari Gauss
        if (aVals==failRet){
            System.out.println("Maaf, titik-titik tersebut tidak bisa diinterpolasi");
        }
        else{
            String outString;
            outString="f(x) = ";
            for (int i=aVals.length-1;i>0;i--){
                outString+=(Float.toString(aVals[i]));
                outString+=("x^"); 
                outString+=(Integer.toString(i));
                outString+=(" + ");
                result+=aVals[i]*Math.pow(x,i);
            }
            result+=aVals[0];
            outString+=(Float.toString(aVals[0]));
            outString+=(", f(");
            outString+=(Float.toString(x));
            outString+=(") = ");
            outString+=(Float.toString(result));
            System.out.println(outString);
            System.out.print("Tulis hasil dalam file .txt? (y/n): ");
            String txt = sc.next();
            while(!txt.equals("y") && !txt.equals("Y") && !txt.equals("n") && !txt.equals("N")){
                System.out.print("Input tidak valid, silahkan input kembali: ");
                txt = sc.next();
            }
            if(txt.equals("y") || txt.equals("Y")){
                TXTReaderWriter.writeTXT(sc, outString);
            }
        }
    }

    public static Matrix keyInput(Scanner sc){
        System.out.println("Masukkan jumlah titik yang akan diinterpolasi (minimal 2): ");            
        int n = Main.cinMinCheck(sc, 2);
        sc.nextLine();
        Matrix m = new Matrix(n, n+1);
        System.out.println("Masukkan "+n+" titik: \n(Format: (x0,y0), (x1,y1), ..., (xn,yn))");
        String line=sc.nextLine(); 
        String[] points=line.split(", ");
        while(points.length!=n){
            System.out.println("Input tidak valid, silahkan input kembali: ");
            System.out.println("Masukkan "+n+" titik: \n(Format: (x0,y0), (x1,y1), ..., (xn,yn))");
            line=sc.nextLine(); 
            points=line.split(", ");
        }
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
            Matrix m = TXTReaderWriter.readTXT(sc);
            interpolationMatrix = new Matrix(m.row-1, m.row);
            for (int i=0;i<interpolationMatrix.row;i++){
                float x=m.element[i][0];
                for (int j=0;j<interpolationMatrix.row;j++){
                    interpolationMatrix.set(i,j,(float)Math.pow(x,j));
                }
                interpolationMatrix.set(i,interpolationMatrix.col-1,m.element[i][1]);
            }
            taksiran=m.elmt(m.row-1, 0);
        }
        interpolation(interpolationMatrix,taksiran,sc);
    }

}