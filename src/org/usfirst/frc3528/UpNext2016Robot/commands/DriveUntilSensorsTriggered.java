package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class DriveUntilSensorsTriggered extends Command {
	
	double power;
	double timeout;

    public DriveUntilSensorsTriggered(double power, double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.power = power;
    	this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.rawDrive(power, power);
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.driveTrain.getRightSensorValue()) {
    		Robot.driveTrain.rawDrive(power, 0);
    	} else if (Robot.driveTrain.getLeftSensorValue()) {
     		Robot.driveTrain.rawDrive(0, power);
     	}
    		
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.driveTrain.getRightSensorValue() && Robot.driveTrain.getLeftSensorValue()) || isTimedOut();
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
