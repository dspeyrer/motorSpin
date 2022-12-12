package frc.robot.cmd;

import frc.robot.subsystems.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Extend extends CommandBase {
	public final Solenoid s;

	public Extend(Solenoid subsystem) {
		s = subsystem;
	}

	@Override
	public void execute() {
		s.forward();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
