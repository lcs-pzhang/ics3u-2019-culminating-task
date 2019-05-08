import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private GreenfootImage bubble[];
    private int frames;
    private static final int delay = 5;
    private int score;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 450, 1); 
        score = 0;
        showScore();

        //Begin with the first bubble image  which will  be the the 'bubble'
        //array of 30 values
        bubble = new GreenfootImage[30];
        //loop through the images from the images folder
        for (int i = 0; i < bubble.length; i+=1)
        {
            bubble[i] = new GreenfootImage("bubble-" + i + ".gif");
        }
        //Set the frame counter
        frames = 0;
    }

    public void act()
    {
        // Track frames / time in scenario
        frames += 1;

        // Track animation stage (e.g first image, second image, etc)
        int stage = frames / delay;
        // Change the image of the actor to create an animation

    }

    public void addScore(int points)
    {
        score = score + points;
        showScore(); 
    }

    private void showScore()
    {
        if (score <= 20)
        {
            showText("Bad: " + score, 80, 25); 
        }

        if (score > 50)
        {
            showText("Okay: " + score, 80, 25); 
        }

        if (score > 70)
        {
            showText("Great: " + score, 80, 25); 
        }

        if (score >= 100)
        {
            showText("Perfect: " + score, 80, 25); 
        }
    }

    private void showEndMessage()
    {
        showText("Your final score: " + score + "points", 390, 170);
    }
}
