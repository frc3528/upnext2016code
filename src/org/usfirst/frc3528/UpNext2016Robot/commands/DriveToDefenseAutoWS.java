package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToDefenseAutoWS extends CommandGroup {
    
    public  DriveToDefenseAutoWS() {
    	addSequential( new BallOnTopAuto() );
    	addSequential( new DriveUntilSensorsTriggered(-.5, 4));
    	//addSequential( new DriveByEncoderCounts(2200, 4, -.5) );
    }
}
