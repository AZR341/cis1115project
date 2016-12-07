package cardpackage;

import java.util.Scanner;
import utilities.Prompt;

/**
 *
 * @author 55greenaja09
 */
public class CardShopMenu {
    
    Scanner sc = new Scanner(System.in);
    CardList data = new CardList();
    
    public CardShopMenu() {
        menuLoop();
    }
    
    private void menuLoop() {
        int choice = 1;
        int id;
        String name;
        double price;
        String set;
        int quantity;
        
        while (choice != 0) {
            System.out.println("\nShop Menu");
            System.out.println("0 = Quit");
            System.out.println("1 = Create New Record");
            System.out.println("2 = Retrieve All Records");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Ordered By Name");
            System.out.println("7 = Retrieve All: Ordered By Set");
            System.out.println("8 = Retrieve All: Ordered By Price");
            choice = Prompt.getInt("Number of choice: ", 0, 8);
            
            if(choice == 0) {
                ;
            } else if(choice == 1) {
                id = Prompt.getInt("Enter card id: ");
                name = Prompt.getLine("Enter card name: ");
                price = Prompt.getDouble("Enter card price: ");
                set = Prompt.getLine("Enter card set: ");
                quantity = Prompt.getInt("Enter card quantity: ");
                Card card = new Card(id, name, price, set, quantity);
                data.create(card);
            } else if(choice == 2) {
                System.out.println(data.toString());
            } else if(choice == 3) {
                id = Prompt.getInt("Enter card id: ");
                System.out.println(data.retrieve(id));      
            } else if(choice == 4) {
                ;
            } else if(choice == 5) {
                id = Prompt.getInt("Enter card id: ");
                data.delete(id);
            } else if(choice == 6) {
                System.out.println(data.orderByName());
            } else if(choice == 7) {
                System.out.println(data.orderBySet());
            } else if(choice == 8) {
                System.out.println(data.orderByPrice());
            }
        }
    }
    
    public static void main(String[] args) {
        new CardShopMenu();
    }
}
