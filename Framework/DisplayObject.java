package Framework;


/**
 * The DisplayObject contains all the data for displaying something by a Core instance.
 * 
 * @author (Marc Price) 
 * @version (24.07.2018)
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
    public DisplayObject(String model, String tex, double scale)
    {
        // initialise instance variables
        this.scale = scale;
        this.model = model;
        this.texture = tex;
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
