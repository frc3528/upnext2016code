package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveIntakeMotor extends Command {

    public DriveIntakeMotor() {
    	
    	requires(Robot.ballGatherer);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// If manual drive mode is enabled, apply power to the intake wheel motor on trigger press
    	if (RobotMap.manualArmDrive) {
    		if (Robot.oi.controlLeftTrigger.get()) {
    			Robot.ballGatherer.driveIntakeWithTriggers(0.5);
    		}
    		
    		if (Robot.oi.controlRightTrigger.get()) {
    			Robot.ballGatherer.driveIntakeWithTriggers(-1);
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Returns true when both triggers are released
        return !Robot.oi.controlLeftTrigger.get() && !Robot.oi.controlRightTrigger.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ballGatherer.driveIntakeWithTriggers(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
