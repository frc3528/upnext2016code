
package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveWithJoystick extends Command {
	
	// Stores the current gyro angle
	double gyroAngle;

    public DriveWithJoystick() {

        requires(Robot.driveTrain);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// Checking if the Single Drivestick Mode is enabled
    	if (RobotMap.driveWithSingleJoystick == false) {
    		// Checking if drive is reversed
    		if (!RobotMap.driveIsReversed) {
    			
    			// Getting joystick inputs
    			double left = Robot.oi.driveStick.getRawAxis(1);
    			double right = Robot.oi.driveStick.getRawAxis(5);
    			
    			// Driving robot by joystick inputs
    			Robot.driveTrain.driveWithJoystick(left, right);
    			
    		} else {

    			double right = Robot.oi.driveStick.getRawAxis(1) * -1;
    			double left = Robot.oi.driveStick.getRawAxis(5) * -1;
    		
    			Robot.driveTrain.driveWithJoystick(left, right);
    			
    		}
    		
    	} else {
    		
    		if (!RobotMap.driveIsReversed) {
    			double left = Robot.oi.driveStick.getRawAxis(1);
    			double right = Robot.oi.driveStick.getRawAxis(1);
    			
    			Robot.driveTrain.driveWithJoystick(left, right);
    		} else {
    			double left = Robot.oi.driveStick.getRawAxis(1) * -1;
    			double right = Robot.oi.driveStick.getRawAxis(1) * -1;
    			
    			Robot.driveTrain.driveWithJoystick(left, right);
    		}
    		
    	}
    	
    	//gyroAngle = Robot.driveTrain.getGyro();
    	SmartDashboard.putNumber("Gyro", gyroAngle);
    	Robot.driveTrain.updateTelemetry();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
