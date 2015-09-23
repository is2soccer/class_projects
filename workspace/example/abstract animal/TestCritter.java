import javax.swing.*;

public class TestCritter
{
  // Write description of and sound produced by Critter c.
  public static void writeInfo(Critter c)
  {
	  System.out.println("Dynamic type = " + c.getClass());
	  c.describe();
	  c.speak();
	  if (c instanceof Trainable){
		  Trainable t = (Trainable) c;
		  t.fetch();
	  }
	  if (c instanceof Sellable){
		  System.out.printf("price = $%.2f\n",((Sellable)c).getPrice());
	  }
	  
  }

  // Test critter classes
  public static void main(String[] args){
    // Create a poodle, a buffalo, a cow and a bird
	Critter[] a = { new Poodle(), new Cow(), new Buffalo() };
    // Call writeInfo for each critter
	for (Critter c : a){
		writeInfo(c);
		System.out.println();
	}
  }
}
