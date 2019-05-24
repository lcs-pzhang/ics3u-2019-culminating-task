import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Minus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Minus extends Actor
{
    private int speed;
    private boolean shouldFall;
    private int frames;
    private boolean stillInWorld;
    private int yPositionTargetValue;
    
    /**
     * Constructor – runs once when the minus is created
     */
    Minus(boolean minusShouldFall, int yPositionTarget)
    {
        shouldFall = minusShouldFall;
        
        // Track time
        frames = 0;
        
        // The object begins in the world
        stillInWorld = true;
        
        // Vertical position at which the person needs to press the appropriate key
        yPositionTargetValue = yPositionTarget;
    }
    /**
     * Act - do whatever the Minus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Move the star down
        if (shouldFall == true)
        {
            // Fall
            setLocation(getX(), getY() + 3);
        }
        
        checkKeyPress();
        checkAtBottom();
    } 
    
    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
     private void checkKeyPress()
    {
        //if the correct keys are pressed, then the world will add points to the total score and remove that note
        if (Greenfoot.isKeyDown("down")) 
        {
           MyWorld world = (MyWorld)getWorld();
           world.addScore(10);
      
           world.removeObject(this);
        } 
    
    }
    
    private void checkAtBottom()
    {
        //when the note reached the bottom edge, remove the note and subtract points from total score
        if (isAtEdge())
        {
            MyWorld world = (MyWorld)getWorld();
            world.removeObject(this);
            world.addScore(-25);
        }
        
    }
}
