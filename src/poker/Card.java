package poker;

public final class Card
{
  private Rank rank;
  private Suit suit;

  public Card (int n)
  {
    set (n);
  }

  public Card (String s)
  {
    set (s);
  }

  private void set (int n)
  {
    rank = new Rank (n%13);
    suit = new Suit (n/13);
  }
  private void set (String s)
  {
      s = s.trim();
      rank = new Rank (s.charAt(0));
      suit = new Suit (s.charAt(1));
  }

  public int value ()
  {
    if (suit == null || rank == null)
      return 52;
    return (suit.value()*13 + rank.value());
  }


  /** returns true if this card is less than the
   * card c.
   * The sorting criterion is (rank,suit).  That is
   * the cards are first compared in terms of rank, and then
   * in terms of suit.
   */
  public boolean lessThan (Card c)
  {
    if (c==null || c.rank==null || rank == null)
      return false;
    if (rank.lessThan (c.rank))
      return true;
    if (rank.greaterThan (c.rank))
      return false;
    if (c.suit == null || suit == null)
      return false;
    if (suit.lessThan (c.suit))
      return true;
    if (suit.greaterThan (c.suit))
      return false;
    
    // shouldn't reach here normally
    System.err.println ("identical card");
    return false;
  }

  public boolean equal (Card c)
  {
    if (c==null || c.rank==null || c.suit == null)
      return false;
    if (rank.equals (c.rank) && suit.equals (c.suit))
      return true;
    return false;
  }

  public Rank rank ()
  {
    return rank;
  }

  public Suit suit ()
  {
    return suit;
  }

  public String toString ()
  {
    if (rank == null && suit == null)
      return " ??";
    if (rank == null)
      return " ?" + suit.toString ();
    if (suit == null)
      return rank.toString () + "?";
    return rank.toString () + suit.toString ();
  }
  
  public static String getImage(Card a) {
	  String s = a.rank().toString().trim().toLowerCase() + a.suit().toString();;
	  return s;
  }
  
}

