import java.util.Scanner;

// This program is to encrypt or decrypt the input user type in.
// User type any text consisting of 26 alphabets and blank space.
// After each encrypt the character, inner rotor rotate clockwise.
// And every 1 cycle of rotation of inner rotor, middle rotor rotate clockwise once.
// For the decrypt, steps are the same as encrypt, but reverse.
public class EnigmaMachine {

	
	private static String userText = "";
	private static String result = "";

	private static char[] outR = { ' ', 'B', 'D', 'F', 'H', 'J', 'L', 'N', 'P',
			'R', 'T', 'V', 'X', 'Z', 'A', 'C', 'E', 'G', 'I', 'K', 'M', 'O',
			'Q', 'S', 'U', 'W', 'Y' };
	private static char[] midR = { ' ', 'E', 'J', 'O', 'T', 'Y', 'C', 'H', 'M',
			'R', 'W', 'A', 'F', 'K', 'P', 'U', 'Z', 'D', 'I', 'N', 'S', 'X',
			'B', 'G', 'L', 'Q', 'V' };
	private static char[] inR = { ' ', 'G', 'N', 'U', 'A', 'H', 'O', 'V', 'B',
			'I', 'P', 'W', 'C', 'J', 'Q', 'X', 'D', 'K', 'R', 'Y', 'E', 'L',
			'S', 'Z', 'F', 'M', 'T' };

	public static void main(String[] args) {
		askFirst();

	}
	
	// First entry for asking whether encrypt or decrypt.
	// After that, ask user for the text to type in.
	// check the input user typed and encrypt or decrypt.
	private static void askFirst() {
		Scanner user_input = new Scanner(System.in);

		String answerFirst;
		System.out.print("Enter \"E\" for Encrypt Or \"D\" for Decrypt: ");
		answerFirst = user_input.next();
		if (answerFirst.toUpperCase().equals("E")) {
			Scanner user_input2 = new Scanner(System.in);
			System.out.print("Type here: ");
			userText = user_input2.nextLine();
			userText = userText.toUpperCase();
			if(inputCheck()){
				encrypt();
			}else{
				System.out.println("Wrong input, please type in only 26 alphabets and blank space.");
				askFirst();
			}
			

		} else if (answerFirst.toUpperCase().equals("D")) {
			Scanner user_input2 = new Scanner(System.in);
			System.out.print("Type here: ");
			userText = user_input2.nextLine();
			userText = userText.toUpperCase();
			userText = new StringBuffer(userText).reverse().toString();
			if(inputCheck()){
				decrypt();
			}else{
				System.out.println("Wrong input, please type in only 26 alphabets and blank space.");
				askFirst();
			}

		} else {
			System.out.println("Wrong input try again");
			askFirst();
		}
	}

	// This method is to encrypt the user input.
	// for each character in the user input, encrypts and stores in the result.
	// After each encrypt, rotate the inner rotor, and middle rotor if necessary.
	// Then, print out the result.
	private static void encrypt() {
		int turnNumber = 0;
		for (int i = 0; i < userText.length(); i++) {
			result += encryptC(userText.charAt(i));
			rotateCw(inR);
			turnNumber++;
			if (turnNumber % 27 == 0) {
				rotateCw(midR);
			}
		}
		System.out.println(result);
	}
	
	// This method is to decrypt the user input.
	// Before the decrypt, turn the inner and middle rotor clockwise if necessary.
	// for each character in the user input, decrypts and stores in the result.
	// After each decrypt, rotate the inner rotor, and middle rotor counter-clockwise if necessary.
	// Then, print out the result.
	private static void decrypt() {
		int turnNumber = 0;
		for (int i = 0; i < userText.length() - 1; i++) {
			rotateCw(inR);
			turnNumber++;
			if (turnNumber % 27 == 0) {
				rotateCw(midR);
			}
		}
		for (int j = 0; j < userText.length(); j++) {
			result += decryptC(userText.charAt(j));
			rotateCcw(inR);
			turnNumber--;
			if (turnNumber % 27 == 0 && turnNumber != 0) {
				rotateCcw(midR);
			}
		}
		System.out.println(result = new StringBuffer(result).reverse()
				.toString());

	}

	// This method is to encrypt the each character of user input.
	private static char encryptC(char c) {
		char ch = 0;
		for (int i = 0; i < inR.length; i++) {
			if (inR[i] == c) {
				for (int j = 0; j < midR.length; j++) {
					if (midR[j] == outR[i]) {
						return outR[j];
					}
				}
			}
		}
		return ch;
	}

	// This method is to decrypt the each character of user input.
	private static char decryptC(char c) {
		char ch = 0;
		for (int i = 0; i < outR.length; i++) {
			if (outR[i] == c) {
				for (int j = 0; j < outR.length; j++) {
					if (outR[j] == midR[i]) {
						return inR[j];
					}
				}
			}
		}
		return ch;
	}

	// This method is to rotate the rotor clockwise.
	private static void rotateCw(char[] c) {
		char ch = c[c.length - 1];
		for (int i = c.length - 1; i > 0; i--) {
			c[i] = c[i - 1];
		}
		c[0] = ch;
	}

	// This method is to rotate the rotor counter-clockwise.
	private static void rotateCcw(char[] c) {
		char ch = c[0];
		for (int i = 1; i < c.length; i++) {
			c[i - 1] = c[i];
		}
		c[c.length - 1] = ch;
	}
	
	// This method is to check the user input.
	// Return false if the user put a wrong input.
	// or true if the user put a right input.
	private static boolean inputCheck(){
		boolean b = true;
		for(int i = 0; i<userText.length(); i++){
			b = false;
			for(int j = 0; j< inR.length; j++){
				if(userText.charAt(i) == inR[j]){
					b = true;
					break;
				}
			}
		}
		return b;
	}
}
