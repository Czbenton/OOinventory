/**
 * Created by Zach on 9/6/16.
 */
public abstract class InventoryItem {
    String name;
    int quantity;
    String category;

    public InventoryItem(String newName, int defaultQuantity, String category) {
        this.name = newName;
        this.quantity = defaultQuantity;
        this.category = category;
    }

    public static void changeQuantity() {
        System.out.println("Please enter the item number you want to change the quantity of.");
        int itemNum = Integer.valueOf(Inventory.scanner.nextLine());

        InventoryItem item = Inventory.currentItems.get(itemNum - 1);

        System.out.println("Please enter the new quantity.");
        int newQuantity = Integer.valueOf(Inventory.scanner.nextLine());

        item.quantity = newQuantity;
    }

    public static void removeItem() {
        System.out.println("Please enter the item number you wish to remove");
        int itemNum = Integer.valueOf(Inventory.scanner.nextLine());

        Inventory.currentItems.remove(itemNum -1);
    }
}