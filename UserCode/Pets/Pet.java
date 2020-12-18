package UserCode.Pets;

import Framework.DisplayObject;
import UserCode.Exceptions.*;
/**
 * Pet is a subclass of display object. All Fish and creatures in the aquarium will inherit the Pet class and pass their characteristics into it.
 * Some code has been imported from Session 2 on blackboard by Marc Price. (Specifically, from JavaFish.class).
 * 
 * @author Kristopher Randle & Marc Price
 * @version 18-12-2020
 */
public abstract class Pet extends DisplayObject
{
    //Instance Variables:
    //DECLARE a reference to a two static final doubles, call them SCREEN_HEIGHT and SCREEN_WIDTH. Set them to 7.0 and 8.0 respectively:
    public static final double SCREEN_HEIGHT = 7.0; //The height of the aquarium.
    public static final double SCREEN_WIDTH = 8.0; //The width of the aquarium.
    
    //DECLARE three static doubles, call them START_SPEED, MAX_SPEED & MIN_SPEED respectively:
    public static double START_SPEED; //used to store the original unchanged randomly generated speed.
    public static double MAX_SPEED; //used to store the maximum speed the Pet can go.
    public static double MIN_SPEED; //used to store the minimum speed the Pet can go.
    
    //DECLARE a public boolean, call it direction and set it to true:
    public boolean direction = true;
    
    //DECLARE protected variables which subclasses of Pet have access to. Create one for xSpeed, ySpeed and scale of the pet:
    protected double xSpeed; //The speed of the Pet about the X axis.
    protected double ySpeed; //The speed of the Pet about the Y axis.
    protected double scale; //Stores the scale of the Pet. Provided on creation.
    /**
     * Constructor for objects of class Pet.
     * Calls the constructor of its parent class DisplayObject, passing in parameters provided by each child of the Pet class.
     * 
     * @param model    The model of the Pet, as passed by the child class.
     * @param tex     The texture of the Pet, as passed by the child class.
     * @param scale     The scale of the Pet, as passed by the child class.
     */
    public Pet(String model, String tex, double scale) throws OutOfBoundsException
    {
       //CALL the super constructor for Pet, passing in the parameters received from each child class:
       super(model, tex, scale);
       
       // IF the received scale is less than 1/20th the window width, or greater than 1/10th the window width THEN throw exception.
       if((scale < 0.225)||(scale > 0.45))
       {
           throw new OutOfBoundsException("A Pets scale must be greater than or equal to 0.225(1/20th window width), and less than or equal to 0.45(1/10th window width).");
       }
       // ELSE scale is within bounds, so proceed with the construction of the DisplayObject.
       else
       {
           // Scale is within acceptable range, so initialise scale instance variable.
           this.scale = scale;
       }
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
        // SET the value of START_SPEED to a random speed in the specified client range:
        START_SPEED = Math.random() * (MAX - MIN) + MIN; //The inital speed is stored in a final double variable. This is needed later for reference when switching directions in the aquarium.
        
        // STORE the MAX and MIN parameters that were passed in:
        MAX_SPEED = MAX;
        MIN_SPEED = MIN;
        
        // SET the Pets x and y speed to the provided start speed:
        xSpeed = START_SPEED;
        ySpeed = START_SPEED;
    }
    
    /**
     * METHOD: set the swim speed of the Pet to a default value if parameters are not provided for it. (Method Overloading)
     *
     *@return      void
     */
    protected void setSpeed()
    {
        // SET the value of speed to a random speed in the specified client range:
        START_SPEED = 0.005; //The inital speed is stored in a final double variable. This is needed later for reference when switching directions in the aquarium.
       
        // SET the Pets x and y speed to the provided start speed:
        xSpeed = START_SPEED; //set the speed to its initial start-up value.
        ySpeed = START_SPEED;
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
     * METHOD: set the position of the Pet within the aquarium - Method from Marc Price, refactored by Kristopher Randle.
     *
     * X and Y is randomly set between the bounds of the aquarium by using the windows height and width. Not specifying a Pets x and y location will give them a randomly
     * generated one. (Method Overloading)
     * 
     * @return      void
     */
    protected void setPosition()
    {
        // SET the position to a random location (x,y,z) within the bounds of the aquarium:
        setPosition((Math.random() * (SCREEN_WIDTH - 1) + 1),(Math.random() * (SCREEN_HEIGHT - 1) + 1),1.0);
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
        // SET orientation via the orientation variables in the base class:
        this.rotateX = x;
        this.rotateY = y;
        this.rotateZ = z;
    }
    
    /**
     * METHOD: GET the scale of the Pet.
     * 
     * @return      The scale of the Pet. 
     */
    public double getScale()
    {
        // GET scale and return it:
        return scale;
    }
    
    /**
     * METHOD: GET the xSpeed of the Pet.
     * 
     * @return      the current speed of this Pet on the X axis. 
     */
    public double getXSpeed()
    {
        // GET xSpeed and return it:
        return xSpeed;
    }
    
    /**
     * METHOD: GET the ySpeed of the Pet.
     * 
     * @return      the current speed of this Pet on the Y axis. 
     */
    public double getYSpeed()
    {
        // GET ySpeed and return it:
        return ySpeed;
    }
    
    /**
     * METHOD: GET the x co-ordinate of the Pet.
     * 
     * @return      The current x co-ordinate of the Pet. 
     */
    public double getX()
    {
        // GET x and return it:
        return x;
    }
    
    /**
     * METHOD: GET the y co-ordinate of the Pet.
     * 
     * @return      The current y co-ordinate of the Pet. 
     */
    public double getY()
    {
        // GET y and return it:
        return y;
    }
    
    /**
     * METHOD: GET the direction of the Pet. 'direction' is a boolean value, with the follow representations:
     * 'true' = This Pet is swimming RIGHT.
     * 'false' = This Pet is swimming LEFT.
     * 
     * @return      The current direction this Pet is swimming, TRUE = RIGHT, FALSE = LEFT. 
     */
    public boolean getDirection()
    {
        return direction;
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
        //IF the xSpeed of this Pet is outside 0.005 - 0.05, throw a new OutOfBoundsException with an error message:
        if((xSpeed < 0.005) || (xSpeed > 0.05))
        {
            throw new OutOfBoundsException("Pets are being randomly assigned a X speed value outside of their specified range (0.005 - 0.05)");
        }
        //IF the ySpeed of this Pet is outside 0.005 - 0.05, throw a new OutOfBoundsException with an error message:
        if((ySpeed < 0.005) || (ySpeed > 0.05))
        {
            throw new OutOfBoundsException("Pets are being randomly assigned a Y speed value outside of their specified range (0.005 - 0.05)"); 
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
     * METHOD: used to generate a new random xSpeed for this Pet, within the specified range (0.005 - 0.05). This is used to emulate random bursts of speed within the Fish.
     *
     *@return   void
     */
    public void generateRandomXSpeed()
    {
        //SET this Pets current xSpeed to a value between the clients specifed range:
        this.xSpeed = Math.random() * (MAX_SPEED - MIN_SPEED) + MIN_SPEED;
    }
    
    /**
     * METHOD: used to generate a new random ySpeed for this Pet, within the specified range (0.005 - 0.05). This is used to emulate random bursts of speed within the Fish.
     *
     *@return   void
     */    
    public void generateRandomYSpeed()
    {
        //SET this Pets current ySpeed to a value between the clients specifed range:
        this.ySpeed = Math.random() * (MAX_SPEED - MIN_SPEED) + MIN_SPEED;
    }
    
    /**
     * METHOD: This method is the aquariums main boundary detection system. The "Pets" use this to know if they hit a wall, if they do they will swim in the opposite direction from which they came.
     * Colliding with the RIGHT wall or the ROOF will result in this Pet receiving a random new xSpeed and ySpeed, this creates random speed bursts in the Pets.
     * 
     * @return  void
     */  
    protected void inBounds()
    {
        //CHECK that the Pet has not gone past the right wall, if it has, send it back the other way on the x axis:
        if((this.x >= (SCREEN_WIDTH + 1)))
        {
            this.generateRandomXSpeed(); //Generate a new, random xSpeed.
            this.xSpeed = -xSpeed; //swim the opposite way.
            this.x = SCREEN_WIDTH + 0.99; //reset it to the edge of the right wall.
            this.rotateY = 90; //face the opposite way. 
            this.direction = false; //FALSE indictates the Pet is heading LEFT across the screen.
        }
        //CHECK that the Pet has not gone past the roof, if it has, send it back the other way on the y axis:
        else if(this.y >= SCREEN_HEIGHT)
        {
            this.generateRandomYSpeed(); //Generate a new, random ySpeed.
            this.ySpeed = -ySpeed; //swim the opposite way.
            this.y = SCREEN_HEIGHT - 0.1; //reset it to the edge of the roof.
        }
        //CHECK that the Pet has not gone past the left wall, if it has, send it back the other way on the x axis:
        if(this.x <= 1)
        {
            this.xSpeed = -xSpeed; //swim the opposite way.
            this.x = 1.1; //reset it to the edge of the left wall.
            this.rotateY = -90; //face the opposite way.
            this.direction = true; //TRUE indictates the Pet is heading RIGHT across the screen.
        }
        //CHECK that the Pet has not gone past the floor, if it has, send it back the other way on the y axis:
        else if(this.y <= 1)
        {
            this.ySpeed = -ySpeed; //swim the opposite way.
            this.y = 1.1; //reset it to the edge of the floor.
        }
    }
}