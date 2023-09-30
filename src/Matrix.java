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

    /* Kali baris dengan konstanta */
    public void timeRow(int row, int k){
        for(int i=0;i<this.col;i++){
            this.element[row][i] *= k;
        }
    }

    /* tambah baris dengan kelipatan baris lain */
    public void addRow(int row1, int row2, float k){
        for(int i=0;i<this.col;i++){
            this.element[row][i] += this.element[row2][i]*k;
        }
    }
}
