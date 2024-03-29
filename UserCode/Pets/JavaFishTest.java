package UserCode.Pets;

import UserCode.Exceptions.*;
import Framework.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class JavaFishTest.
 * 
 * This Test class is used to test that JavaFish's function and instantiate correctly.
 * 
 * Based on Dr Marc Price's LionTest from his video lesson on Blackboard. 
 *
 * @author  Kristopher Randle & Marc Price
 * @version 18-12-2020
 * 
 * Test Conditions:
 * JavaFish(): CHECK that an OutOfBoundsException is thrown if an invalid scale outside the range 0.225 <= scale <= 0.45 is provided.
 * JavaFish(): CHECK that the xSpeed and ySpeed has been automatically set between 0.005 - 0.05.
 */
public class JavaFishTest
{
    /**
     * Default constructor for test class JavaFishTest
     */
    public JavaFishTest()
    {
    }
    
    /**
     * TEST CONDITION: CHECK that an OutOfBoundsException is thrown if an invalid scale outside the range 0.225 <= scale <= 0.45 is provided.
     * 
     * Tests:
     * scaleTest1: CHECK that an OutOfBoundsException is NOT thrown if 0.225 <= scale <= 0.45 is provided.
     * scaleTest2: CHECK that an OutOfBoundsException is thrown if scale < 0.225.
     * scaleTest3: CHECK that an OutOfBoundsException is thrown if scale > 0.45.
     */
    @Test
    public void scaleTest1()
    {
        try
        {
            //CREATE a new JavaFish of type IDisplayObject, call it jf1 and give it a valid scale:
            IDisplayObject jf1 = new JavaFish(0.225);
        }
        catch(OutOfBoundsException e)
        {
            //FAIL if an OutOfBoundsException is thrown:
            fail("OutOfBoundsException was thrown when scale was in acceptable range.");
        }
    }
    
    @Test
    public void scaleTest2()
    {
        //DECLARE a boolean to determine if the test passes or fails, call it pass, set it to false:
        boolean pass = false;
        try
        {
            //CREATE a new JavaFish of type IDisplayObject, call it jf1 and give it an invalid scale which is too small:
            IDisplayObject jf1 = new JavaFish(0.1);
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
    public void scaleTest3()
    {
        //DECLARE a boolean to determine if the test passes or fails, call it pass, set it to false:
        boolean pass = false;
        try
        {
            //CREATE a new JavaFish of type IDisplayObject, call it jf1 and give it an invalid scale which is too big:
            IDisplayObject jf1 = new JavaFish(0.5);
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
     * TEST CONDITION: CHECK that the xSpeed and ySpeed has been automatically set between 0.005 - 0.05.
     * 
     * Tests:
     * speedTestX: Initialise a JavaFish, then check that they aren't being initalized with an xSpeed outside the range. If they are, test should FAIL.
     * speedTestY: Initialise a JavaFish, then check that they aren't being initalized with a ySpeed outside the range. If they are, test should FAIL.
     */

    @Test
    public void speedTestX()
    {
        //CREATE a new JavaFish with a valid scale, call it jf1:
        JavaFish jf1 = new JavaFish(0.4);
        try
        {
            //RUN validateXSpeed(), which will throw an exception if the speed isn't in the correct range:
            jf1.validateSpeed();
        }
        catch(OutOfBoundsException e)
        {
            //FAIL if an OutOfBoundsException is thrown:
            fail(e.getMessage() + " The JavaFish's assigned xSpeed was: " + jf1.getXSpeed());
        } 
    }

    @Test
    public void speedTestY()
    {
        //CREATE a new JavaFish with a valid scale, call it jf1:
        JavaFish jf1 = new JavaFish(0.4);
        try
        {
            //RUN validateYSpeed(), which will throw an exception if the speed isn't in the correct range:
            jf1.validateSpeed();
        }
        catch(OutOfBoundsException e)
        {
            //FAIL if an OutOfBoundsException is thrown:
            fail(e.getMessage() + " The JavaFish's assigned ySpeed was: " + jf1.getYSpeed());
        } 
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
