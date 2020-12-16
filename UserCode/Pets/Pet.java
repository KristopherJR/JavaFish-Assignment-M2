package UserCode.Pets;
import Framework.DisplayObject;
import UserCode.Exceptions.*;

/**
 * Pet is a subclass of display object. All models in the aquarium will inherit the Pet class and pass their characteristics into it.
 * Some code has been imported from Session 2 on blackboard by Marc Price. (Specifically, from JavaFish.class).
 * 
 * @author Kristopher Randle & Marc Price
 * @version 0.4
 */
public abstract class Pet extends DisplayObject
{
    public static final double SCREEN_HEIGHT = 7; //The height of the aquarium.
    public static final double SCREEN_WIDTH = 8; //The width of the aquarium.
    public static double SPEED; //used to store the original unchanged randomly generated speed.
    protected double speed; //The actual speed of the Pet.
    protected boolean direction; //Used to determine the direction the fish is heading across the screen. If True, it's heading East, If False, It's heading west.
    protected double scale; //Stores the scale of the Pet provided on creation.
    
    /**
     * Constructor for objects of class Pet.
     * Calls the constructor of its parent class DisplayObject, passing in parameters provided by each child of the Pet class.
     * 
     * @param model    The model of the pet, as passed by the child class.
     * @param tex     The texture, as passed by the child class.
     * @param scale     The scale of the pet, as passed by the child class.
     */
    public Pet(String model, String tex, double scale)
    {
       super(model, tex, scale); // model, texture and scale provided by each child class.
       this.scale = scale;
       this.direction = true; //setting the fishes default direction as east.
       
    }
    
    /**
     * METHOD: set the swim speed of the fish with a random number between 0.005 - 0.05
     * 
     * @param MAX   the maximum speed the fish can go as specified by the client.
     * @param MIN   the minimum speed the fish can go as specified by the client.
     * 
     * @return  void
     *
     */
    protected void setSpeed(double MAX, double MIN)
    {
        // SET the value of _speed to a random speed in the specified client range.
        SPEED = Math.random() * (MAX - MIN) + MIN; //The inital speed is stored in a final double variable. This is needed later for reference when switching directions in the aquarium.
        speed = SPEED; //set the speed to its initial start-up value.
        

    }
    
    /**
     * METHOD: set the swim speed of the fish to a default value if parameters are not provided for it. (Method Overloading)
     *
     *@return   void
     */
    protected void setSpeed()
    {
        // SET the value of _speed to a random speed in the specified client range.
        SPEED = 0.005; //The inital speed is stored in a final double variable. This is needed later for reference when switching directions in the aquarium.
        speed = SPEED; //set the speed  to its initial start-up value.
    }
    
    /**
     * METHOD: set the position of the fish within the aquarium - Method from Marc Price, refactor by Kristopher Randle.
     *
     * X and Y is randomly set between the bounds of the aquarium by using the windows height and width. Not specifying a Pets x and y location will give them a randomly
     * generated one.
     * 
     * @return      void
     */
    protected void setPosition()
    {
        // SET the position:
        setPosition((Math.random() * (SCREEN_WIDTH - 1) + 1),(Math.random() * (SCREEN_HEIGHT - 1) + 1),1.0); //Randomly set the fishes location to (x, y, z)
    }
    
    /**
     * METHOD: set the position of the fish in the aquarium - Method from Marc Price.
     * 
     * This method can be used to specify the exact starting location of the fish if the user wishes by providing an x and y parameter. Not providing will give them
     * a randomly generated one via the other instance of this overloaded method.
     * 
     * @param  x    the rqd position along the x axis
     * @param  y    the rqd position along the y axis
     * @param  z    the rqd position along the z axis
     * @return      void 
     */
    protected void setPosition(double x, double y, double z)
    {
        // SET position via the position variables in the base class:
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * METHOD: set the orientation of the fish in the aquarium - Method from Marc Price.
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
        // GET speed and return it:
        return SPEED;
    }
    
    public void validateSpeed() throws OutOfBoundsException
    {
        if((speed < 0.005) || (speed > 0.05))
        {
            throw new OutOfBoundsException("JavaFish's are being randomly assigned a speed value outside of their specified range (0.005 - 0.05)");
        }        
    }
    
    /**
     * METHOD: to set the next frame of the simulation, called on each pass of the simulation - Method form Marc Price, edited by Kristopher Randle.
     *
     *@return   void
     */
    public void update()
    {
        x += speed; //move the token on the X axis by its speed.
        this.inBounds(); //check if the token is still in the boundaries of the aquarium.
    }
    
    /**
     * METHOD: This method is the aquariums main boundary detection system. The "pets" use this to know if they hit a wall, if they do they will swim in the opposite direction from which they came.
     * 
     * @return  void
     */
    protected void inBounds()
    {
            if(direction == true) //if the fish is heading East.
            {
                if((this.x >= (SCREEN_WIDTH + 1)) || (this.y >= SCREEN_HEIGHT)) // and it has gone past or hit the East wall or Roof.
                {
                    this.speed = -speed; //swim the opposite way.
                    this.rotateY = 90; //face the opposite way.
                    this.direction = false; //state the fish is now heading West.
                }
            }
            else if(direction == false) //if the fish is heading West.
            {
                if(this.x <= 1 || this.y <= 1) // and it has gone past or hit the West wall or Floor.
                {
                    this.speed = SPEED; //swim the opposite way.
                    this.rotateY = -90; //face the opposite way.
                    this.direction = true; //state the fish is now heading East.
                }
            }
    }
}