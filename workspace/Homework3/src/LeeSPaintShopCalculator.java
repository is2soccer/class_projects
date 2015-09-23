////                                                              
//// On time 
//// Name: LEE SEUNGHWAN   date: Saturday, November 1, 2014 at 9:15:07 pm   Receipt: 1173
//// Email: is2soccer@hotmail.com
//
//		// 12/15
//		// good work overall
//		// But the computation is incorrect for 49'7'', 16'6'' and 7'7''
//		// It should give
//		/*
//		 * For this job, you need 14.477 gallons of paint. 
//		 * You will need to purchase 
//		 * 2 five-gallon containers 
//		 * 4 one-gallon containers 
//		 * 1 one half-gallon container
//		 * 
//		 * The total price is $336.40
//		 * 
//		 * Thank you for your business!
//		 */
//
//
///**
// * Compute the amount of paint needed to paint a room
// * 
// * @author SEUNGHWAN LEE
// */
//
//public class LeeSPaintShopCalculator {
//
//	// Constants
//	// Prices of the paint containers in dollars
//	public final double FIVEGALLONS = 116.00;
//
//	public final double ONEGALLON = 23.20;
//
//	public final double HALFGALLON = 11.60;
//
//	public final double QUART = 5.80;
//
//	public final double PINT = 2.90;
//
//	public final double HALFPINT = 1.45;
//
//	// Area that can be painted with one gallon of paint (in square inches)
//	public final double AREA_PER_GALLON = 25000.0;
//
//	// volume of paint needed in gallons
//	private double volume;
//
//	private double sumPrice;
//
//	/**
//	 * Initialize this LeeSPaintShopCalculator with the room measurements. For
//	 * example, if the height is 10'2'', heightFeet is 10 and heightInches is 2.
//	 * 
//	 * @param heightFeet
//	 *            the number of feet of the height measurement
//	 * @param heightInches
//	 *            the number of inches of the height measurement
//	 * @param widthFeet
//	 *            the number of feet of the width measurement
//	 * @param widthInches
//	 *            the number of inches of the width measurement
//	 * @param lengthFeet
//	 *            the number of feet of the length measurement
//	 * @param lengthInches
//	 *            the number of inches of the length measurement
//	 */
//	public LeeSPaintShopCalculator(int heightFeet, int heightInches,
//			int lengthFeet, int lengthInches, int widthFeet, int widthInches) {
//		// in inches
//		int h = heightFeet * 12 + heightInches;
//		int w = widthFeet * 12 + widthInches;
//		int l = lengthFeet * 12 + lengthInches;
//		// total area in square inches
//		int area = 2 * w * h + 2 * l * h + w * l;
//		// amount of paint needed in gallons
//		volume = area / AREA_PER_GALLON;
//	}
//
//	/**
//	 * Return as a string the result of the computation. The string should list
//	 * the exact amount of paint needed (with 3 digits after the decimal point),
//	 * the number and type of paint containers needed, and the price (with 2
//	 * digits after the decimal point). Pay attention to the spelling (container
//	 * versus containers) and the quality of the output (no 0 one gallon
//	 * container).
//	 * 
//	 * Here is an example with height=4'3'', length=5'4'' and width=6'5'':
//	 * 
//	 * For this job, you need 0.772 gallons of paint. You will need to purchase
//	 * 1 one half gallon container 1 one quart container 1 one half pint
//	 * container
//	 * 
//	 * The total price is $18.85
//	 * 
//	 * Thank you for your business!
//	 * 
//	 * 
//	 */
//	public String toString() {
//		String s = "";
//		s += String.format("For this job, you need %.3f gallons of paint.\n",
//				volume);
//		s += "\nYou need to buy the following list\n";
//		int halfPintGallon = 0;
//
//		s += calcGallon(5, " five-gallon", FIVEGALLONS);
//		s += calcGallon(1, " one-gallon", ONEGALLON);
//		s += calcGallon(0.5, " half-gallon", HALFGALLON);
//		s += calcGallon(0.25, " quart-gallon", QUART);
//		s += calcGallon(0.125, " pint-gallon", PINT);
//
//		// Half pint gallon is different from other gallons.
//		// it is needed only one when volume is left after all the calculation.
//		if (volume != 0) {
//			halfPintGallon = 1;
//			s += "	" + halfPintGallon + " half-pint container" + "\n";
//			sumPrice += HALFPINT;
//		}
//		s += String.format("	Total price is $%.2f\n", sumPrice);
//		s += "\nThank you for shopping at the Paint Shop!"; // CHANGE THIS!
//
//		return s;
//	}
//
//	/**
//	 * Calculate how many five, one, half, quart, pint, and half pint gallons
//	 * are needed for the customer. Also, calculate the total price for the
//	 * customer
//	 * 
//	 * @param n
//	 *            the number of each gallon
//	 * @param g
//	 *            the string of each gallon
//	 * @param p
//	 *            the price of each gallon
//	 * 
//	 */
//	public String calcGallon(double n, String g, double p) {
//		String s = "";
//		int r;
//		if (volume >= n) {
//			r = (int) (volume / n);
//			volume %= n;
//			sumPrice += r * p;
//			return s = "	" + r + g + " container" + ((r > 1) ? "s" : "") + "\n";
//		} else {
//			return "";
//		}
//
//	}
//}
