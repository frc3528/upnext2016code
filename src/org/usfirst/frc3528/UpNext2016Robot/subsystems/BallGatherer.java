package org.usfirst.frc3528.UpNext2016Robot.subsystems;

import org.usfirst.frc3528.UpNext2016Robot.RobotMap;
import org.usfirst.frc3528.UpNext2016Robot.commands.DriveIntakeMotor;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallGatherer extends Subsystem {
    
	// Constructing VictorSP Speed Controller.
	VictorSP intakeMotor = RobotMap.intakeDriveMotor;
	 
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveIntakeMotor());
    }
    
    // Called to apply power to the motor. (range of -1 to 1)
    public void driveIntakeWithTriggers(double power) {
    	intakeMotor.set(power);
    }
    
    public void driveIntakeFromCommand(double power) {
    	intakeMotor.set(power);
    }
}

