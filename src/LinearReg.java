import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
@SuppressWarnings("unused")

public class LinearReg {
    public static void f(Scanner sc, Matrix m){
        int a = 0;
        if ((m.row == 0) || (m.col == 0)) System.out.println("Perhitungan gagal, matriks yang diberikan merupakan matriks kosong.");
        else if (m.col == 1) System.out.println("Perhitungan gagal, matriks yang diberikan bukan berupa persamaan."); 
        else{
            // membentuk matrix sesuai rumus regresi linear
            Matrix linreg = new Matrix(m.col, m.col+1);
            
            // menyusun elemen2nya
            for (int i = 0; i < linreg.row; i++){
                for (int j = 0; j < linreg.col; j++){
                    // declarasi sum
                    float sum = 0;

                    if ((i == 0) && (j == 0)) sum += linreg.row; // elemen ujung kiri atas (nb0)
                    else if (i == 0){
                        for (int k = 0; k < m.row; k++) sum += m.elmt(k, (j % m.col)); // elemen ujung atas
                    } else if (j == 0){
                        for (int k = 0; k < m.row; k++) sum += m.elmt(k, (i % m.col)); // elemen ujung kiri
                    } else {
                        for (int k = 0; k < m.row; k++) sum += (m.elmt(k, (i % m.col))*m.elmt(k, (j % m.col))); // selain.
                    } 
                    
                    // taruh ke matrix linreg
                    linreg.set(i, j, sum);
                }
            } 

            // print matrix linreg
            System.out.println("Dari matriks yang diinput, terbentuk matrix regresi linear: ");
            System.out.print(TXTReaderWriter.castMatrixString(linreg));

            //solving pake gauss
            if(linreg.row < linreg.col-1){
                System.out.println("Akan tetapi, tidak dapat mencari solusi SPL.");
            } else { /* ubah matriks jadi matriks eselon */
                for(int i=0;i<linreg.row;i++){
                    if(linreg.elmt(i, i) != 1){
                        for(int j=i+1;j<linreg.row;j++){
                            if(linreg.elmt(j, i) == 1){
                                linreg.swapRow(i,j);
                                break;
                            }
                        }
                    }
                    if(linreg.elmt(i, i) == 0){
                        for(int j=i+1;j<linreg.row;j++){
                            if(linreg.elmt(j, i) != 0){
                                linreg.swapRow(i,j);
                                break;
                            }
                        }
                    }
                    if(linreg.elmt(i, i) != 0){
                        linreg.timeRow(i, 1/linreg.elmt(i, i));
                        for(int j=i+1;j<linreg.row;j++){
                            linreg.addRow(j, i, -1*(linreg.elmt(j, i)/linreg.elmt(i, i)));
                        }
                    }
    
                    for(int k=0;k<linreg.row;k++){
                        for(int l=0;l<linreg.col-1;l++){
                            Gauss.round(linreg.elmt(k, l), 2);
                        }
                    }
                }
                
    
                int barisnonzero = linreg.row;
                boolean bariszero,barisanomali = false;
    
                for(int i=0;i<linreg.row;i++){
                    bariszero = true;
                    for(int j=0;j<linreg.col;j++){
                        if(j == linreg.col-1 && linreg.elmt(i, j) != 0){
                            barisanomali = true;
                        }
                        if(linreg.elmt(i, j) != 0){
                            bariszero = false;
                            break;
                        }
                    }
                    if(bariszero){
                        barisnonzero--;
                    }
                    if(barisanomali){
                        break;
                    }
                }
    
                float[] x,y;
                x = new float[barisnonzero];
                y = new float[barisnonzero];
    
                if(barisanomali || barisnonzero < linreg.col - 1){
                    System.out.println("Akan tetapi, tidak dapat mencari solusi SPL.");
                } else {
                    x[0] = linreg.elmt(barisnonzero-1, linreg.col-1);
                    for(int i=1;i<barisnonzero;i++){
                        x[i] = linreg.elmt(barisnonzero-1-i, linreg.col-1);
                        for(int j=0;j<i;j++){
                            x[i] -= linreg.elmt(barisnonzero-1-i, linreg.col-2-j)*x[j];
                        }
                    }
    
                    for(int i=0;i<barisnonzero;i++){
                        y[i] = x[barisnonzero-i-1];
                    }
                
    
                    System.out.println("Hasil perhitungan menggunakan metode Gauss :");
                    for(int i=0;i<barisnonzero;i++){
                        System.out.println("x" + (i+1) + " : " + y[i]);
                    }
    
                    System.out.print("Tulis hasil dalam file .txt? (y/n): ");
                    String txt = sc.next();
                    while(!txt.equals("y") && !txt.equals("Y") && !txt.equals("n") && !txt.equals("N")){
                        System.out.print("Input tidak valid, silahkan input kembali: ");
                        txt = sc.next();
                    }
                    if(txt.equals("y") || txt.equals("Y")){
                        String output = "";
                        for(int i=0;i<barisnonzero;i++){
                            output = output.concat("x");
                            output = output.concat(Integer.toString(i+1));
                            output = output.concat(" : ");
                            output = output.concat(Float.toString(y[i]));
                            output = output.concat("\n");
                        }
                        TXTReaderWriter.writeTXT(sc, output);
                    }
                }
            }
        }
    }     
}