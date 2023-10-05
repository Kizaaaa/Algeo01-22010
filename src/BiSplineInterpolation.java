import java.util.Scanner;
import java.lang.Math;

public class BiSplineInterpolation {
    public static Matrix xMatrix(){
        Matrix X = new Matrix(16, 16);
        int i,j,k,l,x,y;
        double val;
        for (i=0;i<X.row;i++){
            x=i%2;
            y=(i/2)%2;
            k=0;
            l=0;
            for (j=0;j<X.col;j++){
                val=0;
                if (i<4){
                    val=Math.pow(x, k)*Math.pow(y, l);
                }
                else if (i<8){
                    if (k!=0) val=k*Math.pow(x, k-1)*Math.pow(y, l);
                    
                } 
                else if (i<12){
                    if (l!=0) val=l*Math.pow(x, k)*Math.pow(y, l-1);
                }
                else if (i<16){
                    if (k!=0 && l!=0)val=k*l*Math.pow(x, k-1)*Math.pow(y, l-1);
                }
                X.set(i,j,(float)val);
                if (k==3) {
                     k=0;
                    l+=1;
                }
                else k+=1;
            }
        }
        return X;
    }

    public static Matrix readF(Scanner sc, Matrix m){
        int i,j,k=0;
        Matrix retMat = new Matrix (16,1);
        for (i=0;i<m.row-1;i++){
            for (j=0;j<m.col;j++){
                retMat.set(k,0,m.elmt(i,j));
                k+=1;
            }
        }
        return retMat;
    }

    public static float countResult(Matrix m,float a,float b){
        int i,j,k=0;
        float r=0;
        for (j=0;j<=3;j++){
            for (i=0;i<=3;i++){
                r+=m.elmt(k,0)*Math.pow(a, i)*Math.pow(b, j);
                k+=1;
            }
        }
        return r;
    }

    public static void f(Scanner sc){
        float a,b;
        Matrix readMat=TXTReaderWriter.readTXT(sc);        
        Matrix fVals=readF(sc, readMat);
        a=readMat.elmt(readMat.col, 0);
        b=readMat.elmt(readMat.col, 1);
        Matrix X=xMatrix();
        Matrix inverseX=Inverse.inverseObeNoText(X,sc);
        Matrix aVals=Matrix.perkalianMatrix(inverseX, fVals);
        float result = countResult(aVals, a, b);
        String outString = "f(" + Float.toString(a) + "," + Float.toString(b) + ") = " + Float.toString(result);
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
