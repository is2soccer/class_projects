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
	private Line web, leg1, leg2, leg3;
	private Oval body, head;

	private int direction;

	public static final int UP = -1;
	public static final int DOWN = 1;

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
	 * Move the spider up and down
	 * 
	 * @param dy
	 *            the value changes in y coordinates
	 */
	public void move(int dy) {
		eraseSpider();

		if (direction == UP) {
			y -= dy;
		} else {
			y += dy;
		}
		if (y > window.getWindowHeight()) {
			direction = UP;
		}

		if (y < 0) {
			direction = DOWN;
		}
		draw();
	}

	/**
	 * Erases the spider
	 */
	private void eraseSpider() {
		window.remove(web);
		window.remove(leg1);
		window.remove(leg2);
		window.remove(leg3);
		window.remove(body);
		window.remove(head);

	}

	/**
	 * Draws in the graphics window a spider at location (x,y) with size =
	 * default size * scale
	 */
	private void draw() {
		int s = (int) (scale * this.SIZE);

		web = new Line(x, y, x, 0, Color.GRAY);
		window.add(web);

		leg1 = new Line(x - s, y, x + s, y, Color.GRAY);
		window.add(leg1);

		leg2 = new Line(x - s, y, x + s, y, Color.gray);
		leg2.rotateAround(x, y, 45);
		window.add(leg2);

		leg3 = new Line(x - s, y, x + s, y, Color.gray);
		leg3.rotateAround(x, y, -45);
		window.add(leg3);

		body = new Oval(x - s / 2, y - s / 2, s, s, Color.gray, true);
		window.add(body);

		head = new Oval(x - s / 2, y - s / 2, s / 2, s / 2, Color.gray, true);
		head.moveBy(s / 4, -s / 4);
		window.add(head);
	}
}