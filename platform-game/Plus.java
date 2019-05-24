import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plus extends Actor
{
    private int speed;
    private boolean shouldFall;
    
    /**
     * Constructor – runs once when the plus is created
     */
    Plus(boolean plusShouldFall)
    {
        shouldFall = plusShouldFall;
    }
    
    /**
     * Act - do whatever the Plus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Move the arrow down
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
        if (Greenfoot.isKeyDown("up")) 
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
