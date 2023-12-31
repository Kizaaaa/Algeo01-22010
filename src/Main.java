import java.util.Scanner;

import javax.sound.sampled.Line;
@SuppressWarnings("unused")

public class Main { 
    public static void main(String[] args){ // seriously? perlu kujelasin?
		Scanner sc = new Scanner(System.in);
        boolean exit = false;
		int input;

				System.out.println("   __  __      _       _____    ____                  __  __   \r\n" + //
				"U|' \\/ '|uU  /\"\\  u  |_ \" _|U |  _\"\\ u     ___       \\ \\/\"/   \r\n" + //
				"\\| |\\/| |/ \\/ _ \\/     | |   \\| |_) |/    |_\"_|      /\\  /\\   \r\n" + //
				" | |  | |  / ___ \\    /| |\\   |  _ <       | |      U /  \\ u  \r\n" + //
				" |_|  |_| /_/   \\_\\  u |_|U   |_| \\_\\    U/| |\\u     /_/\\_\\   \r\n" + //
				"<<,-,,-.   \\\\    >>  _// \\\\_  //   \\\\_.-,_|___|_,-.,-,>> \\\\_  \r\n" + //
				" (./  \\.) (__)  (__)(__) (__)(__)  (__)\\_)-' '-(_/  \\_)  (__) ");
		
        while(!exit){
            input = home(sc);
			switch(input){
				case 1:
					splHome(sc);
					break;
				case 2:
					detHome(sc);
					break;
				case 3:
					inverseHome(sc);
					break;
				case 4:
					interpolasiPolinomHome(sc);
					break;
				case 5:
					interpolasiBicubicHome(sc);
					break;
				case 6:
					linearRegHome(sc);
					break;
				case 7:
					System.out.println("Have a good day! ^_^");
					System.out.println("                                      _ .-') _ .-. .-')                 ('-.   \r\n" + //
							"                                     ( (  OO) )\\  ( OO )              _(  OO)  \r\n" + //
							"  ,----.     .-'),-----.  .-'),-----. \\     .'_ ;-----.\\  ,--.   ,--.(,------. \r\n" + //
							" '  .-./-') ( OO'  .-.  '( OO'  .-.  ',`'--..._)| .-.  |   \\  `.'  /  |  .---' \r\n" + //
							" |  |_( O- )/   |  | |  |/   |  | |  ||  |  \\  '| '-' /_).-')     /   |  |     \r\n" + //
							" |  | .--, \\\\_) |  |\\|  |\\_) |  |\\|  ||  |   ' || .-. `.(OO  \\   /   (|  '--.  \r\n" + //
							"(|  | '. (_/  \\ |  | |  |  \\ |  | |  ||  |   / :| |  \\  ||   /  /\\_   |  .--'  \r\n" + //
							" |  '--'  |    `'  '-'  '   `'  '-'  '|  '--'  /| '--'  /`-./  /.__)  |  `---. \r\n" + //
							"  `------'       `-----'      `-----' `-------' `------'   `--'       `------' ");
					exit = true;
					break;
			}
        } 
		sc.close();
    }

	public static int home(Scanner sc){ // ini home menu nya
		System.out.print("MENU : \n1. Sistem Persamaan Linier\n2. Determinan\n3. Matriks Balikan\n4. Interpolasi Polinom\n5. Interpolasi Bicubic Spine\n6. Regresi Linier Berganda\n7. Keluar\nMasukkan pilihan(1-7): ");

		int input = cinCheck(sc, 1, 7);
		return input; // di sini udah sukses inputnya (valid)
	}

	public static void splHome(Scanner sc){ // buat SPL gan
		int input = 0;
		boolean exit = false;
		
		while (exit == false){
			float[] ans = {4, 2, 0};
			System.out.println("\nSISTEM PERSAMAAN LINEAR\n1. Metode eliminasi Gauss\n2. Metode eliminasi Gauss-Jordan\n3. Metode matriks balikan\n4. Kaidah cramer\n5. Kembali");
			System.out.print("Silahkan pilih metode atau pilihan menu: "); 
			input = cinCheck(sc, 1, 5);
			System.out.println("Opsi " + input + " telah dipilih.");
			switch (input){
				case 1:
					Matrix m1 = InputMatrixSPL(sc);
					ans = Gauss.f(m1, sc);
					break;
				case 2:
					Matrix m2 = InputMatrixSPL(sc);
					ans = GaussJordan.f(m2, sc);
					break;
				case 3:
					Matrix m3 = InputMatrixSPL(sc);
					Balikan.f(m3, sc);
					break;
				case 4:
					Matrix m4 = InputMatrixSPL(sc);
					Cramer.f(m4, sc);
					break;
				case 5:
					exit = true;
					break;
			}
		}
	}

	public static void detHome(Scanner sc){ // buat determinan gan
		int input = 0;
		boolean exit = false;

		while(exit == false){
			System.out.println("\nDETERMINAN\n1. Metode Ekspansi Kofaktor\n2. Metode Reduksi Baris\n3. Kembali");
			System.out.print("Silahkan pilih metode atau pilihan menu: "); 
			input = cinCheck(sc, 1, 3);
			System.out.println("Opsi " + input + " telah dipilih.");
			switch (input){
				case 1:
					Matrix m1 = InputMatrix(sc);
					float det1 = Determinan.detCof(m1);
					System.out.println("Hasil perhitungan menggunakan metode Ekspansi Kofaktor :\nDeterminan : " + det1);
					break;
				case 2:
					Matrix m2 = InputMatrix(sc);
					float det2 = Determinan.detOBE(m2);
					System.out.println("Hasil perhitungan menggunakan metode Reduksi Baris :\nDeterminan : " + det2);
					break;
				case 3:
					exit = true;
					break;
			}
		}
	}

	public static void inverseHome(Scanner sc){ // buat matriks balikan gan
		int input = 0;
		boolean exit = false;

		while(exit == false){
			System.out.println("\nINVERSE\n1. Metode Ekspansi Kofaktor\n2. Metode Reduksi Baris\n3. Kembali");
			System.out.print("Silahkan pilih metode atau pilihan menu: "); 
			input = cinCheck(sc, 1, 3);
			System.out.println("Opsi " + input + " telah dipilih.");
			switch(input){
				case 1:
					Matrix m1 = InputMatrix(sc);
					Inverse.inverseKof(m1, sc);
					break;
				case 2:
					Matrix m2 = InputMatrix(sc);
					Inverse.inverseObe(m2, sc);
					break;
				case 3:
					exit = true;
					break;
			}
		}
	}

	public static void interpolasiPolinomHome(Scanner sc){ // buat interpolasi polinom gan
		System.out.println("Menu Interpolasi Polinom telah dipilih");

		// di sini panggil fungsi interpolasi polinom
		PolynomialInterpolation.f(sc);
	}

    public static void interpolasiBicubicHome(Scanner sc){ // buat interpolasi bicubic gan
		System.out.println("Menu Interpolasi Bicubic Spine telah dipilih");

		// di sini panggil fungsi interpolasi bicubic
		BiSplineInterpolation.f(sc);
	}

	public static void linearRegHome(Scanner sc){ // buat regresi linear gan
		System.out.println("Menu Regresi Linear Berganda telah dipilih\n");
		System.out.print("Silahkan pilih metode input (1 dari keyboard, 2 dari file .txt): "); int input = cinCheck(sc, 1, 2);
		System.out.println("");
		
		Matrix m = new Matrix(0, 0);
		switch (input) {
			case 1:
				// input jumlah pengujian dan jumlah titik x yang akan diuji
				System.out.print("Jumlah pengujian: "); int row = sc.nextInt();
				System.out.print("Masukkan jumlah titik yang diuji: "); int col = sc.nextInt()+1;
				System.out.println("Masukkan Matriksnya di bawah ini");
				m = new Matrix(row, col); m.readMatrix(sc);				
				break;
			case 2:
				m = TXTReaderWriter.readTXT(sc); System.out.println("");
				break;
		}
		// oper matrix ke fungsi
		LinearReg.f(sc, m);
	}



	// fungsi2 buat primitif
	public static Matrix InputMatrixSPL(Scanner sc){ //ini buat input matrix gan.
		Matrix m = new Matrix(0, 0);

		System.out.println("Silahkan Input Matrix yang akan diolah");
		System.out.println("Masukkan pilihan input: (1) untuk input dari keyboard, dan (2) untuk input dari file.txt");
		int input = cinCheck(sc, 1, 2);
		switch (input){

			case 1:
				System.out.println("Masukkan pilihan input: \n(1) Format Ax = B \n(2) Format Matriks Augmented");
				int input1 = cinCheck(sc, 1, 2);
				switch (input1){
					case 1:
						System.out.print("Masukkan ukuran baris dari matriks A: "); int row = sc.nextInt();
						System.out.print("Masukkan ukuran kolom dari matriks A: "); int col = sc.nextInt();

						System.out.println("Masukkan matriks A: ");
						Matrix A = new Matrix(row, col); A.readMatrix(sc);

						Matrix B = new Matrix(row, 1);
						System.out.println("Masukkan matriks B (ukuran baris x 1) dalam bentuk baris: ");
						B.readMatrix(sc);
						
						m = new Matrix(row, col+1);
						for (int i = 0; i < row; i++){
							for (int j = 0; j< col; j++){
								m.set(i, j, A.elmt(i, j));
							}
						} for (int i = 0; i < row; i++){
							m.set(i, col, B.elmt(i, 0));
						} 

						break;
					case 2:
						System.out.print("Masukkan ukuran baris dari matriks: ");	int row2 = sc.nextInt();
						System.out.print("Masukkan ukuran kolom dari matriks: "); int col2 = sc.nextInt();
						m = new Matrix(row2, col2);

						System.out.println("Masukkan matriks: ");
						m.readMatrix(sc);
						
						break;
				} break;

			case 2:
				m = TXTReaderWriter.readTXT(sc);
				break;

		} return m;
	}

	public static Matrix InputMatrix(Scanner sc){ //ini buat input matrix gan.
		Matrix m = new Matrix(0, 0);

		System.out.println("Silahkan Input Matrix yang akan diolah");
		System.out.println("Masukkan pilihan input: (1) untuk input dari keyboard, dan (2) untuk input dari file.txt");
		int input = cinCheck(sc, 1, 2);
		switch (input){

			case 1:
				System.out.print("Masukkan ukuran baris dari Matriks: ");	int row = sc.nextInt();
				System.out.print("Masukkan ukuran kolom dari Matriks: "); int col = sc.nextInt();
				m = new Matrix(row, col);

				System.out.println("Masukkan Matriks berukuran baris x kolom sesuai input sebelumnya");
				m.readMatrix(sc);

				break;

			case 2:
				m = TXTReaderWriter.readTXT(sc);
				break;

		} return m;
	}

	public static int cinCheck(Scanner sc, int a, int b){ // ini buat input yang ada constrain nya
		int input = sc.nextInt(); 
		while((input<a)||(input>b)){
			System.out.print("Input tidak valid, silahkan input kembali: "); input = sc.nextInt();
		} return input;
	}

	public static int cinMinCheck(Scanner sc, int a){ // sama kayak cinCheck tapi cuma ada batas bawah
		int input = sc.nextInt(); 
		while((input<a)){
			System.out.print("Input tidak valid, silahkan input kembali: "); input = sc.nextInt();
		} return input;
	}
}