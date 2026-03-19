package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dataset.DataPoint;

public class BlobGenerator implements DataGenerator {

	private final static int AREA_OF_STARTPOINTS = 15;
	private int numberOfClusters;
	private double stdDeviation;
	private int seed;

	public BlobGenerator(int numberOfClusters, double stdDeviation, int seed) {
		this.numberOfClusters = numberOfClusters;
		this.stdDeviation = stdDeviation;
		this.seed = seed;
	}

	@Override
	public List<DataPoint> generate(int size) {

	    Random rand = new Random(seed);

	    List<DataPoint> dataPoints = new ArrayList<>();
	    List<DataPoint> centers = new ArrayList<>();

	    for (int i = 0; i < numberOfClusters; i++) {
	        centers.add(new DataPoint(
	                rand.nextDouble(1)*AREA_OF_STARTPOINTS,
	                rand.nextDouble(1)*AREA_OF_STARTPOINTS,
	                i));
	    }

	    for (int i = 0; i < size; i++) {

	        int clusterIndex = rand.nextInt(numberOfClusters);
	        DataPoint center = centers.get(clusterIndex);

	        double x = center.getX() + stdDeviation * rand.nextGaussian();
	        double y = center.getY() + stdDeviation * rand.nextGaussian();

	        dataPoints.add(new DataPoint(x, y, clusterIndex));
	    }

	    return dataPoints;
	}

	@Override
	public int getNoClusters() {
		return numberOfClusters;
	}
	
	
	}

