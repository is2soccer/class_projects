public class Car{

   private String name;

   private int age;

   private String breed;

   public Car(String n, int a, String b){

      name = n;

      age = a;

      breed = b;

   }

   public Car(){

      name = "Spot";

      age = 1;

      breed = "mutt and 2";

   }
   public static void main(String[] args) {
		Car c = new Car("S", 1, "S");
		System.out.println(c);

   }
   public void setName(String n){

	    name = n;

   }

   public void gettingOld(){

	    age += 1;

   }

   public void satBreed(String b){

	    breed = b;

	   }
   public String toString(){

		return "Name: "+name+", Age: "+age+", Breed: "+breed;
   }
}