package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByEncoderCounts extends Command {
	
	double distance = 0;
	double timeout = 0;
	double power = 0;
	double encoderCounts = 0;
	double startingLeftPos = 0;
	
	// Distance (In encoder counts), Timeout (in seconds), Power ( RawDrive -1 to 1)
    public DriveByEncoderCounts(double distance, double timeout, double power) {
        
    	requires(Robot.driveTrain);
    	
    	this.distance = distance;
    	this.timeout = timeout;
    	this.power = power;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startingLeftPos = Robot.driveTrain.leftPos();
    	
    	encoderCounts = distance + startingLeftPos;
    	
    	Robot.driveTrain.rawDrive(power, power);
    	
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.leftPos() >= encoderCounts || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.rawDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
