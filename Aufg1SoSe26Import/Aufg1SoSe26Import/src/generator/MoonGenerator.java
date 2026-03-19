package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dataset.DataPoint;

public class MoonGenerator implements DataGenerator {
	
	private int numberOfClusters;
    private double stdDeviation;
    private int seed;

    public MoonGenerator(int numberOfClusters, double stdDeviation, int seed) {
        this.stdDeviation = stdDeviation;
        this.seed = seed;
        this.numberOfClusters = numberOfClusters;
    }

    @Override
    public List<DataPoint> generate(int size) {
        int halfSize = size / 2;

        Random rand = new Random(seed);
        List<DataPoint> dataPoints = new ArrayList<>();

        for (int i = 0; i < halfSize; i++) {
            double t = Math.PI * i / halfSize;
            double x = Math.cos(t) + stdDeviation * rand.nextGaussian();
            double y = Math.sin(t) + stdDeviation * rand.nextGaussian();
            dataPoints.add(new DataPoint(x, y, 0));
        }

        for (int i = 0; i < halfSize; i++) {
            double t = Math.PI * i / halfSize;
            double x = (1 - Math.cos(t)) + stdDeviation * rand.nextGaussian();
            double y = (1 - Math.sin(t) - 0.5) + stdDeviation * rand.nextGaussian();
            dataPoints.add(new DataPoint(x, y, 1));
        }

        return dataPoints;
    }

	@Override
	public int getNoClusters() {
		return numberOfClusters;
	}
}