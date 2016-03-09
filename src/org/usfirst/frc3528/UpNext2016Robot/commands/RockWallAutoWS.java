package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RockWallAutoWS extends CommandGroup {
    
    public  RockWallAutoWS() {
    	addSequential( new BallOnTopAuto() );
    	addSequential( new DriveUntilSensorsTriggered(-.7, 4));
        addSequential( new DriveByEncoderCounts(5000, 6, -.9) );
    }
}
