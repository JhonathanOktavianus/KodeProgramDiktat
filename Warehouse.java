import java.util.ArrayList;

/**
 * @author 1972046 JHONATHAN OKTAVIANUS
 */
public class Warehouse {
    public ArrayList<Item> items;

    public Warehouse() {
        items = new ArrayList<>();
    }

    public void additemToList(Item item){
        items.add(item);
    }

    public void showAllItemData(){
        items.forEach(item -> {
            if(item instanceof Shirt){
                System.out.println(((Shirt)item).toString());
            }
        });
        items.forEach(item -> {
            if (item instanceof Shoe) {
                System.out.println(((Shoe) item).toString());
            }
        });
    }
}
