import java.util.Scanner;

abstract public class GenericPlayer extends Hand {
protected String name;
protected boolean isBusted;

public GenericPlayer(String name) {
super();
this.name = name;
isBusted = false;
}

public boolean isBusted() { 
return isBusted;
}

public void busted() { 
isBusted = true;
System.out.printf("%s: Busted!", name);
}

public void win() { 
System.out.printf("%s: Wins!", name);
}

public void push() { 
System.out.printf("%s: Pushed!", name);
}

public void lost() { 
System.out.printf("%s: Lost!", name);
}

public String toString() {
return String.format("%s: %s", name, super.toString());
}

abstract public boolean isHitting(Scanner input);
}


