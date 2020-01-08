package frc.robot.subsystems;/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;


public class Drivetrain extends Subsystem {

    private static Spark right = new Spark(8);
    private static Spark left = new Spark(9);

    private static DifferentialDrive drive = new DifferentialDrive(right, left);

    public static void tankDrive() { drive.tankDrive(OI.m_stick.getX(), OI.s_stick.getX()); }

    public static void curvatureDrive() { drive.curvatureDrive(OI.m_stick.getX(), OI.m_stick.getZ(), true); }

    public static void standardDrive() { drive.arcadeDrive(OI.m_stick.getX(), OI.m_stick.getY()); }

    public void initDefaultCommand() {
        //setDefaultCommand(new ExampleCommand());
    }
}
