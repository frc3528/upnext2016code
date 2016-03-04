package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ChevyAuto extends CommandGroup {
    
    public  ChevyAuto() {
    	addSequential( new BallOnTopAuto() );
    	addSequential( new DriveUntilSensorsTriggered(-.5, 4));
    	//addSequential( new DriveByEncoderCounts(2200, 4, -.5) );
    	addSequential( new ChevyJTTW() );
    	addSequential( new DriveByEncoderCounts(700, 2, -.5) );
    }
}
