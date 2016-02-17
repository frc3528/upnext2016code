package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PortcullisJTTW extends CommandGroup {
    
    public  PortcullisJTTW() {
        
    	// Moving arm down the the low position for lifting the portcullis
    	addSequential ( new MoveArmToPosition(1, 5, 1720) );
    	// Driving forward just enough to get the arm in position to lift
    	addSequential ( new DriveByEncoderCounts(650, 5, -0.45) );
    	// Lifting the arm to vertical height, and driving forward slowly
    	addParallel ( new MoveArmToPosition(1, 6, 500) );
    	addSequential ( new DriveByEncoderCounts(800, 8, -0.37) );
    	// After the portcullis is lifted, continue driving forward through the defense.
    	addSequential ( new DriveByEncoderCounts(1100, 6, -0.6) );
    	
    }
}
