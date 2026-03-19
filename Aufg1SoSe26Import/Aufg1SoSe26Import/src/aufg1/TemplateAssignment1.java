package aufg1;

import java.awt.Color;
import drawing.DrawWindow;
import drawing.WinPos;

public class TemplateAssignment1 {

	public static void main(String[] args) {
		DrawWindow drawingWindowLeftTop = new DrawWindow("Blob", WinPos.LEFT_TOP);
		new DrawWindow("Blob KMeans", WinPos.RIGHT_TOP);
		new DrawWindow("Moon", WinPos.LEFT_BOTTOM);
		new DrawWindow("Moon KMeans", WinPos.RIGHT_BOTTOM);

		final int WINDOW_WIDTH = DrawWindow.getWidthOfFrame();
		final int WINDOW_HEIGHT = DrawWindow.getHeightOfFrame();
		final int CIRCLE_DIAMETER = 20;
		drawingWindowLeftTop.drawCircle(0, 0, CIRCLE_DIAMETER, Color.RED);
		drawingWindowLeftTop.drawCircle(20, 100, CIRCLE_DIAMETER, Color.GREEN);
		drawingWindowLeftTop.drawCircle(WINDOW_WIDTH, WINDOW_HEIGHT, CIRCLE_DIAMETER, Color.BLUE);
	}
}
