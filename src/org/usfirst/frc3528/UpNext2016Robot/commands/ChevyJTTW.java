package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ChevyJTTW extends CommandGroup {
    
    public  ChevyJTTW() {
    	
    	addSequential ( new MoveArmToPosition(1, 5, 1780) );
    	addSequential ( new DriveByEncoderCounts(700, 4, -0.6) );
    	addParallel ( new DriveByEncoderCounts(500, 5, -0.6) );
    	addSequential ( new MoveArmToPosition(1, 4, 400) );
    	
    }
}
