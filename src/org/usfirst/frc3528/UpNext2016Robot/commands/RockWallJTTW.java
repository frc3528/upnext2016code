package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class RockWallJTTW extends CommandGroup {
    
    public  RockWallJTTW() {
    	// Only requires driving straight forward for now. May change later.
        addSequential( new DriveByEncoderCounts(1000, 6, 0.8) );
    }
}
