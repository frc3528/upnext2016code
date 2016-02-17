package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PortcullisJTTW extends CommandGroup {
    
    public  PortcullisJTTW() {
        
    	addSequential ( new MoveArmToPosition(1, 5, 1720) );
    	addSequential ( new DriveByEncoderCounts(650, 5, -0.45) );
    	addParallel ( new MoveArmToPosition(1, 6, 500) );
    	addSequential ( new DriveByEncoderCounts(800, 8, -0.37) );
    	addSequential ( new DriveByEncoderCounts(1100, 6, -0.6) );
    	
    }
}
