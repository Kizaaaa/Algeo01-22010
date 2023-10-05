import java.util.Scanner;

public class GaussJordan {
    public static float[] f(Matrix m, Scanner sc){
        float[] failRet = {-999999999};
        boolean foundone;
        int j = 0;
        /* ubah matriks jadi matriks eselon */
        for(int i=0;i<m.row;i++){
            foundone = false;
            while(!foundone && j < m.col-1){
                if(m.elmt(i, j) == 1){
                    foundone = true;
                } else {
                    for(int k=i+1;k<m.row;k++){
                        if(m.elmt(k, j) == 1){
                            m.swapRow(i,k);
                            foundone = true;
                            break;
                        }
                    }
                }
                if(m.elmt(i, j) != 0){
                    foundone = true;
                } else {
                    for(int k=i+1;k<m.row;k++){
                        if(m.elmt(k, j) != 0){
                            m.swapRow(i,k);
                            foundone = true;
                            break;
                        }
                    }
                }
                if(foundone){
                    m.timeRow(i, 1/m.elmt(i, j));

                    for(int k=0;k<i;k++){
                        m.addRow(k, i, m.elmt(k, j)/m.elmt(i, j)/-1);
                    }

                    for(int k=i+1;k<m.row;k++){
                        m.addRow(k, i, m.elmt(k, j)/m.elmt(i, j)/-1);
                    }

                    for(int k=0;k<m.row;k++){
                        for(int l=0;l<m.col;l++){
                            m.set(k, l,(float) Gauss.round(m.elmt(k, l), 4));
                        }
                    }
                    continue;
                }
                j++;
            }
            j++;
        }

        int barisnonzero = m.row;
        boolean bariszero,barisanomali = false;

        for(int i=0;i<m.row;i++){
            bariszero = true;
            for(int j1=0;j<m.col;j++){
                if(j1 == m.col-1 && m.elmt(i, j1) != 0){
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

        if(barisanomali){
            System.out.println("Tidak dapat mencari solusi SPL.");
            return failRet;
        } else if(barisnonzero < m.col - 1){ // Solusi parametrik
            String[] x = new String[m.col-1];
            String[] variabel = {"t","s","r","q","p","o","n","m","l","k"};
            int idxvariabel = 0;
            for(int i=barisnonzero-1;i>=0;i--){
                int satupertama = -1;
                String temp = "";
                for(j=m.col-2;j>=0;j--){
                    if(m.elmt(i, j) != 0){
                        satupertama = j;
                    }
                }
                for(j=m.col-2;j>=satupertama;j--){
                    if(m.elmt(i, j) != 0){
                        if(j == satupertama){
                            if(temp != ""){
                                temp = temp.substring(2,temp.length());
                                x[j] = m.elmt(i, m.col-1) + "-" + temp;
                            }
                            
                        } else {
                            if(x[j] == null){
                                x[j] = variabel[idxvariabel];
                                idxvariabel++;
                                temp += "+ (" + (m.elmt(i, j)) + "*(" + x[j] + "))";
                            } else {
                                temp += "+ (" + (m.elmt(i, j)) + "*(" + x[j] + "))";
                            }
                        }
                    }
                }
            }
            System.out.println("Hasil perhitungan menggunakan metode Gauss :");
            for(int i=0;i<m.col-1;i++){
                System.out.print("x" + (i+1) + " : ");
                if(x[i] == null){
                    x[i] = "free";
                }
                System.out.println(x[i]);
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
                    output = output.concat(x[i]);
                    output = output.concat("\n");
                }
                TXTReaderWriter.writeTXT(sc, output);
            }

            return failRet;
        } else { // Solusi tunggal
            float[] x,y;
            x = new float[barisnonzero];
            y = new float[barisnonzero];
            x[0] = m.elmt(barisnonzero-1, m.col-1);
            
            for(int i=1;i<barisnonzero;i++){
                x[i] = m.elmt(barisnonzero-1-i, m.col-1);
                for(int j2=0;j2<i;j++){
                    x[i] -= m.elmt(barisnonzero-1-i, m.col-2-j2)*x[j];
                }
            }

            for(int i=0;i<barisnonzero;i++){
                y[i] = x[barisnonzero-i-1];
            }
            System.out.println("Hasil perhitungan menggunakan metode Gauss Jordan :");

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