package Framework;
import UserCode.Exceptions.*;

/**
 * The DisplayObject contains all the data for displaying something by a Core instance.
 * 
 * Programmed by Dr Marc Price, exception handling functionality added by Kristopher Randle.
 * 
 * @author Marc Price & Kristopher Randle 
 * @version 14-12-2020
 */
public class DisplayObject implements IDisplayObject
{
    // Env3d-defined object-specific fields:
    // Reference to the 3D model, called 'model':
    protected String model;
    
    // Reference to texture-map, called 'texture':
    protected String texture;
    
    // Scale factor applied to model:
    protected double scale=1.0;
    
    // Position in 3D world (x,y,z coordinates):
    protected double x=0, y=0, z=0;
    
    // Orientation (about x,y,z):
    protected double rotateX=0, rotateY=0, rotateZ=0;
    
    // Set transparency to true:
    protected boolean transparent=true;

    /**
     * Constructor for objects of class DisplayObject
     */
    public DisplayObject(String model, String tex, double scale) throws OutOfBoundsException
    {
        // IF the received scale is less than 1/20th the window width, or greater than 1/10th the window width THEN throw exception.
        // ELSE scale is within bounds, so proceed with the construction of the DisplayObject.

        if((scale < 0.4)||(scale > 0.8))
        {
            throw new OutOfBoundsException("Scale must be greater than or equal to 0.4(1/20th window width), and less than or equal to 0.8(1/10th window width).");
        }
        else
        {
            // Scale is within acceptable range, so initialise instance variables.
            this.scale = scale;
            this.model = model;
            this.texture = tex;
        }
    }
    
    /**
     * METHOD: change to DisplayObject for next frame, called by Core class on each update
     * 
     */
    public void update()
    {
        // do nothing
    }
}
