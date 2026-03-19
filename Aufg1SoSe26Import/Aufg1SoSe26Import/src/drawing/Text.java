package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Text implements Drawable {
	private final int x;
	private final int y;
	private final String text;
	private final Color color;

	public Text(int x, int y, String text, Color color) {
		this.x = x;
		this.y = y;
		this.text = text;
		this.color = color;
	}

	/**
	 * @see Drawable#draw(Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawString(text, x, y);
	}

	@Override
	public String toString() {
		return "Text [x=" + x + ", y=" + y + ", text=" + text + ", color=" + color + "]";
	}
}
