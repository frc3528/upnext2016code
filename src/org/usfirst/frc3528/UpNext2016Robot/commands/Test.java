package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Test extends CommandGroup {
    
    public  Test() {
    	addSequential ( new ZeroDriveEncoders() );
    	addSequential( new DriveByFeetForward(10, 20, -0.4, -0.4) );
    }
}
