package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class ArcadeDrive extends SubsystemBase {
	private DifferentialDrive drive;

	public ArcadeDrive(int left1, int left2, int right1, int right2) {
		drive = new DifferentialDrive(initGroup(left1, left2), initGroup(right1, right2));
	}

	private static WPI_VictorSPX initMotor(int dev) {
		WPI_VictorSPX motor = new WPI_VictorSPX(dev);

		motor.configFactoryDefault();
		motor.enableVoltageCompensation(true);
		motor.setNeutralMode(NeutralMode.Brake);

		return motor;
	}

	private static MotorControllerGroup initGroup(int dev1, int dev2) {
		return new MotorControllerGroup(initMotor(dev1), initMotor(dev2));
	}

	public void arcadeDrive(double fwd, double rot) {
		drive.arcadeDrive(fwd, rot);
	}
}
