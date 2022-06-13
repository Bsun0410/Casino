import java.util.Scanner;
public class HighOrLow 
{
  private int compNum;
  private int guess;
  private Scanner myScanner;
  private Player player;
  private int numGuesses;

  public HighOrLow()
  {
    player = null;
    compNum = 0;
    guess = 0;
    myScanner = new Scanner(System.in); 
  }

  public void setPlayer(Player newPlayer)
  {
    this.player = newPlayer;
  }

  public void begin()
  {
    System.out.println("Welcome to the High or Low, " + player.getName() + "! \nGuess the correct number in 3 tries to win 10 times the amount you wagered\nGuess the correct number in 5 tries to win twice the amount you  wagered!\nYou currently have " + player.getChips() + " chips. ");
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

    System.out.println("Welcome to Guess My Secret Number!");
    System.out.println("--------------------------------");
    int number = (int) (Math.random() * 100) + 1;
    compNum = number;
    int numGuesses = 1;

    //int guess = myScanner.nextInt();
    player.setGuess(guess);
    int compNum = (int)(Math.random()*100);


    while (guess != compNum)
    {
        System.out.print("Enter a guess: ");
        guess = myScanner.nextInt();
        
        if (guess > compNum)
        {
            System.out.println("Too high!");
            numGuesses ++;
        }
        else if (guess < compNum)
        {
            System.out.println("Too low!");
            numGuesses ++;
        }
        else
        {
            System.out.println();
            System.out.println("You guessed it! My number was " + compNum + "!\nIt took you " + numGuesses + " guesses." );
            System.out.println("\nGame over!");
        }
    }
    if(numGuesses>=1 && numGuesses<=3)
    {
      int chips = player.getChips();
      player.setChips(chips + 10*player.getWager());
      
      System.out.println("You win " + ( 10*player.getWager()) + " chips.");
    }
    else if (numGuesses > 3  && numGuesses <=5)
    {
      int chips = player.getChips();
      player.setChips(chips + 2*player.getWager());
      
      System.out.println("You win " + (2*player.getWager()) + " chips.");
    }
    else 
    {
      System.out.println("You get your money back. Try again");
      int chips = player.getChips();
      player.setChips(chips - player.getWager());
      System.out.println("You now have " + player.getChips() + " chips.");
    }
  }
}

  // public int status()
  // {
  //   if (numGuesses >= 1 && numGuesses <=3)
  //   {
  //   return -1;
  //   }
  //   else if  (numGuesses > 3  && numGuesses <=5)
  //   {
  //     return 0;
  //   }
  //   else
  //   {
  //     return 1;
  //   }
  // }

  // public void report()
  // {
  //   if(status() == -1)
  //   {
  //     player.setChips(player.getChips() + 10*player.getWager());
  //     System.out.println("You win " + player.getChips() + 10*player.getWager() + " chips.");
  //   }
  //   else if (status() == 0)
  //   {
  //     player.setChips(player.getChips() + 2*player.getWager());
  //     System.out.println("You win " + player.getChips() + 2*player.getWager() + " chips.");
  //   }
  //   else
  //   {
  //     System.out.println("You get your money back. Try again"); 

  //   }
  // }
