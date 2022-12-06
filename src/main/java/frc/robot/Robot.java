package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.cmd.Axis;
import frc.robot.cmd.Transit;

import frc.robot.subsystems.Motor;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class Robot extends TimedRobot {
	private final Joystick joystick = new Joystick(0);

	@Override
	public void robotInit() {
		new Axis(new Motor(1), () -> joystick.getRawAxis(0));
		new JoystickButton(joystick, 1).whenPressed(new Transit(new Motor(0)));
	}

	@Override
	public void robotPeriodic() {
		CommandScheduler.getInstance().run();
	}
}
