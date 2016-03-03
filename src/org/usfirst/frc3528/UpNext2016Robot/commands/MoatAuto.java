package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoatAuto extends CommandGroup {
    
    public  MoatAuto() {
    	addSequential( new BallOnTopAuto() );
        addSequential( new DriveByEncoderCounts(7800, 6, -.8) );
    }
}
