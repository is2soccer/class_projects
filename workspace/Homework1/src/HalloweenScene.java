import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>
 * A HolloweenScene displays pumpkins, candles, spiders and a fourth element of
 * your choice in a graphics window
 * </p>
 * 
 * @author SEUNGHWAN LEE
 */

public class HalloweenScene {

	/** The graphics window that displays the picture */
	private GWindow window;

	/**
	 * Creates a picture
	 */
	public HalloweenScene() {

		// The graphics window
		// The window is by default 500 wide and 400 high
		this.window = new GWindow("Halloween scene");
		this.window.setExitOnClose(); // so that a click on the close box of
		// the
		// window terminates the application

		// Background (black here)
		Rectangle bgnd = new Rectangle(0, 0, window.getWindowWidth(),
				window.getWindowHeight(), Color.black, true);
		this.window.add(bgnd);

		// Create the scene elements
		// e.g. a candle in the lower area 1.5 times the normal size

		new Cloud(120, 20, 0.8, this.window);
		new Cloud(190, 250, 1, this.window);
		new Cloud(350, 80, 1.5, this.window);
		new Cloud(100, 400, 1, this.window);

		new Spider(290, 300, 1, this.window);
		new Spider(25, 340, 0.5, this.window);
		new Spider(100, 100, 0.5, this.window);
		new Spider(480, 200, 1.5, this.window);

		new Candle(100, 300, 1.5, this.window);
		new Candle(200, 400, 2, this.window);
		new Candle(390, 200, 1, this.window);
		new Candle(50, 50, 1.2, this.window);
		new Candle(320, 230, 0.8, this.window);

		new Pumpkin(100, 180, 0.8, this.window);
		new Pumpkin(400, 340, 1.2, this.window);
		new Pumpkin(245, 123, 1.5, this.window);
		new Pumpkin(500, 31, 1, this.window);

	}

	// entry point of the application
	public static void main(String[] args) {
		new HalloweenScene();
	}
}
