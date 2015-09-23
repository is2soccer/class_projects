
public class Dog {
	private String name;
	private boolean isHungry;
	private String prevFood;
	private int count;
	
	public Dog(String name){
		this.name = name;
		this.isHungry = true;
	
	}
	
	public void bark(){
		if (isHungry){
			System.out.println("WOOF");
		}else{
			System.out.println("woof");
		}
	}
	
	public void eat(String food){
		if (isHungry){
			if (!food.equals(prevFood)){
				prevFood = food;
				isHungry = false;
				count = 0;
				
			}else{
				System.out.println("i dont want same food");
			}
		}else{
			System.out.println("I am not hungry");
		}
	}
	public void fetch(){
		if (isHungry){
			System.out.println("I am hungry bitch");
			
		}else{
			System.out.println("Let's play fetch");
			count++;
			if (count == 5){
				isHungry = true;
			}
		}
	
	}
	
	public void rollOver(){
		if (isHungry){
			System.out.println("Im hungry");
			
		}else{
			System.out.println("Let's play roll over");
			count++;
			if (count == 5){
				isHungry = true;
			}
		}
	}
}
