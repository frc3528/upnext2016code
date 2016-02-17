package org.usfirst.frc3528.UpNext2016Robot;

import org.usfirst.frc3528.UpNext2016Robot.commands.*;
import org.usfirst.frc3528.UpNext2016Robot.subsystems.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	
	// Setting up an Autonomous Mode chooser
    Command autonomousCommand;
    SendableChooser autoChooser;

    public static OI oi;
    public static DriveTrain driveTrain;
    public static IntakeArm intakeArm;
    public static BallGatherer ballGatherer;

    
    // Called when the robot is first started up
    public void robotInit() {
    RobotMap.init();
    	
    	System.out.println("==== Insert Robot Name Here (2016) ====");
        
    	
        driveTrain = new DriveTrain();
        intakeArm = new IntakeArm();
        ballGatherer = new BallGatherer();
        oi = new OI();
        
        
        // ********** Finish setting up autonomous chooser **********
        
        autonomousCommand = new AutonomousCommand();
        
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Default Command", new AutonomousCommand());
        //autoChooser.addObject("Add name here", new CommandHere());
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        
        // ********** Finish setting up autonomous chooser **********
        
    }
    
    
    // Called first when robot is disabled
    public void disabledInit(){

    }
    
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void autonomousInit() {
       autonomousCommand = (Command) autoChooser.getSelected();
       autonomousCommand.start();
    }
    
    
    // Called periodically during autonomous
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    
    // Called when teleop is first called
    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    // Called periodically during teleop
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    // Called periodically during test mode
    public void testPeriodic() {
        LiveWindow.run();
    }
}
