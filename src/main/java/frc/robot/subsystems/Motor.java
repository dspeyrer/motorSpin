package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class Motor extends SubsystemBase {
	public final WPI_TalonSRX motor;

	public Motor(int deviceNumber) {
		motor = new WPI_TalonSRX(deviceNumber);

		motor.configFactoryDefault();
		motor.enableVoltageCompensation(true);
		motor.setNeutralMode(NeutralMode.Brake);
	}

	public void setSpeed(double speed) {
		motor.set(ControlMode.PercentOutput, speed);
	}

	public void stopMotor() {
		motor.stopMotor();
	}
}
