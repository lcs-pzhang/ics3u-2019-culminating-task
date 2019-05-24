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
    private int notes;
    private int star;
    private int plus;
    private int cross;
    private int arrow;
    private int minus;

    private String[] realNotes = { "★", "★", "★", "★", "+",
            "+", "−", "−", "╳", "←", "╳", "←", "╳", 
            "←", "+", "+", "+", "−", "−", "★", "★", "★",
            "★", "★", "←", "←", "←", "−", "╳", "−",
            "╳", "−", "╳", "−", "←", "+", "←", "+", "←",
            "+","★", "★", "★", "★", "←", "╳", "+", "−",
            "+", "╳", "←", "−", "−", "+", "−", "←", "+",
            "╳","←", "╳", "←", "★", "★", "★", "★", "★",
            "★", "+", "+", "+", "←", "←", "←", "←", "−", 
            "−", "−", "╳", "╳", "╳"};

    private String[] realKeys = { "left + right", "left + right", "left + right",
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

    private int[] delay = {2, 4, 6, 8, 10, 11, 13, 14, 16,
            19, 21, 23, 25, 27, 28, 30, 31, 33, 35, 37, 39, 41,
            43, 44, 44, 45, 47, 48, 50, 50, 50, 52, 54, 55,
            57, 59, 61, 63, 64, 66, 67, 69, 70, 71, 73,
            73, 75, 75, 77, 77, 77, 79, 80, 80, 81, 81,
            83, 85, 85, 87, 88, 90, 91, 92, 93, 93, 93,
            94, 94, 95, 95, 97, 97, 99, 99, 100, 100, 103, 103, 103};

    private int[] xPosition = {495, 491, 487, 483, 460, 460,100,
            104, 108, 112, 150, 150, 175, 179, 183, 187, 195, 195,
            200, 206, 210, 220, 225, 220, 225, 230, 235, 240, 245,
            250, 247, 244, 241, 239, 115, 120, 121, 125, 127, 100,
            95, 92, 87, 85, 79, 84, 88, 67, 69, 73, 75, 77, 300,
            305, 307, 309, 330, 333, 336, 339, 350, 355, 357, 359, 
            370, 371, 379, 385, 383, 392, 395, 397, 400, 420, 421, 
            417, 440, 441, 444, 450};

    private int[] yPosition = {350, 350, 350, 350, 330, 325, 150,
            140, 130, 160, 165, 170, 171, 173, 175, 177, 177, 185,
            190, 193, 193, 195, 200, 200, 205, 200, 200, 210, 214,
            217, 220, 221, 225, 227, 230, 230, 230, 235, 239, 241,
            243, 248, 250, 50, 52, 54, 55, 57, 59, 65, 67, 69,
            71, 73, 75, 77, 42, 44, 48, 80, 83, 85, 90, 91, 94,
            95, 27, 30, 35, 39, 43, 300, 305, 309, 303, 314, 317,
            325, 335, 345};

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

        // Check the array lengths
        // System.out.println("realNotes length is " + realNotes.length);
        // System.out.println("delay length is " + delay.length);
        // System.out.println("xPosition length is " + xPosition.length);

    }

    public void act()
    {
        countTime();
        checkForNotes();
    }

    public void addScore(int points)
    {
        score = score + points;
        showScore(); 
    }

    private void showScore()
    {
        //These will show the possible score outcomes at the end of the game
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

    private void checkForNotes()
    {
        // Increment frames
        frames += 1;

        // checking that for each second, if a full second has passed.
        if (frames % 60 == 0)
        {
            int currentSecond = frames / 60;
            showText("" + currentSecond, getWidth() - 100, 100);

            //for each second, we're looping over every element of the real notes array/
            for (int currentNote = 0; currentNote < realNotes.length; currentNote +=1)
            {

                // is it time to check a new object
                if (currentSecond == delay[currentNote])
                {
                    //add just that one note (whatever note corresponds to currentNote)
                    if (realNotes[currentNote] == "★")
                    {
                        // Falling note
                        Star newFallingNote = new Star(true);
                        addObject(newFallingNote, xPosition[currentNote], 0);

                        // Stationary note
                        Star newStationaryNote = new Star(false);
                        addObject(newStationaryNote, xPosition[currentNote], yPosition[currentNote]);
                    }
                    else if (realNotes[currentNote] == "+")
                    {
                        // Falling note
                        Plus newFallingNote = new Plus(true);
                        addObject(newFallingNote, xPosition[currentNote], 0);

                        // Stationary note
                        Plus newStationaryNote = new Plus(false);
                        addObject(newStationaryNote, xPosition[currentNote], yPosition[currentNote]);
                    }
                    else if (realNotes[currentNote] == "−")
                    {
                        // Falling note
                        Minus newFallingNote = new Minus(true);
                        addObject(newFallingNote, xPosition[currentNote], 0);

                        // Stationary note
                        Minus newStationaryNote = new Minus(false);
                        addObject(newStationaryNote, xPosition[currentNote], yPosition[currentNote]);
                    }
                    else if (realNotes[currentNote] == "╳")
                    {
                        // Falling note
                        Cross newFallingNote = new Cross(true);
                        addObject(newFallingNote, xPosition[currentNote], 0);

                        // Stationary note
                        Cross newStationaryNote = new Cross(false);
                        addObject(newStationaryNote, xPosition[currentNote], yPosition[currentNote]);
                    }
                    else if (realNotes[currentNote] == "←")
                    {
                        // Falling note
                        Arrow newFallingNote = new Arrow(true);
                        addObject(newFallingNote, xPosition[currentNote], 0);

                        // Stationary note
                        Arrow newStationaryNote = new Arrow(false);
                        addObject(newStationaryNote, xPosition[currentNote], yPosition[currentNote]);
                    }
                }

            }
        }
    }   

}
