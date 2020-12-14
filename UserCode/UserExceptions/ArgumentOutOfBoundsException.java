package UserCode.UserExceptions;


/**
 * Write a description of class ArgumentOutOfBoundsException here.
 * 
 * @author Kristopher Randle 
 * @version 14-12-2020
 */
public class ArgumentOutOfBoundsException extends Exception
{
    // instance variables - none

    /**
     * Constructor for objects of class ArgumentOutOfBoundsException
     * 
     * @param message a string containing details of the exception.
     */
    public ArgumentOutOfBoundsException(String message)
    {
        // PASS message to superclass:
        super(message);
    }
}
