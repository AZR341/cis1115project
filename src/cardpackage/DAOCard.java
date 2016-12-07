package cardpackage;

import java.util.ArrayList;
import java.util.List;


/**
 * The Data Access Object to a card shop inventory.
 *
 * @author Jacob Greenawalt
 */
public class DAOCard {
    List<Card> myList;

    public DAOCard() {
        myList = new ArrayList();
    }

    public void create(Card card) {
        // code to add a card to the list
        myList.add(card);
    }

    public Card retrieve(int id) {
        // retrieve a single card id from the list or null if it does not exist.
        for (Card card : myList) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null;
    }

    public Card retrieve(String name) {
        for (Card card : myList) {
            if (card.getName().equals(name)) {
                return card;
            }
        }
        return null;
    }

    public void update(Card card) {
        for (Card c : myList) {
            if (c.getId() == card.getId()) {
                c.setName(card.getName());
                break;
            }
        }
    }

    public void delete(int id) {
        for (Card c : myList) {
            if (c.getId() == id) {
                myList.remove(c);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Card card : myList) {
            sb.append(card).append("\n");
        }
        return sb.toString();
    }

}
