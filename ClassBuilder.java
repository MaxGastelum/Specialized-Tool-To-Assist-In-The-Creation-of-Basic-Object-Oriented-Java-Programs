/**
 * @author Max Gastelum
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This class will be used to store and check user inputted code
public class ClassBuilder {
	
	// This instance variable will store the class name to be used for the class declaration 
	private String className;
	private String extendedClassName;
	private String classDeclaration;
	
	
	// This list will store the varying number of instance variables
	private ArrayList<InstanceVariable> uninitializedInstanceVariables = new ArrayList<InstanceVariable>();
	private ArrayList<InstanceVariable> directlyInitializedInstanceVariables = new ArrayList<InstanceVariable>();
	
	// This HashMap will store Instance Variables using there names as a key
	private HashMap<String, InstanceVariable> instanceVariableHash = new HashMap<String, InstanceVariable>();
	
	// This list will store all instance variables
	private ArrayList<InstanceVariable> allInstanceVariables = new ArrayList<InstanceVariable>();
	
	// These list will store the varying number of variable declarations, variable initializations
	private ArrayList<String> instanceVariableDeclarations = new ArrayList<String>();
	private ArrayList<String> instanceVariableDirectInitializations = new ArrayList<String>();
	
	// This will hold the default constructor
	private DefaultConstructor defaultConstructor;
	
	// This list will hold the parameterized constructors to be included in the class
	private ArrayList<ParameterizedConstructor> parameterizedConstructors = new ArrayList<ParameterizedConstructor>();
	
	// These list will store the varying number of setter and getter methods
	private ArrayList<Setter> setters = new ArrayList<Setter>();
	private ArrayList<Getter> getters = new ArrayList<Getter>();
	
	// This will hold the create ToString
	private ToString objectsToString;
	
	// Default and only constructor needed
	public ClassBuilder() {
		
	}
	
	
	// This method will take the inputted class name and check for correctness before accepting it
	public boolean setClassName(String inputtedClassName) {
		
		Pattern classNamePattern = Pattern.compile("^[A-Z_][A-Za-z0-9_]*$");
		Matcher classNameMatcher = classNamePattern.matcher(inputtedClassName);
		
		if (classNameMatcher.find()) {
			this.className = inputtedClassName;
			return true;
		} else {
			return false;
		}
		
	}
	
	
	// This method returns the class name
	public String getClassName() {
		return this.className;
	}
	
	
	// This method will take the inputted class declaration and check for correctness before accepting it 
	public boolean setClassDeclaration(String inputtedClassDeclaration) {
		
		Pattern classDeclarationPattern = Pattern.compile("^(public\\s+|private\\s+|protected\\s+)?"
					                                      + "(static\\s+)?(final\\s+)?(abstract\\s+)?class\\s+" 
			                                              + this.className +"\\s*\\{\\s*}\\s*$");
		Matcher classDeclarationMatcher = classDeclarationPattern.matcher(inputtedClassDeclaration);
			
		if (classDeclarationMatcher.find()) {
				this.classDeclaration = inputtedClassDeclaration;
				return true;
			} else {
				return false;
			}
	}
	
	
	// This method will take the inputted extended class name and check for correctness before accepting it
	public boolean setExtendedClassName(String inputtedExtendedClassName) {
		
		Pattern extendedClassNamePattern = Pattern.compile("^[A-Z_][A-Za-z0-9_]*$");
		Matcher extendedClassNameMatcher = extendedClassNamePattern.matcher(inputtedExtendedClassName);
		
		if (extendedClassNameMatcher.find()) {
			this.extendedClassName = inputtedExtendedClassName;
			return true;
		} else {
			return false;
		}
		
	}
	
	// This method will take the inputted extended class declaration and check for correctness before accepting it
	public boolean setExtendedClassDeclaration(String inputtedExtendedClassDeclaration) {
		
		Pattern extendedClassDeclarationPattern = Pattern.compile("^(public\\s+|private\\s+|protected\\s+)?"
				                                                  + "(static\\s+)?(final\\s+)?(abstract\\s+)?class\\s+"
				                                                  + this.className + "\\s+extends\\s+" + this.extendedClassName + "\\s*\\{\\s*}\\s*$");
		Matcher extendedClassDeclarationMatcher = extendedClassDeclarationPattern.matcher(inputtedExtendedClassDeclaration);

		if (extendedClassDeclarationMatcher.find()) {
			this.classDeclaration = inputtedExtendedClassDeclaration;
			return true;
		} else {
			return false;
		}
	}
	
	
	// This method will check if there is already and instance variable with the given name
	public boolean instanceVariableNameExists(String inputtedInstanceVariableName) {
		return this.instanceVariableHash.containsKey(inputtedInstanceVariableName);
	}
	
	
	// This method will add an InstanceVariable to the list of uninitialized InstanceVariables belonging to the Class
	public void addUnitializedInstanceVariable(InstanceVariable inputtedInstanceVariable) {

		this.uninitializedInstanceVariables.add(inputtedInstanceVariable);			
		this.instanceVariableHash.put(inputtedInstanceVariable.getName(), inputtedInstanceVariable);
		this.allInstanceVariables.add(inputtedInstanceVariable);
		
	}
	
	
	// This method will take the inputted instance variable declaration and check for correctness before accepting it
	public boolean addInstanceVariableDeclaration(String inputtedInstanceVariableDeclaration, InstanceVariable userInstanceVariable) {
		
		Pattern instanceVariableDeclarationPattern = Pattern.compile("^(public\\s+|private\\s+|protected\\s+)(final\\s+)?" 
																	 + userInstanceVariable.getType() + "\\s+" + userInstanceVariable.getName() + "\\s*;\\s*$");
		Matcher instanceVariableDeclarationMatcher = instanceVariableDeclarationPattern.matcher(inputtedInstanceVariableDeclaration);
		
		if (instanceVariableDeclarationMatcher.find()) {
			this.instanceVariableDeclarations.add(inputtedInstanceVariableDeclaration);
			return true;
		} else {
			return false;
		}
		
	}
	
	
	// This method will add an InstanceVariable to the list of directly initialized InstanceVariables belonging to the Class
	public void addDirectlyInitializedInstanceVariable(InstanceVariable inputtedInstanceVariable) {

		this.directlyInitializedInstanceVariables.add(inputtedInstanceVariable);			
		this.instanceVariableHash.put(inputtedInstanceVariable.getName(), inputtedInstanceVariable);
		this.allInstanceVariables.add(inputtedInstanceVariable);
			
	}
	
	
	// This method will take the inputted instance variable declaration/direct initialization and check for correctness before accepting it
	public boolean addInstanceVariableDirectInitialization(String inputtedDirectInitialization, InstanceVariable userInstanceVariable) {
		
		Pattern instanceVariableDirectInitilizationPattern = Pattern.compile("^(public\\s+|private\\s+|protected\\s+)(final\\s+)?" 
		                                                                     + userInstanceVariable.getType() + "\\s+" + userInstanceVariable.getName() 
		                                                                     + "\\s*=\\s*" + userInstanceVariable.getValue() + "\\s*;\\s*$");
		Matcher instanceVariableDirectInitializationMatcher = instanceVariableDirectInitilizationPattern.matcher(inputtedDirectInitialization);
		
		if (instanceVariableDirectInitializationMatcher.find()) {
			this.instanceVariableDirectInitializations.add(inputtedDirectInitialization);
			return true;
		} else {
			return false;
		}
		
	}
	
	
	// This method returns the list holding the uninitialized instance variable 
	public ArrayList<InstanceVariable> getUninitializedVariables() {
		return this.uninitializedInstanceVariables;
	}
	
	// This method returns the list holding all the instance variables
	public ArrayList<InstanceVariable> getAllInstanceVariables(){
		return this.allInstanceVariables;
	}
	
	
	// This method sets the default constructor
	public void setDefaultConstructor(DefaultConstructor inputtedDefaultConstructor) {
		this.defaultConstructor = inputtedDefaultConstructor;
	}
	
	
	// This method will add a parameterized constructor to the list
	public void addParameterizedConstructor(ParameterizedConstructor inputtedParameterizedConstructor) {
		this.parameterizedConstructors.add(inputtedParameterizedConstructor);
	}
	
	
	// This method will add a setter method to the list of setters
	public void addSetter(Setter inputtedSetter) {
		this.setters.add(inputtedSetter);
	}
	
	
	// This method will add a getter method to the list of setters
	public void addGetter(Getter inputtedGetter) {
		this.getters.add(inputtedGetter);
	}
	
	
	// This method will set the object's toString
	public void setToString(ToString toString) {
		this.objectsToString = toString;
	}
	
	
	// This method will create a String representing the produced Java class
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		
		// Add the class declaration
		this.classDeclaration.trim();
		str.append(this.classDeclaration.substring(0, classDeclaration.length() - 1) + "\n");
		
		// Add instance variable declarations and initializations
		if (!instanceVariableDeclarations.isEmpty()) {
			str.append("\n");
			for (String instanceVariableDeclaration : this.instanceVariableDeclarations) {
				str.append("\t" + instanceVariableDeclaration + "\n");
			}
		}
		
		if (!instanceVariableDirectInitializations.isEmpty()) {
			str.append("\n");
			for (String instanceVariableDirectInitialization : this.instanceVariableDirectInitializations) {
				str.append("\t" + instanceVariableDirectInitialization + "\n");
			}
		}
				
		// Add the default constructor
		if (defaultConstructor != null) {
			str.append("\n\n");
			str.append(this.defaultConstructor);
			str.append("\n\n");
		}
		
		// Add the parameterized constructors
		if (!parameterizedConstructors.isEmpty()) {
			str.append("\n");
			for (ParameterizedConstructor parameterizedConstructor : this.parameterizedConstructors) {
				str.append(parameterizedConstructor + "\n");
			}
			str.append("\n\n");
		}
		
		// Add the setter methods
		if (!setters.isEmpty()) {
			for (Setter setter : this.setters) {
				str.append(setter + "\n");
				str.append("\n\n");
			}
		}
			
		// Add the getter methods
		if (!getters.isEmpty()) {
			str.append("\n");
			for (Getter getter : this.getters) {
				str.append(getter + "\n");
				str.append("\n\n");
			}
		}
		
		// Add the create toString for the class
		str.append(this.objectsToString);
		
		// Add the closing curly bracket;
		str.append("\n}");
		
		return str.toString();
	}
	
}
