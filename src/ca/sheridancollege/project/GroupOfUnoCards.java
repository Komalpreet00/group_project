/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Komalpreet Kaur
 * 
 * GroupOfUnoCards extends GrouoOfCards and calling givenSize
 */
public class GroupOfUnoCards extends GroupOfCards {
     public GroupOfUnoCards(int givenSize) {
        super(givenSize);
      Deck();
    }
    
    /**
     * implementing the Deck() method
     * 
     **/
    private void Deck() {
        cards = new ArrayList<>(getSize());// cards is arraylist of size
        for (UnoCard.Color color : UnoCard.Color.values()) {// possible values of color of card and values of card in enum
            if (color != UnoCard.Color.WILD) {// put the condition to exclude the WILD color
                for (UnoCard.Value value : UnoCard.Value.values()) {
                    if (value != UnoCard.Value.WILD && value != UnoCard.Value.WILD_4) { // possible values of enum value
                                                                                       // excluding wild and wild_4
                        cards.add(new UnoCard(color, value));// adding cards to the deck without these cards
                        if (value != UnoCard.Value.ZERO) {
                            cards.add(new UnoCard(color, value));
                        }
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {// if color is wild, then add four cards
                    cards.add(new UnoCard(UnoCard.Color.WILD, UnoCard.Value.WILD));
                    cards.add(new UnoCard(UnoCard.Color.WILD, UnoCard.Value.WILD_4));
                }
            }
        }
        shuffle();// calling the shuffle to randomixe the orders
    }
    
}
