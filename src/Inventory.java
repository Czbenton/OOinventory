import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zach on 9/6/16.
 */
public class Inventory {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<InventoryItem> items = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            int i = 1;
            for (InventoryItem listItems : items) {
                System.out.printf("%s. [%s] %s %s\n",i,listItems.quantity,listItems.name,listItems.category);
                i++;
            }
            System.out.println("1. Add new item to your inventory.");
            System.out.println("2. Remove item from your inventory.");
            System.out.println("3. Change quantity of an item.");

            String option = scanner.nextLine();

            if (option.equals("1")) {
                boolean createSuccess = false;
                while (!createSuccess) {
                    try {
                        Inventory.items.add(createItem());
                        createSuccess = true;
                                System.out.println("sucess on create");
                    } catch (Exception e) {
                        System.out.println("Please enter a valid category\n");
                    }
                }
            } else if (option.equals("2")) {
                InventoryItem.removeItem();
            } else if (option.equals("3")) {
                InventoryItem.changeQuantity();
            } else {
                System.out.println("Please enter a valid option.\n");
            }
        }
    }

    public static InventoryItem createItem() throws Exception {
        System.out.println("What would you like to add to your inventory?");
        String userInputItem = Inventory.scanner.nextLine();

        System.out.println("Please enter quantity");
        int userInputQuantity = Integer.parseInt(Inventory.scanner.nextLine());

        System.out.printf("Please enter the appropriate category for %s. " +
                "\n[electronics] [tools] [home appliances] [gardening] or [building supplies] ", userInputItem);
        String userInputCategory = Inventory.scanner.nextLine();

        InventoryItem newItem;

        switch (userInputCategory) {
            case "electronics":
                newItem = new Electronics(userInputItem, userInputQuantity);
                return newItem;
            case "tools":
                newItem = new Tools(userInputItem, userInputQuantity);
                return newItem;
            case "home appliances":
                newItem = new HomeAppliances(userInputItem, userInputQuantity);
                return newItem;
            case "gardening":
                newItem = new Gardening(userInputItem, userInputQuantity);
                return newItem;
            case "building supplies":
                newItem = new BuildingSupplies(userInputItem, userInputQuantity);
                return newItem;
            default:
                throw new Exception("bad cat name");
        }
    }
}