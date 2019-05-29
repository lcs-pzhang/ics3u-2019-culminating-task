import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //Instance variables
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

    //This is an array for which type of note will fall in order throughout the song
    private String[] realNotes = { "★", "★", "★", "★", "+",
            "+", "−", "−", "╳", "←", "╳", "←", "╳", 
            "←", "+", "+", "−", "−", "★", "★", "★",
            "★", "★", "←", "←", "←", "−", "╳",
            "╳", "−", "╳", "−", "←", "+", "←", "+", "←",
            "+","★", "★", "★", "★", "←", "╳", "+", "−",
            "←", "−", "−", "+", "−", "←", "+",
            "╳","←", "╳", "←", "★", "★"};
 
    //This array gives us the value of when each note will fall/appear (in seconds) after the song begins
    private int[] delay = {2, 4, 6, 8, 10, 13, 17, 21, 25,
            27, 30, 33, 37, 41, 43, 48, 50, 52, 54, 57,
            59, 61, 63, 66, 69, 71, 73, 75, 77, 79, 82,
            85, 88, 90, 93, 95, 98, 100, 102, 105, 107, 110,
            112, 114, 117, 120, 123, 125, 127, 130, 133,
            135, 137, 139, 142, 144, 147, 150, 154};

    //This array gives us the value of the predetermined x positions of each falling/stationary notes
    private int[] xPosition = {495, 491, 487, 483, 460, 460,100,
            104, 108, 112, 150, 150, 175, 179, 183, 187, 195,
            200, 190, 210, 220, 225, 220, 225, 230, 240, 250, 265,
            247, 240, 230, 220, 110, 120, 105, 120, 130, 100,
            90, 80, 130, 250, 260, 270, 280, 290, 220, 240, 300,
            305, 310, 315, 330, 320, 340, 325, 350, 355, 360};

    //This array gives the us the value of the predetermined y positions of each falling/stationary notes
    private int[] yPosition = {350, 350, 350, 350, 330, 325, 150,
            140, 130, 160, 165, 170, 171, 173, 175, 177, 185,
            190, 193, 193, 195, 200, 200, 205, 200, 200, 210, 214,
            220, 221, 225, 227, 230, 230, 230, 235, 239, 241,
            243, 248, 250, 225, 195, 164, 185, 177, 197, 209,
            221, 213, 235, 250, 242, 204, 238, 270, 243, 285, 270};

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(498, 372, 1); 

        //Initial score
        score = 0;

        //This will allow us to see the score
        showScore();

        //Inital time
        time = 9400;

        //This will allow us to see the time, but due to it not being a major component of the game, it's just off to the side.
        showTime();

        // Add a Bubble object
        //Put each new image in the center of the world in order for the full image to show when being looped.
        Bubbles background = new Bubbles();
        addObject(background, getWidth() / 2, getHeight() / 2);

        // Check the array lengths
        // System.out.println("realNotes length is " + realNotes.length);
        // System.out.println("delay length is " + delay.length);
        // System.out.println("xPosition length is " + xPosition.length);

    }

    public void act()
    {
        //This will allow us to keep track of the time running.
        countTime();

        //This will allow us to check if the notes are falling or stationary, and when will they fall.
        checkForNotes();
    }

    public void addScore(int points)
    {
        //This will show our score as an interger value.
        score = score + points;
        showScore(); 
    }

    private void showScore()
    {
        //These will show the possible score outcomes at the end of the game
        if (score <= 20)
        {
            showText("Not Cleared: " + score, 70, 9); 
        }

        if ( score >= 21 && score <= 174)
        {
            showText("Bad: " + score, 70, 9); 
        }

        if (score > 175)
        {
            showText("Passed: " + score, 70, 9); 
        }

        if (score > 350)
        {
            showText("Great: " + score, 70, 9); 
        }
        
        if (score > 350)
        {
            showText("Great: " + score, 70, 9); 
        }
        
        if (score >= 665)
        {
            showText("Perfect: " + score, 70, 9); 
        }

        //This will display the song name on the world
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

        //When the time is 9399, this will begin playing the song
        if (time == 9399)
        {
            GreenfootSound sound = new GreenfootSound("Gift.mp3");
            sound.play();  
        }

        //When the time reaches 0, it will completely stop the program
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

            //for each second, we're looping over every element of the real notes array
            for (int currentNote = 0; currentNote < realNotes.length; currentNote +=1)
            {

                // is it time to check a new object
                if (currentSecond == delay[currentNote])
                {
                    //add just that one note (whatever note corresponds to currentNote)
                    if (realNotes[currentNote] == "★")
                    {
                        // Falling note
                        Star newFallingNote = new Star(true, yPosition[currentNote]);
                        addObject(newFallingNote, xPosition[currentNote], 0);

                        // Stationary note
                        Star newStationaryNote = new Star(false, 0);
                        addObject(newStationaryNote, xPosition[currentNote], yPosition[currentNote]);
                    }
                    else if (realNotes[currentNote] == "+")
                    {
                        // Falling note
                        Plus newFallingNote = new Plus(true, yPosition[currentNote]);
                        addObject(newFallingNote, xPosition[currentNote], 0);

                        // Stationary note
                        Plus newStationaryNote = new Plus(false, 0);
                        addObject(newStationaryNote, xPosition[currentNote], yPosition[currentNote]);
                    }
                    else if (realNotes[currentNote] == "−")
                    {
                        // Falling note
                        Minus newFallingNote = new Minus(true, yPosition[currentNote]);
                        addObject(newFallingNote, xPosition[currentNote], 0);

                        // Stationary note
                        Minus newStationaryNote = new Minus(false, 0);
                        addObject(newStationaryNote, xPosition[currentNote], yPosition[currentNote]);
                    }
                    else if (realNotes[currentNote] == "╳")
                    {
                        // Falling note
                        Cross newFallingNote = new Cross(true, yPosition[currentNote]);
                        addObject(newFallingNote, xPosition[currentNote], 0);

                        // Stationary note
                        Cross newStationaryNote = new Cross(false, 0);
                        addObject(newStationaryNote, xPosition[currentNote], yPosition[currentNote]);
                    }
                    else if (realNotes[currentNote] == "←")
                    {
                        // Falling note
                        Arrow newFallingNote = new Arrow(true, yPosition[currentNote]);
                        addObject(newFallingNote, xPosition[currentNote], 0);

                        // Stationary note
                        Arrow newStationaryNote = new Arrow(false, 0);
                        addObject(newStationaryNote, xPosition[currentNote], yPosition[currentNote]);
                    }
                }

            }
        }
    }   

}
