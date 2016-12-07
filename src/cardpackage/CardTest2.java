package cardpackage;

/**
 *
 * @author Jacob Greenawalt
 */
public class CardTest2 {
    public static void main(String[] args) {
        DAOCard data = new DAOCard();
        data.create(new Card(1, "Jace Beleren", 8, "Zendikar", 1));
        data.create(new Card(2, "Chandra Nalaar", 10, "M10", 2));
        data.create(new Card(3, "Oblivion Ring", 1, "M10", 5));
        System.out.println(data);
        data.update(new Card(2,"Chandra Nalaar", 10, "M10", 1));
        System.out.println(data);
        data.delete(2);
        System.out.println(data);
    }
    
}
