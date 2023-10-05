import java.util.Scanner;
import java.lang.Math;

public class PolynomialInterpolation{
    public static double findXn(MatrixDouble m){
        double Xn=m.elmt(0, 1); 
        
        //traversal hanya dilakukan di col 1 karena col 1 berisi x^1
        for (int i=0;i<m.row;i++){
            if (m.elmt(i, 1)>Xn){
                Xn=m.elmt(i, 1);
            }
        }
        return Xn;
    }

    public static double findX0(MatrixDouble m){
        double X0=m.elmt(0, 1); 
        
        //traversal hanya dilakukan di col 1 karena col 1 berisi x^1
        for (int i=0;i<m.row;i++){
            if (m.elmt(i, 1)<X0){
                X0=m.elmt(i, 1);
            }
        }
        return X0;
    }

    public static boolean arePointsUnique(MatrixDouble m){
        boolean unique=true;
        int i,j;
        i=0;
        while ((i<m.row-1)&&(unique)){
            j=i+1;
            while ((j<m.row)&&(unique)){
                if ((m.elmt(i, 0)==m.elmt(j, 0))&&(m.elmt(i, 1)==m.elmt(j, 1))){
                    unique=false;
                }
                j+=1;
            }
            i+=1;
        }
        return unique;
    }

    public static boolean arePointsUniqueS(String[] s){
        boolean unique=true;
        int i=0;

        while ((unique)&&i<s.length-1){
            int j=i+1;
            while((unique)&&j<s.length){
                if (s[i]==s[j]){
                    unique=false;
                }
                j+=1;
            }
            i+=1;
        }
        return unique;
    }

    public static void f(Scanner sc){
        MatrixDouble interpolationMatrix;
        double taksiran=0;
        System.out.println("Masukkan pilihan input: (1) untuk input dari keyboard, dan (2) untuk input dari file.txt");
        int input = Main.cinCheck(sc,1,2);
        if (input==1){
            System.out.println("Masukkan jumlah titik yang akan diinterpolasi (minimal 2): ");            
            int n = Main.cinMinCheck(sc, 2);
            sc.nextLine();
            interpolationMatrix = new MatrixDouble(n, n+1);
            System.out.println("Masukkan "+n+" titik: \n(Format: (x0,y0), (x1,y1), ..., (xn,yn))");
            String line=sc.nextLine(); 
            String[] points=line.split(", ");
            while((points.length!=n)||(!arePointsUniqueS(points))){
                System.out.println("Input tidak valid, silahkan input kembali");
                System.out.println("Masukkan "+n+" titik: \n(Format: (x0,y0), (x1,y1), ..., (xn,yn))");
                line=sc.nextLine(); 
                points=line.split(", ");
            }
            for (int i=0;i<interpolationMatrix.row;i++){
                String[] xArr=points[i].split("[\\(||\\)||,]");
                Double x=Double.parseDouble(xArr[1]);
                for (int j=0;j<interpolationMatrix.row;j++){
                    interpolationMatrix.set(i,j,Math.pow(x,j));
                }
                interpolationMatrix.set(i,n,Double.parseDouble(xArr[2]));
            }
            System.out.println("Masukkan nilai x yang akan ditaksir nilai fungsinya: ");
            taksiran=sc.nextDouble();
            while (taksiran<findX0(interpolationMatrix) || taksiran>findXn(interpolationMatrix)){
                System.out.println("Input tidak valid, silahkan input kembali");
                System.out.println("Nilai x harus berada di antara x0 sampai xn");
                taksiran=sc.nextDouble();
            }
        }
        else{
            MatrixDouble m = TXTReaderWriter.readTXTD(sc);
            interpolationMatrix = new MatrixDouble(m.row-1, m.row);
            for (int i=0;i<interpolationMatrix.row;i++){
                double x=m.element[i][0];
                for (int j=0;j<interpolationMatrix.row;j++){
                    interpolationMatrix.set(i,j,Math.pow(x,j));
                }
                interpolationMatrix.set(i,interpolationMatrix.col-1,m.element[i][1]);
            }
            taksiran=m.elmt(m.row-1, 0);
            if (taksiran<findX0(interpolationMatrix) || taksiran>findXn(interpolationMatrix)){
                System.out.println("Data tidak valid! Nilai x harus berada di antara x0 sampai xn");
                return;
            }
            if (!arePointsUnique(m)){
                System.out.println("Data tidak valid! Setiap titik harus berbeda");
                return;
            }
        }
        double result = 0;
        double[] aVals=Gauss.gaussNoText(interpolationMatrix, sc);
        String outString;
        outString="f(x) = ";
        for (int i=aVals.length-1;i>0;i--){
            outString+=("("+Double.toString(aVals[i])+")"+"x^"+Integer.toString(i)+" + ");
            result+=aVals[i]*Math.pow(taksiran,i);
        }
        result+=aVals[0];
        outString+=(Double.toString(aVals[0])+", f("+Double.toString(taksiran)+") = "+Double.toString(result));
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