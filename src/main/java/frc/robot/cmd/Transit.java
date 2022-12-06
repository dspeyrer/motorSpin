package frc.robot.cmd;

import frc.robot.subsystems.Motor;
import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.networktables.NetworkTableEntry;

public class Transit extends CommandBase {
	public static final double mkaxTransitSpeed = .5;

	private final Motor motors;

	private NetworkTableEntry cfg = Shuffleboard.getTab("Commands")
			.add("Transit Speed", mkaxTransitSpeed).getEntry();

	public Transit(Motor subsystem) {
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
