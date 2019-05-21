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
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
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
        if (Greenfoot.isKeyDown("left + right")) 
        {
           MyWorld world = (MyWorld)getWorld();
           world.addScore(15);
           world.removeObject(this);
        } else {
            MyWorld world = (MyWorld)getWorld();
           world.addScore(-25);
      
           world.removeObject(this);
        }
    }
}
