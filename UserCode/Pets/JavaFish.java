package UserCode.Pets;

import UserCode.Exceptions.*;
import UserCode.*;
import Framework.*;
import java.util.*;
/**
 * JavaFish contains all the behaviour and state to represent a JavaFish, utilizing its parents attributes.
 * 
 * Based on JavaFish from Session 2 on blackboard by Marc Price, edited by Kristopher Randle
 * 
 * @author Marc Price & Kristopher Randle
 * @version 18-12-2020
 */
public class JavaFish extends Pet
{ 
   //Instance Variables:
   // DECLARE the minimum speed a fish can move as specified by the client brief:
   private static final double MIN_SPEED = 0.005;
   // DECLARE the maximum speed a fish can move as specified by the client brief:
   private static final double MAX_SPEED = 0.05;
   // DECLARE a private double, call it bubbleScale:
   private double bubbleScale;
   /**
    * Constructor for objects of class JavaFish, scale is passed to the Parent class, Pet. A JavaFish's position, orientation and speed is set by calling methods in the super class (Pet).
    * 
    * @param scale     The scale (size) of the fish. Must be 0.225 <= scale <= 0.45. Passed up to Pet.
    */
   public JavaFish(double scale)
   {
       // PASS the model, texture and scale to the superclass Pet constructor:
       super("models/billboard/billboard.obj", "textures/javaFish/JavaFish.png", scale);

       // INITIALISE position, orientation and speed of the JavaFish by calling methods in the superclass:
       super.setPosition(); //SET the x, y of the JavaFish to a random location in the aquarium.
       super.setOrientation(0,-90,0); //SET the orientation so that it is the right way up and facing the right direction
       super.setSpeed(MAX_SPEED, MIN_SPEED); //provides the RNG with a minimum and maximum speed for the JavaFish.
        
       // INITIALISE bubble as a Bubble, set it's x and y to that of the JavaFish:
       bubbleScale = scale * 0.025;
   }
    
   /**
    * Constructor for objects of class JavaFish. This constructor is called if the user does not provide a scale for the JavaFish, allowing it to be randomly assigned in a range.
    * A JavaFish's position, orientation, and speed is set by calling methods in the super class (Pet).
    *
    */
   public JavaFish()
   {
       // PASS the model, texture and a RANDOM scale to the superclass Pet constructor:
       super("models/billboard/billboard.obj", "textures/javaFish/JavaFish.png", Math.random() * (0.45 - 0.225) + 0.225); //model, texture and random scale passed to super constructor.

       // INITIALISE position, orientation and speed of fish by calling methods in the superclass:
       super.setPosition(); //set the x, y of the fish to a random location in the aquarium.
       super.setOrientation(0,-90,0); //SET the orientation so that it is the right way up and facing the right direction.
       super.setSpeed(MAX_SPEED, MIN_SPEED); //provides the RNG with a minimum and maximum speed for the JavaFish.
       
       // INITIALISE bubble as a Bubble, set it's x and y to that of the JavaFish:
       bubbleScale = scale * 0.25;
   }
   
   public Bubble getBubble()
   {
       Bubble b = new Bubble(x,y,bubbleScale);
       return b;
   }
}
