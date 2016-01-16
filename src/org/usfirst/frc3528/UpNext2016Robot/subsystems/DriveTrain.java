
package org.usfirst.frc3528.UpNext2016Robot.subsystems;

import org.usfirst.frc3528.UpNext2016Robot.RobotMap;
import org.usfirst.frc3528.UpNext2016Robot.commands.*;

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
    
    
    public void initDefaultCommand() {
    	
        setDefaultCommand(new DriveWithJoystick());
        
    }
    
    public void driveWithJoystick(double left, double right) {
    	tankDrive.tankDrive(left, right);
    }
}

