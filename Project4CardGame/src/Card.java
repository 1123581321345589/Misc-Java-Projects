import java.util.Random;

public class Card implements Comparable<Card> {

private Rank aRank;
private String aName;
private int aVal;
private boolean isFlipped = false;



public Rank getaRank() {
return aRank;
}
public void setaRank(Rank cRank) {
this.aRank = cRank;
}
public String getcName() {
return aName;
}
public void setcName(String cName) {
this.aName = cName;
}
public int getcVal() {
return aVal;
}
public void setcVal(int cVal) {
this.aVal = cVal;
}



public Card(int cVal, String cName) { 

setcName(cName);
setcVal(cVal);

}


public final String toString() {
String output;
if (isFlipped()) {
output = "XX";
} else {
output = aName;
}
return output;


}

public void flip() { 
isFlipped = !isFlipped;
}

public boolean isFlipped() { 
return isFlipped;
}




/**
* @param args
*/
public void main(String[] args) {
Rank cRank = aRank;

String cName = cRank.getDisplayName(); 
setcName(cName);

int cVal = cRank.getPoints(); 
setcVal(cVal);

Comparable<Card> c = new Card(cVal, cName); 

}

@Override
public int compareTo(Card o) {

if(o.getcVal() > this.getcVal()) {
return 1;
} else if (o.getcVal() < this.getcVal()) {
return -1;
} else {
return 0;
}
}

@Override
public boolean equals(Object o) {
if(o == this) {
return true;
}

if(o == null || o.getClass() != this.getClass()) {
return false;
}

Card c = (Card) o;
return c.getcVal() == this.getcVal();
}

}


