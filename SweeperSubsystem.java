// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class SweeperSubsystem extends SubsystemBase {
  /** Creates a new SweeperSubsystem. */

  final CANSparkMax m_sweeperMotor = new CANSparkMax(7, MotorType.kBrushless);
   
  public SweeperSubsystem() {}

  // Each function 
  public void sweep() {
    m_sweeperMotor.set(0.3);
  }

  public void sweepOff() {
    m_sweeperMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
