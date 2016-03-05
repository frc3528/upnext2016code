package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarAuto extends CommandGroup {
    
    public  LowBarAuto() {
    	addSequential( new BallOnTopAuto() );
        addSequential( new LowerArmToLimit() );
        addSequential( new DriveUntilSensorsTriggered(-.5, 4));
        addSequential( new DriveByEncoderCounts(4500, 6, -.60) );
    }
}
