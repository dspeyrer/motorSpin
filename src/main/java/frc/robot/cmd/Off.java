package frc.robot.cmd;

import frc.robot.subsystems.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Off extends CommandBase {
	public final Solenoid s;

	public Off(Solenoid subsystem) {
		s = subsystem;
	}

	@Override
	public void execute() {
		s.off();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
