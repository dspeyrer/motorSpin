package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CompressorControl extends SubsystemBase {
	Compressor c;

	public CompressorControl(int deviceId, double min, double max) {
		c = new Compressor(deviceId, PneumaticsModuleType.CTREPCM);
		c.enableAnalog(min, max);
	}

	public CompressorControl(int deviceId, boolean enabled) {
		c = new Compressor(deviceId, PneumaticsModuleType.CTREPCM);
		if (enabled) {
			c.enableDigital();
		} else {
			c.disable();
		}
	}
}
