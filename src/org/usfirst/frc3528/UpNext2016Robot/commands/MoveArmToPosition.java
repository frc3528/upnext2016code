package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmToPosition extends Command {
	
	// Initializing variables
	double armPos;
	double targetPos;
	double timeout;
	double power;
	double encoderCounts;
	boolean aboveTarget;
	
	// power (-1 to 1), timeout (in seconds), targetPos (Encoder count to move the arm to).
    public MoveArmToPosition(double power, double timeout, double targetPos) {
    	
    	requires(Robot.intakeArm);
    	
    	this.power = power;
    	this.timeout = timeout;
    	this.targetPos = targetPos;

    }
    
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	// Getting the current position of the arm
    	armPos = RobotMap.armEncoder.get();
    	
    	// Checking whether the arm is above or below the target position
    	// and applying the necessary motor power to move towards it.
    	if (armPos > targetPos) {
    		
    		System.out.println("armPos > targetPos");
    		Robot.intakeArm.driveArm(-power);
    		aboveTarget = false;
    		
    	} else if (armPos < targetPos){
    		
    		System.out.println("armPos < targetPos");
    		Robot.intakeArm.driveArm(power);
    		aboveTarget = true;
    		
    	} else {
    		System.out.println("armPos = targetPos");
    	}
    	
    	encoderCounts = Robot.intakeArm.getArmPos();
    	
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	/*
    	 * First, checks if we started above or below the target.
    	 * Returns true when the arm position meets, or is above/below the target
    	 * based on where we started, or when the the timeout is reached
    	 */
        if (aboveTarget) {
        	return Robot.intakeArm.getArmPos() >= targetPos || isTimedOut();
        } else {
        	return Robot.intakeArm.getArmPos() <= targetPos || isTimedOut();
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stops the arm
    	Robot.intakeArm.driveArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
