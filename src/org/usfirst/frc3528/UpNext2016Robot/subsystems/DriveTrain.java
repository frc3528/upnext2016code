
package org.usfirst.frc3528.UpNext2016Robot.subsystems;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;
import org.usfirst.frc3528.UpNext2016Robot.Utils;
import org.usfirst.frc3528.UpNext2016Robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends Subsystem {
    
	double frontLeftEncPos;
	double frontRightEncPos;
	
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
    	this.drive( left, right );
    }
    
    public void drive(double left, double right) {
    	tankDrive.tankDrive(Utils.transform(left), Utils.transform(right), false);
    }
    
    public void drive(double power) {
    	drive(power, power);
    }
    
    public void rawDrive(double left, double right) {
    	tankDrive.tankDrive(left, right);
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
    
    public double leftPos() {
		return frontLeftMotor.getEncPosition();
	}
	
	public double rightPos() {
		return frontRightMotor.getEncPosition() * -1;
	}
	
	public void zeroLeftEncoder() {
		zeroEncoder(frontLeftMotor);
	}
	
	public void zeroRightEncoder() {
		zeroEncoder(frontRightMotor);
	}
	
	public void zeroEncoders() {
		zeroLeftEncoder();
		zeroRightEncoder();
	}
	
	public void updateTelemetry() {
		frontLeftEncPos = Robot.driveTrain.leftPos();
    	frontRightEncPos = Robot.driveTrain.rightPos();
		
		SmartDashboard.putNumber("Left Encoder: ", frontLeftEncPos);
    	SmartDashboard.putNumber("Right Encoder: ", frontRightEncPos);
	}
    
}
