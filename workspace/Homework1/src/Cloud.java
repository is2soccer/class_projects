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

		Oval cloudLeft = new Oval(x - s / 2, y - s / 2, 3 * s / 4, 3 * s / 4,
				Color.GRAY, true);
		cloudLeft.moveBy(-s / 3, 0);
		window.add(cloudLeft);

		Oval cloudPart = new Oval(x - s / 2, y - s / 2, s, s, Color.LIGHT_GRAY,
				true);
		window.add(cloudPart);

		Oval cloudRight = new Oval(x - s / 2, y - s / 2, 4 * s / 3, 4 * s / 3,
				Color.white, true);
		cloudRight.moveBy(s / 3, 0);
		window.add(cloudRight);

	}
}