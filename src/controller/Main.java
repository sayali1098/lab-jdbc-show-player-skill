package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.SkillDAO;
import model.Skill;

public class Main{
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		SkillDAO skilldao = new SkillDAO();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter skill id to get skill details");
		long id= Long.parseLong(br.readLine());
		Skill skill = null;
		skill.setSkillId(id);
		
		ArrayList<Skill> list  = (ArrayList<Skill>) skilldao.listAllSkills();
		System.out.println("List of all Skills");
		
		for(Skill s: list) {
			System.out.println(s.getSkillId() + "\t" + s.getSkillName());
		}
		
		
	}
}
