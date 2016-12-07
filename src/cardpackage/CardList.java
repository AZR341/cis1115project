package cardpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Data Access Object to a card shop inventory.
 * @author Jacob Greenawalt
 */
public class CardList {
    
    private final String fileName = "carddata.txt";
    List<Card> myList;
    
    public CardList() {
        myList = new ArrayList();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(CardList.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();
    }
    
    public void create(Card card) {
        // code to add a card to the list
        myList.add(card);
        writeList();
    }
    
    public Card retrieve(int id) {
        // retrieve a single card id from the list or null if it does not exist.
        for(Card card : myList) {
            if(card.getId() == id) {
                return card;
            }
        }
        return null;
    }
    
    public Card retrieve(String name) {
        for(Card card : myList) {
            if(card.getName() == null ? name == null : card.getName().equals(name)) {
                return card;
            }
        }
        return null;
    }
    
    public void update(Card card) {
        for(Card c : myList) {
            if(c.getId() == card.getId()) {
                c.setName(card.getName());
                break;
            }
        }
    }
    
    public void delete(int id) {
        myList.stream().filter((c) -> (c.getId() == id)).forEach((c) -> {
            myList.remove(c);
        });
        writeList();
    }
    
    public String orderByName() {
        myList.sort(Comparator.comparing(Card::getName));
        return this.toString();
    }
    
    public String orderBySet() {
       myList.sort(Comparator.comparing(Card::getSet));
        return this.toString();
    }
    
    public String orderByPrice() {
        myList.sort(Comparator.comparing(Card::getPrice));
        return this.toString();
    }
    
    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                String set = data[3];
                int quantity = Integer.parseInt(data[4]);
                Card mycard = new Card(id, name, price, set, quantity);
                myList.add(mycard);
            }
        }catch (IOException ex) {
            Logger.getLogger(CardList.class.getName()).log(Level.SEVERE, null, ex);
    }
    }    
        
    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for(Card card : myList) {
                writer.write(String.format("%d,%s,%.2f,%s,%d\n",
                        card.getId(),
                        card.getName(),
                        card.getPrice(),
                        card.getSet(),
                        card.getQuantity()));
            }
        } catch (IOException ex) {
            Logger.getLogger(CardList.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for(Card card : myList) {
            sb.append(card).append("\n");
        }
        return sb.toString();
    }
    
}
