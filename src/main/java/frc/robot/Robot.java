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

		new Drive(new ArcadeDrive(4, 5, 6, 7), new Doubler(() -> joystick.getRawAxis(0)),
				new Doubler(() -> joystick.getRawAxis(1)), 5,
				0.05);

		new Flipper(new Motor(2), new Doubler(() -> joystick.getRawAxis(5)), 1, 0);

		Solenoid solenoid = new Solenoid(0, 1);

		new JoystickButton(joystick, 2).whenPressed(new InstantCommand(solenoid::off, solenoid));

		JoystickButton j = new JoystickButton(joystick, 1);

		j.whenPressed(new InstantCommand(solenoid::forward, solenoid));
		j.whenReleased(new InstantCommand(solenoid::reverse, solenoid));
	}

	@Override
	public void robotPeriodic() {
		CommandScheduler.getInstance().run();
	}
}
