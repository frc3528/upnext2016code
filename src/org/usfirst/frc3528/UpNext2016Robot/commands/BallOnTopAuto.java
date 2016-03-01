package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BallOnTopAuto extends CommandGroup {
    
    public  BallOnTopAuto() {
    	addSequential( new ResetArm() );
    	addSequential( new AutomateIntakeMotor(.3, 1) );
        addParallel( new MoveArmToPosition(0.6, 3, 500) );
        addSequential( new AutomateIntakeMotor(.3, 1) );
    }
}
