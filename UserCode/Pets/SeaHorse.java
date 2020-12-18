package UserCode.Pets;

/**
 * SeaHorse contains all the behaviour and state to represent a SeaHorse, utilizing it's parents attributes with some method overriding.
 * 
 * Based on JavaFish from Session 2 on blackboard by Marc Price, edited by Kristopher Randle
 * 
 * @author Marc Price & Kristopher Randle
 * @version 18-12-2020
 */
public class SeaHorse extends Pet
{    
    // DECLARE the minimum speed a SeaHorse can move as specified by the client brief:
    private static final double MIN_SPEED = 0.005;
    // DECLARE the maximum speed a SeaHorse can move as specified by the client brief:
    private static final double MAX_SPEED = 0.05;

    /**
     * Constructor for objects of class SeaHorse, scale is passed to the Parent class, Pet. A SeaHorses's position, orientation and speed is set by calling methods in the super class (Pet).
     * 
     * @param scale     The scale (size) of the SeaHorse. Must be 0.225 <= scale <= 0.45. Passed up to Pet.
     */
    public SeaHorse(double scale)
    {
        // PASS the model, texture and scale to the superclass Pet constructor:
        super("models/billboard/billboard.obj", "textures/javaFish/Seahorse.png", scale);
        
        // INITIALISE position, orientation and speed of the SeaHorse by calling methods in the superclass:
        super.setPosition(); //SET the x, y of the SeaHorse to a random location in the aquarium.
        super.setOrientation(0,90,0); //SET the orientation so that it is the right way up and facing the right direction.
        super.setSpeed(MAX_SPEED, MIN_SPEED); //provides the RNG with a minimum and maximum speed for the SeaHorse.
    }
    
    /**
     * Constructor for objects of class SeaHorse. This constructor is called if the user does not provide a scale for the SeaHorse, allowing it to be randomly assigned in a range.
     * A SeaHorse's position, orientation, and speed is set by calling methods in the super class (Pet).
     * 
     */
    public SeaHorse()
    {
        // PASS the model, texture and scale to the superclass Pet constructor:
        super("models/billboard/billboard.obj", "textures/javaFish/Seahorse.png", Math.random() * (0.45 - 0.225) + 0.225); //model, texture and random scale passed to super constructor.
        
        // INITIALISE position, orientation and speed of the SeaHorse by calling methods in the superclass:
        super.setPosition(); //SET the x, y of the SeaHorse to a random location in the aquarium.
        super.setOrientation(0,-90,0); //SET the orientation so that it is the right way up and facing the right direction.
        super.setSpeed(MAX_SPEED, MIN_SPEED); //provides the RNG with a minimum and maximum speed for the SeaHorse.
    }

    /**
     * METHOD: Method overriding the "Pet" classes default update method. 
     * This is because SeaHorses must move differently to the other instances of the "Pet" class. (Along the Y Axis as well as the X Axis.)
     * 
     * @return      void
     */
    public void update()
    {
        x += xSpeed; //modulate the x position of the SeaHorse by its speed value.
        y += ySpeed; //modulate the y position of the SeaHorse by its speed value.
        this.inBounds(); //check if the SeaHorse has moved out of scope of the aquarium before making another move.
    }
}