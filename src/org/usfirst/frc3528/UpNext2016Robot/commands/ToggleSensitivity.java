package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleSensitivity extends Command {

    public ToggleSensitivity() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.isHighGear = !RobotMap.isHighGear;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (RobotMap.isHighGear) {
    		RobotMap.JOYSTICK_SCALE = 1;
    		RobotMap.JOYSTICK_CURVE = 1;
    	} else {
    		RobotMap.JOYSTICK_SCALE = .75;
    		RobotMap.JOYSTICK_CURVE = 3;
    	}
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