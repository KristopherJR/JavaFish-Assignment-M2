package UserCode;

import Framework.*;
/**
 * Bubbler contains all the behaviour and state to represent a Bubbler.
 * 
 * @author Kristopher Randle
 * @version 0.1
 */
public class Bubbler extends DisplayObject
{    
    //DECLARE a reference to the variable scale.
    private double scale;
    
    /**
     * Constructor for objects of class Bubbler, initialised to the position at xpos,ypos,zpos
     * 
     * @param xpos      The starting x position of the fish in the aquarium.
     * @param ypos      The starting y position of the fish in the aquarium.
     * @param scale     The scale (size) of the fish.
     */
    public Bubbler(double x, double y, double scale)
    {
        // INITIALISE instance variables
        super("models/billboard/billboard.obj", "textures/Bubbler.png", scale);
        this.scale = scale;
        
        // INITIALISE position and speed of fish
        setPosition(x,y); //set the inital x, y and z of the bubbler object to the specified location given on creation.
        setOrientation(0,90,0);
    }
    
    /**
     * METHOD: set the position of the bubbler in the aquarium - Method from Marc Price.
     * 
     * This method is used to specify the exact starting location of the bubbler.
     * 
     * @param  x    the rqd position along the x axis
     * @param  y    the rqd position along the y axis
     * @return      void 
     */
    protected void setPosition(double x, double y)
    {
        // SET position via the position variables in the base class:
        this.x = x;
        this.y = y;
        this.z = 1.0;
    }
    
    /**
     * METHOD: set the orientation of the bubbler in the aquarium - Method from Marc Price.
     * 
     * @param  x    orientation about the x axis
     * @param  y    orientation about the y axis
     * @param  z    orientation about the z axis
     * @return      void 
     */
    protected void setOrientation(double x, double y, double z)
    {
        // set orientation via the orientation variables in the base class:
        this.rotateX = x;
        this.rotateY = y;
        this.rotateZ = z;
    }
}