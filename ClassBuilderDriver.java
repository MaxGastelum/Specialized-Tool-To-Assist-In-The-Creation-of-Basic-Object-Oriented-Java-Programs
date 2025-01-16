/**
 * @author Max Gastelum
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// This class will create an instance of the ClassBuilder and use it to create a user defined Class
public class ClassBuilderDriver {

	
	public static void main(String[] args) {
		
		// Scanner to scan user input
		Scanner KB = new Scanner(System.in);
		
		// Created Instance of the ClassBuilder class
		ClassBuilder userClass = new ClassBuilder();
		

		// Variables to hold user input
		String inputtedClassName;
		String userYesNo;
		
		
		// Boolean to denote if Class sends another class
		boolean extendsClass = false;
		
		
		/***	Class Declaration Segment		***/
		// Prompt the user for class name
		System.out.println("Enter a valid class name (Should start with capital letter as well as only include letters, digits, and underscores): ");
		inputtedClassName = KB.nextLine().trim();
		
		// While user inputted class name is incorrect prompt the user for class name
		while (!userClass.setClassName(inputtedClassName)) {
			System.out.println("Not a valid class name, please enter a valid class name: ");
			inputtedClassName = KB.nextLine().trim();
		}
		
		// Ask user if the class extends another class
		System.out.println("Should this class extend an existing class? Enter Y/N:");
		userYesNo = KB.nextLine().toUpperCase().trim();
		
		// While user input is not Y/N
		while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
			System.out.println("Invalid Input! Should this class extend an existing class? Please Enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
		}
		
		if (userYesNo.equals("N")) {
			// Call the method used to create the class declaration
			declareClass(KB, userClass);
		} else if (userYesNo.equals("Y")) {
			// Class the method used to create the extending class declaration
			extendsClass = true;
			declareExtendingClass(KB, userClass);
		} 
		
		
		/***	Instance Variables Declaration Segment		***/
		// Now provide information regarding instance variable declarations
		System.out.println("\nDeclaring Instance Variables:\n");
		System.out.println("Please note this section will allow for the declaration of any type of instance variables including user created instantiable classes.");
		System.out.println("Therefore it will not account for the misspelling of existing and common Java data types.");
		System.out.println("Please ensure everything is spelled correctly as this can result in compilation errors.");
		System.out.println("Also, the program will accept other basic access modifiers but requires one in accordance with best practices.");
		System.out.println("The final keyword can also be used before the access modifier to declare a variable that should not be changed after it is initialized.");
		
		// Ask the user if they would like to declare an instance variable
		System.out.println("\nWould you like to declare an instance variable at this time? (only declare variables that are not directly initialized at this time)"
				           + "\nPlease Enter Y/N:");
		userYesNo = KB.nextLine().toUpperCase().trim();
		
		// While user input is not Y/N
		while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
			System.out.println("Invalid Input! Would you like to declare an instance variable? Please Enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
		}
		
		// While the user would like to declare an instance variable
		while (userYesNo.equals("Y")) {
			// Call method used to declare a variable
			declareInstanceVariable(KB, userClass);
			
			// Ask the user if they would like to declare another instance variable
			System.out.println("Would you like to declare another instance variable at this time? Please Enter Y/N: ");
			userYesNo = KB.nextLine().toUpperCase().trim();
			
			// While user input is not Y/N
			while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
				System.out.println("Invalid Input! Would you like to declare another instance variable? Please Enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
			}
			
		}
		
		
		/***	Instance Variables With Direct Initialization Segment		***/
		// Now provide information regarding instance direct variable initialization
		System.out.println("\nDeclaring and Initializing Instance Variables Directly:\n"
						   + "\nPlease note this section will allow for the declaration and direct initialization of any type of instance variables including user created instantiable classes."
						   + "\nTherefore it will not account for the misspelling of existing and common Java data types."
						   + "\nPlease ensure everything is spelled correctly as this can result in compilation errors."
						   + "\nIt will also allow this type checking to be bypassed for assigning other variables or operations."
						   + "\nHowever the validity of these assignments will not be validated and can result in compilation issues in the produced Java program."
						   + "\nAlso, the program will accept other basic access modifiers but requires one in accordance with best practices."
						   + "\nThe final keyword can also be used before the access modifier to declare a variable that should not be changed after it is initialized."
						   + "\nThis program will provide type checking for some of the most common Java data types only."
						   + "\nPlease note, because of the program's use of regular expressions when initializing a String, punctuation and special characters may not be fully accounted for."
						   + "\nDue to this, when checking the direct initialization of a String the program may accept a value that is slightly different"
				           + "\nthan the value that was initially designated for the String instance variable.");
				
		// Ask the user if they would like to declare and directly initialize an instance variable
		System.out.println("\nWould you like to declare and directly initialize an instance variable at this time? \nPlease Enter Y/N:");
		userYesNo = KB.nextLine().toUpperCase().trim();
		
		// While user input is not Y/N
		while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
			System.out.println("Invalid Input! Would you like to declare and directly initialize an instance variable? Please Enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
		}
		
		// While the user would like to declare and directly initialize an instance variable
		while (userYesNo.equals("Y")) {	
			// Call method used to declare and directly initialize a variable
			directlyInitializeInstanceVariable(KB, userClass);
					
			// Ask the user if they would like to declare and directly initialize another instance variable
			System.out.println("Would you like to declare and directly initialize another instance variable at this time? Please Enter Y/N: ");
			userYesNo = KB.nextLine().toUpperCase().trim();
			
			// While user input is not Y/N
			while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
				System.out.println("Invalid Input! Would you like to declare and directly initialize another instance variable? Please Enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
			}
		}
		
		
		/***	Default Constructor Segment		***/	
		// Ask the user if they would like to include a default constructor
		System.out.println("\nShould there be a default constructor (constructor without parameters)? Please Enter Y/N:");
		userYesNo = KB.nextLine().toUpperCase().trim();
						
		// While user input is not Y/N
		while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
			System.out.println("Invalid Input! Would you like to include default constructor? Please Enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
		}
						
		if (userYesNo.equals("Y")) {
			createDefaultConstructor(KB, extendsClass,userClass);
		}
		
		
		/***	Parameterized Constructor Segment	***/
		// Ask the user if they would like to include a default constructor
		System.out.println("\nShould there be a parameterized constructor (constructor with parameters)? Please Enter Y/N:");
		userYesNo = KB.nextLine().toUpperCase().trim();
								
		// While user input is not Y/N
		while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
			System.out.println("Invalid Input! Would you like to include parameterized? Please Enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
		}
		
		// While the user would like to include a parameterized constructor
		while (userYesNo.equals("Y")) {
			// Call method used to create parameterized constructor
			createParameterizedConstructor(KB, extendsClass,userClass);
					
			// Ask the user if they would like to declare another instance variable
			System.out.println("Would you like to create another parameterized constructor? Please Enter Y/N: ");
			userYesNo = KB.nextLine().toUpperCase().trim();
					
			// While user input is not Y/N
			while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
				System.out.println("Invalid Input! Would you like to create another parameterized constructor? Please Enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
			}
					
		}
		
		
		/***	Setters and Getters Segment		***/
		createSetterMethods(KB, userClass);
		createGetterMethods(KB, userClass);
		
		
		/***	toString Segment	***/
		createToString(KB, extendsClass, userClass);
		
		
		/***	Writing Class to Screen and Java File Segment	***/
		System.out.println("\n\nCreated Class:\n\n");
		System.out.println(userClass);
		try(FileWriter writer = new FileWriter(String.format("%s.java", userClass.getClassName()))){
			writer.write(userClass.toString());
			writer.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		KB.close();
	}
	
	
	// This method will be used to create the basic class declaration
	private static void declareClass(Scanner KB, ClassBuilder userClass) {
		
		// This string will hold user input
		String inputtedClassDeclaration;
		
		// Prompt user for class declaration that does not extend another class
		System.out.println("Enter a valid class declaration (Example: \"public class ClassName {}\", can also accept other basic access and non-access modifiers):" );
		inputtedClassDeclaration = KB.nextLine().trim();
					
		// While the user inputted class declaration is incorrect prompt the user for the class declaration
		while (!userClass.setClassDeclaration(inputtedClassDeclaration)) {
			System.out.println("Not a valid class declaration, please enter a valid class declaration: " );
			inputtedClassDeclaration = KB.nextLine().trim();
		}	
		
	}
	
	
	// This method will be used to create the extending class declaration
	private static void declareExtendingClass(Scanner KB, ClassBuilder userClass) {
		
		// These Strings will hold user input
		String userYesNo;
		String extendedClassName;
		String inputtedClassDeclaration;
		
		// Prompt the user for the extended class name
		System.out.println("Enter the name of the class you are extending without the .java extension (Example: \"ClassName\"): ");
		extendedClassName = KB.nextLine().trim();
		extendedClassName = extendedClassName.concat(".java");
		File extendedFile = new File(extendedClassName);
							
		// While inputted file does not exist
		while (!extendedFile.exists()) {
			System.out.println(extendedClassName + " was not found. Would you like to continue with extending this class?");
			System.out.println("Please note that in order for the program to compile there needs to be a class with the specified name within the directory. Enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
			
			// While user input is not Y/N
			while(!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
				System.out.println("Invalid Input! Would you like to continue with extending this class? Please Enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
			}
			
			if (userYesNo.equals("Y")) {
				break;
			} else if (userYesNo.equals("N")){
				System.out.println("Retry entering the name of the class you are extending (Example: \"ClassName.java\"): ");
				extendedClassName = KB.nextLine().trim();
				extendedFile = new File(extendedClassName);
			}
						
		}
					
		// Hold the class name without the .java class extension
		extendedClassName = extendedClassName.substring(0, extendedClassName.length() - 5);
					
		// While the extended class name is not valid
		while (!userClass.setExtendedClassName(extendedClassName)) {
			System.out.println("The inputted name of the class to extend is not valid, please enter a valid class name: ");
			extendedClassName = KB.nextLine().trim();
		}
					
		// Prompt user for class extended declaration that does not extend another class
		System.out.println("Enter a valid class declaration including the extends statement with the corresponding class name. "
									   + "\n(Example: \"public class SubClass extends SuperClass {}\", can also accept other basic access and non-access modifiers):" );
		inputtedClassDeclaration = KB.nextLine().trim();
					
		// While the user inputted extended class declaration is incorrect prompt the user for the class declaration
		while (!userClass.setExtendedClassDeclaration(inputtedClassDeclaration)) {
				System.out.println("Not a valid class declaration, please enter a valid class declaration: " );
				inputtedClassDeclaration = KB.nextLine().trim();
		}	
		
	}
	
	
	// This method will be used to declare instance variables
	private static void declareInstanceVariable(Scanner KB, ClassBuilder userClass) {
		
		// These Strings will hold user input
		String inputtedInstanceVariableType;
		String inputtedInstanceVariableName;
		String inputtedInstanceVariableDeclaration;
		
		// Create a new InstanceVariable
		InstanceVariable userInstanceVariable = new InstanceVariable();
				
		// Prompt the user for the instance variable type
		System.out.println("Please enter the type of the instance variable (int, double, String, custom types, etc.): ");
		inputtedInstanceVariableType = KB.nextLine().trim();
					
		// While the inputted variable type is not valid prompt the user for a valid type
		while (!userInstanceVariable.setType(inputtedInstanceVariableType)) {
			System.out.println("Not a valid instance variable type, please enter a valid instance variable type:");
			inputtedInstanceVariableType = KB.nextLine().trim();
		}
					
		// Prompt the user for the instance variable name
		System.out.println("Please enter the name of the instance variable: ");
		inputtedInstanceVariableName = KB.nextLine().trim();
								
		// While the inputted variable name is not valid prompt the user for a valid name
		while (userClass.instanceVariableNameExists(inputtedInstanceVariableName) || !userInstanceVariable.setName(inputtedInstanceVariableName)) {
			System.out.println("Not a valid instance variable name or it has already been used, please enter a valid instance variable name:");
			inputtedInstanceVariableName = KB.nextLine().trim();
		}
					
		// Add the instance variable to the user created class
		userClass.addUnitializedInstanceVariable(userInstanceVariable);
					
		// Prompt the user to enter an instance variable declaration
		System.out.println("Please enter your instance variable declaration for a variable of type \"" 
					       + inputtedInstanceVariableType + "\" with the name \"" + inputtedInstanceVariableName + "\" "
						   + "(Example: \"private int age;\"):");
		inputtedInstanceVariableDeclaration = KB.nextLine().trim();
					
		// While the inputted variable declaration is not correct prompt the user for a correct declaration
		while (!userClass.addInstanceVariableDeclaration(inputtedInstanceVariableDeclaration, userInstanceVariable)) {
			System.out.println("Not a valid instance variable declaration, please enter a valid instance variable declaration:");
			inputtedInstanceVariableDeclaration = KB.nextLine().trim();
		}	
		
	}
	
	
	// This method will be used to declare and directly initialize instance variables
	private static void directlyInitializeInstanceVariable(Scanner KB, ClassBuilder userClass) {
		
		// These Strings will hold user input
		String userYesNo;
		String inputtedInstanceVariableType;
		String inputtedInstanceVariableName;
		String inputtedInstanceVariableValue;
		String inputtedDirectInitialization;
		
		// Create a new InstanceVariable
		InstanceVariable userInstanceVariable = new InstanceVariable();
		
		// Boolean value to check if type checking in initialization should be bypassed
		boolean bypassTypeChecking = false;
					
		// Prompt the user for the instance variable type
		System.out.println("Please enter the type of the instance variable (int, double, String, custom types, etc.): ");
		inputtedInstanceVariableType = KB.nextLine().trim();
								
		// While the inputted variable type is not valid prompt the user for a valid type
		while (!userInstanceVariable.setType(inputtedInstanceVariableType)) {
			System.out.println("Not a valid instance variable type, please enter a valid instance variable type:");
			inputtedInstanceVariableType = KB.nextLine().trim();
		}
								
		// Prompt the user for the instance variable name
		System.out.println("Please enter the name of the instance variable: ");
		inputtedInstanceVariableName = KB.nextLine().trim();
											
		// While the inputted variable name is not valid prompt the user for a valid name
		while (userClass.instanceVariableNameExists(inputtedInstanceVariableName) || !userInstanceVariable.setName(inputtedInstanceVariableName)) {
			System.out.println("Not a valid instance variable name or it has already been used, please enter a valid instance variable name:");
			inputtedInstanceVariableName = KB.nextLine().trim();
		}
					
		// Prompt the user for the instance variable value
		System.out.println("Please enter the value of the instance variable: ");
		inputtedInstanceVariableValue = KB.nextLine().trim();
				
		// While the inputtedInstanceVariableValue is not valid
		while (!userInstanceVariable.setValue(inputtedInstanceVariableValue, bypassTypeChecking)) {
			System.out.println("Not a valid value for the inputted type, would you like to bypass the typechecking (for example if you are assigning an operation)."
							   + "\nPlease note, the program will not check the validity of these assignments "
							   + "\nwhich may result in compilation issues in the produced Java program."
							   + "\nPlease enter Y/N:");
			
			userYesNo = KB.nextLine().toUpperCase().trim();
			
			// While user input is not Y/N
			while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
				System.out.println("Invalid Input! Should type checking be bypassed? Please enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
			}
			
			if(userYesNo.equals("Y")) {
				bypassTypeChecking = true;
				userInstanceVariable.setValue(inputtedInstanceVariableValue, bypassTypeChecking);
				break;
			}
			
			System.out.println("Please enter a value of the appropriate type:");
			inputtedInstanceVariableValue = KB.nextLine().trim();
		}
					
		// Add the instance variable to the user created class
		userClass.addDirectlyInitializedInstanceVariable(userInstanceVariable);
					
		// Prompt the user for an instance variable declaration with a direct initialization
		System.out.println("Please enter your instance variable declaration and direct initialization for a variable of type "
						   + "\"" + userInstanceVariable.getType() + "\", with the name \"" + userInstanceVariable.getName() + "\","
					       + " and the value \"" + userInstanceVariable.getValue() + "\" (Example: \"private int age = 21;\"):");
		inputtedDirectInitialization = KB.nextLine().trim();
							
		// While the inputted variable declaration and direct initialization is not correct prompt the user for a correct initialization
		while (!userClass.addInstanceVariableDirectInitialization(inputtedDirectInitialization, userInstanceVariable)) {
			System.out.println("Not a valid instance variable declaration and initilization, "
					           + "\nplease enter a valid instance variable declaration with appropriate initialization:");
			inputtedDirectInitialization = KB.nextLine().trim();
		}	
		
	}
	
	
	// This method will be used to create the default constructor
	private static void createDefaultConstructor(Scanner KB, boolean extendsClass,ClassBuilder userClass) {
		
		// This String will hold user input
		String inputtedDefaultConstructorHeader;
		String inputtedSuperStatement;
		
		// Create an instance of DefaultConstructor
		DefaultConstructor userDefaultConstructor = new DefaultConstructor();
					
		// Prompt the user for a default constructor declaration
		System.out.println("Please enter a default constructor header"
						   + "\n(Example: \"public ClassName(){}\","
						   + "\nthe program will also accept other access modifiers but the public access modifier would be the most common for basic OOP.):");
		inputtedDefaultConstructorHeader = KB.nextLine().trim();
					
		// While the inputted default constructor header is not correct prompt the user for a correct header
		while(!userDefaultConstructor.setDefaultConstructorHeader(inputtedDefaultConstructorHeader, userClass.getClassName())) {
			System.out.println("Invalid default constructor header. Please enter a default constructor header:");
			inputtedDefaultConstructorHeader = KB.nextLine().trim();
		}
					
		System.out.println("\nNow the body of the default constructor will be created.");
		
		// If class extends another class include super()
		if(extendsClass) {
			System.out.println("Please enter a proper call to the super class's constructor using the super keyword (\"super();\"):");
			inputtedSuperStatement = KB.nextLine().trim();
			
			// While super statementis not correct prompt the user
			while (!userDefaultConstructor.setSuperStatement(inputtedSuperStatement)) {
				System.out.println("Invalid Input! Please enter a proper call to the super class's constructor using the super keyword (\"super();\")");
				inputtedSuperStatement = KB.nextLine().trim();
			}
			
		}
		
		// Call the method used to initialize the instance variables inside of the constructor
		initializeVariablesInDefaultConstructor(KB, userClass, userDefaultConstructor);
					
		// Set the default constructor in the user's create class
		userClass.setDefaultConstructor(userDefaultConstructor);
			
	}
	
	
	// This method will be used to create the variable initializations inside the default constructor
	private static void initializeVariablesInDefaultConstructor(Scanner KB, ClassBuilder userClass, DefaultConstructor userDefaultConstructor) {
		
		// These Strings will hold user input
		String userYesNo;
		String inputtedInstanceVariableValue;
		String inputtedInitialization;
		
		// Boolean value to check if type checking in initialization should be bypassed
		boolean bypassTypeChecking = false;
					
		for (InstanceVariable currentInstanceVariable : userClass.getUninitializedVariables()) {
			// Ask user if the current instance variable should be initialized in the default constructor 
			System.out.println("Should \"" + currentInstanceVariable.getName() + "\" be initialized in the default constructor? Please enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
						
			// While user input is not Y/N
			while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
			System.out.println("Invalid Input! Should \"" + currentInstanceVariable.getName() + "\" be initialized in the default constructor? Please enter Y/N:");
					userYesNo = KB.nextLine().toUpperCase().trim();
			}
						
			// If the current instance variable should be initialized in the default constructor
			if(userYesNo.equals("Y")){
							
				// Prompt the user for the instance variable value
				System.out.println("Please enter the value that will be assigned to the variable, as before the program will offer some type checking for common data types:");
				inputtedInstanceVariableValue = KB.nextLine().trim();
							
				// While the inputtedInstanceVariableValue is not valid
				while (!currentInstanceVariable.setValue(inputtedInstanceVariableValue, bypassTypeChecking)) {
					System.out.println("Not a valid value for the inputted type, would you like to bypass the typechecking (for example if you are assigning an operation)."
									   + "\nPlease note, the program will not check the validity of these assignments "
									   + "\nwhich may result in compilation issues in the produced Java program."
									   + "\nPlease enter Y/N:");
					
					userYesNo = KB.nextLine().toUpperCase().trim();
					
					// While user input is not Y/N
					while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
						System.out.println("Invalid Input! Should type checking be bypassed? Please enter Y/N:");
						userYesNo = KB.nextLine().toUpperCase().trim();
					}
					
					if(userYesNo.equals("Y")) {
						bypassTypeChecking = true;
						currentInstanceVariable.setValue(inputtedInstanceVariableValue, bypassTypeChecking);
						break;
					}
					
					System.out.println("Please enter a value of the appropriate type:");
					inputtedInstanceVariableValue = KB.nextLine().trim();
				}		
				
				// Prompt the user for the initialization of the current instance variable
				System.out.println("Please enter a proper initialization for the variable \"" 
				                   + currentInstanceVariable.getName() + "\" with the value \"" + currentInstanceVariable.getValue() + "\" \n(Example: \"this.variableName = value\"):");
				inputtedInitialization = KB.nextLine().trim();
				
				// While the initialization for the current instance variable is not correct prompt the user for the initialization
				while(!userDefaultConstructor.addInstanceVariableInitialization(inputtedInitialization, currentInstanceVariable)) {
					System.out.println("Invalid Input! Please enter a proper initialization for the variable:");
					inputtedInitialization = KB.nextLine().trim();
				}	

			}		
		}
	}
	
	
	// This method will be used to create parameterized Constructors
	private static void createParameterizedConstructor(Scanner KB, boolean extendsClass, ClassBuilder userClass) {
		
		// These strings will hold user input
		String userYesNo;
		String inputtedParameterizedConstructorHeader;
		String inputtedSuperStatement;
		
		// Create and instance of ParameterizedConstructor
		ParameterizedConstructor userParameterizedConstructor = new ParameterizedConstructor();
		
		// This array list and hashmap will hold the instance variables that should be accounted for in the parameter list
		ArrayList<InstanceVariable> parameterListInstanceVariables = new ArrayList<InstanceVariable>();
		HashMap<String, InstanceVariable> parameterListInstanceVariablesHash = new HashMap<String, InstanceVariable>();
		
		// Ask the users which instance variables should be accounted for in the parameter list
		for (InstanceVariable currentInstanceVariable : userClass.getUninitializedVariables()) {
			// Ask user if the current instance variable should be initialized in the default constructor 
			System.out.println("Should \"" + currentInstanceVariable.getName() + "\" be accounted for in the parameter list? Please enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
									
			// While user input is not Y/N
			while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
				System.out.println("Invalid Input! Should \"" + currentInstanceVariable.getName() + "\" be initialized in the default constructor? Please enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
			}
		
			if (userYesNo.equals("Y")) {
				parameterListInstanceVariables.add(currentInstanceVariable);
				parameterListInstanceVariablesHash.put(currentInstanceVariable.getName(), currentInstanceVariable);
			}
			
		}
		
		// Prompt the user for a parameterized constructor declaration
		System.out.println("Please enter a parameterized constructor header, including all of the variables that were selected to be accounted for."
						   + "\nEnsure that the parameters are listed with the same data type and name as the instance variable they are accounting for."
						   + "\nAlso, the program requires the parameters to be listed in the same order that the variables they account for were declared."
						   + "\n(Example: \"public ClassName(String str, int num){}\", the program will also accept other "
						   + "\naccess modifiers but the public access modifier would be the most common for basic OOP.).");
		
		// Create a String telling the users which variables they selected to include
		String includedVariables = "";
		for (InstanceVariable currentInstanceVariable : parameterListInstanceVariables) {
			includedVariables = includedVariables.concat(currentInstanceVariable.getName() + ", ");
		}
		includedVariables.trim();
		includedVariables = includedVariables.substring(0, includedVariables.length() - 1);
				
		System.out.println("\nThe following variables were selected to be accounted for in the parameter list: " + includedVariables + ".");
				
		
		// If class extends another class include super()
		if(extendsClass) {
				
			System.out.println("Because the class is extending another class, the parameters needed to instantiated the super class also need to be included in the header."
					           + "\nThe parameters related to the super class should be included in the parameter list before the ones related to the subclass."
					           + "\nAt this stage, the program will not check the validity of the parameters related to the super class"
					           + "\nand will only ensure the inclusion of the parameters related to the subclass.");
			
			System.out.println("Please enter a parameterized constructor header, including all the arguments need to instantiate the super class "
					           + "\nand all of the variables that were selected to be accounted for:");
			
			inputtedParameterizedConstructorHeader = KB.nextLine().trim();
			
			// While the inputted parameterized constructor header is not correct prompt the user for a correct header
			while(!userParameterizedConstructor.setParameterizedConstructorHeaderForExtended(inputtedParameterizedConstructorHeader, userClass.getClassName(), parameterListInstanceVariables)) {
				System.out.println("Invalid parameterized constructor header. Please enter a parameterized constructor header:");
				inputtedParameterizedConstructorHeader = KB.nextLine().trim();
			}
							
		} else {
			
			System.out.println("Please enter a parameterized constructor header, including all of the variables that were selected to be accounted for:");
		
			inputtedParameterizedConstructorHeader = KB.nextLine().trim();
							
			// While the inputted parameterized constructor header is not correct prompt the user for a correct header
			while(!userParameterizedConstructor.setParameterizedConstructorHeader(inputtedParameterizedConstructorHeader, userClass.getClassName(), parameterListInstanceVariables)) {
				System.out.println("Invalid parameterized constructor header. Please enter a parameterized constructor header:");
				inputtedParameterizedConstructorHeader = KB.nextLine().trim();
			}
			
		}
		
		
		
		System.out.println("\nNow the body of the parameterized constructor will be created.");
		
		if (extendsClass) {
			System.out.println("Please enter a proper call to the super class's constructor "
			           + "\nusing the super keyword (\"super(arguments to instantiate the super class);\")."
			           + "\nAt this stage, the program will not check the validity of the arguments in this call to the super constructor:");
			inputtedSuperStatement = KB.nextLine().trim();
			
			// While super statementis not correct prompt the user
				while (!userParameterizedConstructor.setSuperStatement(inputtedSuperStatement)) {
						System.out.println("Invalid Input! Please enter a proper call to the super class's constructor using the super keyword (\"super();\")");
						inputtedSuperStatement = KB.nextLine().trim();
				}
		}
		
		// Call the method used to initialize the instance variables inside of the constructor
		initializeVariablesInParameterizedConstructorParameterList(KB, userClass, userParameterizedConstructor, parameterListInstanceVariables);
		initializeRestOfVariablesInParameterizedConstructor(KB, userClass, userParameterizedConstructor, parameterListInstanceVariables, parameterListInstanceVariablesHash);
		
		// Set the default constructor in the user's create class
		userClass.addParameterizedConstructor(userParameterizedConstructor);	
		
	}
	
	
	// This method will be used to create the variable initializations inside of parameterized constructors
	private static void initializeVariablesInParameterizedConstructorParameterList(Scanner KB, ClassBuilder userClass, ParameterizedConstructor userParameterizedConstructor, ArrayList<InstanceVariable> parameterListInstanceVariables) {
		
		// These Strings will be used to hold user input
		String userYesNo;
		String inputtedInstanceVariableValue;
		String inputtedInitialization;
		
		// Boolean value to check if type checking in initialization should be bypassed
		boolean bypassTypeChecking = false;

		System.out.println("It is common for only the variables listed in the parameters to be initialized inside of the constructor."
						   + "\nHowever, this program will allow for other instance variables to be initialized as well, to account for varying needs."
						   + "\nAlso, the variables listed as parameters will not be required to be used for "
						   + "\ndirect initialization as parameters may be used for other things like operations for initialization.");
		
		System.out.println("\nStarting with the instance variables accounted for in the parameter list.");
		
		for (InstanceVariable currentInstanceVariable : parameterListInstanceVariables)  {
			
			// Ask user if current instance variable should be initialized in the parameterized constructor
			
			System.out.println("Should \"" + currentInstanceVariable.getName() + "\" be initialized in the parameterized constructor? Please enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
			
			// While user input is not Y/N
			while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
				System.out.println("Invalid Input! Should \"" + currentInstanceVariable.getName() + "\" be initialized in the parameterized constructor? Please enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
			}
			
			if (userYesNo.equals("Y")) {
				
				// Ask user if the initialization is the conventional one or a more flexible one
				System.out.println("Is the intended initialization the conventional (\"this.variableName = name;\"). Please enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
				
				while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
					System.out.println("Invalid Input! Is the intended initialization the conventional (\"this.variableName = name;\"). Please enter Y/N:");
					userYesNo = KB.nextLine().toUpperCase().trim();
				}
				
				if (userYesNo.equals("Y")) {
					
					
					// Prompt user for a conventional initialization statement that goes in the parameterized constructor
					System.out.println("Please enter a valid initialization statement to go inside the parameterized constructor (\"this.variableName = name;\"):");
					inputtedInitialization = KB.nextLine().trim();
				
					// While the inputted initialization is not correct
					while (!userParameterizedConstructor.addConventionalInstanceVariableInitialization(inputtedInitialization, currentInstanceVariable)) {
						System.out.println("Invalid Input! Please enter a valid initialization statement to go inside the parameterized constructor (\"this.variableName = name;\"):");
						inputtedInitialization = KB.nextLine().trim();
					}
					
				} else {
					
					// Prompt the user for the instance variable value
					System.out.println("Please enter the value that will be assigned to the variable, as before the program will offer some type checking for common data types:");
					inputtedInstanceVariableValue = KB.nextLine().trim();
							
					// While the inputtedInstanceVariableValue is not valid
					while (!currentInstanceVariable.setValue(inputtedInstanceVariableValue, bypassTypeChecking)) {
						System.out.println("Not a valid value for the inputted type, would you like to bypass the typechecking (for example if you are assigning an operation)."
									   	   + "\nPlease note, the program will not check the validity of these assignments "
									       + "\nwhich may result in compilation issues in the produced Java program."
									       + "\nPlease enter Y/N:");
					
						userYesNo = KB.nextLine().toUpperCase().trim();
					
						// While user input is not Y/N
						while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
							System.out.println("Invalid Input! Should type checking be bypassed? Please enter Y/N:");
							userYesNo = KB.nextLine().toUpperCase().trim();
						}
					
						if(userYesNo.equals("Y")) {
							bypassTypeChecking = true;
							currentInstanceVariable.setValue(inputtedInstanceVariableValue, bypassTypeChecking);
							break;
						}
					
						System.out.println("Please enter a value of the appropriate type:");
						inputtedInstanceVariableValue = KB.nextLine().trim();
					}	
							
					// Prompt the user for the initialization of the current instance variable
					System.out.println("Please enter a proper initialization for the variable \"" 
				                   + currentInstanceVariable.getName() + "\" with the value \"" + currentInstanceVariable.getValue() + "\" \n(Example: \"this.variableName = value;\"):");
					inputtedInitialization = KB.nextLine().trim();
				
					// While the initialization for the current instance variable is not correct prompt the user for the initialization
					while(!userParameterizedConstructor.addFlexibleInstanceVariableInitialization(inputtedInitialization, currentInstanceVariable)) {
						System.out.println("Invalid Input! Please enter a proper initialization for the variable:");
						inputtedInitialization = KB.nextLine().trim();
					}	
				}				
			}			
		}
	}
	
	
	private static void initializeRestOfVariablesInParameterizedConstructor(Scanner KB, ClassBuilder userClass, ParameterizedConstructor userParameterizedConstructor, ArrayList<InstanceVariable> parameterListInstanceVariables, HashMap<String, InstanceVariable> parameterListInstanceVariablesHash) {
		
		// These Strings will be used to hold user input
		String userYesNo;
		String inputtedInstanceVariableValue;
		String inputtedInitialization;
		
		// Boolean value to check if type checking in initialization should be bypassed
		boolean bypassTypeChecking = false;
		
		System.out.println("Now the process of initializing variables that were not in the parameter list, if any.");
		
		for (InstanceVariable currentInstanceVariable : userClass.getUninitializedVariables()) {
			
			// If the instance variable is not part of the parameter
			if (!parameterListInstanceVariablesHash.containsValue(currentInstanceVariable)) {
				
				// Ask user if the current instance variable should be initialized in the parameterized constructor 
				System.out.println("Should \"" + currentInstanceVariable.getName() + "\" be initialized in the parameterized constructor? Please enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
						
				// While user input is not Y/N
				while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
					System.out.println("Invalid Input! Should \"" + currentInstanceVariable.getName() + "\" be initialized in the parameterized constructor? Please enter Y/N:");
					userYesNo = KB.nextLine().toUpperCase().trim();
				}
						
				// If the current instance variable should be initialized in the parameterized constructor
				if (userYesNo.equals("Y")){					
					// Prompt the user for the instance variable value
					System.out.println("Please enter the value that will be assigned to the variable, as before the program will offer some type checking for common data types:");
					inputtedInstanceVariableValue = KB.nextLine().trim();
							
					// While the inputtedInstanceVariableValue is not valid
					while (!currentInstanceVariable.setValue(inputtedInstanceVariableValue, bypassTypeChecking)) {
						System.out.println("Not a valid value for the inputted type, would you like to bypass the typechecking (for example if you are assigning an operation)."
									   	   + "\nPlease note, the program will not check the validity of these assignments "
									       + "\nwhich may result in compilation issues in the produced Java program."
									       + "\nPlease enter Y/N:");
					
						userYesNo = KB.nextLine().toUpperCase().trim();
					
						// While user input is not Y/N
						while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
							System.out.println("Invalid Input! Should type checking be bypassed? Please enter Y/N:");
							userYesNo = KB.nextLine().toUpperCase().trim();
						}
					
						if(userYesNo.equals("Y")) {
							bypassTypeChecking = true;
							currentInstanceVariable.setValue(inputtedInstanceVariableValue, bypassTypeChecking);
							break;
						}
					
						System.out.println("Please enter a value of the appropriate type:");
						inputtedInstanceVariableValue = KB.nextLine().trim();
					}	
							
					// Prompt the user for the initialization of the current instance variable
					System.out.println("Please enter a proper initialization for the variable \"" 
				                   + currentInstanceVariable.getName() + "\" with the value \"" + currentInstanceVariable.getValue() + "\" \n(Example: \"this.variableName = value;\"):");
					inputtedInitialization = KB.nextLine().trim();
				
					// While the initialization for the current instance variable is not correct prompt the user for the initialization
					while(!userParameterizedConstructor.addFlexibleInstanceVariableInitialization(inputtedInitialization, currentInstanceVariable)) {
						System.out.println("Invalid Input! Please enter a proper initialization for the variable:");
						inputtedInitialization = KB.nextLine().trim();
					}	
				}
			}		
		}
	}
	
		
	// This method will be used to create the setter methods
	private static void createSetterMethods(Scanner KB, ClassBuilder userClass) {
		
		// This String will hold user input
		String userYesNo;
		String inputtedSetterHeader;
		String inputtedAssignment;
		String inputtedInstanceVariableValue;
		
		// Will temporarily hold setter
		Setter userSetter;
		
		// Boolean value to check if type checking in initialization should be bypassed
		boolean bypassTypeChecking = false;
		
		System.out.println("Now setter methods will be created. In regards to the headers, although other access modifiers will be allowed, the most common and applicable is \"public\"."
		           + "\nThe \"public\" modifier allows the user to interact with \"private\" instance variables safely."
		           + "\nThe name of the method should start with \"set\" followed by the variable name capitalized."
		           + "\nFor example if the variable name is \"name\", it should be \"setName\"."
		           + "\nThe header should also include a parameter that will be used to initialize the variable the setter method is for."
		           + "\nThe parameter should be of the type and have the same name as the variable that the setter method is for."
		           + "\n(Example of full header: \"public void setName(String name){}\").");
		
		// Ask the user if they would like to create a setter method for each instance variables
		for (InstanceVariable currentInstanceVariable : userClass.getAllInstanceVariables()) {
			
			// Ask user if a setter method should be created for current instance variable
			System.out.println("Should a setter method be created for \"" + currentInstanceVariable.getName() + "\" ? Please enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
			
			// While user input is not Y/N
			while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
				System.out.println("Invalid Input! Should a setter method be created for \"" + currentInstanceVariable.getName() + "\" ? Please enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
			}
			
			if(userYesNo.equals("Y")){
				
				// Create temporary Setter
				userSetter = new Setter();
				
				// Prompt user for a setter header
				System.out.println("Please enter a valid setter method header."
						           + "\n(Example of full header: \"public void setName(String name){}\"):");
				
				inputtedSetterHeader = KB.nextLine().trim();
				
				while(!userSetter.setSetterHeader(inputtedSetterHeader, currentInstanceVariable)) {
					System.out.println("Invalid Input! Please enter a valid setter header:");
					inputtedSetterHeader = KB.nextLine().trim();
				}
				
				// Ask user if the assignment is the conventional one or a more flexible one
				System.out.println("Is the intended assignment the conventional (\"this.variableName = name;\"). Please enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
				
				while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
					System.out.println("Invalid Input! Is the intended assignment the conventional (\"this.variableName = name;\"). Please enter Y/N:");
					userYesNo = KB.nextLine().toUpperCase().trim();
				}
				
				if (userYesNo.equals("Y")) {
					// Prompt user for  conventional initialization statement that goes in the setter method
					System.out.println("Please enter a valid assignment statement to go inside the setter method (\"this.variableName = name;\")");
					inputtedAssignment = KB.nextLine().trim();
					
					// While the assignment is not correct, prompt the user for a new assignment
					while (!userSetter.setConventionalAssigment(inputtedAssignment, currentInstanceVariable)) {
						System.out.println("Invalid input! Please enter a valid assignment statement to go inside the setter method (\"this.variableName = name;\")");
						inputtedAssignment = KB.nextLine().trim();
					}
					
				} else {
					
					// Prompt the user for the instance variable value
					System.out.println("Please enter the value that will be assigned to the variable, as before the program will offer some type checking for common data types:");
					inputtedInstanceVariableValue = KB.nextLine().trim();
							
					// While the inputtedInstanceVariableValue is not valid
					while (!currentInstanceVariable.setValue(inputtedInstanceVariableValue, bypassTypeChecking)) {
						System.out.println("Not a valid value for the inputted type, would you like to bypass the typechecking (for example if you are assigning an operation)."
									   	   + "\nPlease note, the program will not check the validity of these assignments "
									       + "\nwhich may result in compilation issues in the produced Java program."
									       + "\nPlease enter Y/N:");
					
						userYesNo = KB.nextLine().toUpperCase().trim();
					
						// While user input is not Y/N
						while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
							System.out.println("Invalid Input! Should type checking be bypassed? Please enter Y/N:");
							userYesNo = KB.nextLine().toUpperCase().trim();
						}
						
						if(userYesNo.equals("Y")) {
							bypassTypeChecking = true;
							currentInstanceVariable.setValue(inputtedInstanceVariableValue, bypassTypeChecking);
							break;
						}
					
						System.out.println("Please enter a value of the appropriate type:");
						inputtedInstanceVariableValue = KB.nextLine().trim();
					}	
							
					// Prompt the user for the assignment of the current instance variable
					System.out.println("Please enter a proper assignment for the variable \"" 
				                   + currentInstanceVariable.getName() + "\" with the value \"" + currentInstanceVariable.getValue() + "\" \n(Example: \"this.variableName = value;\"):");
					inputtedAssignment = KB.nextLine().trim();
				
					// While the assignment for the current instance variable is not correct prompt the user for the assignment
					while(!userSetter.setFlexibleAssignment(inputtedAssignment, currentInstanceVariable)) {
						System.out.println("Invalid Input! Please enter a proper assignment for the variable:");
						inputtedAssignment = KB.nextLine().trim();
					}	
				}	
				userClass.addSetter(userSetter);
			}	
		}
	}
	
	
	// This method will be used to create getter methods for the selected instance variables
	private static void createGetterMethods(Scanner KB, ClassBuilder userClass) {
		
		// These Strings will hold user input
		String userYesNo;
		String inputtedGetterHeader;
		String inputtedReturnStatement;
		
		// Will temporarily hold getter
		Getter userGetter;
		
		System.out.println("Now getter methods will be created for selected methods.");
		
		// Ask the user if they would like to create a setter method for each instance variables
		for (InstanceVariable currentInstanceVariable : userClass.getAllInstanceVariables()) {
			
			// Ask user if a getter method should be created for current instance variable
			System.out.println("Should a getter method be created for \"" + currentInstanceVariable.getName() + "\" ? Please enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
			
			// While user input is not Y/N
			while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
				System.out.println("Invalid Input! Should a setter method be created for \"" + currentInstanceVariable.getName() + "\" ? Please enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
			}
			
			if (userYesNo.equals("Y")) {
				
				userGetter = new Getter();
				
				// Prompt user for a getter method header
				System.out.println("Please enter a valid getter method header (Example: \"public Type getName(){}\"):");
				inputtedGetterHeader = KB.nextLine().trim();
				
				// While the inputted header is not valid prompt the user for a valid header
				while (!userGetter.setGetterHeader(inputtedGetterHeader, currentInstanceVariable)) {
					System.out.println("Invalid Input! Please enter a valid getter method header (Example: \"public Type getName(){}\"):");
					inputtedGetterHeader = KB.nextLine().trim();
				}
				
				// Ask user if the return statement is a standard return statement
				System.out.println("Does the intended return statement follow the standard form of \"return this.name;\" ? Please enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
				
				// While user input is not Y/N
				while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
					System.out.println("Invalid Input! Does the intended return statement follow the standard convention (\"return this.name;\") ? Please enter Y/N:");
					userYesNo = KB.nextLine().toUpperCase().trim();
				}
				
				if (userYesNo.equals("Y")) {
					
					// Prompt user for standard return statement
					System.out.println("Please enter a valid return statement following the standard convention (\"return this.name;\"):");
					inputtedReturnStatement = KB.nextLine().trim();
					
					// While inputted return statement is not correct prompt user for correct return statement
					while (!userGetter.setStandardReturnStatement(inputtedReturnStatement, currentInstanceVariable)) {
						System.out.println("Invalid Input! Please enter a valid return statement following the standard convention (\"return this.name;\"):");
						inputtedReturnStatement = KB.nextLine().trim();
					}
					
				} else {
					
					// Prompt user for standard return statement
					System.out.println("Please enter a valid return statement (please note complex return statements will not be fully analyzed for validity):");
					inputtedReturnStatement = KB.nextLine().trim();
					
					// While inputted return statement is not correct prompt user for correct return statement
					while (!userGetter.setFlexibleReturnStatement(inputtedReturnStatement, currentInstanceVariable)) {
						System.out.println("Invalid Input! Please enter a valid return statement:");
						inputtedReturnStatement = KB.nextLine().trim();
					}					
				}
				userClass.addGetter(userGetter);
			}			
		}		
	}
	
	
	// This method will be used to create toString to clearly represent the toString class
	private static void createToString(Scanner KB, boolean extendsClass, ClassBuilder userClass) {
		
		// These Strings will hold user input
		String userYesNo;
		String inputtedHeader;
		String inputtedStringBuilder;
		String inputtedSuperToString;
		String inputtedToStringBodyLine;
		String inputtedReturnStatement;
		
		// Create an instance of ToString
		ToString userToString = new ToString();
		
		System.out.println("Now a toString method that returns a String representing the created class and selected fields will be created.");
		
		// Prompt user for toString header
		System.out.println("For simplicity please enter the following header \"public String toString(){}\":");
		inputtedHeader = KB.nextLine().trim();
		
		// While the header is not correct prompt the user
		while (!userToString.setToStringHeader(inputtedHeader)) {
			System.out.println("Invalid Input! For simplicity please enter the following header, \"public String toString(){}\":");
			inputtedHeader = KB.nextLine().trim();
		}
		
		// Prompt user for StringBuilder creation
		System.out.println("For implicity please enter the following StringBuilder declaration and initialization, \"StringBuilder str = new StringBuilder();\":");
		inputtedStringBuilder = KB.nextLine().trim();
		
		// While the inputted StringBuilder is not correct prompt the user
		while (!userToString.createStringBuilder(inputtedStringBuilder)) {
			System.out.println("Invalid Input! For implicity please enter the following StringBuilder declaration and initialization, \"StringBuilder str = new StringBuilder();\":");
			inputtedStringBuilder = KB.nextLine().trim();
		}
		
		// If extends class, include super's toString method
		if(extendsClass) {
			System.out.println("Please include the super classes to string using, \"str.append(super.toString());\":");
			inputtedSuperToString = KB.nextLine();
			
			// While the inputted append statement is incorrect, prompt the user
			while (!userToString.addSuperToString(inputtedSuperToString)) {
				System.out.println("Invalid Input! Please include the super classes to string using, \"str.append(super.toString);\":");
				inputtedSuperToString = KB.nextLine();
			}
			
		}
		
		// Prompt user for toString body
		for (InstanceVariable currentInstanceVariable : userClass.getAllInstanceVariables()) {
			
			// Ask user if instance variable should be included
			System.out.println("Should \"" + currentInstanceVariable.getName() + "\" be included in the toString? Please enter Y/N:");
			userYesNo = KB.nextLine().toUpperCase().trim();
						
			// While user input is not Y/N
			while (!(userYesNo.equals("Y") || userYesNo.equals("N"))) {
				System.out.println("Should \"" + currentInstanceVariable.getName() + "\" be included in the toString? Please enter Y/N:");
				userYesNo = KB.nextLine().toUpperCase().trim();
			}
			
			if (userYesNo.equals("Y")) {
				
				// Prompt user to add to the StringBuilder
				System.out.println("To create symmetry please enter the following append statement with the corresponding variable names, \"str.append(\"variableName: \" + variableName)\" + \"\\n\");\":");
				inputtedToStringBodyLine = KB.nextLine().trim();
				
				// While the append statement is not correct
				while (!userToString.addLineToBody(inputtedToStringBodyLine, currentInstanceVariable)) {
					System.out.println("Invalid input! To create symmetry please enter the following append statement with the corresponding variable names, \"str.append(\"variableName: \" + variableName)\" + \"\\n\");\":");
					inputtedToStringBodyLine = KB.nextLine().trim();
				}
		
			}
		}
		
		// Prompt user for return statement
		System.out.println("Please enter the following return statement, \"return str.toString();\" :");
		inputtedReturnStatement = KB.nextLine().trim();
					
		// While return statement is not correct prompt the user
		while (!userToString.createReturnStatement(inputtedReturnStatement)) {
			System.out.println("Invalid Input! Please enter the following return statement, \"return str.toString();\" :");
			inputtedReturnStatement = KB.nextLine().trim();
		}
		
		userClass.setToString(userToString);
	}
}