package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ToggleDriveMode extends Command {

    public ToggleDriveMode() {
    }

    protected void initialize() {
    	// Toggles boolean that stores whether the robot is in single joystick drive mode or not.
    	RobotMap.driveWithSingleJoystick = !RobotMap.driveWithSingleJoystick;
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
