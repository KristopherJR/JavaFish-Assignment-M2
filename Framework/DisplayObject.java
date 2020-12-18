package Framework;
import UserCode.Exceptions.*;
import javax.activation.MimetypesFileTypeMap;
import java.io.File;

/**
 * The DisplayObject contains all the data for displaying something by a Core instance.
 * 
 * Programmed by Dr Marc Price, refactored by Kristopher Randle.
 * 
 * @author Marc Price & Kristopher Randle 
 * @version 18-12-2020
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
     * 
     * @param model    The model of the pet, as passed by the child class.
     * @param tex     The texture, as passed by the child class.
     * @param scale     The scale of the pet, as passed by the child class.
     * 
     * @throws OutOfBoundsException
     */
    public DisplayObject(String model, String tex, double scale) throws OutOfBoundsException
    {
        // IF the received scale is less than 1/20th the window width, or greater than 1/10th the window width THEN throw exception.
        if((scale < 0.01)||(scale > 1.0))
        {
            throw new OutOfBoundsException("DisplayObjects must be at least 0.01 in scale, and no greater than 1.0 in scale.");
        }
        // ELSE scale is within bounds, so proceed with the construction of the DisplayObject.
        else
        {
            // Scale is within acceptable range, so initialise scale instance variable.
            this.scale = scale;
        }
        
        //CALL this DisplayObjects validateModel method, to check that the model provided is a valid image file:
        if(this.validateModel(model) == true)
        {
            // VALIDATE provided String 'model' is a .obj file or 'sphere' before initalising the object with that model.
            this.model = model;
        }
        
        //CALL this DisplayObjects validateTexture method, to check that the texture provided is a valid image file:
        if(this.validateTexture(tex) == true)
        {
            // VALIDATE provided String 'tex' is a .png or .jpg file before initalising the object with that texture.
            this.texture = tex;
        }
    }
    
    /**
     * METHOD: Used to check that the String model that was provided is an accepted image type.
     * 
     * @param m     The model filepath that was provided on creation of the DisplayObject.
     * 
     * @throws InvalidImageFileException
     *
     * @return      A true boolean value if the instantiated model is valid.
     */
    public boolean validateModel(String m) throws InvalidImageFileException
    {
        //CHECK the model String is an accepted file type:
        if(m.endsWith(".obj") || m.equals("sphere"))
        {
            return true;
        }
        //THROW an InvalidImageFileException if it isn't a valid type:
        else
        {
            throw new InvalidImageFileException("The given Filepath does not present a model ending with .obj.");
        }
    }
    
    /**
     * METHOD: Used to check that the String texture that was provided is an accepted image type.
     * 
     * @param t     The texture filepath that was provided on creation of the DisplayObject.
     * 
     * @throws InvalidImageFileException
     * 
     * @return      A true boolean value if the instantiated texture is valid.
     */
    public boolean validateTexture(String t) throws InvalidImageFileException
    {
        //CHECK the texture String is an accepted file type:
        if(t.endsWith(".png"))
        {
            return true;
        }
        else if(t.endsWith(".jpg"))
        {
            return true;
        }
        //THROW an InvalidImageFileException if it isn't a valid type:
        else
        {     
            throw new InvalidImageFileException("The given Filepath does not present a texture ending with .png or .jpg.");
        }
    }
     
    public void setX(double newX)
    {
        this.x = newX;
    }
    
    public void setY(double newY)
    {
        this.y = newY;
    }
    
    /**
     * METHOD: GET the model of the DisplayObject.
     * 
     * @return      The model of the DisplayObject. 
     */
    
    public String getModel()
    {
        // GET model and return it:
        return model;
    }
    
    /**
     * METHOD: GET the x co-ordinate of the DisplayObject.
     * 
     * @return      The x co-ordinate of the DisplayObject. 
     */
    
    public double getX()
    {
        // GET x and return it:
        return x;
    }
    
    /**
     * METHOD: GET the y co-ordinate of the DisplayObject.
     * 
     * @return      The y co-ordinate of the DisplayObject. 
     */
    
    public double getY()
    {
        // GET y and return it:
        return y;
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
