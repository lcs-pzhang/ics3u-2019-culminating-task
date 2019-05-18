import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plus extends Actor
{
    /**
     * Act - do whatever the Plus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    
    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
     private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
           MyWorld world = (MyWorld)getWorld();
           world.addScore(10);
      
           world.removeObject(this);
        }
    }
}
