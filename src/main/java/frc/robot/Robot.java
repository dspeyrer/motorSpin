package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.cmd.Drive;
import frc.robot.cmd.Flipper;
import frc.robot.subsystems.ArcadeDrive;
import frc.robot.subsystems.CompressorControl;
import frc.robot.subsystems.Motor;
import frc.robot.subsystems.Solenoid;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class Robot extends TimedRobot {
	private final Joystick joystick = new Joystick(0);

	@Override
	public void robotInit() {
		new CompressorControl(0, true);

		new Drive(
				new ArcadeDrive(4, 5, 6, 7),
				new Transform(() -> joystick.getRawAxis(0)).deadband(0.05).slewRateLimit(7).square().scale(0.7),
				new Transform(() -> joystick.getRawAxis(1)).deadband(0.05).slewRateLimit(5).square().scale(0.7));

		new Flipper(
				new Motor(2),
				new Transform(() -> joystick.getRawAxis(5)).deadband(0.05).slewRateLimit(7).square().scale(0.5),
				1, 0);

		Solenoid solenoid = new Solenoid(0, 1);

		new JoystickButton(joystick, 2)
				.whenPressed(new InstantCommand(solenoid::off));

		new JoystickButton(joystick, 1)
				.whenPressed(new InstantCommand(solenoid::forward))
				.whenReleased(new InstantCommand(solenoid::reverse));
	}

	@Override
	public void robotPeriodic() {
		CommandScheduler.getInstance().run();
	}
}
