package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PortcullisJTTW extends CommandGroup {
    
    public  PortcullisJTTW() {
        
    	// Moving arm down the the low position for lifting the portcullis
    	addSequential ( new MoveArmToPosition(1, 6, 1700) );
    	
    	addParallel ( new LowerArmToLimit() );
    	// Driving forward just enough to get the arm in position to lift
    	addSequential ( new DriveByEncoderCounts(400, 2, -0.45) );
    	// Lifting the arm to vertical height, and driving forward slowly
    	addParallel ( new MoveArmToPosition(1, 6, 1300) );
    	addSequential ( new DriveByEncoderCounts(100, 3, -0.44) );
    	addParallel ( new MoveArmToPosition(1, 6, 300) );
    	addSequential( new DriveByEncoderCounts(400, 4, -0.6) );
    	// After the portcullis is lifted, continue driving forward through the defense.
    	addSequential ( new DriveByEncoderCounts(500, 5, -0.6) );
    	
    }
}
