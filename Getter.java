/**
 * @author Max Gastelum
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Getter {

	String header;
	String returnStatement;
	
	
	// Default constructor
	public Getter() {
		
	}
	
	
	// This method will be used to validate the header of the getter method before accepting it
	public boolean setGetterHeader(String inputtedHeader, InstanceVariable instanceVariable) {
		
		// Adjusting instance variable name so first letter is capitalized
		String instanceVariableName = instanceVariable.getName().substring(0, 1).toUpperCase() + instanceVariable.getName().substring(1);
				
		Pattern getterHeaderPattern = Pattern.compile("^(public\\s+|private\\s+|protected\\s+)?\\s*"
						                                      + instanceVariable.getType() + "\\s*get" + instanceVariableName + "\\s*"
						                                      + "\\(\\s*\\)\\s*\\{\\s*\\}\\s*$");
		Matcher getterHeaderMatcher = getterHeaderPattern.matcher(inputtedHeader);
		
		if (getterHeaderMatcher.find()) {
			this.header = inputtedHeader;
			return true;
		} else {
			return false;
		}
	}
	
	
	// This method will be used to validate the return statement that goes inside the getter method before accepting it
	public boolean setStandardReturnStatement(String inputtedReturnStatement, InstanceVariable instanceVariable) {
		
		Pattern returnStatementPattern = Pattern.compile("^return\\s+this\\." + instanceVariable.getName() + "\\s*;\\s*$");
		Matcher returnStatementMatcher = returnStatementPattern.matcher(inputtedReturnStatement);
		
		if (returnStatementMatcher.find()) {
			this.returnStatement = inputtedReturnStatement;
			return true;
		} else {
			return false;
		}
	}
	
	
	// This method will be used to validate the flexible return statement
	public boolean setFlexibleReturnStatement(String inputtedReturnStatement, InstanceVariable instanceVariable) {
		
		Pattern returnStatementPattern = Pattern.compile("^return\\s+.*;$");
		Matcher returnStatementMatcher = returnStatementPattern.matcher(inputtedReturnStatement);
		
		if (returnStatementMatcher.find()) {
			this.returnStatement = inputtedReturnStatement;
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
		str.append("\t\t" + this.returnStatement + "\n");
			
		// Add the closing bracket back in			
		str.append("\t}");
							
		return str.toString();
			
	}
	
}
