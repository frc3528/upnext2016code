
package org.usfirst.frc3528.UpNext2016Robot;

import org.usfirst.frc3528.UpNext2016Robot.commands.ToggleDriveMode;

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
    public Joystick driveStick;
    //public Joystick leftStick;
    //public Joystick rightStick;
    public Joystick controlStick;
    
    
    public OI() {
        
        driveStick = new Joystick(0);
        //leftStick = new Joystick(1);
        //rightStick = new Joystick(2);
        controlStick = new Joystick(3);
        
        driveModeToggleButton = new JoystickButton(driveStick, RobotMap.Y);
        driveModeToggleButton.whenPressed(new ToggleDriveMode());
        
        //madCatsToggleDrive1 = new JoystickButton(leftStick, RobotMap.TRIGGER);
        //madCatsToggleDrive1.whenPressed(new ToggleDriveMode());
        
        //madCatsToggleDrive2 = new JoystickButton(rightStick, RobotMap.TRIGGER);
        //madCatsToggleDrive2.whenPressed(new ToggleDriveMode());
        
    }
    
    
    //public Joystick getDriveStick() {
    //    return driveStick;
    //}
    
    
}

