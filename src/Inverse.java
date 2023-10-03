import java.util.Scanner;

public class Inverse {
    public static Matrix inverseObe(Matrix m, Scanner sc){
        Matrix mtemp,mtemp2,failRet;
        failRet = new Matrix(1, 2); failRet.set(0, 0, 6); failRet.set(0, 1, 9);
        mtemp = new Matrix(m.row, 2*m.col);
        mtemp2 = new Matrix(m.row, m.col);
        for(int i=0;i<m.row;i++){
            for(int j=0;j<m.col;j++){
                mtemp.set(i, j, m.elmt(i, j));
                if(i == j){
                    mtemp.set(i, j+m.col, 1);
                } else {
                    mtemp.set(i, j+m.col, 0);
                }
            }
        }
        
        for(int i=0;i<m.row;i++){
            if(mtemp.elmt(i, i) != 1){
                for(int j=i+1;j<m.row;j++){
                    if(mtemp.elmt(j, i) == 1){
                        mtemp.swapRow(i,j);
                        break;
                    }
                }
            }
            if(mtemp.elmt(i, i) == 0){
                for(int j=i+1;j<mtemp.row;j++){
                    if(mtemp.elmt(j, i) != 0){
                        mtemp.swapRow(i,j);
                        break;
                    }
                }
            }
            if(mtemp.elmt(i, i) != 0){
                mtemp.timeRow(i, 1/mtemp.elmt(i, i));
                for(int j=0;j<i;j++){
                    mtemp.addRow(j, i, -1*(mtemp.elmt(j, i)/mtemp.elmt(i, i)));
                }
                for(int j=i+1;j<m.row;j++){
                    mtemp.addRow(j, i, -1*(mtemp.elmt(j, i)/mtemp.elmt(i, i)));
                }
            }
            
            for(int k=0;k<mtemp.row;k++){
                for(int l=0;l<m.col-1;l++){
                    Gauss.round(mtemp.elmt(k, l), 4);
                }
            }
        }

        if(isIdentity(mtemp)){
            for(int i=0;i<m.row;i++){
                for(int j=0;j<m.col;j++){
                    mtemp2.set(i, j, mtemp.elmt(i, j+m.col));
                }
            }
        } else {
            System.out.println("Matriks tersebut tidak punya inverse!");
            return failRet;
        }

        System.out.println("Hasil perhitungan menggunakan metode OBE :");
        mtemp2.displayMatrix();

        System.out.print("Tulis hasil dalam file .txt? (y/n): ");
        String txt = sc.next();
        while(!txt.equals("y") && !txt.equals("Y") && !txt.equals("n") && !txt.equals("N")){
            System.out.print("Input tidak valid, silahkan input kembali: ");
            txt = sc.next();
        }
        if(txt.equals("y") || txt.equals("Y")){
            TXTReaderWriter.writeTXT(sc, TXTReaderWriter.castMatrixString(mtemp2));
        }

        return mtemp2;
    }

    public static boolean isIdentity(Matrix m){
        for(int i=0;i<m.row;i++){
            for(int j=0;j<m.row;j++){
                if(i == j && m.elmt(i, j) != 1){
                    return false;
                }
                if(i != j && m.elmt(i, j) != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Matrix m = new Matrix(2, 2);
        Scanner sc = new Scanner(System.in);
        m.readMatrix(sc);
        System.out.println("");
        m = Inverse.inverseObe(m, sc);
        m.displayMatrix();
    }
}
/*
3 1 2 2 19
2 1 1 3 19
2 1 4 -1 12
1 2 1 1 12
1 2 1 1 12
 */