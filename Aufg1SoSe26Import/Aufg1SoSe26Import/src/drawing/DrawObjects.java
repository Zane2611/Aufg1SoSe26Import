/**
 * @author Frank Mehler 
 * @version 1.0
 * 25.07.2020 
 * Goal of the class is to manage a list of drawable objects
 * These objects will be shown in a graphical context (e.g. a window)
 */
package drawing;

import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.*;

public class DrawObjects extends JComponent {
	private static final long serialVersionUID = 1L;
	private List<Drawable> allDrawableObjects;

	public DrawObjects() {
		// Attention: ArrayList is not thread-safe!
		allDrawableObjects = new ArrayList<>();
	}

	/**
	 * Adds a new rectangle to the list of drawable objects
	 * 
	 * @param x     x-coordinate of the rectangle
	 * @param y     y-coordinate of the rectangle
	 * @param color Color of the rectangle
	 */
	public void addRectangle(int x, int y, int width, int height, Color color) {
		synchronized (DrawWindow.class) {
			allDrawableObjects.add(new Rectangle(x, y, width, height, color));
			repaint();
		}
	}

	/**
	 * Adds a new circle to the list of drawable objects
	 * 
	 * @param x      x-coordinate of the circle
	 * @param y      y-coordinate of the circle
	 * @param diameter width of the circle
	 * @param color  Color of the circle
	 */
	public void addCircle(int x, int y, int diameter, Color color) {
		synchronized (DrawWindow.class) {
			allDrawableObjects.add(new Circle(x, y, diameter, color));
			repaint();
		}
	}

	/**
	 * Adds a new line to the list
	 * 
	 * @param xBegin x-coordinate of the start of the line
	 * @param yBegin y-coordinate of the start of the line
	 * @param xEnd   x-coordinate of the end of the line
	 * @param yEnd   y-coordinate of the end of the line
	 * @param color  color of the line
	 * @param dashed dotted line true/false
	 */
	public void addLine(int xBegin, int yBegin, int xEnd, int yEnd, Color color, boolean dashed) {
		synchronized (DrawWindow.class) {
			allDrawableObjects.add(new Line(xBegin, yBegin, xEnd, yEnd, color, dashed));
			repaint();
		}
	}

	/**
	 * adds a new text to the list
	 * 
	 * @param x     x-coordinate of the text position
	 * @param y     y-coordinate of the text position
	 * @param text  content of the text
	 * @param color color of the text
	 */
	public void addText(int x, int y, String text, Color color) {
		synchronized (DrawWindow.class) {
			allDrawableObjects.add(new Text(x, y, text, color));
			repaint();
		}
	}

	public void deleteDrawableObjects() {
		synchronized (DrawWindow.class) {
			allDrawableObjects.removeAll(allDrawableObjects);
		}
	}

	/**
	 * This method draws all objects. The method is called automatically, when the
	 * window is shown or updated
	 * 
	 * @param Graphics-Object is the graphic context, i.e. properties for drawing
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// super.paintComponent(g); // not needed
		// Even if the list is thread-safe, the iterators are not!
		// https://www.codejava.net/java-core/collections/understanding-collections-and-thread-safety-in-java
		// synchronizing via class (not via object), because of static attribute
		synchronized (DrawWindow.class) {
			for (Drawable drawObject : allDrawableObjects) {
				drawObject.draw(g);
			}
		}
	}
}