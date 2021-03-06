package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PortcullisAutoWS extends CommandGroup {
    
    public  PortcullisAutoWS() {
    	addSequential( new BallOnTopAuto() );
    	addSequential( new DriveUntilSensorsTriggered(-.5, 4));
    	//addSequential( new DriveByEncoderCounts(2200, 4, -.5) );
    	addSequential( new PortcullisJTTW() );
    	addSequential( new DriveByEncoderCounts(1500, 2, -.5) );
    }
}
