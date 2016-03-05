package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PortcullisAuto extends CommandGroup {
    
    public  PortcullisAuto() {
    	addSequential( new BallOnTopAuto() );
    	//addSequential( new DriveUntilSensorsTriggered(-.5, 4));
    	addSequential( new DriveByEncoderCounts(2450, 4, -.5) );
    	addSequential( new PortcullisJTTW() );
    	addSequential( new DriveByEncoderCounts(1500, 2, -.5) );
    }
}
