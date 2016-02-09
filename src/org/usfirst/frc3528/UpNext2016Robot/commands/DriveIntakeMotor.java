package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveIntakeMotor extends Command {

    public DriveIntakeMotor() {
    	
    	requires(Robot.intakeArm);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (RobotMap.manualArmDrive) {
    		if (Robot.oi.controlLeftTrigger.get()) {
    			Robot.intakeArm.driveIntakeWithTriggers(0.5);
    		}
    		
    		if (Robot.oi.controlRightTrigger.get()) {
    			Robot.intakeArm.driveIntakeWithTriggers(-0.5);
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.oi.controlLeftTrigger.get() && !Robot.oi.controlRightTrigger.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intakeArm.driveIntakeWithTriggers(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
