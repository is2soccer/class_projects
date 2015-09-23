
public class Cow extends Bovine implements Sellable{
	public Cow(){
		super("A cow is bovine that is jealous of the movie star status");
	}
	public void speak(){
		System.out.println("Help me! Some kid just tipped me");
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 2000;
	}
}
