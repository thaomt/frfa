package GeneticAlgorithm.GA;

import java.util.*;

/**
 * Quản lý chữ kí method/constructor
 */
public class MethodSignature {
	/**
	 * Tên method
	 */
	private String name;
	
	private String className;

	/**
	 * List parameter
	 */
	private List<String> parameters;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the parameters
	 */
	public List<String> getParameters() {
		return parameters;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param parameters
	 *            the parameters to set
	 */
	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}

	/**
	 * @param name
	 * @param parameters
	 */
	public MethodSignature(String name, String className, List<String> parameters) {
		super();
		this.name = name;
		this.parameters = parameters;
		this.className = className;
	}

	public MethodSignature() {
	}
	
	public String getClassName() {
		return this.className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String toString() {
		String printString = className + ".";
		printString += this.name + "(";
		if (!parameters.isEmpty()) {
			for (String param : parameters) {
				printString += param + ",";
			}
			printString = printString.substring(0, printString.lastIndexOf(","));
		}
		printString += ")";
		return printString;
	}
}
