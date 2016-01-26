
package org.usfirst.frc3528.UpNext2016Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public JoystickButton lowGearButton;
    public JoystickButton highGearButton;
    public Joystick driveStick;
    
    
    public OI() {
        
        driveStick = new Joystick(0);
        
    }
    
    
    public Joystick getDriveStick() {
        return driveStick;
    }
    
    
}

