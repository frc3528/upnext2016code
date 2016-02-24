package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ChevyJTTW extends CommandGroup {
    
    public  ChevyJTTW() {
    	
    	addSequential ( new MoveArmToPosition(1, 5, 1600) );
    	addSequential ( new DriveByEncoderCounts(1400, 5, -0.50) );
    	addParallel ( new DriveByEncoderCounts(1200, 7, -0.50) );
    	addSequential ( new MoveArmToPosition(1, 5, 400) );
    	
    }
}
