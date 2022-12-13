package frc.robot.cmd;

import frc.robot.subsystems.Motor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.Supplier;

public class Flipper extends CommandBase {
	private final Motor motor;
	private final Supplier<Double> input;
	private final DigitalInput topLimit, bottomLimit;

	public Flipper(Motor subsystem, Supplier<Double> input, int topLimitId, int bottomLimitId) {
		motor = subsystem;
		this.input = input;

		topLimit = new DigitalInput(topLimitId);
		bottomLimit = new DigitalInput(bottomLimitId);

		addRequirements(subsystem);
		subsystem.setDefaultCommand(this);
	}

	@Override
	public void execute() {
		double value = input.get() * 0.5;

		if (value > 0 ? topLimit.get() : bottomLimit.get()) {
			motor.setSpeed(0);
		} else {
			motor.setSpeed(value);
		}
	}

	@Override
	public void end(boolean interrupted) {
		motor.stopMotor();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
