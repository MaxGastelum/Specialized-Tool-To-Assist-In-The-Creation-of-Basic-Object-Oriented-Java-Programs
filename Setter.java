/**
 * @author Max Gastelum
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This class will be used to create setter methods
public class Setter {
	
	private String header;
	private String instanceVariableAssignment;
	
	
	// Default Constructor
	public Setter() {
		
	}
	
	
	// This method will be used to validate the header for the set statement before accepting it
	public boolean setSetterHeader (String inputtedHeader, InstanceVariable instanceVariable) {
		
		// Adjusting instance variable name so first letter is capitalized
		String instanceVariableName = instanceVariable.getName().substring(0, 1).toUpperCase() + instanceVariable.getName().substring(1);
		
		Pattern setterHeaderPattern = Pattern.compile("^(public\\s+|private\\s+|protected\\s+)?\\s*void"
				                                      + "\\s*set" + instanceVariableName + "\\s*"
				                                      + "\\(\\s*" + instanceVariable.getType() +"\\s*" + instanceVariable.getName() + "\\s*\\)\\s*\\{\\s*\\}\\s*$");
		Matcher setterHeaderMatcher = setterHeaderPattern.matcher(inputtedHeader);
		
		if (setterHeaderMatcher.find()) {
			this.header = inputtedHeader;
			return true;
		} else {
			return false;
		}
	}
	
	
	// This method will be used to validate the conventional instance variable assignment before accepting them
	public boolean setConventionalAssigment (String inputtedAssignment, InstanceVariable instanceVariable) {
		
		Pattern instanceVariableInitializationPattern  = Pattern.compile("^this\\." + instanceVariable.getName() + "\\s*=\\s*" + instanceVariable.getName() + "\\s*;$");
		Matcher instanceVariableInitializationMatcher = instanceVariableInitializationPattern.matcher(inputtedAssignment);
		
		if (instanceVariableInitializationMatcher.find()) {
			this.instanceVariableAssignment = inputtedAssignment;
			return true;
		} else {
			return false;
		}
	}
	
	
	// This method will be used to validate the flexible instance variable assignment before accepting them
	public boolean setFlexibleAssignment (String inputtedAssignment, InstanceVariable instanceVariable) {
			
		Pattern instanceVariableInitializationPattern  = Pattern.compile("^this\\." + instanceVariable.getName() + "\\s*=\\s*" + instanceVariable.getValue() + "\\s*;$");
		Matcher instanceVariableInitializationMatcher = instanceVariableInitializationPattern.matcher(inputtedAssignment);
			
		if (instanceVariableInitializationMatcher.find()) {
			this.instanceVariableAssignment = inputtedAssignment;
			return true;
		} else {
			return false;
		}
	}
	
	
	// This method will return a formatted String representing the setter as proper Java code
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		
		// Write header
		this.header.trim();
		str.append("\t" + this.header.substring(0, this.header.length() - 1) + "\n");
		
		// Write the body
		str.append("\t\t" + this.instanceVariableAssignment + "\n");
		
		// Add the closing bracket back in			
		str.append("\t}");
						
		return str.toString();
		
	}
	
}
