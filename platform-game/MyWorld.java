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

private String[] delay = {"10", "14", "18", "22","24", "25", "30", "33", "38",
"42", "47", "50", "55", "58", "63", "67", "70", "72", "75", "78", "81", "84",
"86", "89", "90", "93", "96", "98", "100", "102", "105", "105", "107", "110",
"112", "113", "115", "118", "122", "124", "127", "128", "129", "130", "133",
"135", "137", "139", "141", "143", "143", "148", "148", "150", "152", "154",
"155", "157", "159", "161", "163", "164", "166", "168", "170", "170", "173",
"175", "177", "179", "180", "181", "182", "184", "187", "191", "195", "199"};
    
 private String [] xposition = {"495", "491", "487", "483", "460", "460","100",
 "104", "108", "112", "150", "150", "175", "179", "183", "187", "195", "195",
"200", "206", "210", "220", "225", "220", "225", "230", "235", "240", "245",
"250", "247", "244", "241", "239", "115", "120", "121", "125", "127", "100",
"95", "92", "87", "85", "79", "84", "88", "67", "69", "73", "75", "77", "300",
"305", "307", "309", "330", "333", "336", "339", "350", "355", "357", "359", 
"370", "371", "379", "385", "383", "392", "395", "397", "400", "420", "421", 
"417", "440", "441", "444", "450"};


    
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
