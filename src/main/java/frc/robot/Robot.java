package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.cmd.Drive;
import frc.robot.cmd.Extend;
import frc.robot.cmd.Off;
import frc.robot.cmd.Reverse;
import frc.robot.subsystems.ArcadeDrive;
import frc.robot.subsystems.Solenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class Robot extends TimedRobot {
	private final Joystick joystick = new Joystick(0);

	@Override
	public void robotInit() {
		Solenoid p = new Solenoid(0, 1);
		JoystickButton j = new JoystickButton(joystick, 1);

		j.whenPressed(new Extend(p));
		j.whenReleased(new Reverse(p));

		new JoystickButton(joystick, 2).whenPressed(new Off(p));

		new Drive(new ArcadeDrive(4, 5, 6, 7), () -> joystick.getRawAxis(1), () -> joystick.getRawAxis(0));
	}

	@Override
	public void robotPeriodic() {
		CommandScheduler.getInstance().run();
	}
}
