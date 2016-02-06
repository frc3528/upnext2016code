package org.usfirst.frc3528.UpNext2016Robot.subsystems;

import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeArm extends Subsystem {
    
    VictorSP armMotor = RobotMap.armDriveMotor;
    VictorSP intakeMotor = RobotMap.intakeDriveMotor;
    
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void driveArmWithJoystick(double power) {
    	armMotor.set(power);
    }
    
}
