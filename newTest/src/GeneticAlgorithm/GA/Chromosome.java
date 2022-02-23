/*
 * Copyright(C) 2019 NgocAnh
 *
 * Chromosome.java, Sep 26, 2019 NgocAnh
 */
package GeneticAlgorithm.GA;

import java.util.*;

//import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;

import openjava.ptree.Leaf;
//import sun.tools.jar.resources.jar;

/**
 * Biểu diễn chromosome. Chromosome mã hóa thông tin của testcase
 * <p>
 * Examples:
 * <p>
 * $x0=A(int[0;1]):$x1=B#null:$x0.m(int,$x1)@1,88
 * $x0=A():$x1=B(int[-2;2]):$x1.g1():$x0.m(int,$x1)@-1,42
 */
public class Chromosome implements Comparable, Cloneable {
    /**
     * Testcase : List hàm hoặc constructor
     */
    private List<Statement> statements = new LinkedList<Statement>();
    
    //private List<String> actualValues = new ArrayList<String>();

    /**
     * Branch targets được bao phủ
     */
    private Path coveredPath;

    /**
     * Đường dẫn được bao phủ bởi TestCaseExecutor.
     */
    public void setCoveredPath(Path coveredPath) {
    	this.coveredPath = coveredPath;
    }
    
    public Path getCoveredPath() {
    	return this.coveredPath;
    }

    /**
     * Branch targets được bao phủ ( chỉ xét trong method hiện tại)
     */
    private Path targetPath;

    /**
     * Target được thỏa mãn bởi TestCaseExecutor.
     */
    public void setTargetPath(Path targetPath) {
        this.targetPath = targetPath;
    }
    
    public Path getTargetPath() {
    	return this.targetPath;
    }
    
    public void setStatements(List<Statement> statements) {
    	this.statements = statements;
    }
    
    public List<Statement> getStatements() {
    	return this.statements;
    }

    /**
     * Số branch được bao phủ đến hiện tại bởi chromosome
     */
    private double fitness = 0.0;
    
    public void setFitness(double fitness) {
    	this.fitness = fitness;
    }
    
    public double getFitness() {
    	return this.fitness;
    }
    
    public void updateFitness(double fitness) {
    	this.fitness += fitness;
    }

    /**
     * kết quả trả về của method
     */
    private String expectResult;
    
    public void setExpectResult(String expectResult) {
    	this.expectResult = expectResult;
    }
    
    public String getExpectResult() {
    	return this.expectResult;
    }

    /**
     * Implements chromosome duplication.
     */
    public Object clone() {
        List<Statement> acts = new LinkedList<Statement>();
        Iterator<Statement> it = this.statements.iterator();
        while (it.hasNext()) {
            Statement act = (Statement) it.next();
            acts.add((Statement)act.clone());
        }
        return new Chromosome(acts);
    }

    /**
     * Sắp xếp chromosome dựa trên độ giảm giá trị fitness
     */
    public int compareTo(Object o) {
        Chromosome other = (Chromosome) o;
        if (other.getFitness() == this.fitness)
        	return 0;
        else if (other.getFitness() > this.fitness)
        	return 1;
        else 
        	return -1;
        //return other.fitness - fitness;
    }

    /**
     * Equality of chromosomes is based on fitness.
     */
    public boolean equals(Object o) {
        Chromosome ind = (Chromosome) o;
        //should update in the case the fitness is not integer anymore
        return fitness == ind.getFitness();
    }

    /**
     * @return
     * number of statements in the first part of 
     * chromosome
     */
    public int statementSize() {
        return statements.size();
    }
    
    /**
     * 
     * @return number of values in the second part of chromosome
     */
    public int valueSize() {
    	int count = 0;
    	for (Statement statement : statements) {
			count += statement.getActualValues().size();
		}
    	return count;
    }
    
    /**
     * Number of parameters including both objects and primitive types
     * @return number of parameters in all statements
     */
    public int parameterSize() {
    	int count = 0;
    	for (Statement statement : statements) {
			count += statement.getParameterValues().size();
		}
    	return count;
    }

//    /**
//     * Gets ConstructorInvocation
//     *
//     * @param objId object Target của constructor.
//     * @return ConstructorInvocation object của objId .
//     */
//    private Statement getConstructor(String objId) {
//        Iterator i = statements.iterator();
//        while (i.hasNext()) {
//            Statement act = (Statement) i.next();
//            if (objId.equals(act.getTargetObject()))
//                return act;
//        }
//        return null;
//    }

    /**
     * xậy dựng chromosome từ các action
     */
    public Chromosome(List<Statement> statements) {
        this.statements = statements;
        //after constructing a chromosome from a list of statements, initializing the list of actual values (after @) for this chromosome
        //this.initializeActualValuesList();
    }

    /**
     * Builds chromosome.
     */
    public Chromosome() {
    	
    }

    /**
     * biểu diễn chromosome
     * <p>
     * Example:
     *
     * <pre>
     * $x0=A():$x1=B(int):$x1.c():$x0.m(int, $x1) @ 1, 4
     * each statement is separated by a :
     * each actual value is separated by a ,
     * </pre>
     */
    public String toString() {
        String s = "";
        try {
            Iterator i = statements.iterator();
            while (i.hasNext()) {
                Statement act = (Statement) i.next();
                if (s.equals("")) {
                    s = act.actionDescription();
                } else {
                    s += ":" + act.actionDescription();
                }
            }
            s += "@";
            i = statements.iterator();
            while (i.hasNext()) {
                Statement act = (Statement) i.next();
                String actVals = act.actualValuesToString();
                if (!actVals.equals("")) {
                    if (s.endsWith("@")) {
                        s += actVals;
                    } else {
                        s += "," + actVals;
                    }
                }
            }
        } catch (Exception ex) {

        }
        return s;
    }

    /**
     * Lấy ra list các value của chromosome
     *
     * @return actualParams List các value
     */
//    public void initializeActualValuesList() {
//        actualValues = new ArrayList<String>();
//        Iterator i = statements.iterator();
//        while (i.hasNext()) {
////            Statement stm = (Statement) i.next();
////            String actVals = stm.actualValuesToString();
////            if (!actVals.equals("")) {
////            	String[] actValueStringArray = actVals.split(",");
////                for (String element : actValueStringArray) {
////                	actualValues.add(element);
////                }
////            }
//        	Statement stm = (Statement) i.next();
//        	List<String> actualValueOfStatement = stm.getActualValues();
//        	if (actualValueOfStatement != null) 
//        		actualValues.addAll(actualValueOfStatement);
//        }
//    }

    /**
     * Lấy ra list các value của chromosome
     *
     * @return actualParams List các value
     */
//    public String[] getArrayOfActualValues() {
//        //make sure that actualValues of the chromosome has been invoked before
//        return actualValues.toArray(new String[0]);
//    } 

    /**
     * Set giá trị value cho action
     *
     * @param newValue list giá trị mới
     */
//    public void setInputValue(List<String> newValue) {
//        int index = 0;
//        Iterator<Statement> i = statements.iterator();
//        while (i.hasNext()) {
////			int count=0;
//            Statement act = (Statement) i.next();
//            List<String> actualParamValues = act.getParameterValues();
//            List<String> parameterValues = new ArrayList<String>();
//            for (int j = 0; j < actualParamValues.size(); j++) {
//                String element = actualParamValues.get(j);
//                if (!element.toString().contains("$")) {
//                	parameterValues.add(newValue.get(index));
//                    index++;
//                } else {
//                	parameterValues.add(element);
//                }
//            }
//            if (parameterValues.size() > 0) {
//                act.setParameterValues(parameterValues);
//            }
////			act.setParameterValuesMethod(newValue);
//        }
//    }

    /**
     * java code representation of Chromosome.
     * <p>
     * Example:
     *
     * <pre>
     * $x0=A():$x1=B(int):$x1.c():$x0.m(int, $x1) @ 1, 4
     * </pre>
     * <p>
     * becomes:
     *
     * <pre>
     * A x0 = new A();
     * B x1 = B(1);
     * x1.c();
     * x0.m(4, x1) @ 1, 4
     * </pre>
     */
    public String toCode() {
        String s = "";
        Iterator i = statements.iterator();
        while (i.hasNext()) {
            Statement act = (Statement) i.next();
            act.setExpectResult(this.expectResult);
            s += act.toCode() + "\n";
        }
        return s;
    }

    /**
     * Xác định biến $xN được gán cho obj của 1 class từ class đã biết
     * <p>
     * Scan chromosome cho tới khi gặp đối tượng của 1 class. left hand side
     * variable được trả về
     *
     * @param className class của đối tượng tìm kiếm
     * @return String đại diện của biến đối tượng tìm kiếm (hoặc null)
     */
    public String getObjectId(String className) {
        if (className.indexOf("[") != -1)
            className = className.substring(0, className.indexOf("["));
        Iterator<Statement> i = statements.iterator();
        while (i.hasNext()) {
            Statement a = (Statement) i.next();
            if (className.equals(a.getName()))
                return a.getTargetObject();
        }
        return null;
    }
    
    public Chromosome[] randomSplitInto2Parts(int splitIndex) {
    	Chromosome[] parts = new Chromosome[2];
    	LinkedList<Statement> head = new LinkedList<Statement>();
    	LinkedList<Statement> tail = new LinkedList<Statement>();
    	int k = 0;
    	
    	Iterator<Statement> iterator = statements.iterator();
    	while (iterator.hasNext()) {
    		Statement stm = iterator.next();
    		if (k <= splitIndex)
    			head.add(stm);
    		else 
				tail.add(stm);
    		k++;
    	}
    	parts[0] = new Chromosome(head);
    	parts[1] = new Chromosome(tail);
    	return parts;
    }
    
    public int renameObjects(int idCounter) {
    	int id = idCounter;
    	Map<String, String> oldIdToNewIdMap = new HashMap<String, String>();
    	Iterator<Statement> iterator = statements.iterator();
    	while (iterator.hasNext()) {
			Statement statement = (Statement) iterator.next();
			String objId = statement.getTargetObject();
			if (!oldIdToNewIdMap.containsKey(objId))
				oldIdToNewIdMap.put(objId, "$x" + (id++));
			statement.setTargetObject(oldIdToNewIdMap.get(objId));
			List<String> newParamValues = new LinkedList<String>();
			List<String> oldParamValues = statement.getParameterValues();
			if (oldParamValues != null) {
				Iterator<String> iterator2 = oldParamValues.iterator();
				while (iterator2.hasNext()) {
					String val = (String) iterator2.next();
					if (val != null && val.startsWith("$")) {
						if (!oldIdToNewIdMap.containsKey(val))
							oldIdToNewIdMap.put(val, "$x" + (id++));
						newParamValues.add(oldIdToNewIdMap.get(val));
					} else {
						newParamValues.add(val);
					}
				}
			}
			statement.setParameterValues(newParamValues);
		}
    	return id;
    }
    
    public List<Statement> getMethodCallStatements() {
    	List<Statement> stmList = new ArrayList<Statement>();
    	Iterator<Statement> iterator = statements.iterator();
    	while (iterator.hasNext()) {
			Statement statement = (Statement) iterator.next();
			if (statement instanceof MethodInvocation) {
				stmList.add(statement);
			}
		}
    	
    	return stmList;
    }
    
    public List<Statement> getMethodCallStatementsByObjectId(String objectId) {
    	List<Statement> stmList = new ArrayList<Statement>();
    	Iterator<Statement> iterator = statements.iterator();
    	while (iterator.hasNext()) {
			Statement statement = (Statement) iterator.next();
			if (statement instanceof MethodInvocation && objectId.equals(statement.getTargetObject())) {
				stmList.add(statement);
			}
		}
    	
    	return stmList;
    }
    
    public Statement getConstructorOfObjectId(String objId) {
    	Iterator<Statement> iterator = statements.iterator();
    	while (iterator.hasNext()) {
			Statement statement = (Statement) iterator.next();
			if (statement.getTargetObject().equals(objId) && 
					(statement instanceof NullConstructorInvocation 
					|| statement instanceof ConstructorInvocation))
				return statement;
		}
    	return null;
    }
    
    public Map<String, String> getObjectAndClasses() {
    	Map<String, String> objectClassMap = new HashMap<String, String>();
    	Iterator<Statement> iterator = statements.iterator();
    	while (iterator.hasNext()) {
			Statement statement = (Statement) iterator.next();
			String objectName = statement.getTargetObject();
			String className = null;
			if (statement instanceof NullConstructorInvocation || statement instanceof ConstructorInvocation) {
				className = statement.getName();
				if (!objectClassMap.containsKey(objectName)) {
					objectClassMap.put(objectName, className);
				}
			}
		}
    	return objectClassMap;
    }

    /**
     * Xác định biến $xN được gán cho obj của 1 class từ list class đã biết
     *
     * @param classes Danh sách các lớp đối tượng có thể thuộc về
     * @return String đại diện của biến đối tượng tìm kiếm (hoặc null)
     */
    public String getObjectId(List<String> classes) {
        Iterator<String> i = classes.iterator();
        while (i.hasNext()) {
            String cl = (String) i.next();
            String objId = getObjectId(cl);
            if (objId != null)
                return objId;
        }
        return null;
    }
    
    

    /**
     * Adds action để mô tả input
     *
     * @param act Action được add
     */
    public void addStatement(Statement act) {
        statements.add(act);
//        List<String> actualValuesOfAStatement = act.getActualValues();
//        if (actualValuesOfAStatement != null)
//        	actualValues.addAll(actualValuesOfAStatement);
    }

    /**
     * Append all statements of a chromosome at the end of the current chromosome
     * <p>
     * Example: $x0=A(int)@10 $x1.m($x0,int)@21
     * <p>
     * $x0=A(int):$x1.m($x0,int)@10,21
     *
     * @param chrom Chromosome sau khi được ghép
     */
    public void appendChromosome(Chromosome chrom) {
        statements.addAll(chrom.getStatements());
    }
    
    /**
     * Insert all statements of a chromosome to a specific position in the list
     * of statements of the current chromosome
     * @param chromosome
     * @param atPosition
     */
    public void insertChromosome(int index, Chromosome chromosome) {
    	List<Statement> newStatements = chromosome.getStatements();
    	for (int i = 0; i < newStatements.size(); i++) {
    		statements.add(index + i, newStatements.get(i));
    	}
    }

    /**
     * Mutation operator: randomly changes one of the input values.
     */
    public void mutationByChangingInputValue() {
        int valNum = 0;
        Iterator<Statement> i = statements.iterator();
        while (i.hasNext()) {
            Statement act = (Statement) i.next();
            valNum += act.countPrimitiveTypes();
        }
        if (valNum == 0)
            return;
        int inputIndex = ChromosomeFormer.randomGenerator.nextInt(valNum);
        int k = 0;
        i = statements.iterator();
        while (i.hasNext()) {
            Statement act = (Statement) i.next();
            int actValNum = act.countPrimitiveTypes();
            if (k <= inputIndex && k + actValNum > inputIndex) {
                act.changeInputValue(inputIndex - k);
                break;
            }
            k += actValNum;
        }
    }
    
    public void mutationByChangingMethodInvocation(ChromosomeFormer chromosomeFormer) {
    	//one for constructor of class under test, one for invocation of method under test 
    	if (statementSize() < 2)
			return;
    	int r = chromosomeFormer.randomGenerator.nextInt(100);
    	if (r > 50) 
    		mutationByRemovingMethod(chromosomeFormer);
    	else {
			mutationByAddingMethod(chromosomeFormer);
		}
    }
   
    
    /**
     * The method under test is always the last statement
     * in the list of statements
     * The methods are available to be removed are not constructors
     * setter methods are candidates
     * @param chromosomeFormer
     */
    public void mutationByRemovingMethod(ChromosomeFormer chromosomeFormer) {
    	List<Statement> methodCallStms = getMethodCallStatements();
    	int nbMethodCalls = methodCallStms.size();
    	if (nbMethodCalls == 1)
    		return;
    	nbMethodCalls--;
    	int randomMethod = ChromosomeFormer.randomGenerator.nextInt(nbMethodCalls);
    	int k = 0;
    	Iterator<Statement> iterator = statements.iterator();
    	List<Statement> newStatements = new ArrayList<Statement>();
    	while (iterator.hasNext()) {
			Statement statement = (Statement) iterator.next();
			if (!(k==randomMethod && statement instanceof MethodInvocation)) {
				newStatements.add(statement);
			}
			if (statement instanceof MethodInvocation) {
				k++;
			}
		}
    	this.setStatements(newStatements);
    	System.out.println("Mutation by removing method");
	}
    
    /**
     * Adding only methods void, especially setter methods
     * Methods should be added before the last statements
     * after constructor calls of corresponding object
     * @param chromosomeFormer
     */
    public void mutationByAddingMethod(ChromosomeFormer chromosomeFormer) {
    	//random call a public method of one of objects in chromosome
    	Map<String, String> objectAndClassMap = getObjectAndClasses();
    	Set<String> objectStrings = objectAndClassMap.keySet();
    	List<String> objectList = new ArrayList<String>();
    	Iterator<String> iterator = objectStrings.iterator();
    	while (iterator.hasNext()) {
			String string = (String) iterator.next();
			objectList.add(string);
		}
    	int randomObjectIndex = ChromosomeFormer.randomGenerator.nextInt(objectList.size());
    	String selectedObjId = objectList.get(randomObjectIndex);
    	String selectedClass = objectAndClassMap.get(selectedObjId);
    	//Get list of void methods in the selected class 
    	List<MethodSignature> methods = chromosomeFormer.getMethods().get(selectedClass);
    	if (methods == null) {
    		return;
    	}
    	int methodId = ChromosomeFormer.randomGenerator.nextInt(methods.size());
    	MethodSignature selectedMethod = methods.get(methodId);
    	if (selectedClass.equals(chromosomeFormer.getClassUnderTest()) && 
    			selectedMethod.toString().equals(chromosomeFormer.getMethodUnderTest()))
    		return;
    	Chromosome newChromosome = chromosomeFormer.buildMethodCall(selectedMethod.toString(), selectedObjId);
    	//insert new method call statements right after the selected object's statements
    	int insertionId = findStatementIndexOfObjectId(selectedObjId);
    	this.insertChromosome(insertionId, newChromosome);
    	System.out.println("Mutation by adding new method call");
    }
    
    private int findStatementIndexOfObjectId(String objId) {
    	Iterator<Statement> iterator = statements.iterator();
    	int k = 0;
    	boolean isObjIdStm = false;
    	while (iterator.hasNext()) {
			Statement statement = (Statement) iterator.next();
			if (statement.getTargetObject().equals(objId)) {
				isObjIdStm = true;
			} else if (isObjIdStm) {
				break;
			}
			k++;
		}
    	return k;
    }
    
    public void mutationByChangingConstructor(ChromosomeFormer chromosomeFormer) {
    	List<Statement> newStatements = new LinkedList<Statement>();
    	int nbOfConstructors = 0;
    	Iterator<Statement> iterator = statements.iterator();
    	while (iterator.hasNext()) {
			Statement statement = (Statement) iterator.next();
			if (statement instanceof ConstructorInvocation)
				nbOfConstructors++;
		}
    	if (nbOfConstructors == 0)
    		return;
    	int constructorIndex = ChromosomeFormer.randomGenerator.nextInt(nbOfConstructors);
    	int k = 0;
    	iterator = statements.iterator();
    	while (iterator.hasNext()) {
			Statement statement = (Statement) iterator.next();
			if (k == constructorIndex && statement instanceof ConstructorInvocation) {
				String className = statement.getName();
				String objId = statement.getTargetObject();
				Chromosome newChromosome = chromosomeFormer.buildConstructor(className, objId);
				newStatements.addAll(newChromosome.getStatements());
			} else {
				newStatements.add(statement);
			}
			if (statement instanceof ConstructorInvocation)
				k++;
		}
    	statements = newStatements;
    }
    
    public boolean coversTarget(Path targetPath) {
    	if (coveredPath == null) return false;
    	return coveredPath.covers(targetPath);
    }
}