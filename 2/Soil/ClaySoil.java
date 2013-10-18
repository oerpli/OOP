package Soil;

public class ClaySoil extends Soil {
	public ClaySoil() {
		super();
	}

	@Override
	double percolationLevel() {
		return 0.9;
	}
}
