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

    public static Matrix readF(Scanner sc, float a, float b){
        Matrix readMat=TXTReaderWriter.readTXT(sc);
        Matrix retMat = new Matrix (readMat.row-1,readMat.col);
        for (int i=0;i<retMat.row;i++){
            for (int j=0;j<retMat.col;j++){
                retMat.set(i,j,readMat.elmt(i,j));
            }
        }
        a=readMat.elmt(retMat.col, 0);
        b=readMat.elmt(retMat.col, 1);
        return retMat;
    }

    public static void main(Scanner sc){
        int a=0,b=0;
        //Matrix fVals=readF(sc, a, b);
        Matrix X=xMatrix();
        Matrix fVals=TXTReaderWriter.readTXT(sc);
        X.displayMatrix();
        fVals.displayMatrix();
        System.out.println("\na:" + a + " b:" + b);
    }
}
