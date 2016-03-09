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
        autoChooser.addDefault("Do Nothing", new AutonomousCommand());
        autoChooser.addObject("Low Bar Auto", new LowBarAuto());
        autoChooser.addObject("Low Bar Auto WS", new LowBarAutoWS());
        autoChooser.addObject("Rock Wall Auto", new RockWallAuto());
        autoChooser.addObject("Rock Wall Auto WS", new RockWallAutoWS());
        autoChooser.addObject("Moat Auto", new MoatAuto());
        autoChooser.addObject("Cheval Auto", new ChevyAuto());
        autoChooser.addObject("Cheval Auto WS", new ChevyAutoWS());
        autoChooser.addObject("Portcullis Auto", new PortcullisAuto());
        autoChooser.addObject("Portcullis Auto WS", new PortcullisAutoWS());
        autoChooser.addObject("Drive To Defense", new DriveToDefenseAuto());
        autoChooser.addObject("Drive To Defense WS", new DriveToDefenseAutoWS());
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
