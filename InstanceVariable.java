/**
 * @author Max Gastelum
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This class will be used to create an instance variable object to record things like the type, name, and value of the variable
public class InstanceVariable {

	private String type;
	private String name;
	private String value;
	
	
	// Default Constructor
	public InstanceVariable() {
		
	}
		
	
	// This method checks the validity of the variable type before accepting it
	public boolean setType(String type) {
		
		Pattern instanceVariableTypePattern = Pattern.compile("^[A-Za-z0-9_]+$");
		Matcher instanceVariableTypeMatcher = instanceVariableTypePattern.matcher(type);
		
		if (instanceVariableTypeMatcher.find()) {
			this.type = type;
			return true;
		} else {
			return false;
		}
		
	}
	
	
	// This method checks the validity of the variable name before accepting it
	public boolean setName(String name) {
		
		Pattern instanceVariableNamePattern = Pattern.compile("^[a-z][A-Za-z0-9_]*$");
		Matcher instanceVariableNameMatcher = instanceVariableNamePattern.matcher(name);
		
		if (instanceVariableNameMatcher.find()) {
			this.name = name;
			return true;
		} else {
			return false;
		}
		
	}
	

	// This method checks the validity of the variable value before accepting it
	public boolean setValue(String value, boolean bypassTypeChecking) {
		
		Pattern instanceVariableValuePattern;
		Matcher instanceVariableValueMatcher;
		
		// If type checking is bypassed
		if(bypassTypeChecking) {
			this.value = value;
			return true;
		}
		
		// This switch statement accounts for most common Java data types used in OOP to ensure the correct type of value is assigned
		switch (this.type) {
			case "int":
				instanceVariableValuePattern = Pattern.compile("^[0-9]{1,10}$");
				instanceVariableValueMatcher = instanceVariableValuePattern.matcher(value);
				if (instanceVariableValueMatcher.find() && (Integer.parseInt(value) >= -2147483648 &&  Integer.parseInt(value) <= 2147483647) ) {
					this.value = value;
					return true;
				} else {
					return false;
				}
			case "double":
				instanceVariableValuePattern = Pattern.compile("(?=^.{0,16}$)(([0-9]{1,16}\\.?[0-9]{0,16})|([0-9]{0,16}\\.?[0-9]{1,16}))");
				instanceVariableValueMatcher = instanceVariableValuePattern.matcher(value);
				if(instanceVariableValueMatcher.find()) {
					this.value = value;
					return true;
				} else {
					return false;
				}

			case "boolean":
				if(value.equals("true") || value.equals("false")) {
					this.value = value;
					return true;
				} else {
					return false;
				}
			case "char":
				instanceVariableValuePattern = Pattern.compile("^.$");
				instanceVariableValueMatcher = instanceVariableValuePattern.matcher(value);
				if(instanceVariableValueMatcher.find()) {
					this.value = value;
					return true;
				} else {
					return false;
				}
			case "String":
				instanceVariableValuePattern = Pattern.compile("^\\\".*\\\"$");
				instanceVariableValueMatcher = instanceVariableValuePattern.matcher(value);
				if(instanceVariableValueMatcher.find()) {
					this.value = value;
					return true;
				} else {
					return false;
				}
		}
		
		// If the variable type is not one accounted for above, it is assumed it is another type of variable or user created type and will automatically be accepted
		this.value = value;
		return true;
		
	}
	
	
	public String getType() {
		return this.type;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	
	public String getValue() {
		return this.value;
	}
	
	
}
