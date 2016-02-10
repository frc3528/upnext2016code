package org.usfirst.frc3528.UpNext2016Robot.subsystems;

import org.usfirst.frc3528.UpNext2016Robot.RobotMap;
import org.usfirst.frc3528.UpNext2016Robot.commands.DriveArmWithJoystick;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeArm extends Subsystem {
    
    VictorSP armMotor = RobotMap.armDriveMotor;
    VictorSP intakeMotor = RobotMap.intakeDriveMotor;
    
    Encoder armEncoder = RobotMap.armEncoder;
    
    DigitalInput armIn = RobotMap.armIn;
    DigitalInput armOut = RobotMap.armOut;
	
    public void initDefaultCommand() {
    	
    	setDefaultCommand(new DriveArmWithJoystick());
    	
    }
    
    public void driveArmWithJoystick(double power) {
    	armMotor.set(power);
    }
    
    public void driveArm(double power) {
    	armMotor.set(power);
    }
    
    public void driveIntakeWithTriggers(double power) {
    	intakeMotor.set(power);
    }
    
    public int getArmPos() {
    	return armEncoder.get();
    }
    
    public void zeroArmEncoder() {
    	armEncoder.reset();
    }
    
    public boolean armIn() {
    	return !armIn.get();
    }
    
    public boolean armOut() {
    	return !armOut.get();
    }
    
}
