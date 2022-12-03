import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Phone extends Product {
    private int battery;
    private String color;
    private int camera;

    public Phone(int id, double price, double discountRate, int amount, String name, String brand, int memory, double screenSize, int RAM, int battery, String color, int camera) {
        super(id, price, discountRate, amount, name, brand, memory, screenSize, RAM);
        this.battery = battery;
        this.color = color;
        this.camera = camera;
    }

    public Phone() {
        phoneList.add(new Phone(1, 3199, 10, 5, "Samsung Galaxy A51", "Samsung", 128, 6.5, 6, 4000, "Siyah", 32));
        phoneList.add(new Phone(2, 7379, 10, 5, "Iphone 11 64 GB", "Apple", 64, 6.1, 6, 3046, "Mavi", 5));
        phoneList.add(new Phone(3, 4012, 10, 5, "Redmi Note 10 Pro 8 GB", "Xiaomi", 128, 6.5, 12, 4000, "Beyaz", 35));
    }

    public static void menu() {
        System.out.println("\n===== Phone Management Panel =====\n" +
                "1- Add A New Phone\n" +
                "2- Print Phone List\n" +
                "3- Delete Phone\n" +
                "4- Sort Phones By ID Number\n" +
                "5- Filter Phones By Brands");
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
                add("CellPhone");
                break;
            case 2:
                print(phoneList);
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

    public static void print(List<Phone> phones) {
        System.out.println("| ID | Name of Product               | Price     | Brand     | Memory    | Screen Size | Camera    | Battery   | RAM       | Color      | ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

        for (Phone phone : phones) {
            System.out.printf("| %-2d | %-29s | %-9.1f | %-9s | %-9d | %-11.1f | %-9d | %-9d | %-9d | %-10s |",
                    phone.getId(), phone.getName(), phone.getPrice(), phone.getBrand(), phone.getMemory(),
                    phone.getScreenSize(), phone.getCamera(), phone.getBattery(), phone.getRAM(), phone.getColor());
            System.out.println();
        }
    }

    public static void sort() {
        List<Phone> sortByID = phoneList;

        sortByID.sort(new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
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

            List<Phone> phonesByBrand = new ArrayList<>();

            for (Phone phone : phoneList) {
                if (phone.getBrand().equals(selBrand)) {
                    phonesByBrand.add(phone);
                }
            }

            if (phonesByBrand.size() != 0) {
                print(phonesByBrand);
            } else {
                System.out.println("There are no products from this brand !!");
            }
        } else{
            System.out.println("\nDo not enter a negative number !!!");
        }


    }

    public static void remove() {
        print(phoneList);
        System.out.print("Enter the id of the phone you want to delete: ");
        int sel = scan.nextInt();

        int removeId = -1;  //It keeps the removed phone index;
        for (Phone phone : phoneList) {
            if (phone.getId() == sel) {
                removeId = phoneList.indexOf(phone);
            }
        }

        if (removeId != -1) {
            phoneList.remove(removeId);
            System.out.println("Phone is deleted");
        }
    }


    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }
}
