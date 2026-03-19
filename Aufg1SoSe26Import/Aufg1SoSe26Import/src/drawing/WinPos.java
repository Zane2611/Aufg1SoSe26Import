/**
 * @author Frank Mehler 
 * @version 1.0
 * 28.01.2026
 * Where is the position of the 4 drawing windows on screen?
 *  Only 4 positions available for Prog II Assignment SoSe26
 */
package drawing;

import java.awt.Point;

public enum WinPos {

	LEFT_TOP(0, 0), RIGHT_TOP(DrawWindow.getWidthOfFrame(), 0),
	LEFT_BOTTOM(0, DrawWindow.getHeightOfFrame() + WinPos.GAP),
	RIGHT_BOTTOM(DrawWindow.getWidthOfFrame(), DrawWindow.getHeightOfFrame() + WinPos.GAP);

	// small space between windows
	private static final int GAP = 30;

	private final int left;
	private final int top;

	/**
	 * @param left start position left for window
	 * @param top  start position from top for window
	 */
	private WinPos(int left, int top) {
		this.left = left;
		this.top = top;
	}

	public Point toPoint() {
		return new Point(this.left, this.top);
	}
}
