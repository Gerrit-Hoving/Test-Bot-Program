/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Drivetrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * methods corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot
{
    private static final Drivetrain Drivetrain = new Drivetrain();
    static OI oi;

    /**
     * This function is run when the robot is first started up and is
     * used for any initialization code.
     */
    @Override
    public void robotInit()
    {
        oi = new OI();

        CameraServer.getInstance().startAutomaticCapture();

        //Pushes data from robot to SmartDashboard
        SmartDashboard.putData("PDP Info", new PowerDistributionPanel(1));
        SmartDashboard.putData("Accelerometer", new BuiltInAccelerometer());

    }

    /**
     * This function is called once each time the robot enters Disabled mode
     * (generally when the game ends) You can use it to reset any subsystem
     * information you want to clear when the robot is disabled.
     */
    @Override
    public void disabledInit()
    {

    }

    @Override
    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }

    /**
     * This code helps set up the autonomous by accepting input from the
     * sendableChooser above.
     */
    @Override
    public void autonomousInit()
    {

    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic()
    {

    }

    @Override
    public void teleopInit()
    {

    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic()
    {
        //Sets the primary driving mode
        Drivetrain.tankDrive();
        //Drivetrain.standardDrive();
        //Drivetrain.curvatureDrive();
    }

    /**
     * This function sets up testing mode
     */
    public void testInit() {

    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic()
    {
        Drivetrain.standardDrive();
    }
}