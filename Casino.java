import java.util.Scanner;
public class Casino
{
  private Player player1;
  private Player player2;
  private Player currentPlayer;

  private Lottery lotteryGame;
  private Scanner scanner;

  private DiceGame diceGame;

  private HighOrLow highorlow;


  public Casino()
  {
    player1 = null;
    player2 = null;
    currentPlayer = null;

    lotteryGame = new Lottery();
    diceGame = new DiceGame();
    highorlow = new HighOrLow();
    scanner = new Scanner(System.in);
  }

  public void start()
  {
    System.out.println("Welcome to the Casino!\n");
    System.out.print("What is Player 1's name?");
    String name1 = scanner.nextLine();
    player1 = new Player(name1);

    System.out.print("What is Player 2's name?");
    String name2 = scanner.nextLine();
    player2 = new Player(name2);

    int initialChips = 0;
    player2.setChips(initialChips);
    player1.setChips(initialChips);

    System.out.print("How many chips does " + player1.getName() + " want?");
    int chips1 = scanner.nextInt();
    player1.setChips(chips1);

    System.out.print("How many chips does " + player2.getName() + " want?");
    int chips2 = scanner.nextInt();
    player2.setChips(chips2);

//assigns player1 to go first
    currentPlayer = player1;
    mainMenu();
  }

  public void mainMenu()
  {
    boolean play = true;
    while (play)
    {
      System.out.println();
      if(currentPlayer.getChips()>0)
      {
        System.out.println("-- Game Menu --");
        System.out.println("1. Play Lottery");
        System.out.println("2. Play Lucky Dice Game");
        System.out.println("3. Play High or Low");
        System.out.println("4. Change Player");
        System.out.println("5. Quit");
        System.out.println(player1.getName() + " has " + player1.getChips() + " chips");
        //currentPlayer = player2;
        System.out.println(player2.getName() + " has " + player2.getChips() + " chips");
        //currentPlayer = player1;

        int game = scanner.nextInt();

        if(game==1)
        {
          lotteryGame.setPlayer(currentPlayer);
          lotteryGame.start();
        }
        else if (game==2)
        {
          diceGame.setPlayer(currentPlayer);
          diceGame.welcome();
        }
        else if(game==3)
        {
          highorlow.setPlayer(currentPlayer);
          highorlow.begin();
        }
        else if(game==4)
        {
          if (currentPlayer.equals(player1))
          {
            currentPlayer = player2;
            System.out.println("Welcome, " + currentPlayer.getName());
          }
          else
          {
            currentPlayer = player1;
            System.out.println("Welcome, " + currentPlayer.getName());
          }
        }
        else if(game==5)
        {
          System.out.println("Thanks for coming. Goodbye!");
          break;
        }
        System.out.println("Goodbye");
      }
      else if (currentPlayer.getChips() == 0)
      {
        System.out.println("Sorry, " + currentPlayer.getName() + ", you are out of chips! Either switch players(1) or quit(2)!");
        int decision = scanner.nextInt();
        if(decision==1)
        {
          if (currentPlayer.equals(player1))
          {
            currentPlayer = player2;
            System.out.println("Welcome, " + currentPlayer.getName());
          }
          else
          {
            currentPlayer = player1;
            System.out.println("Welcome, " + currentPlayer.getName());
          }
        }
        else if(decision==2)
        {
          break;
        }
      }
    }
  }
}
