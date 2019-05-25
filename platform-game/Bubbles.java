import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bubbles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubbles extends Actor
{
    //Instance variables
    private GreenfootImage bubble[];
    private int frames;
    private static final int delay = 5;

    /**
     * Constructor
     */
    Bubbles()
    {
        //Begin with the first bubble image  which will  be the the 'bubble'
        // this is an array of 30 values
        bubble = new GreenfootImage[30];

        //loop through the images from the images folder
        for (int index = 0; index < bubble.length; index+=1)
        {
            bubble[index] = new GreenfootImage("bubble-" + index + ".gif");
        }

        //Set the frame counter
        frames = 0; 
    }

    /**
     * Act - do whatever the bubbles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Track frames / time in scenario. //Frames will go up by one.
        
        frames += 1;
        

        // Track animation stage (e.g first image, second image, etc)
        int stage = frames / delay;
        

        // Change the image of the actor to create an animation
        if (stage < bubble.length)
        {
            // Only update image once when it's time for a new stage of
            // the animation
            if (frames % delay == 0)
            {
                this.setImage(bubble[stage]);
            }

        }
        else
        {
            //reset frames
            frames = 0;

        }

    }    
}
