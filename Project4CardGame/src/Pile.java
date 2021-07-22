import java.util.ArrayList;

abstract public class Pile {
protected ArrayList<Card> cards;


public Pile(int num) {
cards = new ArrayList<>(num);
}

public void addCard(Card c) {
cards.add(c);
}

public void removeCard(Card c) {
cards.remove(c);
}

}
