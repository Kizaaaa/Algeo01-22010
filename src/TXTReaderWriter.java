import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TXTReaderWriter {
    public static void readTXT(Matrix A){
        Scanner s = new Scanner(System.in);

        // input nama file
        String namaFile = "";
        while (namaFile == ""){
            System.out.print("Masukkan nama file: "); namaFile = s.nextLine();
        } System.out.println("nama file yang dipilih: " + namaFile);

        // try untuk mencoba mengakses nama file
        try {
            // declare var File
            File current = new File("..");
            File txt = new File(current, "test\\" + namaFile);

            // scanner
            Scanner sizeScanner = new Scanner(txt);
            int rowSize = 0; while(sizeScanner.hasNextLine()){
                rowSize++; sizeScanner.nextLine();
            } sizeScanner.close();

            // try untuk mencoba membaca string dari txt dan mengubahnya ke elemen2 matriks
            A.row = rowSize; Scanner reader = new Scanner(txt);
            try {
                for (int i = 0; i < rowSize; i++){
                    String line = reader.nextLine();
                    String[] row = line.split(" ");
                    A.col = row.length;
                    for (int j = 0; j < A.col; j++) A.set(i, j, Float.parseFloat(row[j]));
                }
            } finally {
                // janlup close
                reader.close();
            }
        } catch (FileNotFoundException err){ // kalo ada error, pesan error nya taruh buat di print
            System.out.println("error gan waktu parsing, error message: " + err);
        }

        s.close();
    }

    public static void writeTXT(String str){
        Scanner s = new Scanner(System.in);

        // input nama file yang akan diwrite/dibuat
        String namaFile = ""; 
        while(namaFile == ""){
            System.out.print("Masukkan nama file ouput (akan diwrite {nama}.txt): "); namaFile = s.nextLine();
        } System.out.println("nama file yang dipilih: " + namaFile);

        // mencoba untuk write
        try {
            File current = new File("..");
            File txt = new File(current, "test\\"+namaFile);
            FileWriter txtWrite = new FileWriter(txt, true);
            txtWrite.write(str);
            txtWrite.close();
            System.out.println("Writing file berhasil.");
        } catch (Exception err){ // kalo error
            System.out.println("error gan waktu parsing, error message: " + err);       
        }

        s.close();
    }
}
