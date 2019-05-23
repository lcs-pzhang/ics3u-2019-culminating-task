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
    
    /**
     * Constructor – runs once when the arrow is created
     */
    Arrow(boolean arrowShouldFall)
    {
        shouldFall = arrowShouldFall;
    }
    
    
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Move the arrow down
        if (shouldFall == true)
        {
            // Fall
            setLocation(getX(), getY() + 1);
        }
    }  

   
    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
     private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("left")) 
        {
           MyWorld world = (MyWorld)getWorld();
           world.addScore(10);
           
           world.removeObject(this);
        } else {
            MyWorld world = (MyWorld)getWorld();
           world.addScore(-15);
      
           world.removeObject(this);
        }
    }
}
