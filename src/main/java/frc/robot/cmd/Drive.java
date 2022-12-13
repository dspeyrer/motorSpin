package frc.robot.cmd;

import frc.robot.subsystems.ArcadeDrive;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.Supplier;

public class Drive extends CommandBase {
	private final ArcadeDrive driveTrain;
	private final Supplier<Double> fwd;
	private final Supplier<Double> rot;

	private final SlewRateLimiter fwdLimit;
	private final SlewRateLimiter rotLimit;

	private final double deadband;

	public Drive(ArcadeDrive subsystem, Supplier<Double> fwd, Supplier<Double> rot, double lim, double deadband) {
		driveTrain = subsystem;
		this.fwd = fwd;
		this.rot = rot;

		this.fwdLimit = new SlewRateLimiter(lim);
		this.rotLimit = new SlewRateLimiter(lim);

		this.deadband = deadband;

		addRequirements(subsystem);
		subsystem.setDefaultCommand(this);
	}

	@Override
	public void execute() {
		double fwd = this.fwd.get();
		double rot = this.rot.get();

		fwd = Math.abs(fwd) > deadband ? fwd : 0.0;
		rot = Math.abs(rot) > deadband ? rot : 0.0;

		driveTrain.arcadeDrive(fwdLimit.calculate(fwd), rotLimit.calculate(rot));
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
