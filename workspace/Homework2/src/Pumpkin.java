import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>
 * Create a pumpkin in a graphics window
 * </p>
 * 
 * @author SEUNGHWAN LEE
 */

public class Pumpkin {
	private int x;
	private int y;
	private double scale;
	private GWindow window;
	private final int SIZE = 100;

	// Your instance fields go here
	private Oval face;
	private Rectangle stalk;
	private Triangle leftEye, rightEye, nose, mouth;

	private double factor = 1.1;

	/**
	 * Creates a pumpkin centered at location (x,y) in the GWindow window. The
	 * size of the pumpkin is the default size times scale.
	 * 
	 * @param x
	 *            the x coordinate of the center of the pumpkin
	 * @param y
	 *            the y coordinate of the center of the pumpkin
	 * @param scale
	 *            the multiplication factor for all default sizes
	 * @param window
	 *            the graphics window where to draw
	 */
	public Pumpkin(int x, int y, double scale, GWindow window) {
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		this.draw();
	}

	/**
	 * Draws in the graphics window a pumpkin at location (x,y) with size =
	 * default size * scale
	 */
	private void draw() {
		int s = (int) (scale * this.SIZE);

		stalk = new Rectangle(x - s / 20, y - 7 * s / 10, s / 10, s / 5,
				Color.gray, true);
		window.add(stalk);

		face = new Oval(x - s / 2, y - s / 2, s, s, Color.orange, true);
		window.add(face);

		leftEye = new Triangle(x - 4 * s / 10, y - s / 4, x - 3 * s / 10, y + s
				/ 4, x - 2 * s / 10, y - s / 4, Color.yellow, true);
		window.add(leftEye);

		rightEye = new Triangle(x + 4 * s / 10, y - s / 4, x + 3 * s / 10, y
				+ s / 4, x + 2 * s / 10, y - s / 4, Color.yellow, true);
		window.add(rightEye);

		nose = new Triangle(x - 2 * s / 10, y + s / 4, x, y, x + 2 * s / 10, y
				+ s / 4, Color.yellow, true);
		window.add(nose);

		mouth = new Triangle(x - 3 * s / 8, y + 2 * s / 6, x, y + 3 * s / 8, x
				+ 3 * s / 8, y + 2 * s / 6, Color.yellow, true);
		window.add(mouth);

	}
	/**
	 * Changes the colors of eyes, nose, and mouth
	 */
	public void flipEyeNoseMouthColor() {
		Color color;
		if (leftEye.getColor() == Color.yellow) {
			color = Color.RED;
		} else {
			color = Color.yellow;
		}
		leftEye.setColor(color);
		rightEye.setColor(color);
		mouth.setColor(color);
		nose.setColor(color);

	}
	/**
	 * Erases the pumpkin
	 */
	public void erasePumpkin() {
		window.remove(face);
		window.remove(leftEye);
		window.remove(rightEye);
		window.remove(nose);
		window.remove(stalk);
		window.remove(mouth);
	}

	/**
	 * Changes the size of the pumpkin
	 */
	public void changeSize() {
		scale *= factor;
		erasePumpkin();
		draw();
		if (scale > 2 || scale < 0.5) {
			factor = 1 / factor;
		}
	}

}