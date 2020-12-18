package UserCode.Pets;

import UserCode.Exceptions.*;
/**
 * Urchin contains all the behaviour and state to represent an Urchin, utilizing its parents attributes.
 * 
 * Based on JavaFish from Session 2 on blackboard by Marc Price, edited by Kristopher Randle
 * 
 * @author Marc Price & Kristopher Randle
 * @version 18-12-2020
 */
public class Urchin extends Pet
{ 
    //Instance Variables:
    // DECLARE the minimum speed a fish can move as specified by the client brief:
    private static final double MIN_SPEED = 0.005;
    // DECLARE the maximum speed a fish can move as specified by the client brief:
    private static final double MAX_SPEED = 0.05;
    /**
     * Constructor for objects of class Urchin, scale is passed to the Parent class, Pet. An Urchin's position, orientation and speed is set by calling methods in the super class (Pet).
     * 
     * @param scale     The scale (size) of the Urchin. Must be 0.225 <= scale <= 0.45. Passed up to Pet.
     */
    public Urchin(double scale)
    {
        // PASS the model, texture and scale to the superclass Pet constructor:
        super("models/billboard/billboard.obj", "textures/javaFish/Urchin.png", scale);

        // INITIALISE position, orientation and speed of the Urchin by calling methods in the superclass:
        super.setPosition(); //SET the x, y of the Urchin to a random location in the aquarium.
        super.setOrientation(0,-90,0); //SET the orientation so that it is the right way up and facing the right direction
        super.setSpeed(MAX_SPEED, MIN_SPEED); //provides the RNG with a minimum and maximum speed for the Urchin.
    }
    
    /**
     * Constructor for objects of class Urchin. This constructor is called if the user does not provide a scale for the Urchin, allowing it to be randomly assigned in a range.
     * An Urchin's position, orientation, and speed is set by calling methods in the super class (Pet).
     *
     */
    public Urchin()
    {
        // PASS the model, texture and a RANDOM scale to the superclass Pet constructor:
        super("models/billboard/billboard.obj", "textures/javaFish/Urchin.png", Math.random() * (0.45 - 0.225) + 0.225); //model, texture and random scale passed to super constructor.

        // INITIALISE position, orientation and speed of the Urchin by calling methods in the superclass:
        this.setPosition(); //SET the x, y of the Urchin to a random location in the aquarium.
        super.setOrientation(0,-90,0); //SET the orientation so that it is the right way up and facing the right direction.
        super.setSpeed(MAX_SPEED, MIN_SPEED); //provides the RNG with a minimum and maximum speed for the Urchin.
    }
    
    /**
     * METHOD: Method overriding the "Pet" classes default setPosition() method.
     * This is because Urchin must sit at the bottom of the aquarium and not have a randomly assigned position.
     * 
     * It still calls the other version of "Pet" classes setPosition(), which takes parameters to set a specified location.
     * 
     * @return      void
     */    
    protected void setPosition()
    {
        super.setPosition(1.0,1.0,1.0); //SET the Urchin to sit at the bottom of the aquarium.
    }
}
