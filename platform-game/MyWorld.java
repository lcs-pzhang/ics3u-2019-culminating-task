import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int score;
    private int frames;
    private GreenfootImage bubble[];
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(498, 372, 1); 
        score = 0;
        showScore();

        // Add a Bubble object
        Bubbles background = new Bubbles();
        addObject(background, getWidth() / 2, getHeight() / 2);
      
    }

    public void act()
    {
        //When to start the song
        if (frames == 10)
        {
            GreenfootSound sound = new GreenfootSound("Gift.mp3");
            sound.play();
        }
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
            showText("Bad: " + score, 50, 25); 
        }

        if (score > 50)
        {
            showText("Okay: " + score, 50, 25); 
        }

        if (score > 70)
        {
            showText("Great: " + score, 50, 25); 
        }

        if (score >= 100)
        {
            showText("Perfect: " + score, 50, 25); 
        }
    }

    private void showEndMessage()
    {
        showText("Your final score: " + score + "points", 390, 170);
    }
}
