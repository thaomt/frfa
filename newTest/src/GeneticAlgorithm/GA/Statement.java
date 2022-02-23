package GeneticAlgorithm.GA;

import java.util.*;

/**
 * Định nghĩa Action
 *
 */
public class Statement implements Cloneable {
	/**
	 * Lưu target object.
	 */
	 private String targetObject;

	/**
	 * Action name.
	 */
	 private String name;

	/**
	 * Lưu các loại param
	 *
	 * Example: ("int", "B", "A", "int").
	 */
	 private List<String> parameterTypes = new LinkedList<String>();

	/**
	 * Giá trị tham số
	 *
	 * Example: ("12", "$x2", "$x0", "23")
	 */
	 private List<String> parameterValues = new LinkedList<String>();
	/**
	 * 
	 */
	 private String expectResult;
	
	public Statement() {
		
	}
	
	public Object clone() {
		Statement act = new Statement();
		act.setTargetObject(this.targetObject);
		act.setName(this.name);
		act.setParameterTypes(this.parameterTypes);
		act.setParameterValues(this.parameterValues);
		act.setExpectResult(this.expectResult);
		return act;
	}

	/**
	 * get ParameterValues
	 */
	public List<String> getParameterValues() {
		return parameterValues;
	}
	
	public void setParameterValues(List<String> parameterValues) {
		this.parameterValues = parameterValues;
	}
	
	public List<String> getParameterTypes() {
		return this.parameterTypes;
	}
	
	public void setParameterTypes(List<String> parameterTypes) {
		this.parameterTypes = parameterTypes;
	}

	/**
	 * return a list of parameters which are object instances
	 *
	 * Example: ("$x2", "$x0") trong tập ("12", "$x2", "$x0", "23")
	 */
	public List<String> getParameterObjects() {
		List<String> paramObjects = new LinkedList<String>();
		if (parameterTypes == null || parameterValues == null)
			return paramObjects;
		Iterator<String> i = parameterTypes.iterator();
		Iterator<String> j = parameterValues.iterator();
		while (i.hasNext() && j.hasNext()) {
			String paramType = (String) i.next();
			String param = (String) j.next();
			if (!ChromosomeFormer.isPrimitiveType(paramType) && !ChromosomeFormer.isPrimitiveArrayType(paramType))
				paramObjects.add(param);
		}
		return paramObjects;
	}

	/**
	 * Get targetObject
	 */
	public String getTargetObject() {
		return targetObject;
	}
	
	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	/**
	 * get name of action
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getExpectResult() {
		return this.expectResult;
	}
	
	public void setExpectResult(String expectResult) {
		this.expectResult = expectResult;
	}

	/**
	 * Code biểu diễn cho action.
	 */
	public String toCode() {
		return "";
	}

	/**
	 * Chuỗi mô tả action
	 */
	public String actionDescription() {
		return actionPrefix() + parameterDescription();
	}

	/**
	 * tiền tố action
	 */
	public String actionPrefix() {
		return "";
	}

	/**
	 * String biểu diễn kiểu param
	 */
	public String parameterDescription() {
		try {
			if (parameterTypes == null || parameterValues == null) {
				return "";
			}
			String s = "(";
			Iterator<String> i = parameterTypes.iterator();
			Iterator<String> j = parameterValues.iterator();
			while (i.hasNext() && j.hasNext()) {
				String param = (String) i.next();
//				String paramId = (String) j.next();

				Object paramId1= (Object) j.next();
				String paramId=paramId1.toString();
				if (!ChromosomeFormer.isPrimitiveType(param) && !ChromosomeFormer.isPrimitiveArrayType(param)) {
					param = paramId;
				}
				if (s.equals("(")) {
					s += param;
				}
				else {
					s += "," + param;
				}
			}
			s += ")";
			return s;
		}catch (Exception e){
			System.out.println("DESCRIPTION: "+e.getMessage());
			return null;
		}
	}

	/**
	 * String biểu diễn giá trị param
	 */
	public String actualValuesToString() {
//		if (parameterValues == null || parameterTypes == null)
//			return "";
//		String s = "";
//		Iterator i = parameterValues.iterator();
//		Iterator j = parameterTypes.iterator();
//		while (i.hasNext() && j.hasNext()) {
//			String paramVal = (String) i.next();
//			String paramType = (String) j.next();
//			if (ChromosomeFormer.isPrimitiveType(paramType) || ChromosomeFormer.isPrimitiveArrayType(paramType)) {
//				if (s.equals(""))
//					s += paramVal;
//				else
//					s += "," + paramVal;
//			}
//		}
//		return s;
		String resultString = "";
		List<String> actualValues = this.getActualValues();
		if (actualValues == null) return resultString;
		Iterator<String> valIterator = actualValues.iterator();
		while (valIterator.hasNext()) {
			String valString = (String) valIterator.next();
			if (resultString.equals(""))
				resultString += valString;
			else {
				resultString += "," + valString;
			}
		}
		return resultString;
	}
	
	public List<String> getActualValues() {
		List<String> actualValues = new ArrayList<String> ();
		if (parameterValues == null || parameterTypes == null)
			return actualValues;
		Iterator<String> i = parameterValues.iterator();
		Iterator<String> j = parameterTypes.iterator();
		while (i.hasNext() && j.hasNext()) {
			String paramVal = (String) i.next();
			String paramType = (String) j.next();
			if (ChromosomeFormer.isPrimitiveType(paramType) || ChromosomeFormer.isPrimitiveArrayType(paramType)) {
				actualValues.add(paramVal);
			}
		}
		return actualValues;
	}
 
	/**
	 * Thay đổi ngẫu nhiên một giá trị của action.
	 *
	 * @param valIndex
	 *            chỉ số của giá trị primitive type thay đổi
	 */
	public void changeInputValue(int valIndex) {
		if (parameterValues == null || parameterTypes == null)
			return;
		List<String> newParamVals = new LinkedList<String>();
		int k = 0;
		Iterator<String> i = parameterValues.iterator();
		Iterator<String> j = parameterTypes.iterator();
		while (i.hasNext() && j.hasNext()) {
			String paramVal = (String) i.next();
			String paramType = (String) j.next();
			if (ChromosomeFormer.isPrimitiveArrayType(paramType) && k == valIndex) {
				int length = ChromosomeFormer.getLengthArray();
				String newVal = ChromosomeFormer.buildArrayValue(paramType, length);
				newParamVals.add(newVal);
			} else if (ChromosomeFormer.isPrimitiveType(paramType) && k == valIndex) {
				String newVal = ChromosomeFormer.buildValue(paramType);
				newParamVals.add(newVal);
			} else {
				newParamVals.add(paramVal);
			}
			if (ChromosomeFormer.isPrimitiveType(paramType) || ChromosomeFormer.isPrimitiveArrayType(paramType))
				k++;
		}
		parameterValues = newParamVals;
	}

	/**
	 * Số lượng primitive type ( int, float..)
	 */
	public int countPrimitiveTypes() {
		int n = 0;
		if (parameterValues == null || parameterTypes == null)
			return n;
		Iterator<String> i = parameterTypes.iterator();
		while (i.hasNext()) {
			String paramType = (String) i.next();
			if (ChromosomeFormer.isPrimitiveType(paramType) || ChromosomeFormer.isPrimitiveArrayType(paramType)) {
				n++;
			}
		}
		return n;
	}
	
	public String toString() {
		return actionDescription();
	}

}
