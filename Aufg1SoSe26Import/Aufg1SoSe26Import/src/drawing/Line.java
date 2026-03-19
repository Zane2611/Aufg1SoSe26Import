/**
 * @author Frank Mehler 
 * @version 1.0
 * 25.07.2020
 */
package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;


public class Line implements Drawable {
	private final int xBegin;
	private final int yBegin;
	private final int xEnd;
	private final int yEnd;
	private final Color color;
	private final boolean dashed;

	public Line(int xBegin, int yBegin, int xEnd, int yEnd, Color color, boolean dashed) {
		this.xBegin = xBegin;
		this.yBegin = yBegin;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		this.color = color;
		this.dashed = dashed;
	}

	/**
	 * @see Drawable#draw(Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		if (this.dashed) {
			Graphics2D g2d = (Graphics2D) g.create();
			BasicStroke dashStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                    0.0f,new float[]{5}, 0);
			g2d.setStroke(dashStroke);
			g2d.drawLine(this.xBegin, this.yBegin, this.xEnd, this.yEnd);
			g2d.dispose();
		}
		else
			g.drawLine(this.xBegin, this.yBegin, this.xEnd, this.yEnd);
	}

	
	@Override
	public String toString() {
		return "Line [xBegin=" + xBegin + ", yBegin=" + yBegin + ", xEnd=" + xEnd + ", yEnd=" + yEnd
				+ ", color=" + color + "]";
	}
}
