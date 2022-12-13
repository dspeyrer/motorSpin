package frc.robot;

import java.util.function.Supplier;

public class Doubler implements Supplier<Double> {
	private final Supplier<Double> inner;

	public Doubler(Supplier<Double> data) {
		inner = data;
	}

	public Double get() {
		double val = inner.get();
		return val * val * (val < 0 ? -1 : 1);
	}
}
