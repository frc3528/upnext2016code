package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarAutoBackwards extends CommandGroup {
    
    public  LowBarAutoBackwards() {
    	addSequential( new BallOnTopAuto() );
        addParallel( new LowerArmToLimit() );
        addSequential( new DriveByEncoderCounts(7000, 5, .60) );
    }
}
