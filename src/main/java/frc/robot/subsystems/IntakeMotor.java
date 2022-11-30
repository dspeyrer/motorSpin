// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class IntakeMotor extends SubsystemBase {

  public final WPI_TalonFX intakeMotor = new WPI_TalonFX(1); // new moter at id 1
  /** Creates a new ExampleSubsystem. */
  public IntakeMotor() {
    intakeMotor.configFactoryDefault();

    intakeMotor.enableVoltageCompensation(true);
    intakeMotor.setNeutralMode(NeutralMode.Coast);
  }

  /**@param speed speed is between -1 and 1 and sets the speed of intake moter */
  public void run(double speed) {
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }
  public void stopMotor() {
    intakeMotor.stopMotor();
  }
}
