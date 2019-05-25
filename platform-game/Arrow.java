import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    private int speed;
    private boolean shouldFall;
    private int frames;
    private boolean stillInWorld;
    private int yPositionTargetValue;
    
    /**
     * Constructor – runs once when the arrow is created
     */
    Arrow(boolean arrowShouldFall, int yPositionTarget)
    {
        //whether if the arrow should fall or not
        shouldFall = arrowShouldFall;
        
        // Track time
        frames = 0;
        
        // The object begins in the world
        stillInWorld = true;
        
        // Vertical position at which the person needs to press the appropriate key
        yPositionTargetValue = yPositionTarget;
    }
    
    
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Track animation frames
        frames +=1;
        
        // Move the arrow down
        if (shouldFall == true)
        {
            // Fall
            setLocation(getX(), getY() + 3);
        }
        
        checkKeyPress();
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
            getY() <= yPositionTargetValue + 10 &&
            getY() >= yPositionTargetValue - 10) 
        {
           MyWorld world = (MyWorld)getWorld();
           world.addScore(10);
            GreenfootSound sound = new GreenfootSound("star.mp3");
           sound.play();
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
