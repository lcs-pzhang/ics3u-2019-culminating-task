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
            "★", "★", "←", "←", "←", "−", "╳", "−",
            "╳", "−", "╳", "−", "←", "+", "←", "+", "←",
            "+","★", "★", "★", "★", "←", "╳", "+", "−",
            "+", "╳", "←", "−", "−", "+", "−", "←", "+",
            "╳","←", "╳", "←", "★", "★", "★", "★", "★",
            "★", "+", "+", "←", "←",  
            "−", "−", "╳", "╳"};
 
    //This array gives us the value of when each note will fall/appear (in seconds) after the song begins
    private int[] delay = {2, 4, 6, 8, 10, 11, 13, 14, 16,
            19, 21, 23, 25, 27, 28, 30, 35, 37, 39, 41,
            43, 44, 44, 45, 47, 48, 50, 50, 50, 52, 54, 55,
            57, 59, 61, 63, 64, 66, 67, 69, 70, 71, 73,
            73, 75, 75, 77, 77, 77, 79, 80, 80, 81, 81,
            83, 85, 85, 87, 88, 90, 91, 92, 93, 93, 93,
            94, 94, 95, 97, 100, 100, 102, 102, 104};

    //This array gives us the value of the predetermined x positions of each falling/stationary notes
    private int[] xPosition = {495, 491, 487, 483, 460, 460,100,
            104, 108, 112, 150, 150, 175, 179, 183, 187, 195,
            200, 206, 210, 220, 225, 220, 225, 230, 235, 240, 245,
            250, 247, 244, 241, 239, 115, 120, 121, 125, 127, 100,
            95, 92, 87, 85, 79, 84, 88, 67, 69, 73, 75, 77, 300,
            305, 307, 309, 330, 333, 336, 339, 350, 355, 357, 359, 
            370, 371, 379, 385, 383, 395, 397,  
            417, 440, 441, 444};

    //This array gives the us the value of the predetermined y positions of each falling/stationary notes
    private int[] yPosition = {350, 350, 350, 350, 330, 325, 150,
            140, 130, 160, 165, 170, 171, 173, 175, 177, 185,
            190, 193, 193, 195, 200, 200, 205, 200, 200, 210, 214,
            217, 220, 221, 225, 227, 230, 230, 230, 235, 239, 241,
            243, 248, 250, 50, 52, 54, 55, 57, 59, 65, 67, 69,
            71, 73, 75, 77, 42, 44, 48, 80, 83, 85, 90, 91, 94,
            95, 27, 30, 35, 43, 300, 314, 317,
            325, 335};

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
            showText("Bad: " + score, 70, 9); 
        }

        if (score > 50)
        {
            showText("Okay: " + score, 70, 9); 
        }

        if (score > 70)
        {
            showText("Great: " + score, 70, 9); 
        }

        if (score >= 100)
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
