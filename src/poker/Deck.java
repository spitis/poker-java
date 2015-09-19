package poker;
import java.util.Random;

import org.uncommons.maths.random.XORShiftRNG;

public class Deck
{
  public static final int NUM_CARDS = 52;

  //should not be used outside the packages
  int _cards[];
  int _currentCard;
  int _cardsRemoved;
  boolean _shuffled;
  boolean _inDeck[];

  public Deck ()
  {

    _cards = new int [NUM_CARDS];
    _inDeck = new boolean [NUM_CARDS];
    for (int i=0; i<NUM_CARDS; i++)
      {
	_cards[i] = i;
	_inDeck[i] = true;
      }
    _currentCard = -1;
    _shuffled = false;
    _cardsRemoved = 0;
  }

  public int getNumCardsLeft ()
  {
    int ret = 0;
    for (int i=0; i<_inDeck.length; i++)
      if (_inDeck[i])
	ret++;
    return ret;
  }

  public void replaceAllCards ()
  {
    for (int i=0; i<NUM_CARDS; i++)
      {
	_inDeck[i] = true;
      }
  }

  /**
   * Knuth Shuffle -- O(n) where n is size of deck.  The shuffle
   * is guaranteed random if the underlying RNG is random.
   */
  public void shuffle (XORShiftRNG k)
  {
    for (int i=0; i<NUM_CARDS; i++)
      {
	int t = k.nextInt (NUM_CARDS-i) + i;
	if (t==i)
	  continue;
	int tmp   = _cards[i];
	_cards[i] = _cards[t];
	_cards[t] = tmp;
      }
    _currentCard = -1;
    _cardsRemoved = 0;
  }

  public int [] getRemainingCards ()
  {
    int cards[] = new int[NUM_CARDS - _cardsRemoved];
    int n=0;
    for (int i=0; i<NUM_CARDS; i++)
      {
	if (_inDeck[i])
	  cards[n++] = i;
      }
    return cards;
  }    

  int randomHalfIndex (int low, Random k)
  {
    int val = low + (int)Math.floor(k.nextFloat ()*NUM_CARDS/2);
    //if (val <= 0 || val >= NUM_CARDS-1) return -1;
    return val;
  }

  void subShuffle (Random k)
  {
    for (int i=0; i<NUM_CARDS/2; i++)
      {
	int t     = randomHalfIndex (NUM_CARDS/2,k);
	int tmp   = _cards[i];
	_cards[i] = _cards[t];
	_cards[t] = tmp;
      }
    for (int i=NUM_CARDS/2; i<NUM_CARDS; i++)
      {
	int t     = randomHalfIndex (0,k);
	int tmp   = _cards[i];
	_cards[i] = _cards[t];
	_cards[t] = tmp;
      }
  }

  public void removeCard (Card c)
  {
    removeCard(c.value());
  }
  
  public void replaceCard (Card c){
	  replaceCard(c.value());
  }

  public void removeCards (Hand h)
  {
    if (h == null)
      return;

    for (int i=0; i<h.getNumCards (); i++)
      removeCard (h.getCard (i));
  }
  
  public void replaceCards (Hand h){
	  if (h == null)
	      return;

	for (int i=0; i<h.getNumCards (); i++)
	replaceCard (h.getCard (i));
  }

  public void removeCard (int c)
  {
    if (c < 0 || c >= NUM_CARDS)
      return;
    _inDeck[c] = false;
    _cardsRemoved++;
  }
 
  public void replaceCard (int c) {
	 if (c < 0 || c >= NUM_CARDS)
	      return;
	 _inDeck[c] = true;
	 _cardsRemoved--;
  }

  public int nextcard ()
  {
    _currentCard++;
    if (_currentCard >= NUM_CARDS)
      return -1;

    if (_inDeck[_cards[_currentCard]])
      {
    	
	_inDeck[_cards[_currentCard]] = false;
	_cardsRemoved++;
	return _cards[_currentCard];
      }
    else 
      return nextcard ();
  }

}

