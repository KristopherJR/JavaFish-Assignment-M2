package UserCode;

import Framework.*;
/**
 * Bubble contains all the behaviour and state to represent a Bubble.
 * 
 * @author Kristopher Randle
 * @version 0.1
 */
public class Bubble extends DisplayObject
{    
    public static final double SCREEN_HEIGHT = 7; //The height of the aquarium.
    //DECLARE a reference to the variable scale.
    private double scale;
    //DECLARE a reference to the variable speed.
    private double speed;
    //DECLARE a reference to the variable startY. Used to store the starting Y Position of the bubble.
    private double startY;
    
    /**
     * Constructor for objects of class Bubble, initialised to the position at xpos,ypos,zpos
     * 
     * @param xpos      The starting x position of the fish in the aquarium.
     * @param ypos      The starting y position of the fish in the aquarium.
     * @param scale     The scale (size) of the fish.
     */
    public Bubble(double x, double y, double scale)
    {
        // INITIALISE instance variables
        super("sphere", "textures/javaFish/Bubble.png", scale);
        this.scale = scale;
        this.speed = 0.01;
        this.startY = y;
        
        // INITIALISE position and speed of fish
        setPosition(x,y); //set the inital x, y and z of the bubble object to the specified location given on creation.
        setOrientation(0,-90,0);
    }
    
    /**
     * METHOD: set the position of the bubble in the aquarium - Method from Marc Price.
     * 
     * This method is used to specify the exact starting location of the bubble.
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
     * METHOD: set the orientation of the bubble in the aquarium - Method from Marc Price.
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
    /**
     * METHOD: sets the next frame of the simulation, called on each pass of the simulation - Method from Marc Price, edited by Kristopher Randle.
     *
     *@return   void
     */
    
    public void update()
    {
        this.y += speed;
        this.inBounds();
    }
    
    /**
     * METHOD: This method is the aquariums main boundary detection system. The "pets" use this to know if they hit a wall, if they do they will swim in the opposite direction from which they came.
     * 
     * @return  void
     */
    protected void inBounds()
    {
                if(this.y >= SCREEN_HEIGHT) // and it has gone past or hit the East wall or Roof.
                {
                    this.y = startY;
                }
    }
}