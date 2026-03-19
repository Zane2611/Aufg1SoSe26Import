/**
 * @author Frank Mehler 
 * @version 1.1
 * 31.01.2026
 * Circle Object for drawing at center x/y
 */
package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Drawable {
	private final int x;
	private final int y;
	private final int diameter;
	private final Color color;

	public Circle(int x, int y, int diameter, Color color) {
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.color = color;
	}

	/**
	 * @see Drawable#draw(Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		// fillOval fits an oval inside a rectangle to the right/bottom of position x/y
		// Instead this method draws the circle with the center at (x,y)
		// Therefore this method moves the rectangle by half its width and half its
		// height.
		g.fillOval(x - (this.diameter / 2), y - (this.diameter / 2), diameter, diameter);
	}

	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", diameter=" + diameter + ", color=" + color + "]";
	}
}
