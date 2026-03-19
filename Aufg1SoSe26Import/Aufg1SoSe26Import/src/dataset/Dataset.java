package dataset;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;

import generator.DataGenerator;

public class Dataset {

	
	public static final int SAMPLE_SIZE = 100;
	
	private List<DataPoint> dataPoints;
	private int numberOfClusters;
	
	public Dataset(DataGenerator generator) {
		this(generator, SAMPLE_SIZE);
	}
	
	public Dataset(DataGenerator generator, int size) {
		this.dataPoints = generator.generate(size);
		numberOfClusters = generator.getNoClusters();
	}
	
	public List<DataPoint> getDataPoints(){
		return dataPoints;
	}
	
	
	public void cluster() {
	    KMeansPlusPlusClusterer<DataPoint> clusterer =
	        new KMeansPlusPlusClusterer<>(numberOfClusters, SAMPLE_SIZE);

	    List<CentroidCluster<DataPoint>> clusterResults = clusterer.cluster(dataPoints);

	    for (int i = 0; i < clusterResults.size(); i++) {
	        for (DataPoint dp : clusterResults.get(i).getPoints()) {
	            dp.setClusterNo(i); 
	        }
	    }

	    List<DataPoint> clusteredPoints = new ArrayList<>();
	    for (CentroidCluster<DataPoint> cluster : clusterResults) {
	        clusteredPoints.addAll(cluster.getPoints());
	    }
	    dataPoints = clusteredPoints;
	}
}
