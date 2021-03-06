package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveArmWithJoystick extends Command {
	
	// Encoder position and Hall effect sensor values (Arm at highest and lowest position)
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
    	
    	// Refreshing values of the encoder and sensors
    	armEncoderPos = Robot.intakeArm.getArmPos();
    	isArmIn = Robot.intakeArm.armIn();
    	isArmOut = Robot.intakeArm.armOut();
    	
    	
    	// Checking if the manual drive control is enabled
    	if (RobotMap.manualArmDrive) {
    		
    		// Getting joystick value and cutting it down by 25%
    		double power = Robot.oi.controlStick.getRawAxis(5);
    		
    		//  If arm is at the highest position, prevent driving the arm any higher
    		if (isArmIn) {
    			if (power >= 0) {
    				Robot.intakeArm.driveArmWithJoystick(power);
    			} else {
    				Robot.intakeArm.driveArmWithJoystick(0);
    			}
    		} else if (isArmOut) {
    			if (power <=0) {
    				Robot.intakeArm.driveArmWithJoystick(power);
    			} else {
    				Robot.intakeArm.driveArmWithJoystick(0);
    			}
    		} else {
    			Robot.intakeArm.driveArmWithJoystick(power);
    		}
    		
    	}
    	
    	Robot.intakeArm.updateArmTelemetry();
    	
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
