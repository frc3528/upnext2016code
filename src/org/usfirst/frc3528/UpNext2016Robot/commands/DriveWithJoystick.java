
package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveWithJoystick extends Command {
	
	double frontLeftEncPos;
	double frontRightEncPos;
	double backLeftEncPos;
	double backRightEncPos;
	double gyroAngle;

    public DriveWithJoystick() {

        requires(Robot.driveTrain);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (RobotMap.driveWithSingleJoystick == false) {
    		
    		double left = Robot.oi.driveStick.getRawAxis(1) * -1;
    		double right = Robot.oi.driveStick.getRawAxis(5) * -1;
    		
    		Robot.driveTrain.driveWithJoystick(left, right);
    		
    		//double left = Robot.oi.leftStick.getRawAxis(1) * -1;
    		//double right = Robot.oi.rightStick.getRawAxis(1) * -1;
    		
    		//Robot.driveTrain.driveWithJoystick(left, right);
    		
    	} else {
    		
    		double left = Robot.oi.driveStick.getRawAxis(1) * -1;
    		double right = Robot.oi.driveStick.getRawAxis(1) * -1;
    		
    		Robot.driveTrain.driveWithJoystick(left, right);
    		
    		//double left = Robot.oi.rightStick.getRawAxis(1) * -1;
    		//double right = Robot.oi.rightStick.getRawAxis(1) * -1;
    		
    		//Robot.driveTrain.driveWithJoystick(left, right);
    		
    	}
    	
    	frontLeftEncPos = Robot.driveTrain.frontLeftPos();
    	frontRightEncPos = Robot.driveTrain.frontRightPos();
    	
    	gyroAngle = Robot.driveTrain.getGyro();
    	SmartDashboard.putNumber("Gyro Angle", gyroAngle);
    	SmartDashboard.putBoolean("In Single Joystick Mode: ", RobotMap.driveWithSingleJoystick);
    	SmartDashboard.putNumber("Left Encoder: ", frontLeftEncPos);
    	SmartDashboard.putNumber("Right Encoder: ", frontRightEncPos);
    	
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
