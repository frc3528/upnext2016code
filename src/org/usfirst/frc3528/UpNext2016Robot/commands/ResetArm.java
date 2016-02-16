package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetArm extends Command {
	
	boolean isArmIn;
	
    public ResetArm() {
        requires(Robot.intakeArm);
        this.setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(4);
    	Robot.intakeArm.driveArm(-1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//System.out.println("Arm Encoder Pos: " + Robot.intakeArm.getArmPos());
    	isArmIn = Robot.intakeArm.armIn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("isTimedOut: " + isTimedOut() + " ||| armIn: " + Robot.intakeArm.armIn());
        return isTimedOut() || isArmIn;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("==========Reached end Method==========");
    	Robot.intakeArm.driveArm(0);
    	System.out.println("Encoder Before Reset: " + Robot.intakeArm.getArmPos());
    	Robot.intakeArm.zeroArmEncoder();
    	System.out.println("Encoder After Reset: " + Robot.intakeArm.getArmPos());
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
