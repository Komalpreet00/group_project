/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

// importing the package 
import java.util.ArrayList;

/**
 * UnoPlayer class extends the Player class 
 * @author komalpreet, 28-07-2024
 */
public class UnoPlayer extends Player {
    
    
    private ArrayList<UnoCard> card;
    private boolean saidUno;
    
    /**
     * parameter constructor which have one parameter name which is field of superclass Player 
     * calling the field by using super
     * card which hold new list of players
     **/
    
    public UnoPlayer(String name) {
        super(name);
        
        card = new ArrayList<>();
    }
    /**
     * getter for getting card from ArrayList of UnoCard
     * @return 
     **/
    
    public ArrayList<UnoCard> getCard() {
        return card;
    }

    /**
     * method to add the card  
     * @param cards
     **/
    
    public void addCard(UnoCard cards) {
        card.add(cards);
    }
    /**
     * method to remove the card  
     * @param cards
     **/
    public void removeCard(UnoCard cards) {
        card.remove(cards);
    }

    
    /**
     * The method to be instantiated with specific type of Player and filled in with logic to play Uno game.
     **/
    @Override
    public void play() {
        // Implement game logic for playing a card
        ArrayList<UnoCard> discardPile = new ArrayList<>(); 
        ArrayList<UnoCard> drawPile = new ArrayList<>(); 

        if (card.isEmpty()) {
            System.out.println(super.getPlayerID() + " has no cards to play.");
            return;
        }
        
        UnoCard topCard = discardPile.get(discardPile.size() - 1);
        UnoCard cardToPlay = null;
        
        // Find a playable card
        for (UnoCard c : card) {
            if (c.getColor() == topCard.getColor() || c.getValue() == topCard.getValue() || c.getColor() == UnoCard.Color.WILD) {
                cardToPlay = c;
                break;
            }
        }
        
        if (cardToPlay != null) {
            // Play the card
            card.remove(cardToPlay);
            discardPile.add(cardToPlay);
            System.out.println(super.getPlayerID() + " played " + cardToPlay);
        } else {
            // If no card can be played, draw a card from the draw pile
            if (!drawPile.isEmpty()) {
                UnoCard drawnCard = drawPile.remove(drawPile.size() - 1);
                card.add(drawnCard);
                System.out.println(super.getPlayerID() + " drew a card: " + drawnCard);
            } else {
                System.out.println("Draw pile is empty. " + super.getPlayerID() + " cannot draw a card.");
            }
        }
    }
    
    
    public void sayUno() {
        this.saidUno = true;
        System.out.println(getPlayerID() + "UNO!");
    }
    
     public boolean saidUno() {
        return saidUno;
    }  
    
    
}
