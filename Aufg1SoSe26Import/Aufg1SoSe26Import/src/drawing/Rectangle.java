/**
 * @author Frank Mehler 
 * @version 1.0
 * 25.07.2020
 */
package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle implements Drawable {
	private final int x;
	private final int y;
	private final int width;
	private final int height;
	private final Color color;

	public Rectangle(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	/**
	 * @see Drawable#draw(Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	@Override
	public String toString() {
		return "Rectangle [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", color=" + color + "]";
	}
}
