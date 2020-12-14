package UserCode;

import env3d.Env;
import java.util.*;
import Framework.*;
import UserCode.Pets.*;

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * Code taken from JavaFish2 Framework on Blackboard by Dr Marc Price, Refactored by Kristopher Randle.
 * 
 * @author Kristopher Randle and Marc Price
 * @version 0.5
 */
public class Simulation
{
    // instance variables:
    // DECLARE a reference to the instance of the ICore, call it '_core':
    private ICore _core;
      
    // DECLARE a reference to the instance of the 'Env' (environment) class, call it '_world':
    private Env _world;
        
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    
    // DECLARE a reference to the instance of 'List<IDisplayObject>', call it '_displayObjects'. Used to store all visual objects:
    private List<IDisplayObject> _displayObjects;

    public static void main(String[]args)
    {
        Simulation sim = new Simulation();
        sim.populateObjectArray();
        sim.populate();
        sim.run(); 
    }
    
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation()
    {
        //INITIALISE instance variables:
        _core = new Core(); //INITIALISE '_core' as dynamic type 'Core'.
        _displayObjects = new ArrayList<IDisplayObject>(); //INITIALISE _displayObjects, store as a dynamic ArrayList containing objects of type 'IDisplayOject'.
    }
    
    /**
     * METHOD: Declares and Initalises all tokens to be added to the Aquarium, then store them in the '_displayObjects' List.
     * 
     * Called on running the static main method.
     *
     */    
    public void populateObjectArray()
    {
        //INITIALISE the objects cast to type IDisplayObject
        
        IDisplayObject jf1 = new JavaFish(0.4); //Create a 'JavaFish' called 'jf1', store it as an 'IDisplayObject'. Give it the specified scale.
        
        //STORE the newly initalized objects in the _displayObjects List
        
        _displayObjects.add(jf1); //add jf1 to the _displayObjects List.
    }

    /**
     * METHOD: populate the scene with all objects
     * 
     * Called on running the static main method, iterates through the List of predefined/initialized DisplayObjects and adds them to the '_core'.
     *
     */
    public void populate()
    {
        
        for (int i = 0; i < _displayObjects.size(); i++)
        {
            _core.addDisplayObject(_displayObjects.get(i)); //add all elements of _displayObjects to the aquarium.
        }
    }
    
    /**
     * METHOD: Run the simulation loop.  User presses escape to exit.
     *
     */
    public void run()
    {
        // CREATE the environment:
        _world = _core.createWorld();

        // Start simulation loop:
        while (!endSim)
        {
            // UPDATE STAGE:
            // IF: user has requested simulation loop exit (ie escape pressed):
            if (_world.getKey() == 1)
            {
                // SET: render loop exit condition
                endSim = true;
            }
                        
            // UPDATE Objects in 3D world:
            
            // RENDER STAGE
            // UPDATE: the environment
            _core.update();
        }
        
        // EXIT: cleanly by closing-down the environment:
        _core.destroyWorld();

    }

}
