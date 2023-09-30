import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        boolean exit = false;
		int input;

        while(!exit){
            input = home();
			switch(input){
				case 1:

				case 2:

			}
        }
    }

	public static int home(){
		System.out.println("MENU : \n1. Sistem Persamaan Linier\n2. Determinan\n3. Matriks Balikan\n4. Interpolasi Polinom\n5. Interpolasi Bicubic Spine\n6. Regresi Linier Berganda\n7.Keluar\nMasukkan pilihan(1-7):");

		int input;
		input = cin();
		
		while(input < 1 || 7 < input){
			System.out.println("Input tidak valid.\nMasukkan pilihan(1-7):");
			input = cin();
		}

		return input;
	}

	public static int cin(){
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		s.close();
		return input;
	}

}
