package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
	
	double timeout = 0;
	double power = 0;
	double Kp = 0.03;
	ADXRS450_Gyro gyro = RobotMap.gyro;
	
    public DriveStraight(double timeout, double power) {
        requires(Robot.driveTrain);
        
        this.timeout = timeout;
        this.power = power;
        
    }
    
    
    protected void initialize() {
    	
    }

    
    protected void execute() {
    }

    
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
    }

    
    protected void interrupted() {
    }
}
