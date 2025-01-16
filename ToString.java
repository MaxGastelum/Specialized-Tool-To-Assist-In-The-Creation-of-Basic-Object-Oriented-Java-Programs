/**
 * @author Max Gastelum
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This class will be used to create toString methods for created classes
public class ToString {
	
	String header;
	String stringBuidlerDeclaration;
	ArrayList<String> toStringBody = new ArrayList<String>();
	String returnStatement;
	String superToString = "";
	
	// Default constructor
	public ToString() {
		
	}
	
	
	// This method will be used to create the toString header
	public boolean setToStringHeader(String inputtedHeader) {
		
		Pattern toStringHeaderPattern = Pattern.compile("^public\\s+String\\s+toString\\s*\\(\\s*\\)\\s*\\{\\s*\\}\\s*$");
		Matcher toStringHeaderMatcher = toStringHeaderPattern.matcher(inputtedHeader);
		
		if (toStringHeaderMatcher.find()) {
			this.header = inputtedHeader;
			return true;
		} else {
			return false;
		}
	}
	
	
	// This method will be used to create a String builder
	public boolean createStringBuilder(String inputtedDeclaration) {
		
		Pattern stringBuilderPattern = Pattern.compile("^StringBuilder\\s+str\\s*=\\s*new\\s+StringBuilder\\s*\\(\\s*\\)\\s*;\\s*$");
		Matcher stringBuilderMatcher = stringBuilderPattern.matcher(inputtedDeclaration);
		
		if (stringBuilderMatcher.find()) {
			this.stringBuidlerDeclaration = inputtedDeclaration;
			return true;
		} else {
			return false;
		}
		
	}
	
	
	// This method will help create the inclusion of the super class's toString
	public boolean addSuperToString(String inputtedSuperToString) {
		
		Pattern superToStringPattern = Pattern.compile("^str\\.append\\(\\s*super\\.toString\\(\\s*\\)\\s*\\)\\s*;\\s*$");
		Matcher superToStringMatcher = superToStringPattern.matcher(inputtedSuperToString);
		
		if (superToStringMatcher.find()) {
			this.superToString = inputtedSuperToString;
			return true;
		} else {
			return false;
		}
	}
	
	
	// This method will be used to create segments of the body
	public boolean addLineToBody(String inputtedLine, InstanceVariable instanceVariable) {
		
		Pattern toStringBodyLinePattern = Pattern.compile("^str\\.append\\(\\s*\\\"" + instanceVariable.getName() + ":\\s*\\\"\\s*\\+\\s*" + instanceVariable.getName() + "\\s*\\+\\s+\\\"\\\\n\\\"\\)\\s*;\\s*$");
		Matcher toStringBodyLineMatcher = toStringBodyLinePattern.matcher(inputtedLine);
		
		if (toStringBodyLineMatcher.find()) {
			this.toStringBody.add(inputtedLine);
			return true;
		} else {
			return false;
		}
	}
	
	
	// This method will be used to create the return statement
	public boolean createReturnStatement(String inputtedReturnStatement) {
		
		Pattern returnStatementPattern = Pattern.compile("^return\\s+str\\s*\\.toString\\(\\);\\s*$");
		Matcher returnStatementMatcher = returnStatementPattern.matcher(inputtedReturnStatement);
		
		if (returnStatementMatcher.find()) {
			this.returnStatement = inputtedReturnStatement;
			return true;
		} else {
			return false;
		}
		
	}
	
	
	// To String
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		// Write header
		this.header.trim();
		str.append("\t" + this.header.substring(0, this.header.length() - 1) + "\n");
		
		// Write the StringBuilder declaration
		str.append("\t\t" + this.stringBuidlerDeclaration + "\n\n");
		
		// If not empty write the super toString
		if(!this.superToString.isEmpty())  {
			str.append("\n\t\t" + this.superToString + "\n\n");
		}
		
		// Write each line of the toString body
		if (!toStringBody.isEmpty()) {
			for (String line : this.toStringBody) {
				str.append("\t\t" + line + "\n");
			}
		}
		
		// Write the return statement
		str.append("\n\t\t" + this.returnStatement);
		
		// Add the closing curly brace
		str.append("\n\t}");
		
		return str.toString();
	}
	
}
