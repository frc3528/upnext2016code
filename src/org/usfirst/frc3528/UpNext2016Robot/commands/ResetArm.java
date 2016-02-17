package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetArm extends Command {
	
	// Stores whether the arm is in or not.
	boolean isArmIn;
	
    public ResetArm() {
        requires(Robot.intakeArm);
        this.setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Setting timeout, and applying power to the motor.
    	setTimeout(4);
    	Robot.intakeArm.driveArm(-1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Refreshing the reading of the Hall Effect sensor at the highest position.
    	isArmIn = Robot.intakeArm.armIn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Returns true when the Hall Effect sensor reads true, or the timeout is reached.
    	System.out.println("isTimedOut: " + isTimedOut() + " ||| armIn: " + Robot.intakeArm.armIn());
        return isTimedOut() || isArmIn;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Cutting power to the motor, and reseting the encoder to 0.
    	Robot.intakeArm.driveArm(0);
    	Robot.intakeArm.zeroArmEncoder();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
