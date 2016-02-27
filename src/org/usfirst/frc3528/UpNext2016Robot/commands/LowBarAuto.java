package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarAuto extends CommandGroup {
    
    public  LowBarAuto() {
    	addSequential( new BallOnTopAuto() );
        addSequential( new LowerArmToLimit() );
        addSequential( new DriveByEncoderCounts(6000, 6, -.60) );
    }
}
