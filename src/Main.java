import java.util.Scanner;

public class Main { 
    public static void main(String[] args){ // seriously? perlu kujelasin?
        boolean exit = false;
		int input;
		
        while(!exit){
            input = home();
			switch(input){
				case 1:
					System.out.println("Sistem Persamaan Linier");
					break;
				case 2:
					System.out.println("Determinan");
					break;
				case 3:
					System.out.println("Matriks Balikan");
					break;
				case 4:
					System.out.println("Interpolasi Polinom");
					break;
				case 5:
					System.out.println("Interpolasi Bicubic Spine");
					break;
				case 6:
					System.out.println("Interpolasi Regresi Linier Berganda");
					break;
				case 7:
					System.out.println("Have a good day! ^_^");
					exit = true;
					break;
			}
        } 
    }

	public static int home(){ // ini home menu nya
		System.out.println("MENU : \n1. Sistem Persamaan Linier\n2. Determinan\n3. Matriks Balikan\n4. Interpolasi Polinom\n5. Interpolasi Bicubic Spine\n6. Regresi Linier Berganda\n7.Keluar\nMasukkan pilihan(1-7):");

		int input = cinCheck(1, 7);
		return input; // di sini udah sukses inputnya (valid)
	}

	public static void spl(Scanner s){ // spl gan
		int input = 0, ipt1 = 0;
		int result; boolean exit = false;
		System.out.println("SISTEM PERSAMAAN LINEAR\n1. Metode eliminasi Gauss\n2.Metode eliminasi Gauss-Jordan\n3.Metode matriks balikan\n4.Kaidah cramer\n5.Kembali");
		System.out.print("Silahkan pilih metode atau pilihan menu: "); input = cinCheck(1, 5);
		switch (input){
			case 1:
				Matrix m1 = InputMatrix();
				// gauss
				break;
			case 2:
				Matrix m2 = InputMatrix();
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
		}
	}

	public static Matrix InputMatrix(){ //ini buat input matrix gan.
		Matrix m = new Matrix(0, 0);
		System.out.println("Masukkan pilihan input: (1) untuk input dari keyboard, dan (2) untuk input dari file.txt");
		int input = cinCheck(1, 2);
		switch (input){

			case 1:
				System.out.println("Masukkan pilihan input: \n(1) Format Ax = B \n(2) Format Matriks Augmented");
				int input1 = cinCheck(1, 2);
				switch (input1){
					case 1:
						System.out.print("Masukkan ukuran baris dari matriks A: "); int row = cin();
						System.out.print("Masukkan ukuran kolom dari matriks A: "); int col = cin();

						System.out.println("Masukkan matriks A: ");
						Matrix A = new Matrix(row, col); A.readMatrix();

						float[] B = new float[row];
						System.out.println("Masukkan matriks B (ukuran baris x 1) dalam bentuk baris: ");
						for (int i = 0; i < row; i++){
							B[i] = cinf();
						}
						
						m = new Matrix(row, col+1);
						for (int i = 0; i < row; i++){
							for (int j = 0; j< col; j++){
								m.set(i, j, A.elmt(i, j));
							}
						} for (int i = 0; i < row; i++){
							m.set(i, col, B[i]);
						} 

						break;
					case 2:
						System.out.print("Masukkan ukuran baris dari matriks: "); int row2 = cin();
						System.out.print("Masukkan ukuran kolom dari matriks: "); int col2 = cin();
						m = new Matrix(row2, col2);

						System.out.println("Masukkan matriks: ");
						m.readMatrix();
						
						break;
				} break;

			case 2:
				TXTReaderWriter.readTXT(m);
				break;
		} return m;
	}

	public static int cinCheck(int a, int b){ // ini buat input yang ada constrain nya
		int input = cin(); 
		while((input<=a)||(input>=b)){
			System.out.println("Input tidak valid, silahkan ulangi prosesi input kembali di bawah ini."); 
			input = cin();
		} return input;
	}


	public static float cinf(){ // ini buat input in general
		Scanner s = new Scanner(System.in);
		float input = s.nextFloat();
		s.close();
		return input;
	}
	
	public static int cin(){ // ini buat input in general
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		s.close();
		return input;
	}

}
