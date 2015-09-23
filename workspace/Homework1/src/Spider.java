import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>
 * Create a spider in a graphics window
 * </p>
 * 
 * @author SEUNGHWAN LEE
 */

public class Spider {
	private int x;
	private int y;
	private double scale;
	private GWindow window;
	private final int SIZE = 50;

	// Your instance fields go here

	/**
	 * Creates a spider centered at location (x,y) in the GWindow window. The
	 * size of the spider is the default size times scale.
	 * 
	 * @param x
	 *            the x coordinate of the center of the spider
	 * @param y
	 *            the y coordinate of the center of the spider
	 * @param scale
	 *            the multiplication factor for all default sizes
	 * @param window
	 *            the graphics window where to draw
	 */
	public Spider(int x, int y, double scale, GWindow window) {
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		this.draw();

	}

	/**
	 * Draws in the graphics window a spider at location (x,y) with size =
	 * default size * scale
	 */
	private void draw() {
		int s = (int) (scale * this.SIZE);

		Line web = new Line(x, y, x, 0, Color.GRAY);
		window.add(web);

		Line leg1 = new Line(x - s, y, x + s, y, Color.GRAY);
		window.add(leg1);

		Line leg2 = new Line(x - s, y, x + s, y, Color.gray);
		leg2.rotateAround(x, y, 45);
		window.add(leg2);

		Line leg3 = new Line(x - s, y, x + s, y, Color.gray);
		leg3.rotateAround(x, y, -45);
		window.add(leg3);

		Oval body = new Oval(x - s / 2, y - s / 2, s, s, Color.gray, true);
		window.add(body);

		Oval head = new Oval(x - s / 2, y - s / 2, s / 2, s / 2, Color.gray,
				true);
		head.moveBy(s / 4, -s / 4);
		window.add(head);
	}
}