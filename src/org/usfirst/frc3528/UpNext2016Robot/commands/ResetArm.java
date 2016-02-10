package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetArm extends Command {

    public ResetArm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(4);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.intakeArm.driveArm(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//System.out.println("==========Reached isFinished Method==========");
    	System.out.println("isTimedOut: " + isTimedOut() + " ||| armIn: " + Robot.intakeArm.armIn());
        return isTimedOut() || Robot.intakeArm.armIn();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("==========Reached end Method==========");
    	Robot.intakeArm.driveArm(0);
    	Robot.intakeArm.zeroArmEncoder();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
