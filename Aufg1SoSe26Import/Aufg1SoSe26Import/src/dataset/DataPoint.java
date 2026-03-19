package dataset;
import org.apache.commons.math3.ml.clustering.Clusterable;

public class DataPoint implements Clusterable{

	private double x;
	private double y;
	private int label;
	private int clusterNo;

	public DataPoint(double x, double y, int label) {
		this.x = x;
		this.y = y;
		this.label = label;
		this.clusterNo = -1;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getLabel() {
		return label;
	}

	public int getClusterNo() {
		return clusterNo;
	}

	public void setClusterNo(int clusterNo) {
		this.clusterNo = clusterNo;
	}

	public double[] getPoint() {
		return new double[] { this.x, this.y };
	}

	@Override
	public String toString() {
		return "DataPoint [x=" + x + ", y=" + y + ", label=" + label + ", clusterNo=" + clusterNo + "] \n";
	}
	
	
}
