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
    private int time;
   

private String[] realnotes = { "★", "★", "★", "★", "+",
    "+", "−", "−", "╳", "←", "╳", "←", "╳", 
    "←", "+", "+", "+", "−", "−", "★", "★", "★",
    "★", "★", "←", "←", "←", "−", "╳", "−",
"╳", "−", "╳", "−", "←", "+", "←", "+", "←",
"+","★", "★", "★", "★", "←", "╳", "+", "−",
"+", "╳", "←", "−", "−", "+", "−", "←", "+",
"╳","←", "╳", "←", "★", "★", "★", "★", "★",
"★", "+", "+", "+", "←", "←", "←", "←", "−", 
"−", "−", "╳", "╳", "╳"};

private String[] realkeys = { "left + right", "left + right", "left + right",
"left + right", "up", "up", "down", "down", "right", "left", "right", "left",
"right", "left", "up", "up", "up", "down", "down", "left + right",
"left + right", "left + right", "left + right", "left + right", "left", "left",
"left", "down", "right", "down", "right", "down", "right", "down", "left", "up"
, "left", "up", "left", "up", "left + right", "left + right", "left + right",
"left + right", "left", "right", "up", "down", "up", "right", "left", "down",
"down", "up", "down", "left", "up", "right", "left", "right", "left", 
 "left + right", "left + right", "left + right","left + right", "left + right",
"left + right", "up", "up", "up", "left", "left", "left", "left", "down", 
"down", "down", "right", "right", "right"};
    
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
        time = 9400;
        showTime();
        //Start the song
        // GreenfootSound sound = new GreenfootSound("Gift.mp3");
        // sound.play();
        
        // Add a Bubble object
        Bubbles background = new Bubbles();
        addObject(background, getWidth() / 2, getHeight() / 2);
      
    }

    public void act()
    {
        countTime();
    
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
            showText("Bad: " + score, 30, 9); 
        }

        if (score > 50)
        {
            showText("Okay: " + score, 30, 9); 
        }

        if (score > 70)
        {
            showText("Great: " + score, 30, 9); 
        }

        if (score >= 100)
        {
            showText("Perfect: " + score, 30, 9); 
        }
        
        showText("[Gift] From The Princess Who Brought Sleep", 255, 29);
    }

    private void showEndMessage()
    {
        showText("Your final score: " + score + "points", 390, 170);
    }
    
    private void countTime()
    {
        time--;
        showTime();
        if (time == 9399)
        {
          GreenfootSound sound = new GreenfootSound("Gift.mp3");
          sound.play();  
        }
       
        if (time == 0)
        {
            Greenfoot.stop();
        }
    
    }

    private void showTime()
    {
        showText("Time: " + time, 560, 10);
    }
}
