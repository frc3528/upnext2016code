package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RockWallAuto extends CommandGroup {
    
    public  RockWallAuto() {
    	addSequential( new BallOnTopAuto() );
    	//addSequential( new DriveUntilSensorsTriggered(-.7, 4));
        addSequential( new DriveByEncoderCounts(8000, 6, -.9) );
    }
}
