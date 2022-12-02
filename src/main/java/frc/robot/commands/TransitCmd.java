package frc.robot.commands;

import frc.robot.subsystems.Motor;
import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.networktables.NetworkTableEntry;

public class TransitCmd extends CommandBase {
	public static final double mkaxTransitSpeed = .5;

	private final Motor motors;

	private NetworkTableEntry cfg = Shuffleboard.getTab("Commands")
			.add("Transit Speed", mkaxTransitSpeed).getEntry();

	public TransitCmd(Motor subsystem) {
		motors = subsystem;
		addRequirements(subsystem);
	}

	@Override
	public void execute() {
		motors.setSpeed(cfg.getDouble(mkaxTransitSpeed));
	}

	@Override
	public void end(boolean interrupted) {
		motors.stopMotor();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
