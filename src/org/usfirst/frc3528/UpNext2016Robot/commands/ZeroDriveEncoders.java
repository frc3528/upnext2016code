package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;
import org.usfirst.frc3528.UpNext2016Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZeroDriveEncoders extends Command {

    public ZeroDriveEncoders() {
    }

    protected void initialize() {
    	// Setting timeout
    	setTimeout(.075);
    }

    protected void execute() {
    	// Zeroing encoders. (And setting the timeout again?)
    	setTimeout(.075);
    	Robot.driveTrain.zeroEncoders();
    }

    protected boolean isFinished() {
    	// Returns true when either both drive encoders reach 0, or timeout is reached.
    	return Robot.driveTrain.leftPos() == 0 && Robot.driveTrain.rightPos() == 0 || isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
