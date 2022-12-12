package frc.robot.cmd;

import frc.robot.subsystems.ArcadeDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.Supplier;

public class Drive extends CommandBase {
	private final ArcadeDrive driveTrain;
	private final Supplier<Double> fwd;
	private final Supplier<Double> rot;

	public Drive(ArcadeDrive subsystem, Supplier<Double> fwd, Supplier<Double> rot) {
		driveTrain = subsystem;
		this.fwd = fwd;
		this.rot = rot;

		addRequirements(subsystem);
		subsystem.setDefaultCommand(this);
	}

	@Override
	public void execute() {
		driveTrain.arcadeDrive(fwd.get(), rot.get());
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
