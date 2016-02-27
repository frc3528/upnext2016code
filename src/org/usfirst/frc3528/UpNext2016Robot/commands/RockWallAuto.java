package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RockWallAuto extends CommandGroup {
    
    public  RockWallAuto() {
    	addSequential( new BallOnTopAuto() );
        addSequential( new DriveByEncoderCounts(6300, 6, -.8) );
    }
}
