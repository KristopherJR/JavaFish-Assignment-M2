package UserCode.Pets;

import Framework.DisplayObject;
import UserCode.Exceptions.*;
/**
 * Pet is a subclass of display object. All models in the aquarium will inherit the Pet class and pass their characteristics into it.
 * Some code has been imported from Session 2 on blackboard by Marc Price. (Specifically, from JavaFish.class).
 * 
 * @author Kristopher Randle & Marc Price
 * @version 16-12-2020
 */
public abstract class Pet extends DisplayObject
{
    //Instance Variables:
    //DECLARE a reference to a two static final doubles, call them SCREEN_HEIGHT and SCREEN_WIDTH. Set them to 7.0 and 8.0 respectively:
    public static final double SCREEN_HEIGHT = 7.0; //The height of the aquarium.
    public static final double SCREEN_WIDTH = 8.0; //The width of the aquarium.
    
    //DECLARE a static double, call it SPEED:
    public static double SPEED; //used to store the original unchanged randomly generated speed.
    
    //DECLARE protected variables which subclasses of Pet have access to. Create one for speed, direction and scale of the pet:
    protected double xSpeed; //The speed of the Pet about the X axis.
    protected double ySpeed; //The speed of the Pet about the Y axis.
    protected double scale; //Stores the scale of the Pet provided on creation.
    /**
     * Constructor for objects of class Pet.
     * Calls the constructor of its parent class DisplayObject, passing in parameters provided by each child of the Pet class.
     * 
     * @param model    The model of the Pet, as passed by the child class.
     * @param tex     The texture of the Pet, as passed by the child class.
     * @param scale     The scale of the Pet, as passed by the child class.
     */
    public Pet(String model, String tex, double scale)
    {
       //CALL the super constructor for Pet, passing in the parameters received from each child class:
       super(model, tex, scale);
       
       //SET the scale and direction instance variables of this Pet:
       this.scale = scale;
    } 
    
    /**
     * METHOD: set the swim speed of the Pet with a random number between 0.005 - 0.05
     * 
     * @param MAX   the maximum speed the Pet can go as specified by the client.
     * @param MIN   the minimum speed the Pet can go as specified by the client.
     * 
     * @return      void
     */
    protected void setSpeed(double MAX, double MIN)
    {
        // SET the value of speed to a random speed in the specified client range:
        SPEED = Math.random() * (MAX - MIN) + MIN; //The inital speed is stored in a final double variable. This is needed later for reference when switching directions in the aquarium.
        xSpeed = SPEED; //set the speed to its initial start-up value.
        ySpeed = SPEED;
    }
    
    /**
     * METHOD: set the swim speed of the Pet to a default value if parameters are not provided for it. (Method Overloading)
     *
     *@return      void
     */
    protected void setSpeed()
    {
        // SET the value of speed to a random speed in the specified client range:
        SPEED = 0.005; //The inital speed is stored in a final double variable. This is needed later for reference when switching directions in the aquarium.
        xSpeed = SPEED; //set the speed  to its initial start-up value.
        ySpeed = SPEED;
    }
    
    /**
     * METHOD: set the position of the Pet within the aquarium - Method from Marc Price, refactored by Kristopher Randle.
     *
     * X and Y is randomly set between the bounds of the aquarium by using the windows height and width. Not specifying a Pets x and y location will give them a randomly
     * generated one.
     * 
     * @return      void
     */
    protected void setPosition()
    {
        // SET the position to a random location (x,y,z) within the bounds of the aquarium:
        setPosition((Math.random() * (SCREEN_WIDTH - 1) + 1),(Math.random() * (SCREEN_HEIGHT - 1) + 1),1.0);
    }
    
    /**
     * METHOD: set the position of the Pet in the aquarium - Method from Marc Price.
     * 
     * This method can be used to specify the exact starting location of the Pet if the user wishes by providing an x, y and z parameter. Not providing will give them
     * a randomly generated one via the other instance of this overloaded method.
     * 
     * @param  x    the rqd position along the x axis
     * @param  y    the rqd position along the y axis
     * @param  z    the rqd position along the z axis
     * 
     * @return      void 
     */
    protected void setPosition(double x, double y, double z)
    {
        // SET the position of this Pet to the x,y,z provided:
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * METHOD: set the orientation of the Pet in the aquarium - Method from Marc Price.
     * 
     * @param  x    orientation about the x axis
     * @param  y    orientation about the y axis
     * @param  z    orientation about the z axis
     * 
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
     * METHOD: GET the scale of the Pet.
     * 
     * @return      The scale of the Pet. 
     */
    protected double getScale()
    {
        // GET scale and return it:
        return scale;
    }
    
    /**
     * METHOD: GET the speed of the Pet.
     * 
     * @return      The speed of the Pet. 
     */
    public double getSpeed()
    {
        // GET SPEED and return it:
        return SPEED;
    }
    
    /**
     * METHOD: used to validate that the speed this Pet has been assigned is within the correct range, if it isn't an OutOfBoundsException is thrown which can be caught at another part in the program.
     * 
     * @throws OutOfBoundsException
     * 
     * @return      void 
     */
    
    public void validateSpeed() throws OutOfBoundsException
    {
        //IF the speed of this Pet is outside 0.005 - 0.05, throw a new OutOfBoundsException with an error message:
        if((SPEED < 0.005) || (SPEED > 0.05))
        {
            throw new OutOfBoundsException("Pets are being randomly assigned a speed value outside of their specified range (0.005 - 0.05)");
        }        
    }
    
    /**
     * METHOD: to set the next frame of the simulation, called on each pass of the simulation - Method form Marc Price, edited by Kristopher Randle.
     *
     *@return   void
     */
    public void update()
    {
        x += xSpeed; //move the token on the X axis by its speed.
        this.inBounds(); //check if the token is still in the boundaries of the aquarium.
    }
    
    /**
     * METHOD: This method is the aquariums main boundary detection system. The "Pets" use this to know if they hit a wall, if they do they will swim in the opposite direction from which they came.
     * 
     * @return  void
     */  
    protected void inBounds()
    {
        //CHECK that the Pet has not gone past the right wall, if it has, send it back the other way on the x axis:
        if((this.x >= (SCREEN_WIDTH + 1))) // and it has gone past or hit the East wall or Roof.
        {
            this.xSpeed = -xSpeed; //swim the opposite way.
            this.x = SCREEN_WIDTH + 1; //reset it to the edge of the right wall.
            this.rotateY = 90; //face the opposite way.
        }
        //CHECK that the Pet has not gone past the roof, if it has, send it back the other way on the y axis:
        else if(this.y >= SCREEN_HEIGHT)
        {
            this.ySpeed = -ySpeed; //swim the opposite way.
            this.y = SCREEN_HEIGHT; //reset it to the edge of the roof.
        }
        //CHECK that the Pet has not gone past the left wall, if it has, send it back the other way on the x axis:
        if(this.x <= 1)
        {
            this.xSpeed = -xSpeed; //swim the opposite way.
            this.x = 1; //reset it to the edge of the left wall.
            this.rotateY = -90; //face the opposite way.
        }
        //CHECK that the Pet has not gone past the floor, if it has, send it back the other way on the y axis:
        else if(this.y <= 1)
        {
            this.ySpeed = -ySpeed; //swim the opposite way.
            this.y = 1; //reset it to the edge of the floor.
        }
    }
}