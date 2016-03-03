package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToDefenseAuto extends CommandGroup {
    
    public  DriveToDefenseAuto() {
    	addSequential( new BallOnTopAuto() );
    	addSequential( new DriveByEncoderCounts(2200, 4, -.5) );
    }
}