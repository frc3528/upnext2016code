package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutomateIntakeMotor extends Command {

	double power;
	double timeout;
	
    public AutomateIntakeMotor(double power, double timeout) {
        requires(Robot.ballGatherer);
        
        this.power = power;
        this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeout);
    	Robot.ballGatherer.driveIntakeFromCommand(power);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ballGatherer.driveIntakeFromCommand(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
