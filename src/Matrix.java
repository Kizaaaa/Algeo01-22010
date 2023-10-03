import java.util.Scanner;

public class Matrix {
    float element[][];
    int row;
    int col;

    /* Konstruktor*/
    public Matrix(int row, int col){
        this.row = row;
        this.col = col;
        this.element = new float[row][col];
    }

    /* Konstruktor */
    public void set(int row, int col, float val){
        this.element[row][col] = val;
    }

    /* Selector */
    public float elmt(int row, int col){
        return this.element[row][col];
    }

    /* Input Matrix */
    public void readMatrix(Scanner sc){
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                this.element[i][j] = sc.nextFloat();
            }
        }
    }

    /* Print Matrix */
    public void displayMatrix(){
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(elmt(i, j) == -0){
                    set(i, j, 0);
                }
                if(j == 0){
                    System.out.print(elmt(i, j));
                } else {
                    System.out.print(" " + elmt(i, j));
                }
            }
            System.out.println();
        }
    }

    /* Operasi Baris Elementer */
    /* Tukar 2 baris */
    public void swapRow(int row1, int row2){
        float temp[] = this.element[row1];
        this.element[row1] = this.element[row2];
        this.element[row2] = temp;
    }

    public void swapCol(int row1, int row2){
        for(int i=0;i<this.row;i++){
            float temp = this.elmt(i, row1);
            this.set(i, row1, this.elmt(i, row2));
            this.set(i, row2, temp);
        }
    }

    /* Kali baris dengan konstanta */
    public void timeRow(int row, float k){
        for(int i=0;i<this.col;i++){
            this.element[row][i] *= k;
        }
    }

    /* tambah baris dengan kelipatan baris lain */
    public void addRow(int row1, int row2, float k){
        for(int i=0;i<this.col;i++){
            this.element[row1][i] += this.element[row2][i]*k;
        }
    }

    /* Transpose Matrix */
    public static Matrix transposeMatrix(Matrix m){
        Matrix mtemp = new Matrix(m.col, m.row);
        for(int i=0;i<mtemp.row;i++){
            for(int j=0;j<mtemp.col;j++){
                mtemp.set(i, j, m.elmt(j, i));
            }
        }
        return mtemp;
    }

    /* Perkalian Matrix */
    public static Matrix perkalianMatrix(Matrix m1, Matrix m2){
        Matrix m3 = new Matrix(m1.row, m2.col);
        for(int i=0;i<m1.row;i++){
            for(int j=0;j<m2.col;j++){
                int val = 0;
                for(int k=0;k<m1.col;k++){
                    val += (m1.elmt(i, k) * m2.elmt(k, j));
                }
                m3.set(i, j, val);
            }
        }

        return m3;
    }
}
