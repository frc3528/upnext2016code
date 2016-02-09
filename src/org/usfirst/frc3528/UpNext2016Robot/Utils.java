package org.usfirst.frc3528.UpNext2016Robot;

public class Utils {

	//A method used for smooth driving
	public static double rampSpeed(double input) {
    	//auto set sensitivity to .5
    	return rampSpeed(input, .5);
	}	


	public static double rampSpeed(double input, double sensitivity) {

    	if (IsInDeadband(input)) {
    		return 0;
    	}
    	if (IsAtTop(input)) {
    		return RobotMap.JOYSTICK_TOP;
    	}
    	
    	if(IsAtBottom(input)) {
    		return RobotMap.JOYTICK_BOTTOM;
    	}

    	//formula for ramping: f(x) = ax^3 + (1-a)x where a is the sensitivity and x is the input
    	return (sensitivity * input * input * input + (1 - sensitivity) * input);
	}


	private static boolean IsInDeadband(double input) {
		return input > -.1 && input < .1;
	}

	
	private static boolean IsAtTop(double input) {
		return input >= RobotMap.JOYSTICK_TOP;
	}
	
	
	private static boolean IsAtBottom(double input) {
		return input <= RobotMap.JOYTICK_BOTTOM;
	}
}