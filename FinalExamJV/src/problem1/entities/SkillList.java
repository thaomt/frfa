package problem1.entities;

import java.util.ArrayList;

public class SkillList {
	ArrayList<String> skillList = new ArrayList<>();

	public SkillList() {
		skillList.add("Java");
		skillList.add(".Net");
		skillList.add("Android");
		skillList.add("NodeJS");
		skillList.add("AI");
	}

	public void display() {
		System.out.println(skillList);

	}

	public String getHead(int position) {
		if ((skillList.size()==-1 || position < 0) || (skillList == null)) {
			return null;
		} else {
			return skillList.get(position);
		}
	}

	public boolean remove(String skill) {
		if (skillList.contains(String.valueOf(skill))) {
			skillList.remove(skill);
			return true;
		} else {
			return false;
		}

	}
	public void update(int index, String skillNew) {
		skillList.set(index, skillNew);
	}
}
