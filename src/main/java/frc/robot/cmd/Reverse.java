package frc.robot.cmd;

import frc.robot.subsystems.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Reverse extends CommandBase {
	public final Solenoid s;

	public Reverse(Solenoid subsystem) {
		s = subsystem;
	}

	@Override
	public void execute() {
		s.reverse();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
