// this class represents a single die
// (die is the singular form of dice)

public class Die
{
    private int sides;
    private int roll;

    public Die(int sides)
    {
        this.sides = sides;
        roll = 0;
    }

    public int getRoll()
    {
        return roll;
    }

    /* Sets roll to a random number from 1 through
        the number of sides; e.g. if sides == 6,
        then this will set roll to a random number
        between 1 and 6
    */
    public void rollDie()
    {
        roll = (int) (Math.random() * sides) + 1;
    }
}