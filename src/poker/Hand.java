package poker;
import utils.*;
import java.util.*;


public class Hand implements Cloneable
{
  public static final int NO_PAIR               = Valuation.NO_PAIR          ;
  public static final int ONE_PAIR              = Valuation.ONE_PAIR         ;
  public static final int TWO_PAIR              = Valuation.TWO_PAIR         ;
  public static final int THREE_OF_A_KIND       = Valuation.THREE_OF_A_KIND  ;
  public static final int STRAIGHT              = Valuation.STRAIGHT         ;
  public static final int FLUSH                 = Valuation.FLUSH            ;
  public static final int FULL_HOUSE            = Valuation.FULL_HOUSE       ;
  public static final int FOUR_OF_A_KIND        = Valuation.FOUR_OF_A_KIND   ;
  public static final int STRAIGHT_FLUSH        = Valuation.STRAIGHT_FLUSH   ;

  private static final long NO_PAIR_MASK         = 0x01 << 21;
  private static final long ONE_PAIR_MASK        = 0x01 << 22;
  private static final long TWO_PAIR_MASK        = 0x01 << 23;
  private static final long THREE_OF_A_KIND_MASK = 0x01 << 24;
  private static final long STRAIGHT_MASK        = 0x01 << 25;
  private static final long FLUSH_MASK           = 0x01 << 26;
  private static final long FULL_HOUSE_MASK      = 0x01 << 27;
  private static final long FOUR_OF_A_KIND_MASK  = 0x01 << 28;
  private static final long STRAIGHT_FLUSH_MASK  = 0x01 << 29;

  
  //public static final int FLUSH_DRAW            = Valuation.FLUSH_DRAW         ;
  //public static final int STRAIGHT_DRAW         = Valuation.STRAIGHT_DRAW      ;

  public static final int NUM_HAND_CARDS	= 5;
  public static final int MAX_CARDS		=10;
  
  int _cards[];
  int _cardsDelt;
  int _intval;
  int _card_hash[];
  int _rankbits;
  int _suithash;		// need at least  4 suits * 4 bits = 16 bits
  long _Rankhash;		// need at least 13 ranks * 4 bits = 52 bits 
				// each 4 bits stores the total number of
				// cards for a particular rank
  //int _rankhash[] = new int[Rank.NUM_RANK];

  /*
   *		Various constructors and clone
   *
   *		Hand ()
   *		Hand (int, int)
   *		Hand (int [])
   *		Hand (String)
   */

  public Hand () 
  {
    _cards = new int[7];
    _cardsDelt = 0;
    _intval = 0;
    _card_hash = new int[4];
    _rankbits = 0;
    _suithash = 0;
    _Rankhash = 0;
  }

  public void copy (Hand h)
  {
    _cardsDelt      = h._cardsDelt;
    for (int i=0; i<_cardsDelt; i++)
      _cards[i]     = h._cards[i];
    _intval         = h._intval;
    for (int i=0; i<_card_hash.length; i++)
      _card_hash[i] = h._card_hash[i];
    _rankbits       = h._rankbits;
    _Rankhash       = h._Rankhash;
    _suithash       = h._suithash;
  }

  public Object clone ()
  {
    Hand h = new Hand ();
    h.copy (this);
    return h;
  }
  
  public Hand (int i, int j)
  {
    this ();

    _cards[0] = i;
    _cards[1] = j;
    _cardsDelt = 2;
  }

  public Hand (int [] c)
  {
    this ();

    if (c.length == 7)
      _cards = c;
    else
      {
	_cards = new int[7];
	for (int i=0; i<c.length; i++)
	  _cards[i] = c[i];
      }
    _cardsDelt = c.length;
  }

  /**
   * The string which is passed in must contain
   * standard character card encodings [2-9TJQK][cdhs]
   * catenated with no spaces in between.  All valid
   * input strings will have an even number of characters.
   */
  public Hand (String s)
  {
    this ();

    StringTokenizer st = new StringTokenizer (s);
    while (st.hasMoreTokens())
      {
	String str = st.nextToken();
	for (int i=0; i<str.length(); i+=2)
	  addCard (str.substring (i));
      }
  }

  /*
   *
   *	UTILITY FUNCTIONS
   *
   *
   */
  
  public boolean equals (Hand h) {
	  int[] a = this._cards.clone();
	  int[] b = h._cards.clone();
	  Arrays.sort(a);
	  Arrays.sort(b);
	  if (Arrays.equals(a, b)) {
		  return true;
	  }
	  return false;
  }

  public void setLength (int n)
  {
    _cardsDelt = n;
  }


  /*
   *
   *
   *	Simple Utilities and interfaces
   *
   *
   */

  public void addCard (int n)
  {
    if (n >= 0 && n < Deck.NUM_CARDS)
      {
	_intval = 0;
	_cardsDelt++;
	_cards[_cardsDelt-1] = n;
      }
  }

  public void addCard (Card c)
  {
    addCard (c.value());
  }

  /**
   * These functions doens't do any kind of bounds
   * checking so it's use is DANGEROUS
   */
  public void addcard (int c1)
  {
    _cards[_cardsDelt++] = c1;
  }
  public void addcards (int c1, int c2)
  {
    _cards[_cardsDelt++] = c1;
    _cards[_cardsDelt++] = c2;
  }

  public void addCard (String s)
  {
    addCard (new Card (s));
  }

  /**
   * This is an unsafe version of addHand, it does not check if the
   * card already exists in the hand.
   *
   * Normally this version should be avoided except in portions of the
   * code where fast evaluation need to occur.
   *
   * */
  public void addhand (Hand h)
  {
    try 
      {
	for (int i=0; i<h._cardsDelt; i++)
	  {
	    _cards[_cardsDelt] = h._cards[i];
	    _cardsDelt++;
	  }
      }
    catch (ArrayIndexOutOfBoundsException e)
      {
	_cardsDelt = 7;
      }
  }
  /**
   * Empty out the hand
   */
  public void clear ()
  {
    _intval = 0;
    _cardsDelt = 0;
  }

      
  /**
   * A safer version of addHand, checks for duplicate cards
   */
  public void addHand (Hand h)
  {
    if (h==null)
      return;  
    for (int i=0; i<h._cardsDelt; i++)
      {
	try
	  {
	    boolean flag_add = true;
	    for (int j=0; j<_cardsDelt; j++)
	      if (_cards[j] == h._cards[i])
		flag_add = false;
	    if (flag_add)
	      addCard (h._cards[i]);
	  }
	catch (ArrayIndexOutOfBoundsException e)
	  {
	    //System.err.println ("Hand.java : " +h + " : " + e);
	    _cardsDelt = 7;
	  }
      }
  }
  
  public int getNumCards ()
  {
    return _cardsDelt;
  }

  /**
   * return the card in position i
   */
  public Card getCard (int i)
  {
    return new Card(_cards[i]);
  }

  /**
   * return the int value of the card in position i
   */
  public int getcard (int i)
  {
    return _cards[i];
  }

  /**
   * No bounds checking !!!
   */
  public void setcards (int [] c,int n)
  {
    for (int i=0; i<n; i++)
      _cards[i] = c[i];
    _cardsDelt = n;
  }

  public String toString ()
  {
    int i = 0;
    StringBuffer sb = new StringBuffer ();
    while (i < _cards.length && i<_cardsDelt)
      {
	Card c = new Card (_cards[i]);
	if (i == _cardsDelt-1)
	  sb.append (c.toString ());
	else
	  sb.append (c.toString () + " ");
	i++;
      }
    return sb.toString ();
  }



  /*
   *
   *
   *		Old hand evaluation code.  The evaluate1
   *		function should always provide the correct
   *		answer to any evaluation.
   *
   *		The new code uses the HandEvaluator class
   *		for all evaluation.  A hook is provided
   *		below for backwards compatability.
   *
   *
   */



  /** there is an invariant that the cards in the hand
   * must be consecutivly correct [0,52) starting with _cards[0],
   *
   * The value returned is an integer value which uniuqely determines
   * the value of the hand, such that there is a total ordering on
   * all hands.
   */
  public int evaluate ()
  {
    return HandEvaluator.evaluate (this);
  }
 
  public int evaluateLow (int n)
  {
    hashCards ();		// probably wasting time here, oh well
    int hash = _card_hash[0] | _card_hash[1] | 
      _card_hash[2] | _card_hash[3];
	
    int lowcards = 0;
    int result = 0;

    // first check for the ace
    if ((hash & (0x01 << 12)) > 0)
      {
	lowcards ++;
	//result |= (0x01 << 12);
      }

    for (int i=0; i<n-1; i++)
      {
	if ((hash & (0x01 << i)) > 0)
	  {
	    lowcards ++;
	    result |= (0x01 << i);
	  }
	if (lowcards >= 5)
	  break;
      }
    if (lowcards == 5)
      {
	result ^= NO_PAIR_MASK;
	result ^= NO_PAIR << 16;
	return result;
      }
    return Valuation.NO_LOW;
  }

  private void hashCards ()
  {
    //Debug.out (".");
    // the card_hash array is sorted by suits
    if (_card_hash == null)
      _card_hash = new int [4];
    else
      _card_hash[0] = 
	_card_hash[1] = 
	_card_hash[2] = 
	_card_hash[3] = 0;

    //    	System.arraycopy (_suitzero, 0, _suithash, 0, _suitzero.length);
    //    	System.arraycopy (_rankzero, 0, _rankhash, 0, _rankzero.length);

    _suithash = 0;
    //_rankhash = new int[Rank.NUM_RANK];
    _Rankhash = 0;
//      System.out.println (this);
    for (int i=0; i<_cardsDelt; i++)
      {
	//Debug.out (_cards[i]%13 + " " +_cards[i]/13);
	int tmp_suit = _cards[i]/13;
	int tmp_rank = _cards[i]%13;
	_suithash += (0x01<<(tmp_suit*4));
	//_rankhash [(int)tmp_rank]++;
	_Rankhash += ((long)0x01<<(tmp_rank*4));
	//System.out.println (tmp_rank + " " +((long)0x01<<(tmp_rank*4)));
	_card_hash[tmp_suit] |= (0x01<<tmp_rank);
      }
//      for (int i=12; i>=0; i--)
//        System.out.print (_rankhash[i]);
//      Format.print (System.out, "\n%o\n",_Rankhash);
  }


}

