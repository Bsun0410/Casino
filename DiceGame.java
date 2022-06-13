import java.util.Scanner;
public class DiceGame
{
    // instance variables:
    private Die die1;
    private Die die2;
    private boolean snakeEyes;
    private Scanner myScanner;
    private Player player;

    // constructor, no parameters; initialize
    // instance variables to default values
    public DiceGame()
    {
      die1 = null;
      die2 = null;
      snakeEyes = false;
      player = null;
      myScanner = new Scanner(System.in);
    }

     public void setPlayer(Player newPlayer)
    {
      this.player = newPlayer;
    }
    // welcome method:  welome the user, ask their name,
    // threshold, and sides; create both Die objects with sides.
    // call play method to begin game
    public void welcome()
    {
      System.out.println("Welcome to the DiceGame, " + player.getName() + ", you currently have " + player.getChips() + " chips. ");
      System.out.print("How much would you like to wager?");
      int wager = myScanner.nextInt();
      if(wager<= player.getChips())
      {
        player.setWager(wager);
      }
      else 
      {
        while(wager>player.getChips())
        {
          System.out.print("You can't wager more chips than you have. You currently have " + player.getChips() + " chips.\nPlease enter a value less than or equal to your chip count: ");
          int wagerAgain = myScanner.nextInt();
          wager = wagerAgain;
        }
        player.setWager(wager);
      }
    
    
      // else
      // {
      //   player.setWager(wager); 
      // }
      //\nEnter your name: ");
  //    String name = myScanner.nextLine();

      System.out.print("Enter your threshold: ");
      int threshold = myScanner.nextInt();
      player.setThreshold(threshold);


      //player = new Player(name, threshold);


      System.out.print("How many sides on each dice? ");
      int side = myScanner.nextInt();


      die1 = new Die(side);
      die2 = new Die(side);

      play();

    }

    // play method:  roll the dice (using rollDice method),
    // determine result (using the winningStatus method),
    // ask user to roll again, etc.
    public void play()
    {
      rollDice();

      if (winningStatus()==-1)
      {
        System.out.println("Busted. Try again.");
        //int chips = Math.abs(player.getWager()-player.chips());
       // int newChips = player.getChips();

        int chips = player.getChips();
        player.setChips(chips - player.getWager());

        // newChips = (int)(player.chips() - wager);
      
        System.out.println("You now have " + player.getChips() + " chips.");
      }
      else if (player.getCurrentTotal() < player.getThreshold())
      {
        System.out.print("Would you like to roll again? (yes(1) or no(2)): ");
        int answer = myScanner.nextInt();
        if(answer == 2)
        {
          System.out.println("Your total is " + player.getCurrentTotal() + "\nYour threshold is " + player.getThreshold());

        }
        else if (answer == 1)
        {
          rollDice();
          if (winningStatus() == -1)
          {
            System.out.println("Busted. Try again.");
            int chips = player.getChips();
            player.setChips(chips - player.getWager());   
            System.out.println("You now have " + (chips - player.getWager()) + " chips.");

          }
          else if(winningStatus() == 0)
          {
            int chips = player.getChips();
            player.setChips(chips + 20*player.getWager());
            System.out.println("Congrats! You hit the jackpot! You now have " + (chips + 20*player.getWager()) + " chips.");          
          }
          else
          {
            System.out.println("You get your money back. Try again"); 
            
          }
        }
      }
    } 

    // rollDice method
    /* Rolls each of the two dice,
     then adds the sum to currentTotal
     
     If the roller rolls doubles
     (both dice are the same number),
     add only a single die (e.g. add 5 instead
     of 10 if they roll two 5's).
     
     If the roll is snake eyes (two 1's), set
     snakeEyes to true; otherwise set it to false.
     Do NOT update the score with snake eye.
     
     Print out a message:
     - If die1 and die2 are different 
      "You rolled __ and ___"
      "Your total is ___"
      "Your threshold is ___"
     
     - If they rolled snake eyes (two 1's):
      "You rolled snake eyes!"
       
     - If they rolled any other double:
      "You rolled two ___"
      "Your total is ___"
      "Your threshold is ___"
  */
  public void rollDice()
    {
      die1.rollDie();
      die2.rollDie();

      int die1Num = die1.getRoll();
      int die2Num = die2.getRoll();

      if (die1Num==1 && die2Num==1)
      {
        snakeEyes = true;
        System.out.println("You rolled snake eyes!");
      }
      else
      {
        snakeEyes = false;
        if(die1Num == die2Num)
        {
          int current = player.getCurrentTotal();
          player.setCurrentTotal(current*2);
          System.out.println("You rolled two " + player.getCurrentTotal() + "'s");
        }
        else
        {
          int current = player.getCurrentTotal();
          player.setCurrentTotal(current + die1Num + die2Num);
          System.out.println("You rolled a " + die1Num + " and a " + die2Num);
        }
        System.out.println("Your total is " + player.getCurrentTotal() + "\nYour threshold is " + player.getThreshold());
      }
    }

    // winningStatus method
    /* Returns -1 if the user "busted" and lost the game, which
     occurs if currentTotal exceeds player's threshhold OR if the
     latest roll was snake eyes (double 1's)
     
     Returns 0 if the user "won jackpot!", which occurs
     if currentTotal is within 2 of the player's threshold, without going over
     
     Returns 1 if the user "get your money back", which occurs if the player didn't
     bust (lose), but also didn't win the jackpot (i.e. the current total is more
     than 2 away from threshold).    
   */
   public int winningStatus()
   {
     if (player.getCurrentTotal() > player.getThreshold() || snakeEyes)
     {
      return -1;
     }
     else if  (player.getThreshold() - player.getCurrentTotal() <= 2)
     {
       return 0;
     }
     else
     {
       return 1;
     }
   }
}