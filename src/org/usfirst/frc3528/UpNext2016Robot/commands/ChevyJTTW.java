package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ChevyJTTW extends CommandGroup {
    
    public  ChevyJTTW() {
    	
    	addSequential ( new MoveArmToPosition(1, 5, 1600) );
    	addSequential ( new DriveByEncoderCounts(900, 5, -0.53) );
    	addParallel ( new DriveByEncoderCounts(1700, 7, -0.53) );
    	addSequential ( new MoveArmToPosition(0.75, 6, 1400) );
    	
    }
}
