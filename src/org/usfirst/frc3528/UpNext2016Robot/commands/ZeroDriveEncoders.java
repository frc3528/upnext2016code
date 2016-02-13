package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZeroDriveEncoders extends Command {

    public ZeroDriveEncoders() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(.075);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	setTimeout(.075);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.driveTrain.leftPos() == 0 && Robot.driveTrain.rightPos() == 0 || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
