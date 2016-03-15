package org.usfirst.frc3528.UpNext2016Robot;

import org.usfirst.frc3528.UpNext2016Robot.commands.ChevyJTTW;
import org.usfirst.frc3528.UpNext2016Robot.commands.DecreaseSensitivity;
import org.usfirst.frc3528.UpNext2016Robot.commands.DriveIntakeMotor;
import org.usfirst.frc3528.UpNext2016Robot.commands.IncreaseSensitivity;
import org.usfirst.frc3528.UpNext2016Robot.commands.ResetArm;
import org.usfirst.frc3528.UpNext2016Robot.commands.ReverseDriveControl;
import org.usfirst.frc3528.UpNext2016Robot.commands.PortcullisJTTW;
import org.usfirst.frc3528.UpNext2016Robot.commands.ToggleDriveMode;

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
    public Joystick testStick;
	
    
    // Joystick Buttons
    
    public JoystickButton driveModeToggleButton;
    public JoystickButton madCatsToggleDrive1;
    public JoystickButton madCatsToggleDrive2;
    public JoystickButton controlLeftTrigger;
    public JoystickButton controlRightTrigger;
    public JoystickButton reverseDriveControl;
    public JoystickButton resetArmButton;
    public JoystickButton resetArmEncPos;
    public JoystickButton driveLeftTrigger;
    public JoystickButton driveRightTrigger;
    public JoystickButton test;
    public JoystickButton controlBackButton;
    public JoystickButton controlStartButton;
    
    
    public OI() {
        
    	// Constructing joysticks
    	
        driveStick = new Joystick(0);
        controlStick = new Joystick(1);
        testStick = new Joystick(5);
        
        
        // Assigning buttons to commands
        
        
        // Control Stick
        controlLeftTrigger = new JoystickButton(controlStick, RobotMap.LEFT_TRIGGER);
        controlLeftTrigger.whenPressed(new DriveIntakeMotor());
        
        controlRightTrigger = new JoystickButton(controlStick, RobotMap.RIGHT_TRIGGER);
        controlRightTrigger.whenPressed(new DriveIntakeMotor());
        
        resetArmButton = new JoystickButton(controlStick, RobotMap.A);
        resetArmButton.whenPressed(new ResetArm());
        
        controlBackButton = new JoystickButton(controlStick, RobotMap.BACK);
        controlBackButton.whenPressed(new ChevyJTTW());
        
        controlStartButton = new JoystickButton(controlStick, RobotMap.START);
        controlStartButton.whenPressed(new PortcullisJTTW());
        
        // Drive Stick
        
        driveModeToggleButton = new JoystickButton(driveStick, RobotMap.Y);
        driveModeToggleButton.whenPressed(new ToggleDriveMode());
        
        reverseDriveControl = new JoystickButton(driveStick, RobotMap.A);
        reverseDriveControl.whenPressed(new ReverseDriveControl());
        
        driveLeftTrigger = new JoystickButton(driveStick, RobotMap.LEFT_TRIGGER);
        driveLeftTrigger.whenPressed(new DecreaseSensitivity());
        
        driveRightTrigger = new JoystickButton(driveStick, RobotMap.RIGHT_TRIGGER);
        driveRightTrigger.whenPressed(new IncreaseSensitivity());
    }
    
}

