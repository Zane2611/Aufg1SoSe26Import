/**
 * @author Frank Mehler 
 * @version 1.2
 * 28.01.2026
 * Goal is to give an easy access for drawing in a window for simple drawing operations
  */
package drawing;

import java.awt.*;
import javax.swing.*;

public class DrawWindow {
	// width and height of all windows
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;

	private JFrame frame;

	// content of window
	private DrawObjects allDrawObjects;

	// current movement of an object controlled by user
	private Direction currentDirection = Direction.RIGHT;

	// Constructor
	public DrawWindow(String title, WinPos posOfWindow) {
		this.frame = new JFrame();
		this.frame.setTitle(title);
		this.frame.setLocation(posOfWindow.toPoint());
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.allDrawObjects = new DrawObjects();
		this.allDrawObjects.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.frame.getContentPane().setSize(WIDTH, HEIGHT);
		this.frame.getContentPane().add(allDrawObjects);
		this.frame.pack();
		this.frame.setVisible(true);	
	}

	/**
	 * This method draws a circle at the specified point
	 * 
	 * @param x      x-coordinate of the middle point of the circle
	 * @param y      y-coordinate of the middle point of the circle
	 * @param diameter Width of the circle
	 * @param color  Color of the circle, e.g. Color.BLUE
	 */
	public void drawCircle(int x, int y, int diameter, Color color) {
		this.allDrawObjects.addCircle(x, y, diameter, color);
	}

	/**
	 * This method draws a rectangle at the specified point
	 * 
	 * @param x      x-coordinate of the starting point of the rectangle
	 * @param y      y-coordinate of the starting point of the rectangle
	 * @param width  Width of the crectangleircle
	 * @param height Height of the rectangle
	 * @param color  Color of the rectangle, e.g. Color.BLUE
	 */
	public void drawRectangle(int x, int y, int width, int height, Color color) {
		this.allDrawObjects.addRectangle(x, y, width, height, color);
	}

	/**
	 * This method draws a line from beginning to end
	 * 
	 * @param xBegin x-coordinate of the beginning of the line
	 * @param yBegin y-coordinate of the beginning of the line
	 * @param xEnd   x-coordinate of end-point
	 * @param yEnd   y-coordinate of end-point
	 * @param color  Color of the line, e.g. Color.BLUE
	 * @param dashed dotted line true/false
	 */
	public void drawLine(int xBegin, int yBegin, int xEnd, int yEnd, Color color, boolean dashed) {
		this.allDrawObjects.addLine(xBegin, yBegin, xEnd, yEnd, color, dashed);
	}

	/**
	 * The method draws a String-text at the specified coordinates
	 * 
	 * @param x     x-coordinate of the text
	 * @param y     y-coordinate of the text
	 * @param text  content of the text
	 * @param color Color of the text, e.g. Color.BLUE
	 */
	public void drawText(int x, int y, String text, Color color) {
		this.allDrawObjects.addText(x, y, text, color);
	}

	/**
	 * @return the width of the window
	 */
	public static int getWidthOfFrame() {
		return WIDTH;
	}

	/**
	 * @return the height of the window
	 */
	public static int getHeightOfFrame() {
		return HEIGHT;
	}

	/**
	 * If a keyboard is used, i.e. movement to the left or right via arrows, the new
	 * selected direction is defined
	 * 
	 * @param newDirection the direction selected by the user of the window
	 */
	public void setDirection(Direction newDirection) {
		currentDirection = newDirection;
	}

	/**
	 * If a keyboard is used, i.e. movement to the left or right via arrows, this
	 * method gives the last selected direction of the keyboard, e.g. RIGHT or LEFT
	 * direction
	 * 
	 * @return currentDirection
	 */
	public Direction getDirection() {
		return currentDirection;
	}

	/**
	 * Remove all previously created drawable objects for a clean white screen
	 */
	public void refresh() {
		this.allDrawObjects.deleteDrawableObjects();
	}
	
	/**
	 * draw content again
	 */
	public void forcePainting() {
		this.frame.repaint();
	}
}
