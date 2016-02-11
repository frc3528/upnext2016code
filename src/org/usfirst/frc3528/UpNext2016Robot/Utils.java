package org.usfirst.frc3528.UpNext2016Robot;

public class Utils {

	public static double transform( double input ) {
		
		// deadband check
		if ( isInDeadband( input ) ) {
    		return 0;
    	}
		
		// clip the input to min & max
		input = ( clip(input) );
		
		// scale the input value
		double output = input * RobotMap.JOYSTICK_SCALE;
		
		// curve the input value
		output = Math.pow( output, RobotMap.JOYSTICK_CURVE );
		
		
		return output;
	}
	

	private static boolean isInDeadband(double input) {
		return input > RobotMap.JOYSTICK_DEADBAND_MIN && input < RobotMap.JOYSTICK_DEADBAND_MAX;
	}

	
	
	private static double clip( double input ) {
	
		double output = input;
		
		if ( input > RobotMap.JOYSTICK_RANGE_MAX ) {
    		output = RobotMap.JOYSTICK_RANGE_MAX;
    	} else if ( input < RobotMap.JOYSTICK_RANGE_MIN ) {
    		output = RobotMap.JOYSTICK_RANGE_MIN;
    	}
		
		return output;
    	
	}
}