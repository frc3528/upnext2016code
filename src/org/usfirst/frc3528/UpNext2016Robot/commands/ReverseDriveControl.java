package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReverseDriveControl extends Command {

    public ReverseDriveControl() {
    }

    protected void initialize() {
    	// Toggles the boolean that stores whether robot is in reversed drive mode or not.
    	RobotMap.driveIsReversed = !RobotMap.driveIsReversed;
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
