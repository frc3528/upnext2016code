package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestCommand extends Command {

	double armPos;
	int targetPos = 500;
	
    public TestCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	armPos = RobotMap.armEncoder.get();
    	if (armPos > targetPos) {
    		System.out.println("armPos > targetPos");
    	} else if (armPos < targetPos){
    		System.out.println("armPos < targetPos");
    	} else {
    		System.out.println("armPos = targetPos");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
