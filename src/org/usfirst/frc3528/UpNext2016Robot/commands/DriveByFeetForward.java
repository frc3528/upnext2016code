package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot; 
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByFeetForward extends Command {

	double distance = 0;
	double encoderCounts = 0;
	double timeout = 0;
	double left = 0;
	double right = 0;
	double startingLeftPos = 0;
	double startingRightPos = 0;
	double error = 0;
	
    public DriveByFeetForward(double distance, double timeout, double left, double right) {
        
        requires(Robot.driveTrain);
        
        // grab distance and convert from feet to inches
        this.distance = distance * 12;
        this.timeout = timeout;
        this.left = left;
        this.right = right;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	// Getting the current position of the encoders
    	startingLeftPos = Robot.driveTrain.leftPos();
    	startingRightPos = Robot.driveTrain.rightPos();
    	
    	System.out.println("Left: " + startingLeftPos + " Right: " + startingRightPos);
    	
    	// Calculate the number of encoderCounts (distance) to drive
        encoderCounts = distance / RobotMap.INCHES_PER_COUNT;
        encoderCounts = encoderCounts + startingRightPos;
        
        System.out.println("Encoder Counts: " + encoderCounts);
        
        // Ensures motors aren't moving
        Robot.driveTrain.rawDrive(0, 0);
        
        setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// Apply power to the motors
    	System.out.println("Current Pos: " + Robot.driveTrain.rightPos() + " Expected: " + encoderCounts);
    	Robot.driveTrain.rawDrive(left, right);
    	
     }
     
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Returns true when either the distance to drive has been reached, or the timer runs out.
    	return Robot.driveTrain.rightPos() >= encoderCounts || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stops motors
    	Robot.driveTrain.rawDrive(0, 0);
    	RobotMap.driveTraintankDrive.setSafetyEnabled(false);
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
    }
}
