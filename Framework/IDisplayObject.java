package Framework;


/**
 * The IDisplayObject instance contains all the data for displaying something by an ICore instance.
 * 
 * @author (Marc Price) 
 * @version (24.07.2018)
 */
public interface IDisplayObject
{
    /**
     * METHOD: change to IDisplayObject for next frame, called by ICore instance on each update
     * 
     */
    public void update();

}
