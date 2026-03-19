package generator;

import java.util.List;

import dataset.DataPoint;

public interface DataGenerator {
	List<DataPoint> generate(int size);
	
	int getNoClusters();
}
