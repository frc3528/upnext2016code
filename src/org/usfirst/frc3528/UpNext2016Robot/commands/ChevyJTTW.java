package org.usfirst.frc3528.UpNext2016Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ChevyJTTW extends CommandGroup {
    
    public  ChevyJTTW() {
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
    	
    	addSequential ( new MoveArmToPosition(1, 5, 1600) );
    	addParallel ( new DriveByEncoderCounts(2600, 5, -0.53) ); // 900 + the 1700
    	//addParallel ( new DriveByEncoderCounts(1700, 7, -0.53) );
    	addSequential ( new MoveArmToPosition(0.75, 6, 1400) );
    	
    }
}
