package UserCode;

import UserCode.Exceptions.*;
import Framework.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BubbleTest.
 * 
 * This Test class is used to test that Bubbles function and instantiate correctly.
 * 
 * Based on Dr Marc Price's LionTest from his video lesson on Blackboard. 
 *
 * @author  Kristopher Randle & Marc Price
 * @version 23-12-2020
 * 
 * Test Conditions:
 * Bubble(): CHECK that a Bubbles scale is between 0.05625 - 0.1125 (25% of the JavaFish's scale range). If not, an OutOfBoundsException should be thrown.
 */
public class BubbleTest
{
    /**
     * Default constructor for test class JavaFishTest
     */
    public BubbleTest()
    {
    }
    
    /**
     * TEST CONDITION: CHECK that a Bubbles scale is between 0.05625 - 0.1125 (25% of the JavaFish's scale range). If not, an OutOfBoundsException should be thrown.
     * 
     * Tests:
     * bubbleScaleTest1: CHECK that an OutOfBoundsException is NOT thrown if 0.05625 <= bubbleScale <= 0.1125 is provided.
     * bubbleScaleTest2: CHECK that an OutOfBoundsException is thrown if scale < 0.05625.
     * bubbleScaleTest3: CHECK that an OutOfBoundsException is thrown if scale > 0.1125.
     */
    @Test
    public void bubbleScaleTest1()
    {
        try
        {
            //CREATE a new Bubble of type IDisplayObject, call it b1 and give it a valid scale:
            IDisplayObject b1 = new Bubble(1.0,1.0,0.05625);
        }
        catch(OutOfBoundsException e)
        {
            //FAIL if an OutOfBoundsException is thrown:
            fail("OutOfBoundsException was thrown when scale was in acceptable range.");
        }
    }
    
    @Test
    public void bubbleScaleTest2()
    {
        //DECLARE a boolean to determine if the test passes or fails, call it pass, set it to false:
        boolean pass = false;
        try
        {
            //CREATE a new Bubble of type IDisplayObject, call it b1 and give it an invalid scale which is too small:
            IDisplayObject b1 = new Bubble(1.0,1.0,0.02);
        }
        catch(OutOfBoundsException e)
        {
            //SET pass to true if OutOfBoundsException is thrown:
            pass = true;
        }
        //FAIL if an OutOfBoundsException is NOT thrown:
        assertTrue("OutOfBoundsException was NOT thrown when scale was too small (below 0.225)", pass);
    }
    
    @Test
    public void bubbleScaleTest3()
    {
        //DECLARE a boolean to determine if the test passes or fails, call it pass, set it to false:
        boolean pass = false;
        try
        {
            //CREATE a new Bubble of type IDisplayObject, call it b1 and give it an invalid scale which is too big:
            IDisplayObject b1 = new Bubble(1.0,1.0,0.3);
        }
        catch(OutOfBoundsException e)
        {
            //SET pass to true if OutOfBoundsException is thrown:
            pass = true;
        }
        //FAIL if an OutOfBoundsException is NOT thrown:
        assertTrue("OutOfBoundsException was NOT thrown when scale was too big (above 0.45)", pass);
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}