/**
 * @author Max Gastelum
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

// This class will be used to create a parameterized constructor constructor object
public class ParameterizedConstructor {

	private String header;
	private ArrayList<String> instanceVariableInitializations = new ArrayList<String>();
	private String superStatement = "";
	
	
	// Default constructor
	public ParameterizedConstructor() {
		
	}
	
	
	// This method will be used to validate the default constructor header before accepting it
	public boolean setParameterizedConstructorHeader(String inputtedHeader, String className, ArrayList<InstanceVariable> parameterListInstanceVariables) {
		
		// Create a String that will be used to match the parameter list
		String parameterList = "";
		
		for(InstanceVariable currentInstanceVariable : parameterListInstanceVariables) {
			
			parameterList = parameterList.concat(currentInstanceVariable.getType() + "\\s*" + currentInstanceVariable.getName() + ",\\s*");
			
		}
		
		parameterList.trim();
		parameterList = parameterList.substring(0, parameterList.length() - 4);
		
		Pattern parameterizedConstructorHeaderPattern = Pattern.compile("^(public\\s+|private\\s+|protected\\s+)?" 
		                                                                + className + "\\s*\\(\\s*" + parameterList + "\\s*\\)\\s*\\{\\s*\\}\\s*$");
		Matcher parameterizedConstructorMatcher = parameterizedConstructorHeaderPattern.matcher(inputtedHeader);
			
		if (parameterizedConstructorMatcher.find()) {
			this.header = inputtedHeader;
			return true;
		} else {
			return false;
		}	
	}
	
	
	// This method will be used to validate the default constructor header before accepting it
	public boolean setParameterizedConstructorHeaderForExtended(String inputtedHeader, String className, ArrayList<InstanceVariable> parameterListInstanceVariables) {
			
		// Create a String that will be used to match the parameter list
		String parameterList = "";
			
		for(InstanceVariable currentInstanceVariable : parameterListInstanceVariables) {
				
			parameterList = parameterList.concat(currentInstanceVariable.getType() + "\\s*" + currentInstanceVariable.getName() + ",\\s*");
				
		}
			
		parameterList.trim();
		parameterList = parameterList.substring(0, parameterList.length() - 4);
			
		Pattern parameterizedConstructorHeaderPattern = Pattern.compile("^(public\\s+|private\\s+|protected\\s+)?" 
			                                                                + className + "\\s*\\(.*\\s*" + parameterList + "\\s*\\)\\s*\\{\\s*\\}\\s*$");
		Matcher parameterizedConstructorMatcher = parameterizedConstructorHeaderPattern.matcher(inputtedHeader);
				
		if (parameterizedConstructorMatcher.find()) {
			this.header = inputtedHeader;
			return true;
		} else {
			return false;
		}				
	}

	
	// This method will be used to include a super constructor is the class extends another class
	public boolean setSuperStatement(String inputtedSuperStatement) {
			
		
		Pattern superStatementPattern = Pattern.compile("^super\\s*\\(.*\\)\\s*;\\s*$");
		Matcher superStatementMatcher = superStatementPattern.matcher(inputtedSuperStatement);
			
		if (superStatementMatcher.find()) {
			this.superStatement = inputtedSuperStatement;
			return true;
		} else {
			return false;
		}
	}
	
	
	// This method will be used to validate the conventional instance variable initializations before accepting them
	public boolean addConventionalInstanceVariableInitialization(String inputtedInitialization, InstanceVariable instanceVariable) {
					
		Pattern instanceVariableInitializationPattern = Pattern.compile("^this\\." + instanceVariable.getName() + "\\s*=\\s*" + instanceVariable.getName() + "\\s*;$");
		Matcher instanceVariableInitializationMatcher = instanceVariableInitializationPattern.matcher(inputtedInitialization);
					
		if (instanceVariableInitializationMatcher.find()) {
			this.instanceVariableInitializations.add(inputtedInitialization);
			return true;
		} else {
			return false;
		}
					
	}
	
	
	// This method will be used to validate the flexible instance variable initializations before accepting them
	public boolean addFlexibleInstanceVariableInitialization(String inputtedInitialization, InstanceVariable instanceVariable) {
						
		Pattern instanceVariableInitializationPattern = Pattern.compile("^this\\." + instanceVariable.getName() + "\\s*=\\s*" + instanceVariable.getValue() + "\\s*;$");
		Matcher instanceVariableInitializationMatcher = instanceVariableInitializationPattern.matcher(inputtedInitialization);
						
		if (instanceVariableInitializationMatcher.find()) {
			this.instanceVariableInitializations.add(inputtedInitialization);
			return true;
		} else {
			return false;
		}				
	}
			
		
	// This method will return a formatted String representing the parameterized constructor as proper Java code
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
