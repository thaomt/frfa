
package GeneticAlgorithm.GA;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.lang.reflect.*;

public class ChromosomeFormer {

    /**
     * Biểu diễn testcase
     * <p>
     * Example:
     * <p>
     * $a=A():$b=B(int):$b.c():$a.m(int, $b) @ 1, 4
     */
    private Chromosome chromosome;
    /**
     * giá trị hàm mục tiêu
     */
    int fitness;
    /**
     * kết quả trả về của method
     */
    String expectResult;

    /**
     * Class đang test
     */
    String classUnderTest;

    /**
     * Method đang test
     */
    String methodUnderTest;

    /**
     * get class under test.
     */
    String getClassUnderTest() {

        return classUnderTest;
    }

    /**
     * Liên kết class name với List of constructors.
     * <p>
     * className:String -> classConstructors:List&lt;MethodSignature&gt;
     */

    private Map<String, List<MethodSignature>> constructors = new HashMap<String, List<MethodSignature>>();

    public Map<String, List<MethodSignature>> getConstructors() {
        return this.constructors;
    }

    public void setConstructors(Map<String, List<MethodSignature>> constructors) {
        this.constructors = constructors;
    }

    /**
     * @return the methodUnderTest
     */
    public String getMethodUnderTest() {
        return this.methodUnderTest;
    }

    /**
     * @param methodUnderTest the methodUnderTest to set
     */
    public void setMethodUnderTest(String methodUnderTest) {
        this.methodUnderTest = methodUnderTest;
    }

    /**
     * liên kết class name với List of methods.
     *
     * <br>
     * className:String -> classMethods:List&lt;MethodSignature&gt;
     */
    private Map<String, List<MethodSignature>> methods = new HashMap<String, List<MethodSignature>>();

    public Map<String, List<MethodSignature>> getMethods() {
    	return this.methods;
    }
    /**
     * liên kết abstract type (e.g. abstract class, interface) to implementations
     * (list of classes).
     *
     * <br>
     * abstractTypeName:String -> concreteTypeNames:List&lt;String&gt;
     */
    private Map<String, List<String>> concreteTypes = new HashMap<String, List<String>>();

    public Map<String, List<String>> getConcreteTypes() {
    	return this.concreteTypes;
    }
    
    /**
     * Bộ đếm tăng dần được sử dụng để xây dựng id mới.
     */
    private int idCounter = 0;

    public static Random randomGenerator = new Random();
    public static StringGenerator stringGenerator = new StringGenerator();

    /**
     * Returns String biểu diễn chromosome
     *
     * @return chromosome: String
     */
    public Chromosome getChromosome() {
        return chromosome;
    }

    /**
     * Set current chromosome.
     */
    public void setCurrentChromosome(Chromosome chrom) {
        chromosome = chrom;
    }

    public static int lengthArray;

    /**
     * @return the lengthArray
     */
    public static int getLengthArray() {
        return lengthArray;
    }

    /**
     * @param lengthArray the lengthArray to set
     */
    public void setLengthArray(int lengthArray) {
        this.lengthArray = lengthArray;
    }

    /**
     * Create a new chromosome
     */
    public void buildNewChromosome() {
            String objId = "$x" + (idCounter++);
            chromosome = new Chromosome();
            // add both constructor and input values
            prependConstructor(classUnderTest);
            // add method call of method under test
            //appendInitMethodCall(classUnderTest, methodUnderTest, null);
            appendMethodCall(methodUnderTest, null);
//            List list = chromosome.getActualValues();
    }
    
    /**
     * Call this method to either perform crossover two individuals
     * or to mutate one individual
     * Set the new created chromosome to the current chromosome
     * @param population in which another parent will be chosen
     */
    public void evolveChromosome(Chromosome parent) throws IOException{
    	float r = randomGenerator.nextFloat();
    	if (r < CommonParameter.mutationInputValueRate) {
    		mutationByChangingInputValue();
    	} else if (r < CommonParameter.mutationConstructorRate) {
    		mutationByChangingConstructor();
    	} else if (r < CommonParameter.mutationMethodInvocationRate){
    		mutationByChangingMethodInvocation();
    	} else {
    		crossover(parent);
    	}
    	/*
    	 * add simulated annealing to combine two algorithm
    	 */
    	if(CommonParameter.useSA) {
    		Population curPopulation=Population.generateRandomPopulation();
        	SimulateAnnealing simulateAnnealing = new SimulateAnnealing(parent,curPopulation);
        	simulateAnnealing.simulateAnnealing();
        	
    	}
    	if (chromosome.statementSize() == 0) 
    		buildNewChromosome();
    }
    
    public void mutationByChangingMethodInvocation() {
    	System.out.println("Debug: mutation by changing method invocation");
    	chromosome.mutationByChangingMethodInvocation(this);
    }
    
    public void mutationByChangingInputValue() {
    	System.out.println("Debug: mutation by changing input value");
    	chromosome.mutationByChangingInputValue();
    }
    
    public void mutationByChangingConstructor() {
    	System.out.println("Debug: mutation by changing constructor");
    	chromosome.mutationByChangingConstructor(this);
    }
    
    /**
     * Crossover only happens on chromosomes having the same statement length
     * to assure the method call structures
     * This may cause problem when having many statements so it should be improved
     * @param pop
     */
    public void crossover(Chromosome parent) {
    	//only crossover on two individuals with the same statement length
    	if (parent.statementSize() != chromosome.statementSize()) {
    		return;
    	}
    	if (chromosome.statementSize() <= 1) 
    		return;
    	//rename objects in two chromosomes so that the swap does not cause any problems
    	int idObject = idCounter;
    	chromosome.renameObjects(idObject);
    	parent.renameObjects(idObject);
    	//randomly split
    	int splitIndex = 0;
    	splitIndex = ChromosomeFormer.randomGenerator.nextInt(chromosome.statementSize());
    	Chromosome[] motherParts = chromosome.randomSplitInto2Parts(splitIndex);
    	Chromosome[] fatherParts = parent.randomSplitInto2Parts(splitIndex);
    	Chromosome head, tail;
    	if (randomGenerator.nextInt(100) < 50) {
    		head = motherParts[0];
    		tail = fatherParts[1];
    	} else {
    		head = fatherParts[0];
    		tail = motherParts[1];
    	}
    	//idCounter = head.renameObjects(idCounter);
    	//idCounter = tail.renameObjects(idCounter);
    	System.out.println("Debug: crossover");
    	chromosome = head;
    	chromosome.appendChromosome(tail);
    }

    /**
     * Tính toán ApproadLevel cho các case test
     *
     * @param chrom chromosome đang được xét thực thi
     * @throws IOException
     */

//    public void caculateApproachLevel(Set coveredTarget) throws IOException {
//
//        TestCaseExecutor exec = new TestCaseExecutor();
//        String classUnderTest = getClassUnderTest();
//
//        chromosome.setCoveredTarget(coveredTarget);
//
//        System.out.println(getChromosome().toString());
//        exec.execute(classUnderTest, getChromosome().toString());
//        Set coveredPath = (Set) exec.getExecutionTrace(classUnderTest);
//        chromosome.setExpectResult(exec.expectResult);
//        chromosome.setCoveredPath(coveredPath);
//
//        System.out.println("coveredBr:" + chromosome.getCoveredPath());
//        System.out.println("targetBr:" + coveredTarget);
//
//        Pattern pattern = Pattern.compile("[0-9]+");
//        String temp = "";
//        for (int i = 0; i < coveredPath.toString().length(); i++) {
//            Matcher matcher = pattern.matcher(coveredPath.toString().charAt(i) + "");
//            if (matcher.matches()) {
//                temp += coveredPath.toString().charAt(i) + "";
//            } else {
//                if (temp.equals("") == true) {
//                    continue;
//                } else {
//                    if (temp.equals("") == false) {
//                        int t = 0;
//                        if (coveredTarget.toString().contains("[" + temp + ","))
//                            t = 1;
//                        if (coveredTarget.toString().contains(" " + temp + ","))
//                            t = 2;
//                        if (coveredTarget.toString().contains(" " + temp + "]"))
//                            t = 3;
//                        if (coveredTarget.toString().contains("[" + temp + "]"))
//                            t = 4;
//                        switch (t) {
//                            case 1:
//                            case 2:
//                            case 3:
//                            case 4:
//                                fitness++;
//                                break;
//                        }
//                    }
//                }
//                temp = "";
//            }
//        }
//        chromosome.setFitness(fitness);
//        System.out.println("fitness:" + fitness);
//    }

    /**
     * Adds a constructor cho list constructors đã biết.
     *
     * @param sign: MethodSignature The constructor được add
     */
    public void addConstructor(MethodSignature sign) {
        String className = sign.getName();
        if (constructors.get(className) == null)
            constructors.put(className, new LinkedList());
        List constr = (List) constructors.get(className);
        constr.add(sign);
    }

    /**
     * Adds a method cho list methods đã biết.
     *
     * @param className: String class đi kèm
     * @param sign:      MethodSignature The method được add
     */
    public void addMethod(String className, MethodSignature sign) {
        if (methods.get(className) == null)
            methods.put(className, new LinkedList());
        List meth = (List) methods.get(className);
        meth.add(sign);
    }

    /**
     * add kiểu cụ thể
     *
     * @param abstractType: String The abstract class.
     * @param concreteType: String The implementation.
     */
    public void addConcreteType(String abstractType, String concreteType) {
        if (concreteTypes.get(abstractType) == null)
            concreteTypes.put(abstractType, new LinkedList());
        List types = (List) concreteTypes.get(abstractType);
        types.add(concreteType);
    }

    /**
     * Kiểm tra kiểu dữ liệu nguyên thủy
     *
     * @param type kiểu cần check
     */
    public static boolean isPrimitiveType(String type) {
        if (type.indexOf("[") != -1)
            type = type.substring(0, type.indexOf("["));
        return type.equals("int") || type.equals("long") || type.equals("short") || type.equals("char")
                || type.equals("byte") || type.equals("java.lang.String") || type.equals("boolean")
                || type.equals("float") || type.equals("double");
    }

    public static boolean isWrapperType(String type) {
        if (type.indexOf("java.lang.") != -1) {
            if (type.indexOf("Boolean") != -1 || type.indexOf("Character") != -1 || type.indexOf("Byte") != -1 ||
                    type.indexOf("Short") != -1 || type.indexOf("Integer") != -1 || type.indexOf("Long") != -1 ||
                    type.indexOf("Float") != -1 || type.indexOf("Double") != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWrapperArrayType(String type) {
        if (type.indexOf("[]") != -1) {
            if (type.indexOf("java.lang.") != -1) {
                if (type.indexOf("Boolean") != -1 || type.indexOf("Character") != -1 || type.indexOf("Byte") != -1 ||
                        type.indexOf("Short") != -1 || type.indexOf("Integer") != -1 || type.indexOf("Long") != -1 ||
                        type.indexOf("Float") != -1 || type.indexOf("Double") != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * kiểm tra kiểu mảng dữ liệu nguyên thủy
     *
     * @param type kiểu dữ liệu cần check
     * @return
     */
    public static boolean isPrimitiveArrayType(String type) {
        if (type.contains(";") == true)
            type = type.substring(0, type.indexOf("][") + 1);
        return type.equals("int[]") || type.equals("long[]") || type.equals("short[]") || type.equals("char[]")
                || type.equals("byte[]") || type.equals("java.lang.String[]") || type.equals("boolean[]")
                || type.equals("float[]") || type.equals("double[]");

    }

    public static boolean isObjectArrayType(String type) {
        if (type.contains("[]")) {
            return true;
        }
        return false;
    }

    /**
     * Build giá trị
     *
     * @param type ví dụ như "int", "String", "boolean", etc..
     */
    public static String buildValue(String type) {
        if (type.startsWith("int") || type.startsWith("long") )
            return buildIntValue(type);
        else if (type.startsWith("java.lang.String") || type.startsWith("byte"))
            return buildStringValue(type);
        else if (type.startsWith("boolean"))
            return buildBoolValue(type);
        else if (type.startsWith("float") || type.startsWith("double"))
            return buildRealValue(type);
        else
            return "";
    }

    /**
     * build giá trị mảng
     *
     * @param type   ví dụ như "int", "String", "boolean", etc..
     * @param length độ dài mảng
     * @return
     */
    public static String buildArrayValue(String type, int length) {
        String values = "";
        if (type.startsWith("int[]") || type.startsWith("java.lang.Integer[]") ||
                type.startsWith("long[]") || type.startsWith("java.lang.Long[]") ||
                type.startsWith("byte[]") || type.startsWith("java.lang.Byte[]")) {
            for (int i = 0; i < length; i++) {
                if (i == length - 1) {
                    values += buildIntValue(type.replace("[]", ""));

                } else
                    values += buildIntValue(type.replace("[]", "")) + " ";
            }
        } else if (type.startsWith("java.lang.String[]")) {
            for (int i = 0; i < length; i++) {
                if (i == length - 1) {
                    values += buildStringValue(type.replace("[]", ""));
                } else
                    values += buildStringValue(type.replace("[]", "")) + " ";
            }
        } else if (type.startsWith("boolean[]") || type.startsWith("java.lang.Boolean[]")) {
            for (int i = 0; i < length; i++) {
                if (i == length - 1) {
                    values += buildBoolValue(type.replace("[]", ""));
                } else
                    values += buildBoolValue(type.replace("[]", "")) + " ";
            }
        } else if (type.startsWith("float[]") || type.startsWith("java.lang.Float[]") ||
                type.startsWith("double[]") || type.startsWith("java.lang.Double[]")) {
            for (int i = 0; i < length; i++) {
                if (i == length - 1) {
                    values += buildRealValue(type.replace("[]", ""));
                } else
                    values += buildRealValue(type.replace("[]", "")) + " ";
            }
        }
        return values;

    }

    /**
     * @param clName
     * @param methName
     * @return
     */
    public static String buildUserDefValue(String clName, String methName) {
        try {
            Class cl = Class.forName(clName);
            Constructor constr = cl.getConstructor(null);
            Object obj = constr.newInstance(null);
            Method method = cl.getMethod(methName, null);
            return (String) method.invoke(obj, null);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found. " + e);
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.err.println("Illegal access error. " + e);
            System.exit(1);
        } catch (NoSuchMethodException e) {
            System.err.println("Method not found. " + e);
            System.exit(1);
        } catch (InvocationTargetException e) {
            System.err.println("Invocation target error. " + e);
            System.exit(1);
        } catch (InstantiationException e) {
            System.err.println("Instantiation error. " + e);
            System.exit(1);
        }
        return "";
    }

    /**
     * tại giá trị boolean ngẫu nhiên với xác suất bằng nhau
     *
     * @param type "boolean"
     */
    public static String buildBoolValue(String type) {
        int n = randomGenerator.nextInt(100);
        if (n < 50)
            return "true";
        else
            return "false";
    }

    /**
     * Tạo giá trị nguyên ngẫu nhiên
     * <p>
     * trong khoảng l (default -65335) and u (default 65335)
     *
     * @param type "int", với phạm vi "[l;u]"
     */
    public static String buildIntValue(String type) {
        int lowBound = -100;
        int upBound = 100;

        if (type.indexOf("[") != -1) {
            String range = type.substring(type.indexOf("[") + 1, type.indexOf("]"));
            if (range.indexOf(";") == -1)
                return buildUserDefValue(range, "newIntValue");
            lowBound = Integer.parseInt(range.substring(0, range.indexOf(";")));
            upBound = Integer.parseInt(range.substring(range.indexOf(";") + 1));
        }
        int n = lowBound + randomGenerator.nextInt(upBound - lowBound + 1);
        return Integer.toString(n);
    }

    /**
     * Tạo giá trị số thực ngẫu nhiên
     * <p>
     * trong khoảng l (default -65335) and u (default 65335)
     *
     * @param type "float" hoặc "double", với phạm vi "[l;u]"
     */
    public static String buildRealValue(String type) {
        int lowBound = -65335;
        int upBound = 65335;
        if (type.indexOf("[") != -1) {
            String range = type.substring(type.indexOf("[") + 1, type.indexOf("]"));
            if (range.indexOf(";") == -1)
                return buildUserDefValue(range, "newRealValue");
            lowBound = Integer.parseInt(range.substring(0, range.indexOf(";")));
            upBound = Integer.parseInt(range.substring(range.indexOf(";") + 1));
        }
        double n = lowBound + randomGenerator.nextInt(1000 * (upBound - lowBound) + 1) / 1000.0;
        return Double.toString(n);
    }

    /**
     * Tạo một chuỗi mới gồm các kí tự chữ và số
     *
     * @param type "String".
     */
    public static String buildStringValue(String type) {
        String str;
        if (type.equals("byte")) {
            str = stringGenerator.newString(1, 1);
        } else {
            if (type.indexOf("[") != -1) {
                String generator = type.substring(type.indexOf("[") + 1, type.indexOf("]"));
                String[] domain = generator.split(";");
                str = stringGenerator.newString(Integer.parseInt(domain[0]), Integer.parseInt(domain[1]));
            } else {
                str = stringGenerator.newString();
            }
        }
        return "\"" + str + "\"";
    }


    /**
     * map classname đến 1 lớp cụ thể
     *
     * @param className: class cần map
     * @return concrete class name: String
     */
    public String mapToConcreteClass(String className) {
        String newClassName = className;
        if (className.indexOf("[") != -1)
            newClassName = className.substring(0, className.indexOf("["));
        if (concreteTypes.containsKey(className)) {
            List classes = (List) concreteTypes.get(className);
            int classNum = classes.size();
            int classIndex = randomGenerator.nextInt(classNum);
            newClassName = (String) classes.get(classIndex);
        }
        return newClassName;
    }

    /**
     * map class name với danh sách các lớp cụ thể sẽ thực hiện nó
     *
     * @param className: class cần map
     * @return list of concrete class names: List&lt;String&gt;
     */
    public List<String> concreteTypes(String className) {
        if (className.indexOf("[") != -1)
            className = className.substring(0, className.indexOf("["));
        List<String> classes = new LinkedList<String>();
        classes.add(className);
        if (concreteTypes.containsKey(className))
            classes = concreteTypes.get(className);
        return classes;
    }

    /**
     * Builds constructor and return the chromosome
     * Redirects to buildConstructor(String, String, int)
     */
    Chromosome buildConstructor(String className, String objId) {
        return buildConstructor(className, objId, -1);
    }

    /**
     * cleaned by anhbtm
     * Builds constructor and returns it.  
     *
     * Randomly chooses among available constructors.
     * Constructed objects are assigned to $xN, where N is an incremented
     * integer, determined through idCounter
     * <p>
     * Primitive type parameters are assigned random values. Recursively
     * needed constructors are prepended. 
     *
     * @param className   name of the constructor's class
     * @param objId         name of left hand side object
     * @param constrIndex id of the selected constructor
     * @return constructor của chromosome (e.g., "$xN=A(int)@12")
     */
    Chromosome buildConstructor(String className, String objId, int constrIndex) {
        String objVar = "$x" + idCounter;
        if (objId != null)
            objVar = objId;
        else
            idCounter++;
        if (className.indexOf("[") != -1) {
            String percent = className.substring(className.indexOf(";") + 1, className.indexOf("%"));
            int nullProb = Integer.parseInt(percent);
            className = className.substring(0, className.indexOf("["));
            if (randomGenerator.nextInt(100) <= nullProb) {
                Chromosome nullConstr = new Chromosome();
                className = mapToConcreteClass(className);
                ConstructorInvocation constrInv = new NullConstructorInvocation(objVar, className);
                nullConstr.addStatement(constrInv);
                return nullConstr;
            }
        }
        Chromosome neededConstr = new Chromosome();
        className = mapToConcreteClass(className);
        List constrList = (List) constructors.get(className);
        int constrNum = constrList.size();
        if (constrIndex == -1)
            constrIndex = randomGenerator.nextInt(constrNum);
        MethodSignature constrSign = (MethodSignature) constrList.get(constrIndex);
        List formalParams = (List) constrSign.getParameters();
        List actualParams = new LinkedList();
        Iterator i = formalParams.iterator();
        while (i.hasNext()) {
//            String paramType = (String) i.next();
//            if (isPrimitiveArrayType(paramType)) {
//                Random rd = new Random();
//                int length = 2 + rd.nextInt(5);
//                setLengthArray(length);
//                actualParams.add(buildArrayValue(paramType.substring(0, paramType.indexOf("[") + 1) + "]", length));
//            } else if (isObjectArrayType(paramType)) {
//                Random rd = new Random();
//                int length = 2 + rd.nextInt(5);
//                setLengthArray(length);
//
//                String convertedParam = paramType.substring(0, paramType.indexOf("["));
//                for (int k = 0; k < length; k++) {
//                    Chromosome newConstr = buildConstructor(convertedParam, null);
//                    neededConstr.append(newConstr);
//                    String neededConstrId = newConstr.getObjectId(concreteTypes(convertedParam));
//                    actualParams.add(neededConstrId);
//                }
//
//            } else if (isPrimitiveType(paramType)) {
//                // add input values
//                actualParams.add(buildValue(paramType));
//            } else {
//                Chromosome newConstr = buildConstructor(paramType, null);
//                neededConstr.append(newConstr);
//                String neededConstrId = neededConstr.getObjectId(concreteTypes(paramType));
//                actualParams.add(neededConstrId);
//            }
            String paramType = (String) i.next();
            // old version code just only check PrimaryArrayType, PrimaryType, and Object
            if (isPrimitiveArrayType(paramType)) {
                // length of the array is the random value and >2 and <5
                Random rd = new Random();
                int length = 2 + rd.nextInt(5);
                setLengthArray(length);
                String values = buildArrayValue(paramType, length);
                actualParams.add(values);

            } else if (isObjectArrayType(paramType)) {
                Random rd = new Random();
                int length = 5 + rd.nextInt(1);
                setLengthArray(length);

                // get className to create an array
                String convertedParam = paramType.substring(0, paramType.indexOf("["));
                List<String> tempActualParams = new ArrayList();
                for (int k = 0; k < length; k++) {
                    Chromosome newConstr = buildConstructor(convertedParam, null);
                    neededConstr.appendChromosome(newConstr);
                    String neededConstrId = newConstr.getObjectId(concreteTypes(convertedParam));
                    tempActualParams.add(neededConstrId);
                }
                // format param array
                String actualParamsString= tempActualParams.toString();
                String actualParamsArray="{"+actualParamsString.substring(1,actualParamsString.length()-1)+"}";
                actualParams.add(paramType + actualParamsArray.replace(", "," "));
            } else if (isPrimitiveType(paramType)) {
                actualParams.add(buildValue(paramType));
            } else {
                Chromosome newConstr = buildConstructor(paramType, null);
                neededConstr.appendChromosome(newConstr);
                String neededConstrId = newConstr.getObjectId(concreteTypes(paramType));
                actualParams.add(neededConstrId);
            }
        }
        // formalParams = type of parameters; actualParams= input value in use
        ConstructorInvocation constrInv = new ConstructorInvocation(objVar, constrSign.getName(), formalParams,
                actualParams);
        neededConstr.addStatement(constrInv);
        return neededConstr;
    }

    /**
     * Adds constructor vào đầu chromosome.
     *
     * @param constrIndex vụ trí trong list constructor
     */
    public void prependConstructor(int constrIndex) {
        Chromosome chrom = buildConstructor(classUnderTest, null, constrIndex);
        chrom.appendChromosome(chromosome);
        chromosome = chrom;
    }

    /**
     * Adds constructor at the beginning of the building chromosome.
     *
     * @param className Name of the constructor to prepend
     */
    public void prependConstructor(String className) {
        chromosome = prependConstructor(className, null);
    }

    /**
     * Adds constructor at the beginning of the building chromosome.
     *
     * @param className Name of the constructor to prepend
     * @param objId     Name of target object
     */
    public Chromosome prependConstructor(String className, String objId) {
        // also add input values after @
        Chromosome chrom = buildConstructor(className, objId);
        chrom.appendChromosome(chromosome);
        return chrom;
    }

    /**
     * Trả về đối tượng MethodSignature khớp với các tham số.
     *
     * @param className  Enclosing class
     * @param methodName Method
     * @param params     List kiểu tham số của method
     * @return method signature object (class: MethodSignature)
     */
    private MethodSignature lookForMethod(String className, String methodName, String[] params) {
        List signatureList = (List) methods.get(className);
        Iterator i = signatureList.iterator();
        while (i.hasNext()) {
            MethodSignature sign = (MethodSignature) i.next();
            String curMethodName = sign.getName();
            List curParams = (List) sign.getParameters();
            if (!curMethodName.equals(methodName) || curParams.size() != params.length)
                continue;
            Iterator j = curParams.iterator();
            boolean found = true;
            int k = 0;
            while (j.hasNext()) {
                String curParam = (String) j.next();
                if (curParam.indexOf("[") != -1)
                    curParam = curParam.substring(0, curParam.indexOf("["));
                if (params[k].indexOf("[") != -1)
                    params[k] = params[k].substring(0, params[k].indexOf("["));
                if (!curParam.equals(params[k++])) {
                    found = false;
                    break;
                }
            }
            if (found)
                return sign;
        }
        return null;
    }

    /**
     * Trả về thứ tự của đối tượng MethodSignature khớp với các tham số.
     *
     * @param constr constructor name đầy đủ
     * @return vị trí của chữ kí method (class: MethodSignature)
     */
    private int lookForConstructor(String constr) {
        String constr1 = constr.substring(0, constr.indexOf("("));
        String className = constr1.substring(0, constr1.lastIndexOf("."));
        String constrName = constr1.substring(constr1.lastIndexOf(".") + 1);
        String[] params = constr.substring(constr.indexOf("(") + 1, constr.indexOf(")")).split(",");
        if (params.length == 1 && params[0].equals(""))
            params = new String[0];
        List signatureList = (List) constructors.get(className);
        int constrIndex = -1;
        Iterator i = signatureList.iterator();
        while (i.hasNext()) {
            MethodSignature sign;
            sign = (MethodSignature) i.next();
            constrIndex++;
            String curConstrName = sign.getName();
            List curParams = (List) sign.getParameters();
            if (!curConstrName.equals(constrName) || curParams.size() != params.length)
                continue;
            Iterator j = curParams.iterator();
            boolean found = true;
            int k = 0;
            while (j.hasNext()) {
                String curParam = (String) j.next();
                if (!curParam.equals(params[k++])) {
                    found = false;
                    break;
                }
            }
            if (found)
                return constrIndex;
        }
        return -1;
    }

    /**
     * Xây dựng cuộc gọi phương thức và trả về nó.
     * <p>
     * Phương thức để gọi được xác định bằng chữ ký hoàn chỉnh.
     * <p>
     * Tham số loại nguyên thủy được gán giá trị ngẫu nhiên. Tham số loại đối tượng
     * được xây dựng.
     *
     * @param fullMethodName Ví dụ: A.m(int, B)
     * @param objId          Ví dụ: $x0
     * @return Phương thức gọi. Ví dụ: "$x0.m(int,B)@10".
     */
    public Chromosome buildMethodCall(String fullMethodName, String objId) {
        Chromosome neededConstr = new Chromosome();
        String fullMethodName1 = fullMethodName.substring(0, fullMethodName.indexOf("("));
        String className = fullMethodName1.substring(0, fullMethodName1.lastIndexOf("."));
        String methodName = fullMethodName1.substring(fullMethodName1.lastIndexOf(".") + 1);
        String[] paramString = fullMethodName.substring(fullMethodName.indexOf("(") + 1, fullMethodName.indexOf(")"))
                .split(",");
        if (paramString.length == 1 && paramString[0].equals(""))
            paramString = new String[0];
        MethodSignature methodSign = lookForMethod(className, methodName, paramString);
        List<String> formalParams = methodSign.getParameters();
        List<String> actualParams = new LinkedList<String>();
        if (objId == null)
            objId = chromosome.getObjectId(concreteTypes(className));
        Iterator<String> i = formalParams.iterator();
        while (i.hasNext()) {
            String paramType = (String) i.next();
            // old version code just only check PrimaryArrayType, PrimaryType, and Object
            if (isPrimitiveArrayType(paramType)) {
                // length of the array is the random value and >2 and <5
                Random rd = new Random();
                int length = 2 + rd.nextInt(5);
                setLengthArray(length);
                String values = buildArrayValue(paramType, length);
                actualParams.add(values);

            } else if (isObjectArrayType(paramType)) {
                Random rd = new Random();
                int length = 2 + rd.nextInt(5);
                setLengthArray(length);

                // get className to create an array
                String convertedParam = paramType.substring(0, paramType.indexOf("["));
                List<String> tempActualParams = new ArrayList<String>();
                for (int k = 0; k < length; k++) {
                    Chromosome newConstr = buildConstructor(convertedParam, null);
                    neededConstr.appendChromosome(newConstr);
                    String neededConstrId = newConstr.getObjectId(concreteTypes(convertedParam));
                    tempActualParams.add(neededConstrId);
                }
                // format param array
                String actualParamsString= tempActualParams.toString();
                String actualParamsArray="{"+actualParamsString.substring(1,actualParamsString.length()-1)+"}";
                actualParams.add(paramType + actualParamsArray.replace(", "," "));


            } else if (isPrimitiveType(paramType)) {
                actualParams.add(buildValue(paramType));
            } else {
                Chromosome newConstr = buildConstructor(paramType, null);
                neededConstr.appendChromosome(newConstr);
                String neededConstrId = newConstr.getObjectId(concreteTypes(paramType));
                actualParams.add(neededConstrId);
            }
        }
        MethodInvocation methodInv = new MethodInvocation(objId, methodSign.getName(), formalParams, actualParams);
        neededConstr.addStatement(methodInv);
//        System.out.println("Former: 823");
//        System.out.println(neededConstr);
        return neededConstr;
    }

    /**
     * Adds method call vào phía cuối chromosome
     *
     * @param fullMethodName ví dụ: A.m(int,int)
     */
    public void appendMethodCall(String fullMethodName, String objId) {
        Chromosome chrom = buildMethodCall(fullMethodName, objId);
//        System.out.println(chrom);
        chromosome.appendChromosome(chrom);
    }
    
    public boolean hasMethod(String className, String methodName) {
    	List<MethodSignature> methodList = this.methods.get(className);
    	if (methodList == null)
    		return false;
    	for (MethodSignature methodSignature : methodList) {
			if (methodUnderTest.contains(methodSignature.getName())) {
				return true;
			}
		}
    	return false;
    }

    /**
     * Add them loi goi method
     *
     * @param className
     * @param objId
     * @param idMethodUnderTest
     */
    public void appendInitMethodCall(String className, String methodName, String objId) {
//        if (!hasMethod(className, methodName))
//        	return;
//        //int methodNum = methodList.size();
//        //int methodIndex = idMethodUnderTest;
//        MethodSignature methodSign = toMethodSignature(methodUnderTest);
//        String fullMethodName = className + "." + methodSign.getName();
//        fullMethodName += "(";
//        List params = (List) methodSign.getParameters();
//        Iterator i = params.iterator();
//        boolean first = true;
//        while (i.hasNext()) {
//            String paramType = (String) i.next();
//            if (first)
//                first = false;
//            else
//                fullMethodName += ",";
//            fullMethodName += paramType;
//        }
//        fullMethodName += ")";
//        appendMethodCall(fullMethodName, objId);
    	appendMethodCall(methodName, objId);
    }

    /**
     * Reads constructor and method signatures from file.
     *
     * Signatures are read from an input text file formatted
     * in the following way:
     * <pre>
     * A.A()
     * A.A(int)
     * B.B()
     * B.B(int[0;10])
     * A.m1()
     * A.m2(int)
     * A.m3(int, int)
     * A.m(int, Comparable[null;5%])
     * #
     * MyInteger as Comparable
     * String as Comparable
     * </pre>
     * Constructors for all classes used as parameter types MUST
     * be included. 
     *
     * @param fileName   File with signatures.
     */
    public void readSignaturesFromClassUnderTest(String fileName) {
        Map constructorTemp = constructors;
        try {
            Set<String> usedClassNames = new HashSet<String>();
            String s, r = "";
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            while ((s = in.readLine()) != null && !s.equals("#")) {
                s = s.replaceAll("\\s+", "");
                if (s.length() > 0) {
                    String s1 = s.substring(0, s.indexOf("("));
                    String className = s1.substring(0, s1.lastIndexOf("."));
                    String methodName = s1.substring(s1.lastIndexOf(".") + 1);
                    String[] paramNames = s.substring(s.indexOf("(") + 1, s.indexOf(")")).split(",");
                    if (paramNames.length == 1 && paramNames[0].equals(""))
                        paramNames = new String[0];
                    List<String> params = new LinkedList<String>();
                    for (int i = 0; i < paramNames.length; i++) {
                        params.add(paramNames[i]);
                        String usedClass = paramNames[i];
                        if (paramNames[i].indexOf("[") != -1)
                            usedClass = paramNames[i].substring(0, paramNames[i].indexOf("["));
                        if (!isPrimitiveType(paramNames[i]))
                            usedClassNames.add(usedClass);
                    }
                    String simpleClassName = className.substring(className.lastIndexOf(".") + 1);
                    if (simpleClassName.equals(methodName)) {
                        MethodSignature methodSign = new MethodSignature(className, className, params);
                        addConstructor(methodSign);
                    } else {
                        MethodSignature methodSign = new MethodSignature(methodName, className, params);
                        addMethod(className, methodSign);
                        usedClassNames.add(className);
                    }
                    r = s;
                }
            }
            String r1 = r.substring(0, r.indexOf("("));
            this.classUnderTest = r1.substring(0, r1.lastIndexOf("."));
            while ((s = in.readLine()) != null) {
                if (s.length() > 0) {
                    String className = s.substring(0, s.indexOf(" as ")).trim();
                    String typeName = s.substring(s.indexOf(" as ") + 4).trim();
                    addConcreteType(typeName, className);
                }
            }
            in.close();
            if (constructorTemp.size() > 0) {
                // add previous constructors
                constructors.putAll(constructorTemp);
            }
            //check if constructors of used classes are availble
            checkConstructorsAvailable(usedClassNames);
        } catch (IOException e) {
            System.err.println("IO error: " + fileName);
            System.exit(1);
        }

    }

    /**
     * add default constructor for wrapper types
     *
     * @author huannt
     */
    public void addDefaultConstructor() {
        Map<String, String> typeList = new HashMap<>();
        typeList.put("java.lang.Boolean", "boolean");
        typeList.put("java.lang.Character", "char");
        typeList.put("java.lang.Byte", "byte");
        typeList.put("java.lang.Short", "short");
        typeList.put("java.lang.Integer", "int");
        typeList.put("java.lang.Long", "long");
        typeList.put("java.lang.Float", "float");
        typeList.put("java.lang.Double", "double");
        for (String typeName : typeList.keySet()
        ) {
            LinkedList<String> parameters = new LinkedList<>();
            parameters.add(typeList.get(typeName));
            MethodSignature methodSignature = new MethodSignature();
            methodSignature.setName(typeName);
            methodSignature.setParameters(parameters);
            LinkedList<MethodSignature> linkedList = new LinkedList<>();
            linkedList.add(methodSignature);
            constructors.put(typeName, linkedList);
        }
    }

    /**
     * Kiểm tra nếu tất cả các hàm constructor có sẵn.
     * <p>
     * Việc thực thi bị gián đoạn nếu không có hàm constructor cho một số lớp được
     * sử dụng.
     *
     * @param usedClass Tập hợp tất cả các lớp được sử dụng trong chữ ký.
     */
    private void checkConstructorsAvailable(Set usedClasses) {
        boolean error = false;
        String className = "";
        Iterator k = concreteTypes.keySet().iterator();
        while (!error && k.hasNext()) {
            String absType = (String) k.next();
            List types = (List) concreteTypes.get(absType);
            Iterator j = types.iterator();
            while (!error && j.hasNext()) {
                className = (String) j.next();
                if (!constructors.containsKey(className)) {
                	String signFile = CommonParameter.relativePath + className + ".sign";
                	error = readConstructorSignatures(signFile);
                }
            }
        }
        Iterator i = usedClasses.iterator();
        while (!error && i.hasNext()) {
            className = (String) i.next();
            if (!constructors.containsKey(className) && !concreteTypes.containsKey(className)) {
                String signFile = CommonParameter.relativePath + className + ".sign";
            	error = readConstructorSignatures(signFile);
            }
        }
        if (error) {
            System.err.println("Missing constructor for class: " + className);
            // comment this line to void exit program in case missing constructors
//            System.exit(1);
        }
    }
    
    public boolean readConstructorSignatures(String dependencyClass) {
    	boolean hasError = false;
        try {
            Set<String> usedClassNames = new HashSet<String>();
            String s, r = "";
            BufferedReader in = new BufferedReader(new FileReader(dependencyClass));
            while ((s = in.readLine()) != null && !s.equals("#")) {
                s = s.replaceAll("\\s+", "");
                if (s.length() > 0) {
                    String s1 = s.substring(0, s.indexOf("("));
                    String className = s1.substring(0, s1.lastIndexOf("."));
                    String methodName = s1.substring(s1.lastIndexOf(".") + 1);
                    //only load constructors
//                    if (!className.equals(methodName))
//                    	break;
                    String[] paramNames = s.substring(s.indexOf("(") + 1, s.indexOf(")")).split(",");
                    if (paramNames.length == 1 && paramNames[0].equals(""))
                        paramNames = new String[0];
                    List<String> params = new LinkedList<String>();
                    for (int i = 0; i < paramNames.length; i++) {
                        params.add(paramNames[i]);
                        String usedClass = paramNames[i];
                        if (paramNames[i].indexOf("[") != -1)
                            usedClass = paramNames[i].substring(0, paramNames[i].indexOf("["));
                        if (!isPrimitiveType(paramNames[i]))
                            usedClassNames.add(usedClass);
                    }
                    String simpleClassName = className.substring(className.lastIndexOf(".") + 1);
                    if (simpleClassName.equals(methodName)) {
                        MethodSignature methodSign = new MethodSignature(className, className, params);
                        addConstructor(methodSign);
                    } else {
                    	MethodSignature methodSign = new MethodSignature(methodName, className, params);
                    	addMethod(className, methodSign);
                    	usedClassNames.add(className);
                    }
                    r = s;
                }
            }
            String r1 = r.substring(0, r.indexOf("("));
            //classUnderTest = r1.substring(0, r1.lastIndexOf("."));
            while ((s = in.readLine()) != null) {
                if (s.length() > 0) {
                    String className = s.substring(0, s.indexOf(" as ")).trim();
                    String typeName = s.substring(s.indexOf(" as ") + 4).trim();
                    addConcreteType(typeName, className);
                }
            }
            in.close();
            //check if constructors of used classes are availble
            checkConstructorsAvailable(usedClassNames);
        } catch (IOException e) {
        	hasError = true;
            System.err.println("IO error: " + dependencyClass);
            System.exit(1);
        }
    	return hasError;
    }
    
    public String toString() {
    	String infoString = "";
    	infoString += "Class under test: " + classUnderTest + "\n";
//    	infoString += "Method under test: " + methodUnderTest + "\n";
    	infoString += "List of methods: " + methods.values().toString();
    	return infoString;
    }
    
}


