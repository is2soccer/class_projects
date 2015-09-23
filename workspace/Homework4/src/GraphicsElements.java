import java.awt.Color;
import java.util.*;
import java.awt.Point;
import uwcse.io.*;
import uwcse.graphics.*;
import javax.swing.*;

/**
 * A class to create and manipulate graphics elements stored in an ArrayList
 * @author SEUNGHWAN LEE
 */

public class GraphicsElements {

	/** Maximum number of wedges in a pie */
	public static final int MAXIMUM_NUMBER_OF_PIE_WEDGES = 100;

	/** Maximum number of stripes of one color in the pattern of stripes */
	public static final int MAXIMUM_NUMBER_OF_STRIPES = 15;

	/** Maximum number of divisions in a Koch snow flake */
	public static final int MAXIMUM_NUMBER_OF_DIVISIONS = 5;

	// The window is 400 pixels wide and 300 pixels high

	/**
	 * Create the view of a pie Use filled arcs. The color of each arc is
	 * random. The pie should fill the window. Store the arcs in an ArrayList
	 * and return that ArrayList. The number of pie wedges (= arcs) is given by
	 * the user (use a dialog box). If that number is less than or equal to 0 or
	 * greater than MAXIMUM_NUMBER_OF_PIE_WEDGES, display an error message (use
	 * JOptionPane.showMessageDialog)and ask for it again. Make sure that no gap
	 * appears in the pie when drawing it.
	 */
	public ArrayList<Arc> createAPie() {

		Input in = new Input();
		int n;
		do {
			n = in.readIntDialog("Enter the number of wedges (between 1 and "
					+ MAXIMUM_NUMBER_OF_PIE_WEDGES + ")");
			if (n < 1 || n > MAXIMUM_NUMBER_OF_PIE_WEDGES) {
				JOptionPane.showMessageDialog(null, "Invalid number",
						"Input error", JOptionPane.WARNING_MESSAGE);
			}
		} while (n < 1 || n > MAXIMUM_NUMBER_OF_PIE_WEDGES);

		ArrayList<Arc> graphicsList = new ArrayList<Arc>();

		int startAngle = 0;
		int angle = 0;
		int r, g, b;
		Random rand = new Random();
		Color color;

		for (int i = 0; i < n; i++) {
			if (i < 360 % n) {
				angle = 360 / n + 1;
			} else {
				angle = 360 / n;
			}

			r = rand.nextInt(256);
			g = rand.nextInt(256);
			b = rand.nextInt(256);
			color = new Color(r, g, b);
			graphicsList.add(new Arc(ViewWindow.WINDOW_WIDTH / 2
					- ViewWindow.WINDOW_HEIGHT / 2, 0,
					ViewWindow.WINDOW_HEIGHT, ViewWindow.WINDOW_HEIGHT,
					startAngle, angle, color, true));
			startAngle += angle;

		}

		return graphicsList;
	}

	/**
	 * Create a pattern of stripes as shown in the homework instructions. Store
	 * the triangles in an ArrayList and return that ArrayList. Use two colors
	 * only to paint the triangles. The pattern should cover most of the window.
	 * The number of stripes (of one color) is given by the user (use a dialog
	 * box). If that number is less than or equal to 0 or greater than
	 * MAXIMUM_NUMBER_OF_STRIPES, display an error message (use
	 * JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Triangle> createStripes() {
		Input in = new Input();
		int n;
		do {
			n = in.readIntDialog("Enter the number of each color of stripes (between 1 and "
					+ MAXIMUM_NUMBER_OF_STRIPES + ")");
			if (n < 1 || n > MAXIMUM_NUMBER_OF_STRIPES) {
				JOptionPane.showMessageDialog(null, "Invalid number",
						"Input error", JOptionPane.WARNING_MESSAGE);
			}
		} while (n < 1 || n > MAXIMUM_NUMBER_OF_STRIPES);

		ArrayList<Triangle> graphicsList = new ArrayList<Triangle>();
		int d = 300 / n;
		boolean c = true;
		Color c1 = Color.YELLOW;
		Color c2 = Color.BLUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c) {
					c1 = Color.YELLOW;
					c2 = Color.BLUE;
				} else {
					c1 = Color.BLUE;
					c2 = Color.YELLOW;
				}
				Triangle up = new Triangle(50 + d * i, d * j, 50 + d + d * i, d
						* j, 50 + d + d * i, d + d * j, c1, true);
				Triangle down = new Triangle(50 + d * i, d * j, 50 + d * i, d
						+ d * j, 50 + d + d * i, d + d * j, c2, true);
				graphicsList.add(up);
				graphicsList.add(down);
				c = !c;
			}
			if (i / 2 * 2 != i) {
				c = true;
			} else {
				c = false;
			}
		}

		return graphicsList;
	}

	/**
	 * Create a Koch snow flake. Use the class java.awt.Point. Store the Points
	 * in an ArrayList and return that ArrayList. Note that you can't set the
	 * color of a point. The initial color of the lines making up the snow flake
	 * is black. But, you can change the color in the method
	 * changeColorOfSnowFlake below. The snow flake should cover most of the
	 * window, and be always visible. The number of divisions of the initial
	 * triangle is given by the user (use a dialog box). If that number is less
	 * than 0 or greater than MAXIMUM_NUMBER_OF_DIVISIONS, display an error
	 * message (use JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Point> createASnowFlake() {
		Input in = new Input();
		int n;
		do {
			n = in.readIntDialog("Enter the number of divisions (between 0 and "
					+ MAXIMUM_NUMBER_OF_DIVISIONS + ")");
			if (n < 0 || n > MAXIMUM_NUMBER_OF_DIVISIONS) {
				JOptionPane.showMessageDialog(null, "Invalid number",
						"Input error", JOptionPane.WARNING_MESSAGE);
			}
		} while (n < 0 || n > MAXIMUM_NUMBER_OF_DIVISIONS);

		ArrayList<Point> graphicsList = new ArrayList<Point>();
		// Create the original triangle
		Point p1 = new Point(200, 0);
		Point p2 = new Point(350, 220);
		Point p3 = new Point(50, 220);
		graphicsList.add(p1);
		graphicsList.add(p2);
		graphicsList.add(p3);
		// Add your code here
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < graphicsList.size(); i += 4) {
				Point p = graphicsList.get(i);
				Point q = graphicsList.get((i + 1) % graphicsList.size());

				Point a = new Point((int) (p.x + (q.x - p.x) / 3.0),
						(int) (p.y + (q.y - p.y) / 3.0));
				Point c = new Point((int) (p.x + 2 * (q.x - p.x) / 3.0),
						(int) (p.y + 2 * (q.y - p.y) / 3.0));
				Point b = new Point();

				b.x = (int) (a.x + (c.x - a.x) * Math.cos(Math.PI / 3.0) + (c.y - a.y)
						* Math.sin(Math.PI / 3.0));
				b.y = (int) (a.y - (c.x - a.x) * Math.sin(Math.PI / 3.0) + (c.y - a.y)
						* Math.cos(Math.PI / 3.0));
				graphicsList.add(i + 1, c);
				graphicsList.add(i + 1, b);
				graphicsList.add(i + 1, a);
			}
		}
		return graphicsList;
	}

	/**
	 * Rotate the colors in the pie, in a clockwise direction. Precondition:
	 * graphicsList describes a pie Return the updated ArrayList
	 */
	public ArrayList<Arc> rotateColorsInPie(ArrayList<Arc> graphicsList) {
		ArrayList<Arc> newGraphicsList = new ArrayList<Arc>();
		int startAngle = 0;
		int angle = 0;
		Arc first = graphicsList.get(0);
		for (int i = 0; i < graphicsList.size() - 1; i++) {
			if (i < 360 % graphicsList.size()) {
				angle = 360 / graphicsList.size() + 1;
			} else {
				angle = 360 / graphicsList.size();
			}
			Arc a = graphicsList.get(i + 1);
			Arc b = new Arc(ViewWindow.WINDOW_WIDTH / 2
					- ViewWindow.WINDOW_HEIGHT / 2, 0,
					ViewWindow.WINDOW_HEIGHT, ViewWindow.WINDOW_HEIGHT,
					startAngle, angle, a.getColor(), true);
			newGraphicsList.add(b);
			startAngle += angle;
		}
		Arc last = new Arc(ViewWindow.WINDOW_WIDTH / 2
				- ViewWindow.WINDOW_HEIGHT / 2, 0, ViewWindow.WINDOW_HEIGHT,
				ViewWindow.WINDOW_HEIGHT, startAngle, angle, first.getColor(),
				true);
		newGraphicsList.add(last);

		return newGraphicsList;
	}

	/**
	 * Flip the 2 colors of the pattern of stripes Precondition: graphicsList
	 * describes a pattern of stripes Return the updated ArrayList
	 */
	public ArrayList<Triangle> flipColorsInStripes(
			ArrayList<Triangle> graphicsList) {
		for (int i = 0; i < graphicsList.size(); i++) {
			Triangle t = graphicsList.get(i);
			Color c1 = t.getColor();
			if (c1 == Color.YELLOW) {
				c1 = Color.BLUE;
			} else {
				c1 = Color.YELLOW;
			}
			t.setColor(c1);
			graphicsList.set(i, t);
		}

		return graphicsList;
	}

	/**
	 * Return the new color of the snow flake (select a new random color) Use
	 * the Random class (in java.util) to select the new random color. The color
	 * that you create and return in this method will automatically be assigned
	 * to the snow flake.
	 */
	public Color changeColorOfSnowFlake() {
		Random rand = new Random();
		int r = rand.nextInt(256);
		int g = rand.nextInt(256);
		int b = rand.nextInt(256);
		return new Color(r,g,b);
	}
}
