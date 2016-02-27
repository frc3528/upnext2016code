package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ChevyAuto extends CommandGroup {
    
    public  ChevyAuto() {
    	addSequential(new DriveByEncoderCounts(701, 4, .4));
    	addSequential(new ChevyJTTW());
    }
}
