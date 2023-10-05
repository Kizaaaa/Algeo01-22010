import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TXTReaderWriter {
    public static Matrix readTXT(Scanner sc){
        Matrix A = new Matrix(0, 0);

        // input nama file
        String namaFile = "";
        while (namaFile == ""){
            System.out.print("Masukkan nama file: "); namaFile = sc.next();
        } System.out.println("nama file yang dipilih: " + namaFile);

        // try untuk mencoba mengakses nama file
        try {
            // declare var File
            File txt = new File("test\\" + namaFile);

            // scanner
            Scanner sizeScanner = new Scanner(txt);
            int rowSize = 0; while(sizeScanner.hasNextLine()){
                rowSize++; sizeScanner.nextLine();
            } sizeScanner.close();

            // try untuk mencoba membaca string dari txt dan mengubahnya ke elemen2 matriks
            int Arow = rowSize, Acol = 0; Scanner reader = new Scanner(txt); Scanner reader2 = new Scanner(txt);
            try {
                String line2 = reader2.nextLine();
                String[] row2 = line2.split(" ");
                Acol = row2.length;
                A = new Matrix(Arow, Acol);
                for (int i = 0; i < rowSize; i++){
                    String line = reader.nextLine();
                    String[] row = line.split(" ");
                    for (int j = 0; j < row.length; j++) A.set(i, j, Float.parseFloat(row[j]));
                }
            } finally {
                // janlup close
                reader2.close();
                reader.close();
            }
        } catch (FileNotFoundException err){ // kalo ada error, pesan error nya taruh buat di print
            System.out.println("error gan waktu parsing, error message: " + err);
        }

        return A;
    }

    public static void writeTXT(Scanner sc, String str){

        // input nama file yang akan diwrite/dibuat
        String namaFile = ""; 
        while(namaFile == ""){
            System.out.print("Masukkan nama file ouput (akan diwrite {nama}.txt): "); namaFile = sc.next();
        } System.out.println("nama file yang dipilih: " + namaFile);

        // mencoba untuk write
        try {
            File txt = new File("test\\"+namaFile);
            FileWriter txtWrite = new FileWriter(txt, true);
            txtWrite.write(str);
            txtWrite.close();
            System.out.println("Writing file berhasil.");
        } catch (Exception err){ // kalo error
            System.out.println("error gan waktu parsing, error message: " + err);       
        }

    }

    public static String castMatrixString(Matrix m){
        String ret = ""; for (int i = 0; i < m.row; i++){
            for (int j = 0; j < m.col; j++){
                ret = ret.concat(Float.toString(m.elmt(i, j)));
                if (j != m.col-1) ret = ret.concat(" ");
                else ret = ret.concat("\n");
            }
        } return ret;
    }
}
