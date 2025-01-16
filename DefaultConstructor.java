/**
 * @author Max Gastelum
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

// This class will be used to create a default constructor object
public class DefaultConstructor {
	
	private String header;
	private ArrayList<String> instanceVariableInitializations = new ArrayList<String>();
	private String superStatement = "";
	
	// Default constructor
	public DefaultConstructor() {
		
	}
	
	
	// This method will be used to validate the default constructor header before accepting it
	public boolean setDefaultConstructorHeader(String inputtedHeader, String className) {
		
		Pattern defaultConstructorHeaderPattern = Pattern.compile("^(public\\s+|private\\s+|protected\\s+)?" + className + "\\s*\\(\\s*\\)\\s*\\{\\s*\\}\\s*$");
		Matcher defaultConstructorMatcher = defaultConstructorHeaderPattern.matcher(inputtedHeader);
		
		if (defaultConstructorMatcher.find()) {
			this.header = inputtedHeader;
			return true;
		} else {
			return false;
		}
		
	}
	
	
	// This method will be used to include a super constructor is the class extends another class
	public boolean setSuperStatement(String inputtedSuperStatement) {
		
		Pattern superStatementPattern = Pattern.compile("^super\\s*\\(\\s*\\)\\s*;\\s*$");
		Matcher superStatementMatcher = superStatementPattern.matcher(inputtedSuperStatement);
		
		if (superStatementMatcher.find()) {
			this.superStatement = inputtedSuperStatement;
			return true;
		} else {
			return false;
		}
	}
	
	
	// This method will be used to validate the instance variable initializations before accepting them
	public boolean addInstanceVariableInitialization(String inputtedInitialization, InstanceVariable instanceVariable) {
				
		Pattern instanceVariableInitializationPattern = Pattern.compile("^this\\." + instanceVariable.getName() + "\\s*=\\s*" + instanceVariable.getValue() + "\\s*;$");
		Matcher instanceVariableInitializationMatcher = instanceVariableInitializationPattern.matcher(inputtedInitialization);
				
		if (instanceVariableInitializationMatcher.find()) {
			this.instanceVariableInitializations.add(inputtedInitialization);
			return true;
		} else {
			return false;
		}
				
	}
		
	
	// This method will return a formatted String representing the default constructor as proper Java code
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		// Write header
		this.header.trim();
		str.append("\t" + this.header.substring(0, this.header.length() - 1) + "\n");
		
		// It not empty include super statement
		if(!this.superStatement.isEmpty()) {
			str.append("\t\t" + this.superStatement + "\n");
		}
		
		// Write the body
		for(String initialization : this.instanceVariableInitializations) {
			str.append("\t\t" + initialization + "\n");
		}
		
		// Add the closing bracket back in		
		str.append("\t}");
		
		return str.toString();
	}	
}
