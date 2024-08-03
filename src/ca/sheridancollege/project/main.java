/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Komalpreet Kaur
 */
public class main {
    public static void main(String[] args) {
        UnoGame game = new UnoGame("UnoGame");
        ArrayList<Player> players = new ArrayList<>();
        
        UnoPlayer player1 = new UnoPlayer("Player1");
        UnoPlayer player2 = new UnoPlayer("Player2");

        players.add(player1);
        players.add(player2);

        game.setPlayers(players);


        // Start the game
        game.play();

        // Declare winner
        game.declareWinner();
    }
}
    

