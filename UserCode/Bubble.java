package UserCode;

import java.util.*;
import UserCode.Pets.*;
import UserCode.Exceptions.*;
import Framework.*;
/**
 * Bubbles contains all of the code needed to represent a Bubble to be placed in the Aquarium. Bubble is a subclass of DisplayObject, inheriting it's fields and methods.
 * 
 * @author Kristopher Randle 
 * @version 18-12-2020
 */
public class Bubble extends DisplayObject
{
    //Instance Variables:
    // DECLARE a public static final double, call it SCREEN_HEIGHT and set it to 7.0:
    public static final double SCREEN_HEIGHT = 7.0;
    // DECLARE a private double, call it floatSpeed:
    private double floatSpeed;
    /**
     * Constructor for objects of class Bubble, initialised to the position at xpos,ypos,zpos
     * 
     * @param xpos      The starting x position of the Bubble in the aquarium.
     * @param ypos      The starting y position of the Bubble in the aquarium.
     * @param scale     The scale (size) of the Bubble.
     */
    public Bubble(double x, double y, double scale) throws OutOfBoundsException
    {
       // INITIALISE instance variables by calling the super constructor:
        super("sphere", "textures/javaFish/Bubble.png", scale);
       // IF the received scale is not in the range 0.05625 <= scale <= 0.1125 THEN throw exception:
       if((scale < 0.05625)||(scale > 0.1125))
       {
           throw new OutOfBoundsException("A Bubbles Scale must be within 25% of a JavaFish's scale range. (0.05625 <= bubbleScale <= 0.1125)");
       }
       // ELSE scale is within bounds, so proceed with the construction of the DisplayObject (Bubble):
       else
       {
           // Scale is within acceptable range, so initialise the rest of the Instance Variables:
           this.scale = scale;
           this.floatSpeed = 0.01;
           this.setPosition(x,y,1.0); //SET the start Position of the Bubble to that of it's JavaFish.
       }        

    }
    
    /**
     * METHOD: set the initial position of the Bubble in the aquarium - method from Marc Price, edited by Kristoper Randle.
     * 
     * A Bubble should always start at the same x,y as a JavaFish' mouth.
     * 
     * @param  x    the rqd position along the x axis
     * @param  y    the rqd position along the y axis
     * @param  z    the rqd position along the z axis
     * 
     * @return      void 
     */
    protected void setPosition(double x, double y, double z)
    {
        // SET the position of this Bubble to the x,y,z provided:
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * METHOD: to set the next frame of the simulation, called on each pass of the simulation - Method form Marc Price, edited by Kristopher Randle.
     *
     *@return   void
     */
    public void update()
    {
        this.y += floatSpeed; //move the Bubble on the Y axis by its floatSpeed.
    }
}