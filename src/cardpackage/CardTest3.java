package cardpackage;

import java.util.Scanner;

/**
 *
 * @author Jacob Greenawalt
 */
public class CardTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CardList data = new CardList();
        System.out.println(data);
        
       data.create(new Card(3, "Chandra Nalaar", 8, "M10", 3));
       System.out.println(data);
       data.delete(2);
       data.delete(3);
        System.out.println(data);
    }
    
}
