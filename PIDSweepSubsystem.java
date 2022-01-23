// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDSweepSubsystem extends SubsystemBase {

  final CANSparkMax m_sweeperMotor = new CANSparkMax(7, MotorType.kBrushless);
  final RelativeEncoder m_driveEncoder = m_sweeperMotor.getEncoder();
  final SparkMaxPIDController m_PIDController = m_sweeperMotor.getPIDController();


  // From: https://github.com/REVrobotics/SPARK-MAX-Examples/blob/master/Java/Smart%20Motion%20Example/src/main/java/frc/robot/Robot.java

  /* PID coefficients
  kP = 5e-5; 
  kI = 1e-6;
  kD = 0; 
  kIz = 0; 
  kFF = 0.000156; 
  kMaxOutput = 1; 
  kMinOutput = -1;
  maxRPM = 5700;

  // Smart Motion Coefficients
  maxVel = 2000; // rpm
  maxAcc = 1500;
  */

  // set PID coefficients
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM, maxVel, minVel, maxAcc, allowedErr;

  
  /** Creates a new PIDSweepSubsystem. */
  public PIDSweepSubsystem() {

    
    kP = 5e-5; 
    kI = 1e-6;
    kD = 0; 
    kIz = 0; 
    kFF = 0.000156; 
    kMaxOutput = 1; 
    kMinOutput = -1;
    maxRPM = 5700;

    // Smart Motion Coefficients
    maxVel = 2000; // rpm
    maxAcc = 1500;

    m_PIDController.setP(5e-5);
    m_PIDController.setI(1e-6);
    // D damps down oscillation? https://www.chiefdelphi.com/t/tune-rev-spark-max-pid-for-shooter/379068/11
    m_PIDController.setD(0);
    m_PIDController.setIZone(0);
    m_PIDController.setFF(0.000156);
    m_PIDController.setOutputRange(1, -1);

    SmartDashboard.putNumber("P Gain", kP);
    SmartDashboard.putNumber("I Gain", kI);
    SmartDashboard.putNumber("D Gain", kD);
    SmartDashboard.putNumber("I Zone", kIz);
    SmartDashboard.putNumber("Feed Forward", kFF);
    SmartDashboard.putNumber("Max Output", kMaxOutput);
    SmartDashboard.putNumber("Min Output", kMinOutput);
  }

  public void holdRPM(double RPM) {
    // Set the goal for PID to RPM
    // kVelocity = RPM
    m_PIDController.setReference(RPM, CANSparkMax.ControlType.kVelocity);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
