import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    //Instance variables
    private int speed;
    private boolean shouldFall;
    private int frames;
    private boolean stillInWorld;
    private int yPositionTargetValue;

    /**
     * Constructor – runs once when the star is created
     */
    Star(boolean starShouldFall, int yPositionTarget)
    {
        // Whether this star should fall
        shouldFall = starShouldFall;

        // Track time
        frames = 0;

        // The object begins in the world
        stillInWorld = true;

        // Vertical position at which the person needs to press the appropriate key
        yPositionTargetValue = yPositionTarget;
    }

    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Track animation frames
        frames +=1;

        // Move the star down
        if (shouldFall == true)
        {
            // Fall
            setLocation(getX(), getY() + 3);
        }

        checkKeyPress();
        
        //This will determine which method to use depending if the current note(s) are still in the world or not.
        if (stillInWorld == true)
        {
            checkAtBottom();
        }
        if (shouldFall == false && stillInWorld == true)
        {
            checkForRemovalTime();
        }
    }  

    private void checkForRemovalTime()
    {
        //When the frames is 110 for each note and upcoming note, then the world will remove the note(s). This also when each falling note 
        //should be pressed right before the falling/stationary notes dissappear.
        if (frames == 110)
        {
            MyWorld world = (MyWorld)getWorld();
            stillInWorld = false;
            world.removeObject(this);
        }
    }

    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
    private void checkKeyPress()
    {
        //if the correct keys are pressed, then the world will add points to the total score and remove that note
        if (Greenfoot.isKeyDown("left") &&
        Greenfoot.isKeyDown("right") &&
        getY() <= yPositionTargetValue + 10 &&
        getY() >= yPositionTargetValue - 10 ) 
        {
            MyWorld world = (MyWorld)getWorld();
            world.addScore(15);
            
            stillInWorld = false;
            world.removeObject(this);
        }
    }

    private void checkAtBottom()
    {
        //when the note reached the bottom edge, remove the note and subtract points from total score
        if (isAtEdge())
        {
            MyWorld world = (MyWorld)getWorld();
            stillInWorld = false;
            world.removeObject(this);
            world.addScore(-25);
        }

    }
}
