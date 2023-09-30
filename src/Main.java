import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		int input;
        boolean exit = false;

        while(!exit){
            input = home();
        }
    }

	public static int home(){
		System.out.println("MENU : \n1. Sistem Persamaan Linier\n2. Determinan\n3. Matriks Balikan\n4. Interpolasi Polinom\n5. Interpolasi Bicubic Spine\n6. Regresi Linier Berganda\n7.Keluar\nMasukkan pilihan :");

		
		int input;
		
		while(in)

	}

	public static int cin(){
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		s.close();
		return input;
	}

}
