/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * Here UnoCard extends the Card
 * using the Enum for color and values of card
 * @author Komalpreet Kaur
 **/
public class UnoCard extends Card{

    public enum Color { RED, YELLOW, GREEN, BLUE, WILD }
    public enum Value { ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, REVERSE, DRAW_2, WILD, WILD_4 }

    private final Color color;
    private final Value value;
    
    /**
     * parameter constructor
     * all getters and setters
     **/

    public UnoCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }
  
    public Color getColor() {
        return color;
    }
    
    public void setColor( Color unoColor){
        unoColor = color;
    }

    public Value getValue() {
        return value;
    }
    public void setValue( Value unoValue){
        unoValue = value;
    }

    /**
     * implementing the toString() method which is representation of card 
     **/
    @Override
    public String toString() {
        return color + " " + value;
    }
    
}
