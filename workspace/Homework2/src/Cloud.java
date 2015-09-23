import uwcse.graphics.*;
import java.awt.Color;

/**
 * 
 * Create a cloud in a graphics window
 * 
 * @author SEUNGHWAN LEE
 * 
 */
public class Cloud {
	private int x;
	private int y;
	private double scale;
	private GWindow window;
	private final int SIZE = 50;

	private Oval cloudLeft, cloudPart, cloudRight;

	private int direction;

	public static final int LEFT = 1;
	public static final int RIGHT = -1;

	private int chooseColor = 0;

	/**
	 * Creates a cloud centered at location (x,y) in the GWindow window The size
	 * of the cloud is the default size times scale
	 * 
	 * @param x
	 *            the x coordinate of the center of the cloud
	 * @param y
	 *            the y coordinate of the center of the cloud
	 * @param scale
	 *            the multiplication factor for all default sizes
	 * @param window
	 *            the graphics window where to draw
	 */

	public Cloud(int x, int y, double scale, GWindow window) {
		this.scale = scale;
		this.window = window;
		this.x = x;
		this.y = y;
		this.draw();
	}

	/**
	 * Draw the cloud in the graphics window
	 */
	private void draw() {
		int s = (int) (scale * this.SIZE);

		cloudLeft = new Oval(x - s / 2, y - s / 2, 3 * s / 4, 3 * s / 4,
				Color.GRAY, true);
		cloudLeft.moveBy(-s / 3, 0);
		window.add(cloudLeft);

		cloudPart = new Oval(x - s / 2, y - s / 2, s, s, Color.LIGHT_GRAY, true);
		window.add(cloudPart);

		cloudRight = new Oval(x - s / 2, y - s / 2, 4 * s / 3, 4 * s / 3,
				Color.white, true);
		cloudRight.moveBy(s / 3, 0);
		window.add(cloudRight);

	}

	/**
	 * Create own actions: moves along the x-coordinates and keeps changing
	 * color in order at the same time
	 * 
	 * @param dx
	 *            the value changes in x coordinates
	 */
	public void doAction(int dx) {

		eraseCloud();

		if (direction == LEFT) {
			x -= dx;
		} else {
			x += dx;
		}
		if (x > window.getWindowWidth()) {
			direction = LEFT;
		}
		if (x < 0) {
			direction = RIGHT;
		}
		draw();

		int a = chooseColor % 3;

		if (a == 0) {
			cloudLeft.setColor(Color.DARK_GRAY);
			cloudPart.setColor(Color.gray);
			cloudRight.setColor(Color.white);
		} else if (a == 1) {
			cloudLeft.setColor(Color.WHITE);
			cloudPart.setColor(Color.DARK_GRAY);
			cloudRight.setColor(Color.GRAY);
		} else if (a == 2) {
			cloudLeft.setColor(Color.GRAY);
			cloudPart.setColor(Color.WHITE);
			cloudRight.setColor(Color.DARK_GRAY);
		}
		chooseColor += 1;
	}

	/**
	 * Erases the cloud
	 */
	public void eraseCloud() {
		window.remove(cloudLeft);
		window.remove(cloudPart);
		window.remove(cloudRight);

	}
}