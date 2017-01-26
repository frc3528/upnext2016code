package org.usfirst.frc3528.UpNext2016Robot.subsystems;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;
import org.usfirst.frc3528.UpNext2016Robot.Utils;
import org.usfirst.frc3528.UpNext2016Robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends Subsystem {
	
	// Encoder positions and gyro angle
	double frontLeftEncPos;
	double frontRightEncPos;
	double gyroAngle;
	
	boolean isRightSensorTriggered;
	boolean isLeftSensorTriggered;
	boolean driveReversed;
	
	
	// Constructing drivetrain and Gyro
	
    CANTalon frontLeftMotor = RobotMap.driveTrainfrontLeftMotor;
    CANTalon frontRightMotor = RobotMap.driveTrainfrontRightMotor;
    CANTalon backLeftMotor = RobotMap.driveTrainbackLeftMotor;
    CANTalon backRightMotor = RobotMap.driveTrainbackRightMotor;
    RobotDrive tankDrive = RobotMap.driveTraintankDrive;
    
    ADXRS450_Gyro gyro = RobotMap.gyro;
    
    DigitalInput rightSensor = RobotMap.frontRightSensor;
    DigitalInput leftSensor = RobotMap.frontLeftSensor;
    
    
    public void initDefaultCommand() {
    	
        setDefaultCommand(new DriveWithJoystick());
        
    }
    
    // Called from DriveWithJoystick command to pass in joystick values
    public void driveWithJoystick(double left, double right) {
    	this.drive( left, right );
    }
    
    // Applies power to the motors with ramping functions
    public void drive(double left, double right) {
    	tankDrive.tankDrive(Utils.transform(left), Utils.transform(right), false);
    }
    
    // Applies the same power input to both motor sets. (With ramping functions)
    public void drive(double power) {
    	drive(power, power);
    }
    
    // Applies power to the motors without ramping functions
    public void rawDrive(double left, double right) {
    	tankDrive.tankDrive(left, right);
    }
     
    // Resets a drive encoder
    public void zeroEncoder(CANTalon tal) {
    	tal.setPosition(0);
    }
    
    public void updateSensitivity() {
    	if (RobotMap.driveMode == 1) {
    		RobotMap.JOYSTICK_SCALE = .85;
    		RobotMap.JOYSTICK_CURVE = 3;
    	} else if (RobotMap.driveMode == 2) {
    		RobotMap.JOYSTICK_SCALE = 1;
    		RobotMap.JOYSTICK_CURVE = 2;
    	} else if (RobotMap.driveMode == 0) {
    		RobotMap.JOYSTICK_SCALE = .75;
    		RobotMap.JOYSTICK_CURVE = 3;
    	}
    }
    
    
    // Brake and Coast mode
    public void setBrakeMode(CANTalon tal) {
    	tal.enableBrakeMode(true);
    }
    
    public void setCoastMode(CANTalon tal) {
    	tal.enableBrakeMode(false);
    }
    
    
    // Returns the current position of the left drive encoder
    public double leftPos() {
		return frontLeftMotor.getEncPosition();
	}
	
    // Returns the current position of the right drive encoder
	public double rightPos() {
		return frontRightMotor.getEncPosition() * -1;
	}
	
	public boolean getRightSensorValue() {
		return rightSensor.get();
	}
	
	public boolean getLeftSensorValue() {
		return leftSensor.get();
	}
	
	
	// Zeros specific motors
	public void zeroLeftEncoder() {
		zeroEncoder(frontLeftMotor);
	}
	
	public void zeroRightEncoder() {
		zeroEncoder(frontRightMotor);
	}
	
	
	// Zeros both drive encoders
	public void zeroEncoders() {
		zeroLeftEncoder();
		zeroRightEncoder();
	}
	
	// Called to update encoder positions on the dashboard
	public void updateTelemetry() {
		frontLeftEncPos = Robot.driveTrain.leftPos();
    	frontRightEncPos = Robot.driveTrain.rightPos();
    	isRightSensorTriggered = getRightSensorValue();
    	isLeftSensorTriggered = getLeftSensorValue();
		
		SmartDashboard.putNumber("Left Encoder: ", frontLeftEncPos);
    	SmartDashboard.putNumber("Right Encoder: ", frontRightEncPos);
    	SmartDashboard.putBoolean("Right Sensor Triggered: ", isRightSensorTriggered);
    	SmartDashboard.putBoolean("Left Sensor Triggered: ", isLeftSensorTriggered);
	}
    
}
