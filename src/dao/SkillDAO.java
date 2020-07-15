package dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Skill;
import utility.ConnectionManager;

public class SkillDAO {
	
	List<Skill> list = new ArrayList<Skill>();
	public List< Skill > listAllSkills () throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		Statement stmt=  con.getConnection().createStatement();
		ResultSet rs =stmt.executeQuery("SELECT name FROM skill ORDER BY name ASC");
		
		while(rs.next())
		{
			long skillId = rs.getLong(1);
			String skillName = rs.getString(2);
			
			Skill skill = new Skill(skillId, skillName);
			list.add(skill);
		}
		return list;
	}	
}
