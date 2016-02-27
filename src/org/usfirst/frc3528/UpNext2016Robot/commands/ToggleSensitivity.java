package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleSensitivity extends Command {

    public ToggleSensitivity() {
    }

    protected void initialize() {
    	// Toggles boolean storing whether the robot is in "high gear" or not.
    	//RobotMap.isHighGear = !RobotMap.isHighGear;
    	if (RobotMap.driveMode == 0) {
    		RobotMap.driveMode = 1;
    		RobotMap.JOYSTICK_SCALE = .85;
    		RobotMap.JOYSTICK_CURVE = 3;
    	} else if (RobotMap.driveMode == 1) {
    		RobotMap.driveMode = 2;
    		RobotMap.JOYSTICK_SCALE = 1; // Originally ".75"
    		RobotMap.JOYSTICK_CURVE = 2;   // Originally "3"
    	} else if (RobotMap.driveMode == 2) {
    		RobotMap.driveMode = 0;
    		RobotMap.JOYSTICK_SCALE = .75;
    		RobotMap.JOYSTICK_CURVE = 3;
    	}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
