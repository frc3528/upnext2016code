package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToDefenseAuto extends CommandGroup {
    
    public  DriveToDefenseAuto() {
    	addSequential( new BallOnTopAuto() );
    	//addSequential( new DriveUntilSensorsTriggered(-.5, 4));
    	addSequential( new DriveByEncoderCounts(2450, 4, -.5) );
    }
}
