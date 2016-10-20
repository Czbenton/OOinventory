import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zach on 9/6/16.
 */
public class Inventory {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<InventoryItem> currentItems = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            int i = 1;
            for (InventoryItem listItem : currentItems) {
                System.out.printf("\n%s. [%s] %s %s\n", i, listItem.quantity, listItem.name, listItem.category);
                i++;
            }
            System.out.println("\n1. Add new item to your inventory.");
            System.out.println("2. Remove item from your inventory.");
            System.out.println("3. Change quantity of an item.");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    boolean createItemSuccess = false;
                    while (!createItemSuccess) {
                        try {
                            Inventory.currentItems.add(createItem());
                            createItemSuccess = true;
                        } catch (Exception e) {
                            System.out.println("Please enter a valid category\n");
                        }
                    }
                    break;
                case "2":
                    InventoryItem.removeItem();
                    break;
                case "3":
                    InventoryItem.changeQuantity();
                    break;
                default:
                    System.out.println("Please enter a valid option.\n");
                    break;
            }
        }
    }

    public static InventoryItem createItem() throws Exception {
        System.out.println("What would you like to add to your inventory?");
        String userInputItemName = Inventory.scanner.nextLine();

        System.out.println("Please enter quantity");
        int userInputItemQuantity = Integer.parseInt(Inventory.scanner.nextLine());

        System.out.printf("Please enter the appropriate category for %s. " +
                "\n[electronics] [tools] [home appliances] [gardening] or [building supplies] ", userInputItemName);
        String userInputItemCategory = Inventory.scanner.nextLine();

        InventoryItem newItem;

        switch (userInputItemCategory) {
            case "electronics":
                newItem = new Electronics(userInputItemName, userInputItemQuantity);
                return newItem;
            case "tools":
                newItem = new Tools(userInputItemName, userInputItemQuantity);
                return newItem;
            case "home appliances":
                newItem = new HomeAppliances(userInputItemName, userInputItemQuantity);
                return newItem;
            case "gardening":
                newItem = new Gardening(userInputItemName, userInputItemQuantity);
                return newItem;
            case "building supplies":
                newItem = new BuildingSupplies(userInputItemName, userInputItemQuantity);
                return newItem;
            default:
                throw new Exception("bad cat name");
        }
    }
}