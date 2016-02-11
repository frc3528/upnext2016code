package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveArmWithJoystick extends Command {
	
	double armEncoderPos;
	boolean isArmIn;
	boolean isArmOut;
	
    public DriveArmWithJoystick() {
        
    	requires(Robot.intakeArm);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	armEncoderPos = Robot.intakeArm.getArmPos();
    	isArmIn = Robot.intakeArm.armIn();
    	isArmOut = Robot.intakeArm.armOut();
    	
    	if (RobotMap.manualArmDrive) {
    		
    		double power = Robot.oi.controlStick.getRawAxis(5);
    		
    		if (isArmIn) {
    			if (power >= 0) {
    				Robot.intakeArm.driveArmWithJoystick(power);
    			}
    		} else {
    			Robot.intakeArm.driveArmWithJoystick(power);
    		}
    		
    	}
    	
    	SmartDashboard.putNumber("Arm Encoder", armEncoderPos);
    	SmartDashboard.putBoolean("Arm In: ", isArmIn);
    	SmartDashboard.putBoolean("Arm Out: ", isArmOut);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
