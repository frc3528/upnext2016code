package org.usfirst.frc3528.UpNext2016Robot;

import org.usfirst.frc3528.UpNext2016Robot.commands.ChevyJTTW;
import org.usfirst.frc3528.UpNext2016Robot.commands.DriveIntakeMotor;
import org.usfirst.frc3528.UpNext2016Robot.commands.ResetArm;
import org.usfirst.frc3528.UpNext2016Robot.commands.ResetArmEncoder;
import org.usfirst.frc3528.UpNext2016Robot.commands.ReverseDriveControl;
import org.usfirst.frc3528.UpNext2016Robot.commands.PortcullisJTTW;
import org.usfirst.frc3528.UpNext2016Robot.commands.ToggleDriveMode;
import org.usfirst.frc3528.UpNext2016Robot.commands.ToggleSensitivity;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Joysticks
	
    public Joystick driveStick;
    public Joystick controlStick;
	
    
    // Joystick Buttons
    
    public JoystickButton driveModeToggleButton;
    public JoystickButton madCatsToggleDrive1;
    public JoystickButton madCatsToggleDrive2;
    public JoystickButton controlLeftTrigger;
    public JoystickButton controlRightTrigger;
    public JoystickButton reverseDriveControl;
    public JoystickButton resetArmButton;
    public JoystickButton resetArmEncPos;
    public JoystickButton toggleDriveSensitivity;
    public JoystickButton driveRightTrigger;
    public JoystickButton test;
    public JoystickButton driveLeftTrigger;
    
    
    public OI() {
        
    	// Constructing joysticks
    	
        driveStick = new Joystick(0);
        controlStick = new Joystick(3);
        
        
        // Assigning buttons to commands
        
        controlLeftTrigger = new JoystickButton(controlStick, RobotMap.LEFT_TRIGGER);
        controlLeftTrigger.whenPressed(new DriveIntakeMotor());
        
        controlRightTrigger = new JoystickButton(controlStick, RobotMap.RIGHT_TRIGGER);
        controlRightTrigger.whenPressed(new DriveIntakeMotor());
        
        driveModeToggleButton = new JoystickButton(driveStick, RobotMap.Y);
        driveModeToggleButton.whenPressed(new ToggleDriveMode());
        
        reverseDriveControl = new JoystickButton(driveStick, RobotMap.X);
        reverseDriveControl.whenPressed(new ReverseDriveControl());
        
        resetArmButton = new JoystickButton(controlStick, RobotMap.A);
        resetArmButton.whenPressed(new ResetArm());
        
        
        
        // Might want to remove this button entirely. We don't want to reset the encoder anywhere else.
        //
        resetArmEncPos = new JoystickButton(controlStick, RobotMap.B);
        resetArmEncPos.whenPressed(new ResetArmEncoder());
        //
        //
        
        
        toggleDriveSensitivity = new JoystickButton(driveStick, RobotMap.START);
        toggleDriveSensitivity.whenPressed(new ToggleSensitivity());
        
        driveRightTrigger = new JoystickButton(driveStick, RobotMap.RIGHT_TRIGGER);
        driveRightTrigger.whenPressed(new PortcullisJTTW());
        
        driveLeftTrigger = new JoystickButton(driveStick, RobotMap.LEFT_TRIGGER);
        driveLeftTrigger.whenPressed(new ChevyJTTW());
        
    }
    
}

