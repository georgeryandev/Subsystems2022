// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



// Subsystems and Commands
import frc.robot.subsystems.SweeperSubsystem;
import frc.robot.commands.SweeperCommand;
import frc.robot.subsystems.PIDSweepSubsystem;
import frc.robot.commands.PIDSweepCommand;

// Controller
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//FIXME Get rid of these too.

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.commands.ExampleCommand;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //FIXME Get rid of this stuff 
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  //Sweeper command and subsystem
  private final SweeperSubsystem m_sweeperSubsystem = new SweeperSubsystem();
  private final SweeperCommand m_sweeperCommand = new SweeperCommand(m_sweeperSubsystem);

  // PID sweep command and subsystem.
  private final PIDSweepSubsystem m_PIDSweepSubsystem = new PIDSweepSubsystem();
  private final PIDSweepCommand m_PIDSweepCommand = new PIDSweepCommand(m_PIDSweepSubsystem, 10);

  // Controller
  public final XboxController m_controller = new XboxController(0);

  // Creating the buttons.
  public final JoystickButton m_shootButton =  new JoystickButton(m_controller,XboxController.Button.kA.value);
  public final JoystickButton m_PIDSweepButton = new JoystickButton(m_controller, XboxController.Button.kB.value);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_shootButton.whenPressed(m_sweeperCommand);
    m_PIDSweepButton.whenHeld(m_PIDSweepCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_controller.getAButtonPressed();

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
