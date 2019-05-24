import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    private int speed;
    private boolean shouldFall;
    
    /**
     * Constructor – runs once when the star is created
     */
    Star(boolean starShouldFall)
    {
        shouldFall = starShouldFall;
    }
    
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
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
        
        checkAtBottom();
    }  

    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("left + right")) 
        {
            MyWorld world = (MyWorld)getWorld();
            world.addScore(15);
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
