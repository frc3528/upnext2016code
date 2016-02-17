package org.usfirst.frc3528.UpNext2016Robot.commands;

import org.usfirst.frc3528.UpNext2016Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class ResetArmEncoder extends Command {

    public ResetArmEncoder() {
    }

    protected void initialize() {
    	Robot.intakeArm.zeroArmEncoder();
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
