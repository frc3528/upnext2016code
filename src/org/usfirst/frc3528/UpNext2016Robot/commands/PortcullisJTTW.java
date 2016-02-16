package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PortcullisJTTW extends CommandGroup {
    
    public  PortcullisJTTW() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential ( new MoveArmToPosition(1, 5, 1720) );
    	addSequential ( new DriveByEncoderCounts(-650, 5, .45) );
    	addParallel ( new MoveArmToPosition(.75, 6, 500) );
    	addSequential ( new DriveByEncoderCounts(-2000, 6, .55) );
    	
    }
}
