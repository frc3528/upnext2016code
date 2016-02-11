
package org.usfirst.frc3528.UpNext2016Robot;

import org.usfirst.frc3528.UpNext2016Robot.commands.DriveIntakeMotor;
import org.usfirst.frc3528.UpNext2016Robot.commands.ResetArm;
import org.usfirst.frc3528.UpNext2016Robot.commands.ResetArmEncoder;
import org.usfirst.frc3528.UpNext2016Robot.commands.ReverseDriveControl;
import org.usfirst.frc3528.UpNext2016Robot.commands.ToggleDriveMode;
import org.usfirst.frc3528.UpNext2016Robot.commands.ToggleSensitivity;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public JoystickButton lowGearButton;
    public JoystickButton highGearButton;
    public JoystickButton driveModeToggleButton;
    public JoystickButton madCatsToggleDrive1;
    public JoystickButton madCatsToggleDrive2;
    public JoystickButton controlLeftTrigger;
    public JoystickButton controlRightTrigger;
    public JoystickButton reverseDriveControl;
    public JoystickButton resetArmButton;
    public JoystickButton resetArmEncPos;
    public JoystickButton toggleDriveSensitivity;
    public Joystick driveStick;
    //public Joystick leftStick;
    //public Joystick rightStick;
    public Joystick controlStick;
    
    
    public OI() {
        
        driveStick = new Joystick(0);
        //leftStick = new Joystick(1);
        //rightStick = new Joystick(2);
        controlStick = new Joystick(3);
        
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
        
        resetArmEncPos = new JoystickButton(controlStick, RobotMap.B);
        resetArmEncPos.whenPressed(new ResetArmEncoder());
        
        toggleDriveSensitivity = new JoystickButton(driveStick, RobotMap.START);
        toggleDriveSensitivity.whenPressed(new ToggleSensitivity());
        
        //madCatsToggleDrive1 = new JoystickButton(leftStick, RobotMap.TRIGGER);
        //madCatsToggleDrive1.whenPressed(new ToggleDriveMode());
        
        //madCatsToggleDrive2 = new JoystickButton(rightStick, RobotMap.TRIGGER);
        //madCatsToggleDrive2.whenPressed(new ToggleDriveMode());
        
    }
    
    
    //public Joystick getDriveStick() {
    //    return driveStick;
    //}
    
    
}

