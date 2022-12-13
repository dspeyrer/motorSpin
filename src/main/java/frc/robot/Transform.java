package frc.robot;

import java.util.function.Supplier;

import edu.wpi.first.math.filter.SlewRateLimiter;

public class Transform implements Supplier<Double> {
	private Supplier<Double> inner;

	public Transform(Supplier<Double> input) {
		inner = input;
	}

	public Transform(Supplier<Double> input, double scale) {
		SlewRateLimiter limiter = new SlewRateLimiter(5);

		inner = () -> {
			double val = input.get();
			val = Math.abs(val) > 0.05 ? val : 0.0;
			val = limiter.calculate(val);
			val = val * val * (val < 0 ? -1 : 1);
			val = val * scale;
			return val;
		};
	}

	public Transform square() {
		return new Transform(() -> {
			double val = this.get();
			return val * val * (val < 0 ? -1 : 1);
		});
	}

	public Transform scale(double s) {
		return new Transform(() -> {
			return this.get() * s;
		});
	}

	public Transform deadband(double db) {
		return new Transform(() -> {
			double val = this.get();
			return Math.abs(val) > db ? val : 0.0;
		});
	}

	public Transform slewRateLimit(double lim) {
		SlewRateLimiter limiter = new SlewRateLimiter(lim);
		return new Transform(() -> limiter.calculate(this.get()));
	}

	public Double get() {
		return inner.get();
	}
}
