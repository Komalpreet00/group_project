/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author komalpreet, 28-07-2024
 * 
 *  private fields from different classes
 */
public class UnoGame extends Game implements DealGame{
    private GroupOfCards deck;
    private GroupOfCards discardPile;
    private UnoCard.Color color;
    private UnoCard.Value value;
    private int rank;
 

    public UnoGame(String name) {
        super(name);
        deck = new GroupOfCards(108);
        discardPile = new GroupOfCards(0);
       
    }
    
    @Override
    public void dealCards() {
    // Iterate through each player
    for (Player player : getPlayers()) {
        UnoPlayer unoPlayer = (UnoPlayer) player;

        // Deal 7 cards to each player
        for (int i = 0; i < 7; i++) {
            // Check if the deck is not empty
            if (!deck.showCards().isEmpty()) {
                // Draw the top card from the deck and add it to the player's hand
                UnoCard card = (UnoCard) deck.showCards().remove(0);
                unoPlayer.addCard(card);
            } else {
                // If the deck is empty, handle the situation accordingly
                System.out.println("The deck is empty, cannot deal more cards.");
                break;
            }
        }
    }
}

    /**
     * Implementing game logic for playing UNO
     **/
    @Override
    public void play() {
        
         // Initial setup: Deal 7 cards to each player
        dealCards();
        // Start the game by drawing the top card from the deck to the discard pile
        UnoCard firstCard = (UnoCard) deck.showCards().remove(0);
        discardPile.showCards().add(firstCard);
        color = firstCard.getColor();
        value = firstCard.getValue();

        // Game loop
        while (true) {
            UnoPlayer currentPlayer = (UnoPlayer) getPlayers().get(rank);
            System.out.println("Current player: " + currentPlayer.getPlayerID());
            System.out.println("Current discard pile top card: " + discardPile.showCards().get(discardPile.showCards().size() - 1));

            // Player's turn to play a card or draw
            boolean hasPlayed = false;
            for (UnoCard card : currentPlayer.getCard()) {
                if (card.getColor() == color || card.getValue() == value || card.getColor() == UnoCard.Color.WILD) {
                    currentPlayer.removeCard(card);
                    discardPile.showCards().add(card);
                    color = card.getColor();
                    value = card.getValue();
                    hasPlayed = true;
                    break;
                }
            }

            if (!hasPlayed) {
                System.out.println("No playable card, drawing a card...");
                UnoCard drawnCard = (UnoCard) deck.showCards().remove(0);
                currentPlayer.addCard(drawnCard);
                System.out.println("Drew card: " + drawnCard);
            }

            // Check if the current player has won
            if (currentPlayer.getCard().isEmpty()) {
                declareWinner();
                break;
            }

    
        }
    }

    /**
     * When the game is over, method to declare and display a winning
     **/
    @Override
    public void declareWinner() {
        for (Player player : getPlayers()) {
        UnoPlayer unoPlayer = (UnoPlayer) player;

        if (unoPlayer.getCard().size() == 1) {// condition for winning the game
            if (!unoPlayer.saidUno()) { 
                System.out.println(unoPlayer.getPlayerID() + " didn't say UNO and loses!");
                continue; // Continue to the next player
            } else {
                System.out.println(unoPlayer.getPlayerID() + " has one card left and said UNO!");
            }
        }

        if (unoPlayer.getCard().isEmpty()) {// if player does not have any cards , wins the game
            System.out.println("Winner is: " + unoPlayer.getPlayerID());
            break;
        }
        }
    }
}

