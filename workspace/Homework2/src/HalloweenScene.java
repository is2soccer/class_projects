import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class  

/**
 * <p>
 * A HalloweenScene displays pumpkins, candles, spiders and a fourth element of
 * your choice in a graphics window
 * </p>
 * Add a line to declare an instance field of type the new type that you defined
 * in hw1, then complete the method addGraphicsElements. Leave all the rest of
 * the code unchanged.
 * 
 * @author SEUNGHWAN LEE
 */

public class HalloweenScene extends GWindowEventAdapter {
	/** The graphics window that displays the picture */
	private GWindow window;

	/** The elements in the picture */
	// the spider that moves up and down
	private Spider spider1, spider2, spider3, spider4;

	// 2 pumpkins: one flashes, the other increases or decreases in size
	private Pumpkin flashingPumpkin1, changingPumpkin1, flashingPumpkin2,
			changingPumpkin2, flashingPumpkin3, changingPumpkin3;

	// A candle that flickers
	private Candle candle1, candle2, candle3, candle4;

	// Add here the declaration of an instance field of the type that you
	// created in hw1
	// YOU MUST NAME THIS VARIABLE: myElement. Thus your statement should be
	// (replacing
	// classname with the name of your class)
	private Cloud myElement1, myElement2, myElement3;

	// To keep track of the duration of the animation
	private int animationCounter;

	/**
	 * Create a picture
	 */
	public HalloweenScene() {
		// The graphics window
		this.window = new GWindow("Halloween scene");
		this.window.setExitOnClose();

		// paint the background
		Rectangle bgnd = new Rectangle(0, 0, this.window.getWindowWidth(),
				this.window.getWindowHeight(), Color.black, true);
		this.window.add(bgnd);
		this.window.doRepaint();

		// Add the graphics elements
		this.addGraphicsElements();

		// Code to do the animation
		this.window.addEventHandler(this);
		this.window.startTimerEvents(150);
	}

	/**
	 * To do the animation
	 */
	public void timerExpired(GWindowEvent we) {
		this.window.suspendRepaints();

		this.candle1.flicker();
		this.candle2.flicker();
		this.candle3.flicker();
		this.candle4.flicker();

		this.spider1.move(10);
		this.spider2.move(5);
		this.spider3.move(6);
		this.spider4.move(8);

		this.flashingPumpkin1.flipEyeNoseMouthColor();
		this.changingPumpkin1.changeSize();
		this.flashingPumpkin2.flipEyeNoseMouthColor();
		this.changingPumpkin2.changeSize();
		this.flashingPumpkin3.flipEyeNoseMouthColor();
		this.changingPumpkin3.changeSize();

		this.myElement1.doAction(10);
		this.myElement2.doAction(5);
		this.myElement3.doAction(7);

		this.window.resumeRepaints();

		// Run the animation 100 times (about 15 s)
		this.animationCounter++;
		if (this.animationCounter >= 100)
			this.window.stopTimerEvents();
	}

	/**
	 * Instantiate in this method the elements of the scene. This is the only
	 * method that you need to modify in this class
	 */
	private void addGraphicsElements() {
		// You can change the coordinates and scales that appear
		// in the constructors (but don't change the names of the variables)

		this.candle1 = new Candle(100, 70, 1.8, this.window);
		this.candle2 = new Candle(200, 140, 1, this.window);
		this.candle3 = new Candle(300, 210, 0.8, this.window);
		this.candle4 = new Candle(400, 300, 1.2, this.window);

		this.spider1 = new Spider(100, 100, 1, this.window);
		this.spider2 = new Spider(200, 100, 1.2, this.window);
		this.spider3 = new Spider(340, 250, 0.8, this.window);
		this.spider4 = new Spider(400, 10, 1, this.window);

		// Complete the line of code below to instantiate an object of the type
		// that you created in homework #1
		this.myElement1 = new Cloud(50, 50, 1.2, this.window);
		this.myElement2 = new Cloud(200, 200, 0.8, this.window);
		this.myElement3 = new Cloud(450, 380, 1, this.window);

		this.flashingPumpkin1 = new Pumpkin(10, 70, 0.8, this.window);
		this.changingPumpkin1 = new Pumpkin(430, 120, 0.6, this.window);
		this.flashingPumpkin2 = new Pumpkin(150, 300, 1.2, this.window);
		this.changingPumpkin2 = new Pumpkin(370, 10, 1.5, this.window);
		this.flashingPumpkin3 = new Pumpkin(180, 110, 1, this.window);
		this.changingPumpkin3 = new Pumpkin(90, 380, 1, this.window);
	}

	/**
	 * Entry point of the program
	 */
	public static void main(String[] args) {
		new HalloweenScene();
	}

}