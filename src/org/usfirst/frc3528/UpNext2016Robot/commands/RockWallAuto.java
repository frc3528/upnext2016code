package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RockWallAuto extends CommandGroup {
    
    public  RockWallAuto() {
    	addSequential( new BallOnTopAuto() );
    	addSequential( new DriveUntilSensorsTriggered(-.5, 4));
        addSequential( new DriveByEncoderCounts(3500, 6, -.8) );
    }
}
