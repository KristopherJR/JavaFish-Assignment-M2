package UserCode.Pets;

/**
 * JavaFish contains all the behaviour and state to represent a JavaFish, utilizing its parents attributes.
 * 
 * Based on JavaFish from Session 2 on blackboard by Marc Price, edited by Kristopher Randle
 * 
 * @author Marc Price & Kristopher Randle
 * @version 0.4
 */
public class JavaFish extends Pet
{    
    // DECLARE the minimum speed a fish can move as specified by the client brief:
    private static final double MIN_SPEED = 0.005;
    // DECLARE the maximum speed a fish can move as specified by the client brief:
    private static final double MAX_SPEED = 0.05;

    /**
     * Constructor for objects of class JavaFish, initialised to the position at xpos,ypos,zpos
     * 
     * @param xpos      The starting x position of the fish in the aquarium.
     * @param ypos      The starting y position of the fish in the aquarium.
     * @param scale     The scale (size) of the fish. Must be 0.4 <= scale <= 0.8.
     */
    public JavaFish(double scale)
    {
        // PASS the model, texture and scale to the superclass Pet constructor:
        super("models/billboard/billboard.obj", "textures/javaFish/JavaFish.png", scale);
        // INITIALISE position and speed of fish
        super.setPosition(); //set the x, y of the fish to a random location in the aquarium.
        super.setOrientation(0,-90,0);
        super.setSpeed(MAX_SPEED, MIN_SPEED); //provides the RNG with a minimum and maximum speed for the JavaFish.
    }
}
