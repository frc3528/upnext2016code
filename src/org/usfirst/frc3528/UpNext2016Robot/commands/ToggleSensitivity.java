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
    	RobotMap.isHighGear = !RobotMap.isHighGear;
    }

    protected void execute() {
    	// Switches the values used for ramping code
    	if (RobotMap.isHighGear) {
    		RobotMap.JOYSTICK_SCALE = 1;
    		RobotMap.JOYSTICK_CURVE = 1;
    	} else {
    		RobotMap.JOYSTICK_SCALE = .75;
    		RobotMap.JOYSTICK_CURVE = 3;
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
