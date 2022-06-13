public class Player
{
  private String name;
  private int userLotteryNumber;
  private int threshold;
  private int currentTotal;
  private int chips;
  private int wager;
  private int guess;


  public Player(String name)//, int userLotteryNumber)
  {
    this.name = name;
    chips = 0;
    wager = 0;
    //this.
    userLotteryNumber = 0;//userLotteryNumber;
  }


  public void setChips(int newChips)
  {
    chips= newChips;
  }

  public int getChips()
  {
    return chips;
  }

  public int getUserLotteryNumber()
  {
    return userLotteryNumber;
  }

  public String getName()
  {
    return name;
  }

  public void setUserLotteryNumber(int newUserLotteryNumber)
  {
    userLotteryNumber = newUserLotteryNumber;
  }

  public void setGuess(int newGuess)
  {
    guess = newGuess;
  }

   public int getGuess()
  {
    return guess;
  }


   public int getThreshold()
  {
    return threshold;
  }

  public void setThreshold(int num)
  {
    threshold = num;
  }

   public int getCurrentTotal()
  {
    return currentTotal;
  }

    public void setCurrentTotal(int newNum)
  {
    currentTotal= newNum;
  }

  public int getWager()
  {
    return wager;
  }

  public void setWager(int newWager)
  {
    wager= newWager;
  }
}