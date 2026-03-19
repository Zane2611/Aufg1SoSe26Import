package diagram;

import java.awt.Color;
import java.util.List;

import dataset.DataPoint;
import dataset.Dataset;
import drawing.DrawWindow;
import drawing.WinPos;

public class ScatterDiagram {

	private String name;
	private WinPos position;
	private Dataset dataset;
	final int CIRCLE_DIAMETER = 6;

	public ScatterDiagram(String name, WinPos position, Dataset dataset) {
		this.name = name;
		this.position = position;
		this.dataset = dataset;
	}

	public void show() {
		DrawWindow window = new DrawWindow(name, position);

		final int WINDOW_WIDTH = DrawWindow.getWidthOfFrame();
		final int WINDOW_HEIGHT = DrawWindow.getHeightOfFrame();
		final int MARGIN = 20;

		List<DataPoint> points = dataset.getDataPoints();

		double[] bounds = calculateBounds(points);

		for (DataPoint p : points) {
			int[] pos = scalePoint(p.getPoint(), bounds, WINDOW_WIDTH, WINDOW_HEIGHT, MARGIN);
			Color color;
			if (p.getClusterNo() == -1) {
				color = getColorForLabelOrClusterNo(p.getLabel());
			} else {
				color = getColorForLabelOrClusterNo(p.getClusterNo());
			}
			drawPoint(window, pos[0], pos[1], color);
		}
	}

	private double[] calculateBounds(List<DataPoint> points) {
		double minX = Double.MAX_VALUE;
		double maxX = -Double.MAX_VALUE;
		double minY = Double.MAX_VALUE;
		double maxY = -Double.MAX_VALUE;

		for (DataPoint p : points) {
			double[] c = p.getPoint();
			minX = Math.min(minX, c[0]);
			maxX = Math.max(maxX, c[0]);
			minY = Math.min(minY, c[1]);
			maxY = Math.max(maxY, c[1]);
		}

		return new double[] { minX, maxX, minY, maxY };
	}

	private int[] scalePoint(double[] coordinates, double[] bounds, int width, int height, int margin) {

		double minX = bounds[0];
		double maxX = bounds[1];
		double minY = bounds[2];
		double maxY = bounds[3];

		double rangeX = maxX - minX;
		double rangeY = maxY - minY;

		int drawWidth = width - 2 * margin;
		int drawHeight = height - 2 * margin;

		int x = (int) ((coordinates[0] - minX) / rangeX * drawWidth) + margin;

		int y = height - margin - (int) ((coordinates[1] - minY) / rangeY * drawHeight);

		return new int[] { x, y };
	}

	private Color getColorForLabelOrClusterNo(int colorCode) {
		switch (colorCode % 3) {
		case 0:
			return Color.RED;
		case 1:
			return Color.BLUE;
		default:
			return Color.GREEN;
		}
	}

	private void drawPoint(DrawWindow window, int x, int y, Color color) {
		window.drawCircle(x, y, CIRCLE_DIAMETER, color);
	}

}
