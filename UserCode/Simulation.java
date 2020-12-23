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
 * @version 18-12-2020
 */
public class Simulation
{
    // Instance Variables:
    // DECLARE a reference to the instance of the ICore, call it '_core':
    private ICore _core;
      
    // DECLARE a reference to the instance of the 'Env' (environment) class, call it '_world':
    private Env _world;
        
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    
    // DECLARE a reference to the instance of 'List<IDisplayObject>', call it '_displayObjects'. Used to store all visual objects:
    private List<IDisplayObject> _displayObjects;
    
    // DECLARE a reference to the instance of 'List<JavaFish>', call it '_javaFish'. Used to store all objects of type 'JavaFish':
    private List<JavaFish> _javaFish;
    
    // DECLARE a reference to the instance of 'List<Bubble>', call it '_bubbles'. Used to store all objects of type 'Bubble':
    private List<Bubble> _bubbles;
    
    // DECLARE a reference to the instance of 'List<SoundEffect>', call it '_bubbleSoundEffects'. Used to store all objects of type 'SoundEffect':
    private List<SoundEffect> _bubbleSoundEffects;
    
    // DECLARE an int called jNumber, used for specifying the number of JavaFish to be added to the scene:
    private int jNumber;

    // DECLARE an int called sNumber, used for specifying the number of SeaHorses to be added to the scene:
    private int sNumber;
    
    // DECLARE an int called uNumber, used for specifying the number of Urchins to be added to the scene:
    private int uNumber;    
    public static void main(String[]args)
    {
        //INITIALISE a new Simulation, call it sim:
        Simulation sim = new Simulation();
        //RUN the simulation start-up code within a try-catch block to catch the potential exceptions that could be thrown:
        try
        {
            sim.populateObjectArray();
            sim.populateSoundEffectArray();
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
        _javaFish = new ArrayList<JavaFish>(); //INITIALISE _javaFish, store as a dynamic ArrayList containing objects of type 'JavaFish'.
        _bubbles = new ArrayList<Bubble>(); //INITIALISE _bubbles, store as a dynamic ArrayList containing objects of type 'Bubble'.
        _bubbleSoundEffects = new ArrayList<SoundEffect>(); //INITIALISE _bubbleSoundEffects, store as a dynamic ArrayList containing objects of type 'SoundEffect'.
        
        jNumber = 4; //INITIALISE jNumber, this specifies that 4 'JavaFish' objects will be added to the aquarium.
        sNumber = 4; //INITIALISE sNumber, this specifies that 4 'SeaHorse' objects will be added to the aquarium.
        uNumber = 3; //INITIALISE uNumber, this specifies that 3 'Urchin' objects will be added to the aquarium.
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
        //CREATE a specific number of JavaFish in a for loop using jNumber. Add them to the _javaFish List, Then add the bubbles to the _displayObjects List:
        for(int i = 0; i < jNumber; i++)
        {
            _javaFish.add(new JavaFish());
            _displayObjects.add(_javaFish.get(i));
        }
        //CREATE a specific number of Bubbles, based on the amount of JavaFish - add them to the _bubbles List. Then add the bubbles to the _displayObjects List:
        for(int i = 0; i < _javaFish.size(); i++)
        {
            _bubbles.add(_javaFish.get(i).getBubble());
            _displayObjects.add(_bubbles.get(i));
        } 
        //CREATE a specific number of SeaHorses in a for loop using sNumber. Add them to the _displayObjects List.
        for(int i = 0; i < sNumber; i++)
        {
            _displayObjects.add(new SeaHorse());
        }
        //CREATE a specific number of SeaHorses in a for loop using uNumber. Add them to the _displayObjects List.
        for(int i = 0; i < uNumber; i++)
        {
            _displayObjects.add(new Urchin());
        }
    }
    
    /**
     * METHOD: Declares and Initalises all sound effects to be added to _bubbleSoundEffects List. In this case, there are 5 different sound effects for a bubble being
     * emitting from a JavaFish.
     * 
     * Called on running the static main method.
     *
     * @return void
     */    
    public void populateSoundEffectArray()
    {
        //INITIALISE all sound effects as type 'SoundEffect':
        SoundEffect bubble_emit1 = new SoundEffect("sfx/bubble_emit1.wav");
        SoundEffect bubble_emit2 = new SoundEffect("sfx/bubble_emit2.wav"); 
        SoundEffect bubble_emit3 = new SoundEffect("sfx/bubble_emit3.wav"); 
        SoundEffect bubble_emit4 = new SoundEffect("sfx/bubble_emit4.wav"); 
        SoundEffect bubble_emit5 = new SoundEffect("sfx/bubble_emit5.wav"); 
        
        //ADD each 'SoundEffect' to the _bubbleSoundEffects List:
        _bubbleSoundEffects.add(bubble_emit1);
        _bubbleSoundEffects.add(bubble_emit2);
        _bubbleSoundEffects.add(bubble_emit3);
        _bubbleSoundEffects.add(bubble_emit4);
        _bubbleSoundEffects.add(bubble_emit5);
    }
    
    /**
     * METHOD: This method will play a random sound effect everytime it is called from the '_bubbleSoundEffects' List.
     * 
     * Called from the programs main Run loop, each time 'resetBubbles()' is called. (Only once a 'Bubble' is reset to a JavaFish's mouth.)
     * 
     * @return void
     */
    public void playRandomSoundEffect()
    {
        //DECLARE int i, generate a random number between 0 - _bubbleSoundEffects.size() - Store it in i:
        int i = (int)(_bubbleSoundEffects.size() * Math.random()); //code snippet from https://javarevisited.blogspot.com/2013/05/how-to-generate-random-numbers-in-java-between-range.html#:~:text=If%20you%20want%20to%20create,that%20number%20into%20int%20later.
        //PLAY a random sound effect from the _bubbleSoundEffects List at index i:
        _bubbleSoundEffects.get(i).playSoundEffect();
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
     * METHOD: This method is used to reset all of the bubbles that have been added to scene once they float past the roof.
     * They use the reference to all JavaFish stored in _javaFish to get the current x and y of each JavaFish.
     * This method is called in the RENDER stage of the Run() method loop.
     * 
     * getDirection() is used to identify if the JavaFish is swimming Left or Right. This is needed to appropriately reset the bubble to the JavaFish's mouth.
     * 
     * @return void
     */
    public void resetBubbles()
    {
        // LOOP for the amount of Bubble objects that exist:
        for(int i = 0; i < _bubbles.size(); i++)
        { 
            //IF a Bubble has risen past the top of the screen:
            if((_bubbles.get(i).getY()) > Pet.SCREEN_HEIGHT + 2) 
            {
                //AND the JavaFish is swimming RIGHT:
                if(_javaFish.get(i).getDirection() == true) 
                {
                    //SET the current Bubbles X co-ordinate to it's corresponding JavaFish's current X co-ordinate. PLUS it's body size so that the bubble emits from its mouth:
                    _bubbles.get(i).setX(_javaFish.get(i).getX() + _javaFish.get(i).getScale());
                    //SET the current Bubbles Y co-ordinate to it's corresponding JavaFish's current Y co-ordinate:
                    _bubbles.get(i).setY(_javaFish.get(i).getY());
                    //PLAY a random bubble sound effect once the bubble has rest to the JavaFish's mouth:
                    this.playRandomSoundEffect();
                }
                //AND the JavaFish is swimming LEFT:
                if(_javaFish.get(i).getDirection() == false) 
                {
                    //SET the current Bubbles X co-ordinate to it's corresponding JavaFish's current X co-ordinate. MINUS it's body size so that the bubble emits from its mouth:
                    _bubbles.get(i).setX(_javaFish.get(i).getX() - _javaFish.get(i).getScale());
                    //SET the current Bubbles Y co-ordinate to it's corresponding JavaFish's current Y co-ordinate:
                    _bubbles.get(i).setY(_javaFish.get(i).getY());
                    //PLAY a random bubble sound effect once the bubble has rest to the JavaFish's mouth:
                    this.playRandomSoundEffect();
                }
            }
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
            this.resetBubbles();
            // UPDATE: the environment
            _core.update();
        }
        // EXIT: cleanly by closing-down the environment:
        _core.destroyWorld();
    }
}
