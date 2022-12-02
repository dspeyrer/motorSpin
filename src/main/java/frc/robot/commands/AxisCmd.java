package frc.robot.commands;

import frc.robot.subsystems.Motor;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.Supplier;

public class AxisCmd extends CommandBase {
	private final Motor m_motors;
	private final Supplier<Double> input;

	public AxisCmd(Motor subsystem, Supplier<Double> input) {
		m_motors = subsystem;
		this.input = input;

		subsystem.setDefaultCommand(this);
		addRequirements(subsystem);
	}

	@Override
	public void execute() {
		m_motors.setSpeed(input.get());
	}

	@Override
	public void end(boolean interrupted) {
		m_motors.stopMotor();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
