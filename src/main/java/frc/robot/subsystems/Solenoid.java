package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Solenoid extends SubsystemBase {
	DoubleSolenoid s;

	public Solenoid(int forward, int reverse) {
		s = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, forward, reverse);
	}

	public void forward() {
		// System.out.println("\n=======\nTRIGGERING FORWARD\n========\n");
		s.set(DoubleSolenoid.Value.kForward);
	}

	public void off() {
		s.set(DoubleSolenoid.Value.kOff);
	}

	public void reverse() {
		s.set(DoubleSolenoid.Value.kReverse);
	}
}
