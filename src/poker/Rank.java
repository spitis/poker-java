package poker;

final class Rank
{
  static final int NUM_RANK = 13;
  static final char ACE =   'A';
  static final char TWO =   '2';
  static final char THREE = '3';
  static final char FOUR =  '4';
  static final char FIVE =  '5';
  static final char SIX =   '6';
  static final char SEVEN = '7';
  static final char EIGHT = '8';
  static final char NINE =  '9';
  static final char TEN =   'T';
  static final char JACK =  'J';
  static final char QUEEN = 'Q';
  static final char KING =  'K';

  private int _val;

  Rank (char c)
  {
      switch (c)
	  {
	  case TWO:
	      _val = 0;
	      break;
	  case THREE:
	      _val = 1;
	      break;
	  case FOUR: 
	      _val = 2;
	      break;
	  case FIVE: 
	      _val = 3;
	      break;
	  case SIX:
	      _val = 4;
	      break;
	  case SEVEN:
	      _val = 5;
	      break;
	  case EIGHT:
	      _val = 6;
	      break;
	  case NINE: 
	      _val = 7;
	      break;
	  case 'T':
	  case 't':
	      _val = 8;
	      break;
	  case 'J': 
	  case 'j': 
	      _val = 9;
	      break;
	  case 'Q':
	  case 'q':
	      _val = 10;
	      break;
	  case 'K': 
	  case 'k': 
	      _val = 11;
	      break;
	  case 'A':
	  case 'a':
	      _val = 12;
	      break;
	  default:
	      _val = -1;
	  }
      //Debug.out (_val);
  }

  Rank (int n)
  {
    if (n >= 0 && n < NUM_RANK)
      _val = n;
    else
      _val = 0;
  }

  Rank (Rank r)
  {
    _val = r._val;
  }

  boolean lessThan (Rank r)
  {
    if (_val < r._val)
      return true;
    return false;
  }

  boolean greaterThan (Rank r)
  {
    if (_val > r._val)
      return true;
    return false;
  }

  boolean equals (Rank r)
  {
    if (_val == r._val)
      return true;
    return false;
  }

  int value ()
  {
    return _val;
  }

  public String toString ()
  {
    char ret[] = new char[2];

    switch (_val)
      {
      case 0:
	ret [1] = TWO;
	break;
      case 1:
	ret [1] = THREE;
	break;
      case 2:
	ret [1] = FOUR;
	break;
      case 3:
	ret [1] = FIVE;
	break;
      case 4:
	ret [1] = SIX;
	break;
      case 5:
	ret [1] = SEVEN;
	break;
      case 6:
	ret [1] = EIGHT;
	break;
      case 7:
	ret [1] = NINE;
	break;
      case 8:
	ret [1] = TEN;
	break;
      case 9:
	ret [1] = JACK;
	break;
      case 10:
	ret [1] = QUEEN;
	break;
      case 11:
	ret [1] = KING;
	break;
      case 12:
	ret [1] = ACE;
	break;
      }
    ret[0] = ' ';
    return new String (ret,1,1);
  }

}

