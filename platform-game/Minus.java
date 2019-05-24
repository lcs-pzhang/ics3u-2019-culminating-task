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
    
    /**
     * Constructor – runs once when the minus is created
     */
    Minus(boolean minusShouldFall)
    {
        shouldFall = minusShouldFall;
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
        
        checkAtBottom();
    } 
    
    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
     private void checkKeyPress()
    {
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
