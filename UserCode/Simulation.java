package UserCode;

import env3d.Env;
import java.util.*;
import Framework.*;
import UserCode.Pets.*;
import UserCode.Exceptions.*;

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * Code taken from JavaFish2 Framework on Blackboard by Dr Marc Price, Refactored by Kristopher Randle.
 * 
 * @author Kristopher Randle and Marc Price
 * @version 17-12-2020
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
        //INITIALISE a new Simulation, call it sim:
        Simulation sim = new Simulation();
        //RUN the simulation start-up code within a try-catch block to catch the potential exceptions that populateObjectArray() could throw:
        try
        {
            sim.populateObjectArray();
            sim.populate();
            sim.run();
        }
        //IF an out of bounds exception is thrown, catch it and output the error message to the console:
        catch(OutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
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
     * @return void
     */    
    public void populateObjectArray()
    {
        //INITIALISE the objects cast to type IDisplayObject:
        IDisplayObject jf1 = new JavaFish(); //Create a 'JavaFish' called 'jf1', store it as an 'IDisplayObject'. Give it the specified scale.
            
        //STORE the newly initalized objects in the _displayObjects List.
        _displayObjects.add(jf1); //add jf1 to the _displayObjects List.
    }

    /**
     * METHOD: populate the scene with all objects
     * 
     * Called on running the static main method, iterates through the List of predefined/initialized DisplayObjects and adds them to the '_core'.
     * 
     * @return void
     */
    public void populate()
    {
        //FOR each element in displayObject ArrayList, add them to '_core':
        for (int i = 0; i < _displayObjects.size(); i++)
        {
            _core.addDisplayObject(_displayObjects.get(i)); //add all elements of _displayObjects to the aquarium.
        }
    }
    
    /**
     * METHOD: Run the simulation loop.  User presses escape to exit.
     * 
     * @return void
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
