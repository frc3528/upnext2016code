package org.usfirst.frc3528.UpNext2016Robot.subsystems;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;
import org.usfirst.frc3528.UpNext2016Robot.commands.DriveArmWithJoystick;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class IntakeArm extends Subsystem {
    
    double armEncoderPos;
	boolean isArmIn;
	boolean isArmOut;
	
	
	// Constructing VictorSP Speed Controller and Encoder.
    VictorSP armMotor = RobotMap.armDriveMotor;
    Encoder armEncoder = RobotMap.armEncoder;
    
    // Constructing Hall Effect sensors to detect the high and low positions of the arm.
    DigitalInput armIn = RobotMap.armIn;
    DigitalInput armOut = RobotMap.armOut;
    
	
    public void initDefaultCommand() {
    	
    	setDefaultCommand(new DriveArmWithJoystick());
    	
    }
    
    // Applies power to the arm. Called to pass in joystick values specifically.
    public void driveArmWithJoystick(double power) {
    	armMotor.set(power);
    }
    
    // Applies power to the arm like above. Can be used for automation.
    public void driveArm(double power) {
    	armMotor.set(power);
    }
    
    // Returns the current position of the arm in encoder counts.
    public int getArmPos() {
    	return armEncoder.get();
    }
    
    // Resets the arm encoder to 0
    public void zeroArmEncoder() {
    	armEncoder.reset();
    }
    
    // Returns the value of the Hall Effect sensor marking the High position
    public boolean armIn() {
    	return !armIn.get();
    }
    
    // Returns the value of the Hall Effect sensor marking the Low position
    public boolean armOut() {
    	return !armOut.get();
    }
    
    public void setEncoderPosition(double position) {
    	
    }
    
    // Refreshes SmartDashboard data for the arm.
    public void updateArmTelemetry() {
    	armEncoderPos = Robot.intakeArm.getArmPos();
    	isArmIn = Robot.intakeArm.armIn();
    	isArmOut = Robot.intakeArm.armOut();
    	
    	SmartDashboard.putNumber("Arm Encoder", armEncoderPos);
    	SmartDashboard.putBoolean("Arm In: ", isArmIn);
    	SmartDashboard.putBoolean("Arm Out: ", isArmOut);
    }
    
}
