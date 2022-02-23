package problem1.management;

import problem1.entities.SkillList;

public class SkillManagment {

	public static void main(String[] args) {
	SkillList skillList=new SkillList();
	System.out.println("ArrayList original display:");
	skillList.display();
	System.out.println("Specific element from the ArrayList");
	System.out.println(skillList.getHead(1));
	System.out.println("Status remove element of ArrayList:");
	System.out.println(skillList.remove("NodeJS"));
	System.out.println("ArrayList after remove"); 
	skillList.display();
	System.out.println("ArrayList after update: ");
	skillList.update(1, "thao");
	skillList.display();
	}

}
