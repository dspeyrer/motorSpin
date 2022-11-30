// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.IntakeMotor;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.SubsytemConstants;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.networktables.NetworkTableEntry;

/** An example command that uses an example subsystem. */
public class ExampleCmd extends CommandBase {
  private final IntakeMotor m_testingMotor;

  private ShuffleboardTab exampleCmd = Shuffleboard.getTab("Comands"); // this makes a network table wich alows us to send and resive data with the robot
  private NetworkTableEntry m_ExampleSubsytemSpeed = exampleCmd.add("ExampleSubsytemSpeed", SubsytemConstants.kexampleSubsytemSpeed).getEntry(); // this alows us to change ths speed without redeploying the code.
  /**
   * Creates a new ExampleCommand that runs the intake motor
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCmd(IntakeMotor subsystem) {
    m_testingMotor = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_testingMotor.run(m_ExampleSubsytemSpeed.getDouble(SubsytemConstants.kexampleSubsytemSpeed));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_testingMotor.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
