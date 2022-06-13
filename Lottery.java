import java.util.Scanner;
public class Lottery
{
  private int lotteryNumber;
  private Player player;
  private Scanner myScanner;

  public Lottery()
  {
    player = null;
    lotteryNumber = 0;//(int)(Math.random()*100);
    myScanner = new Scanner(System.in);
  }

  public void setPlayer(Player newPlayer)
  {
    this.player = newPlayer;
  }
  
  public void start()
  {
    System.out.println("Welcome to the Lottery, " + player.getName() + ", you currently have " + player.getChips() + " chips. ");
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
  //  System.out.print("Enter your name: ");
  //  String name = scan.nextLine();

    System.out.print("Please choose a number between 0-99: ");
    int num = myScanner.nextInt();

    player.setUserLotteryNumber(lotteryNumber);
    lotteryNumber = (int)(Math.random()*100);

   // player = new Player(name, lotteryNumber);

    int tens =  (num % 100)/ 10;
    int ones = (num % 100) % 10;
    int tens2 =  (lotteryNumber % 100)/ 10;
    int ones2 = (lotteryNumber % 100) % 10;
    int reverse = (ones + tens);
    
    if(lotteryNumber==num)
    {
      System.out.println("The lottery number is " + lotteryNumber);
      System.out.println("Exact match! You win $100");
      int chips = player.getChips();
      player.setChips(chips + 100*player.getWager());
      System.out.println("You now have " + (chips + 100*player.getWager()) + " chips."); 
    }
    else if(lotteryNumber == reverse)
    {
      System.out.println("The lottery number is " + lotteryNumber);
      System.out.println("Correct digits, but not in correct order. You win $10");
      int chips = player.getChips();
      player.setChips(chips + 10*player.getWager());
      System.out.println("You now have " + (chips + 10*player.getWager()) + " chips."); 
    }
    else if(tens==tens2 || tens ==ones2 || tens2==ones || ones2==tens)
    {
      System.out.println("The lottery number is " + lotteryNumber);
      System.out.println("One digit correct. You win $3");
      int chips = player.getChips();
      player.setChips(chips + 3*player.getWager());
      System.out.println("You now have " + (chips + 3*player.getWager()) + " chips."); 
    }
    else
    {
      int chips = player.getChips();
      player.setChips(chips - player.getWager());
      System.out.println("You now have " + (chips - player.getWager()) + " chips."); 

      System.out.println("No matching digits; You win nothing, " + player.getName());
    } 

  }
    
}