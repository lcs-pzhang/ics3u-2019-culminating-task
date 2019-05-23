import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cross here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cross extends Actor
{
    private int speed;
    private boolean shouldFall;
    
    /**
     * Constructor – runs once when the cross is created
     */
    Cross(boolean crossShouldFall)
    {
        shouldFall = crossShouldFall;
    }
    
    /**
     * Act - do whatever the Cross wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Fall
        setLocation(getX(), getY() + 1);
    }  
    
    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
     private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("right")) 
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
