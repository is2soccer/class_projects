import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>
 * Create a candle in a graphics window
 * </p>
 * 
 * @author SEUNGHWAN LEE
 * 
 */

public class Candle {

	// Instance fields
	// The graphics window this Candle belongs to
	private GWindow window;

	// The center of this Candle
	private int x;

	private int y;

	// The scale used to draw this Candle
	private double scale;

	// Default size of a generic Candle.
	// A generic candle appears as a rectangle 25 (=size/2) wide
	// and 50 (=size) high.
	private final int SIZE = 50;

	private int flameDirection;

	private Rectangle candle;
	private Triangle flame;

	/**
	 * Creates a candle centered at location (x,y) in the GWindow window. The
	 * size of the candle is the default size times scale.
	 * 
	 * @param x
	 *            the x coordinate of the center of the candle
	 * @param y
	 *            the y coordinate of the center of the candle
	 * @param the
	 *            multiplication factor for all default sizes
	 * @param the
	 *            graphics window where to draw
	 */
	public Candle(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields (the use of this is required
		// since the instance fields have the same name as the
		// parameters of the constructor)
		this.window = window;
		this.scale = scale;
		this.x = x;
		this.y = y;
		this.draw();
		this.flameDirection = 0;
	}

	/**
	 * Draws in the graphics window a candle at location (x,y) with size =
	 * default size * scale
	 */
	private void draw() {
		// Size of this Candle
		// (int) converts to an int scale * this.size which is a double, e.g.
		// (int)23.8 is 23
		// This is necessary since the Rectangle constructor where we use
		// s takes integers.
		int s = (int) (scale * this.SIZE);

		// Select a random color for the candle
		// (int)(Math.random()*256) generates a random number between 1 and 256
		// excluded.
		// Check the documentation of the color class to see what this Color
		// constructor does.
		Color color = new Color((int) (Math.random() * 256),
				(int) (Math.random() * 256), (int) (Math.random() * 256));
		candle = new Rectangle(x - s / 4, y - s / 2, s / 2, s, color, true);

		// Add a flame ...
		flame = new Triangle(x, y - s / 2, x - s / 8, y - 3 * s / 4, x, y - s,
				Color.YELLOW, true);
		// Put the candle in the window
		window.add(candle);
		window.add(flame);
	}

	/**
	 * To do animate the flame, rotates flame every second
	 */
	public void flicker() {
		int s = (int) (scale * this.SIZE);
		flameDirection += 1;
		int a = flameDirection % 4;
		if (a == 0) {
			flame.rotateAround(x, y - s / 2, 15);
		} else if (a == 1) {
			flame.rotateAround(x, y - s / 2, 15);
		} else if (a == 2) {
			flame.rotateAround(x, y - s / 2, -15);
		} else if (a == 3) {
			flame.rotateAround(x, y - s / 2, -15);
		}
	}

	/**
	 * Erases the flame
	 */
	public void eraseFlame() {
		window.remove(candle);
		window.remove(flame);

	}

}
