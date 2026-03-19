package aufg1;

import dataset.Dataset;
import diagram.ScatterDiagram;
import drawing.WinPos;
import generator.BlobGenerator;
import generator.MoonGenerator;

public class Main {

	public static final int NUMBER_CLUSTERS_BLOB = 3;
	public static final double STD_DEVIATION_BLOB = 0.5;
	
	public static final int NUMBER_CLUSTERS_MOON = 2;
	public static final double STD_DEVIATION_MOON = 0.1;
	public static final int SEED = 0;

	
	public static void window1() {
		Dataset dataset = new Dataset(new BlobGenerator(NUMBER_CLUSTERS_BLOB, STD_DEVIATION_BLOB, SEED));
		ScatterDiagram scatter = new ScatterDiagram("Blob", WinPos.LEFT_TOP, dataset);
		scatter.show();
	}
	
	public static void window2(){
		Dataset dataset = new Dataset(new BlobGenerator(NUMBER_CLUSTERS_BLOB, STD_DEVIATION_BLOB, SEED));
		dataset.cluster();
		ScatterDiagram scatter = new ScatterDiagram("Blob-k-Means", WinPos.RIGHT_TOP, dataset);
		scatter.show();
	}
	
	
	public static void window3() {
		Dataset dataset = new Dataset(new MoonGenerator(NUMBER_CLUSTERS_MOON, STD_DEVIATION_MOON, SEED));
		ScatterDiagram scatter = new ScatterDiagram("Moon", WinPos.LEFT_BOTTOM, dataset);
		scatter.show();
	}
	
	public static void window4() {
		Dataset dataset = new Dataset(new MoonGenerator(NUMBER_CLUSTERS_MOON, STD_DEVIATION_MOON, SEED));
		dataset.cluster();
		System.out.println(dataset.getDataPoints());
		ScatterDiagram scatter = new ScatterDiagram("Moon-k-Means", WinPos.RIGHT_BOTTOM, dataset);
		scatter.show();
	}
	
	public static void main(String[] args) {
		window1();
		window2();
		window3();
		window4();
	}
	
}
