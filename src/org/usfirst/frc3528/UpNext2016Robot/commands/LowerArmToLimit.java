package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerArmToLimit extends Command {
	
	boolean isArmOut;
	
    public LowerArmToLimit() {
    	requires(Robot.intakeArm);
    	this.setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(4);
    	Robot.intakeArm.driveArm(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	isArmOut = Robot.intakeArm.armOut();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut() || isArmOut;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intakeArm.driveArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
