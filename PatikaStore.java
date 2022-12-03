import java.util.Scanner;

public class PatikaStore {
    Scanner scan = new Scanner(System.in);

    public void run() {
        //To start the program we need to run the default constructors
        new Notebook();
        new Phone();
        new Brands();

        boolean isExit = false;

        while (true) {
            System.out.println("\n===== PatikaStore Product Management Panel =====");
            System.out.println("1- Notebook Operations");
            System.out.println("2- Phone Operations");
            System.out.println("3- List of Brands");
            System.out.println("0- Exit");
            System.out.print("Select Your Choice: ");

            int sel = scan.nextInt();
            while (sel < 0 || sel > 3) {
                System.out.print("Invalid selection, Try Again: ");
                sel = scan.nextInt();
            }

            switch (sel) {
                case 1:
                    Notebook.menu();
                    break;
                case 2:
                    Phone.menu();
                    break;
                case 3:
                    Brands.printBrands();
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    System.out.println();
                    System.out.println("There is no such an option. Please enter your choice again.");
                    System.out.println();
            }

            if (isExit) {
                System.out.println("\nProgram Termination...");
                break;
            }
        }
    }
}
