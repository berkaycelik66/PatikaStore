import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Notebook extends Product {


    public Notebook(int id, double price, double discountRate, int amount, String name, String brand, int memory, double screenSize, int RAM) {
        super(id, price, discountRate, amount, name, brand, memory, screenSize, RAM);
    }

    public Notebook() {
        notebookList.add(new Notebook(1, 7000, 10, 5, "Huawei Matebook 14", "Huawei", 512, 14, 16));
        notebookList.add(new Notebook(2, 3699, 10, 5, "Lenovo V14 IGL", "Lenovo", 1024, 14, 8));
        notebookList.add(new Notebook(3, 8199, 10, 5, "Asus Tuf Gaming", "Asus", 2048, 15.6, 32));
    }

    public static void menu() {
        System.out.println("\n===== Notebook Management Panel =====\n" +
                "1- Add A New Notebook\n" +
                "2- Print Notebook List\n" +
                "3- Delete Notebook\n" +
                "4- Sort Notebooks By ID Number\n" +
                "5- Filter Notebooks By Brands");
        System.out.print("Select Your Choice: ");
        int sel = scan.nextInt();

        while (sel < 0 || sel > 5) {
            System.out.print("Invalid selection, Try Again: ");
            sel = scan.nextInt();
        }

        switchCaseNotebook(sel);
    }

    public static void switchCaseNotebook(int sel) {
        switch (sel) {
            case 1:
                add("Notebook");
                break;
            case 2:
                print(notebookList);
                break;
            case 3:
                remove();
                break;
            case 4:
                sort();
                break;
            case 5:
                filterByBrand();
                break;
            default:
                System.out.println();
                System.out.println("There is no such an option. Please enter your choice again.");
                System.out.println();
        }
    }

    public static void print(List<Notebook> notebooks) {
        System.out.println("| ID | Name of Product               | Price     | Brand     | Memory  | Screen Size | RAM      |");
        System.out.println("-------------------------------------------------------------------------------------------------");

        for (Notebook notebook : notebooks) {
            System.out.printf("| %-2d | %-29s | %-9.1f | %-9s | %-7d | %-11.1f | %-8d |",
                    notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand(), notebook.getMemory(),
                    notebook.getScreenSize(), notebook.getRAM());
            System.out.println();
        }
    }

    public static void sort() {
        List<Notebook> sortByID = notebookList;

        sortByID.sort(new Comparator<Notebook>() {
            @Override
            public int compare(Notebook o1, Notebook o2) {
                return o1.getId() - o2.getId();
            }
        });
        print(sortByID);
    }

    public static void filterByBrand() {
        String[] brandArray = Brands.getBrandArray();
        Brands.printWithId();

        System.out.print("Enter the id number of the brand you want to filter: ");
        int sel = scan.nextInt();

        if(sel > 0){
            String selBrand = brandArray[sel - 1];

            List<Notebook> notebooksByBrand = new ArrayList<>();

            for (Notebook notebook : notebookList) {
                if (notebook.getBrand().equals(selBrand)) {
                    notebooksByBrand.add(notebook);
                }
            }

            if (notebooksByBrand.size() != 0) {
                print(notebooksByBrand);
            } else {
                System.out.println("There are no products from this brand !!");
            }
        } else {
            System.out.println("\nDo not enter a negative number !!!");
        }

    }

    public static void remove() {
        print(notebookList);
        System.out.print("Enter the id of the phone you want to delete: ");
        int sel = scan.nextInt();
        int removeId = -1;      // It keeps the removed phone index;
        for (Notebook notebook : notebookList) {
            if (notebook.getId() == sel) {
                removeId = notebookList.indexOf(notebook);
            }
        }

        if (removeId != -1) {
            notebookList.remove(removeId);
            System.out.println("Notebook is deleted");
        }

    }

}
