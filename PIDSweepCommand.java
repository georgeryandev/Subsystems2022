// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PIDSweepSubsystem;

public class PIDSweepCommand extends CommandBase {

  private final PIDSweepSubsystem m_subsystem;
  private double m_RPM;
  /** Creates a new PIDSweepCommand. */
  public PIDSweepCommand(PIDSweepSubsystem subsystem, double RPM) {
    m_subsystem = subsystem;
    m_RPM = RPM;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.holdRPM(m_RPM);
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
