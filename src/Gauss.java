import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Gauss {
    public static float[] f(Matrix m, Scanner sc){
        float[] failRet = {6, 9};
        if(m.row < m.col-1){
            System.out.println("Tidak dapat mencari solusi SPL.");
            return failRet;
        } else { /* ubah matriks jadi matriks eselon */
            for(int i=0;i<m.row;i++){
                if(m.elmt(i, i) != 1){
                    for(int j=i+1;j<m.row;j++){
                        if(m.elmt(j, i) == 1){
                            m.swapRow(i,j);
                            break;
                        }
                    }
                }
                if(m.elmt(i, i) == 0){
                    for(int j=i+1;j<m.row;j++){
                        if(m.elmt(j, i) != 0){
                            m.swapRow(i,j);
                            break;
                        }
                    }
                }
                if(m.elmt(i, i) != 0){
                    m.timeRow(i, 1/m.elmt(i, i));
                    for(int j=i+1;j<m.row;j++){
                        m.addRow(j, i, -1*(m.elmt(j, i)/m.elmt(i, i)));
                    }
                }

                for(int k=0;k<m.row;k++){
                    for(int l=0;l<m.col-1;l++){
                        Gauss.round(m.elmt(k, l), 2);
                    }
                }
            }
            

            int barisnonzero = m.row;
            boolean bariszero,barisanomali = false;

            for(int i=0;i<m.row;i++){
                bariszero = true;
                for(int j=0;j<m.col;j++){
                    if(j == m.col-1 && m.elmt(i, j) != 0){
                        barisanomali = true;
                    }
                    if(m.elmt(i, j) != 0){
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

            if(barisanomali || barisnonzero < m.col - 1){
                System.out.println("Tidak dapat mencari solusi SPL.");
                return failRet;
            } else {
                x[0] = m.elmt(barisnonzero-1, m.col-1);
                for(int i=1;i<barisnonzero;i++){
                    x[i] = m.elmt(barisnonzero-1-i, m.col-1);
                    for(int j=0;j<i;j++){
                        x[i] -= m.elmt(barisnonzero-1-i, m.col-2-j)*x[j];
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

                return y;
            }
        }
    }

    public static float[] gaussNoText(Matrix m, Scanner sc){
        float[] failRet = {6, 9};
        if(m.row < m.col-1){
            return failRet;
        } else { /* ubah matriks jadi matriks eselon */
            for(int i=0;i<m.row;i++){
                if(m.elmt(i, i) != 1){
                    for(int j=i+1;j<m.row;j++){
                        if(m.elmt(j, i) == 1){
                            m.swapRow(i,j);
                            break;
                        }
                    }
                }
                if(m.elmt(i, i) == 0){
                    for(int j=i+1;j<m.row;j++){
                        if(m.elmt(j, i) != 0){
                            m.swapRow(i,j);
                            break;
                        }
                    }
                }
                if(m.elmt(i, i) != 0){
                    m.timeRow(i, 1/m.elmt(i, i));
                    for(int j=i+1;j<m.row;j++){
                        m.addRow(j, i, -1*(m.elmt(j, i)/m.elmt(i, i)));
                    }
                }

                for(int k=0;k<m.row;k++){
                    for(int l=0;l<m.col-1;l++){
                        Gauss.round(m.elmt(k, l), 2);
                    }
                }
            }
            

            int barisnonzero = m.row;
            boolean bariszero,barisanomali = false;

            for(int i=0;i<m.row;i++){
                bariszero = true;
                for(int j=0;j<m.col;j++){
                    if(j == m.col-1 && m.elmt(i, j) != 0){
                        barisanomali = true;
                    }
                    if(m.elmt(i, j) != 0){
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

            if(barisanomali || barisnonzero < m.col - 1){
                return failRet;
            } else {
                x[0] = m.elmt(barisnonzero-1, m.col-1);
                for(int i=1;i<barisnonzero;i++){
                    x[i] = m.elmt(barisnonzero-1-i, m.col-1);
                    for(int j=0;j<i;j++){
                        x[i] -= m.elmt(barisnonzero-1-i, m.col-2-j)*x[j];
                    }
                }

                for(int i=0;i<barisnonzero;i++){
                    y[i] = x[barisnonzero-i-1];
                }
            
                return y;
            }
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}