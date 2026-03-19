package drawing;

import java.awt.Graphics;

/**
 * @author Lars Jung
 * @version 1.0
 * 15.08.2022
 * An interface for labeling and implementing drawable objects
 */
public interface Drawable {

	/**
	 * This method draws the drawable object
	 * 
	 * @param g Graphics-Object is the graphic context
	 */
	void draw(Graphics g);
}
