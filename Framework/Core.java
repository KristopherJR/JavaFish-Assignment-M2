package Framework;

import java.util.List;
import java.util.ArrayList;
import env3d.Env;

/**
 * Core is intended to provide the core functionality for the top-level aquarium simulation class.
 * Note that the top-level simulation class must implement the simulation loop.
 * 
 * @author Marc Price 
 * @version 0.4
 */
public class Core implements ICore
{
    // instance variables (fields):
    // DECLARE the reference to the 3D world:
    private Env _world;
    
    // DECLARE the reference to a list of IDisplayObjects, call it _displayables:
    private List<IDisplayObject> _displayables;
    
    // DEFINE a private inner class that creates the Env3D 'room', call it 'Aquarium':
    private class Aquarium
    {
        private String textureTop;
        private String textureBottom; // = "textures/orangeFish/AquariumBackground.png";
        private String textureNorth = "textures/javaFish/AquariumBackground.png";
        private String textureSouth;
        private String textureEast; // = "textures/orangeFish/AquariumBackground.png";
        private String textureWest; // = "textures/orangeFish/AquariumBackground.png";
        
        private double width;
        private double height;
        private double depth;
        
        private double bgRed;
        private double bgGreen;
        private double bgBlue;
        
        /**
         * Constructor
         *
         * @param  x   width of type double
         * @param  y   height of type double
         * @param  z   depth of type double
         */
        public Aquarium(double x, double y, double z)
        {
            width = x;
            height = y;
            depth = z;
        }
    
    }
    
        
    /**
     * Constructor for objects of class Core
     */
    public Core()
    {
        // INITIALISE _displayables
        _displayables = new ArrayList<IDisplayObject>();

    }

    /**
     * METHOD: add a displayable to the world.
     *
     * @param       displayable - a displayable of type IDisplayObject
     */
    public void addDisplayObject(IDisplayObject displayable)
    {
        // Place object in _displayables:
        _displayables.add(displayable);
        
        // Place object in _world (if it exists yet):
        if (_world!=null)
        {
            _world.addObject(displayable);
        }
    }

    /**
     * METHOD: remove a displayable from the world.
     *
     * @param       displayable - the displayable of type IDisplayObject to be removed
     */
    public void removeDisplayObject(IDisplayObject displayable)
    {
        // Remove object from world:
        _world.removeObject(displayable);
        _displayables.remove(displayable);
    }

        
    /**
     * METHOD: create and initialise the environment (aka 'world')
     *
     * @return      the 'world', once it has been created.
     */

    public Env createWorld()
    {
        // Instantiate an environment:
        _world = new Env();
        
        // Get rid of the awful mouse control:
        _world.setDefaultControl(false);
        
        // Set the window resolution:
        _world.setResolution(1280,960,24);
        
        // Instantiate Aquarium and assign it to the environment as the scene:
        _world.setRoom(new Aquarium(10, 8, 1));
        
        // Set the camera to a fixed position so that scene looks flat:
        _world.setCameraXYZ((_world.getCameraX()),3.9,9.1);
        
        // Place _displayables into the scene:
        for (int i=0; i<_displayables.size(); i++)
            _world.addObject(_displayables.get(i));
            
        // Return reference to the environment:
        return _world;
    }

    /**
     * METHOD: destroy the 3D world.
     * Although there is a garbage-collector in Java, the world has to be destroyed with 'destroyWorld'
     * in order to close-down your simulation-loop cleanly.
     *
     */

    public void destroyWorld()
    {
        // Close down the environment:
        _world.exit();
    }
    
    /**
     * Apply all updates to the environment.
     * This must be called at the end of each pass through the simulation loop.
     *
     */

    public void update()
    {
        // Update state:
        for (int i=0; i<_displayables.size(); i++)
            _displayables.get(i).update();

        // Update the environment
        _world.advanceOneFrame();
    }
}
