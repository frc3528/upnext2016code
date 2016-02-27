package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PortcullisAuto extends CommandGroup {
    
    public  PortcullisAuto() {
    	addSequential( new BallOnTopAuto() );
    	addSequential( new DriveByEncoderCounts(2200, 4, -.5) );
    	addSequential( new PortcullisJTTW() );
    	addSequential( new DriveByEncoderCounts(700, 2, -.5) );
    }
}
