
package org.usfirst.frc3528.UpNext2016Robot.subsystems;

import org.usfirst.frc3528.UpNext2016Robot.RobotMap;
import org.usfirst.frc3528.UpNext2016Robot.Utils;
import org.usfirst.frc3528.UpNext2016Robot.commands.*;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
    
    CANTalon frontLeftMotor = RobotMap.driveTrainfrontLeftMotor;
    CANTalon frontRightMotor = RobotMap.driveTrainfrontRightMotor;
    CANTalon backLeftMotor = RobotMap.driveTrainbackLeftMotor;
    CANTalon backRightMotor = RobotMap.driveTrainbackRightMotor;
    RobotDrive tankDrive = RobotMap.driveTraintankDrive;
    
    AnalogGyro gyro = RobotMap.gyro;
    
    
    public void initDefaultCommand() {
    	
        setDefaultCommand(new DriveWithJoystick());
        
    }
    
    public void driveWithJoystick(double left, double right) {
    	tankDrive.tankDrive(Utils.rampSpeed(left, RobotMap.SENSITIVITY), Utils.rampSpeed(right, RobotMap.SENSITIVITY));
    }
    
    public void initGyro() {
    	gyro.initGyro();
    	gyro.reset();
    }
    
    public double getGyro() {
    	return gyro.getAngle();
    }
    
    public void zeroEncoder(CANTalon tal) {
    	tal.setPosition(0);
    }
    
    public void setBrakeMode(CANTalon tal) {
    	tal.enableBrakeMode(true);
    }
    
    public void setCoastMode(CANTalon tal) {
    	tal.enableBrakeMode(false);
    }
    /*
    public double frontLeftPos() {
		return frontLeftMotor.getEncPosition();
	}

	
	public double frontRightPos() {
		return frontRightMotor.getEncPosition() * -1;
	}

	
	public double backLeftPos() {
		return backLeftMotor.getEncPosition();
	}
	
	
	public double backRightPos() {
		return backRightMotor.getEncPosition()* -1;
	}
    */
}

