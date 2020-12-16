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
 * @author  Kristopher Randle @ Marc Price
 * @version 16-12-2020
 * 
 * Test Conditions:
 * JavaFish(): CHECK that an OutOfBoundsException is thrown if an invalid scale outside the range 0.4 <= scale <= 0.8 is provided.
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
     * TEST CONDITION: CHECK that an OutOfBoundsException is thrown if an invalid scale outside the range 0.4 <= scale <= 0.8 is provided.
     * 
     * Tests:
     * scaleTest1: CHECK that an OutOfBoundsException is NOT thrown if 0.4 <= scale <= 0.8 is provided.
     * scaleTest2: CHECK that an OutOfBoundsException is thrown if scale < 0.4.
     * scaleTest3: CHECK that an OutOfBoundsException is thrown if scale > 0.8.
     */
    @Test
    public void scaleTest1()
    {
        try
        {
            //CREATE a new JavaFish of type IDisplayObject, call it jf1 and give it a valid scale:
            IDisplayObject jf1 = new JavaFish(0.5);
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
            IDisplayObject jf1 = new JavaFish(0.2);
        }
        catch(OutOfBoundsException e)
        {
            //SET pass to true if OutOfBoundsException is thrown:
            pass = true;
        }
        //FAIL if an OutOfBoundsException is NOT thrown:
        assertTrue("OutOfBoundsException was NOT thrown when scale was too small (below 0.4)", pass);
    }
    
    @Test
    public void scaleTest3()
    {
        //DECLARE a boolean to determine if the test passes or fails, call it pass, set it to false:
        boolean pass = false;
        try
        {
            //CREATE a new JavaFish of type IDisplayObject, call it jf1 and give it an invalid scale which is too small:
            IDisplayObject jf1 = new JavaFish(0.9);
        }
        catch(OutOfBoundsException e)
        {
            //SET pass to true if OutOfBoundsException is thrown:
            pass = true;
        }
        //FAIL if an OutOfBoundsException is NOT thrown:
        assertTrue("OutOfBoundsException was NOT thrown when scale was too big (above 0.8)", pass);
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