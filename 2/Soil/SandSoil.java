package Soil;

public class SandSoil extends Soil {
	public SandSoil() {
		super();
	}

	@Override
	double percolationLevel() {
		return 0.4;
	}
}
