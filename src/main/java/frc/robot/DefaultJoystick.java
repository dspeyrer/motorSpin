package frc.robot;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Joystick;

public class DefaultJoystick implements Supplier<Double> {
	private Supplier<Double> inner;

	public DefaultJoystick(Joystick j, int id, double scale) {
		inner = new Transform(() -> j.getRawAxis(id)).deadband(0.05).slewRateLimit(5).square().scale(scale);
	}

	public Double get() {
		return inner.get();
	}
}
