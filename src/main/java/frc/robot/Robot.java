// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with split
 * arcade steering and an Xbox controller.
 */
public class Robot extends TimedRobot {
  //right motor controllers in ports 0 and 1
  private final PWMVictorSPX leftMotor1 = new PWMVictorSPX(0);
  private final PWMVictorSPX leftMotor2 = new PWMVictorSPX(1);

  //left motor controllers in ports 2 and 3
  private final PWMVictorSPX rightMotor1 = new PWMVictorSPX(2);
  private final PWMVictorSPX rightMotor2 = new PWMVictorSPX(3);

  //group left and right motors together
  private final MotorControllerGroup leftspeedgroup = new MotorControllerGroup(leftMotor1, leftMotor2);
  private final MotorControllerGroup rightspeedgroup = new MotorControllerGroup(rightMotor1, rightMotor2);

  //drivetrain
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(rightspeedgroup, leftspeedgroup);

  //joystick
  private final XboxController m_driverController = new XboxController(0);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages 
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    rightMotor1.setInverted(true);
    rightMotor2.setInverted(true);
  }

  @Override
  public void robotPeriodic() {
  }
  
  @Override
  public void autonomousInit() {
  }
  
  @Override
  public void autonomousPeriodic() {
  }
  
  @Override
  public void teleopInit() {
  }
  
  @Override
  public void teleopPeriodic() {
    // Drive with split arcade drive.
    // That means that the Y axis of the left stick moves forward
    // and backward, and the X of the right stick turns left and right.

    m_robotDrive.arcadeDrive(-m_driverController.getLeftY(), m_driverController.getRightX());
  }
}
