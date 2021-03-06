package org.tothought.data.repositories.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.tothought.data.entities.Comment;
import org.tothought.data.entities.Commit;
import org.tothought.data.entities.DataLoadLogEntry;
import org.tothought.data.entities.Degree;
import org.tothought.data.entities.DegreeDetail;
import org.tothought.data.entities.Experience;
import org.tothought.data.entities.ExperienceDetail;
import org.tothought.data.entities.Image;
import org.tothought.data.entities.Skill;
import org.tothought.data.entities.SkillCategory;
import org.tothought.data.entities.Tag;

public class TestUtil {

	public static Image createImage(){
		File file = new File("./src/test/resources/images/java.png");
		Image image = new Image();
		
		try {
			image.setFile(FileUtils.readFileToByteArray(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		image.setName(file.getName());
		image.setType(file.getName().substring(file.getName().lastIndexOf(".")));
		return image;
	}
	
	public static SkillCategory createSkillCategory(){
		SkillCategory skillCategory = new SkillCategory();
		skillCategory.setName("Software");
		return skillCategory;
	}
	
	public static Skill createSkill(){
		Skill skill = new Skill();
		skill.setName("Spring");
		skill.setDescription("A Java framework based on dependency injection");
		skill.setProvider("VMWare");
		skill.setRating(4);
		skill.setUrl("http://www.springsource.org");
		return skill;
	}
	
	public static Experience createExperience(){
		Experience experience = new Experience();
		experience.setOrganization("SEDA-COG");
		experience.setDescription("I worked as an intern");
		experience.setStartDate(new Date());
		experience.setEndDate(new Date());
		experience.setPosition("Intern");
		experience.setIsPresent(true);
		return experience;
	}
	
	public static Tag createTag(){
		Tag tag = new Tag();
		tag.setName("J2EE");
		return tag;
	}
	
	public static ExperienceDetail createExperienceDetail(){
		ExperienceDetail experienceDetail = new ExperienceDetail();
		experienceDetail.setDescription("I saved a bunch of money on my car insurance");
		return experienceDetail;
	}
	
	public static Degree createDegree(){
		Degree degree = new Degree();
		degree.setDegreeType("Diploma");
		degree.setEmphasis("Technology");
		degree.setEndDate(new Date());
		degree.setGpa("3.25");
		degree.setInstitution("Mifflinburg Area High School");
		degree.setIsPresent(false);
		degree.setProgram("College Preparation");
		degree.setStartDate(new Date());
		return degree;
	}

	public static DegreeDetail createDegreeDetail() {
		DegreeDetail detail = new DegreeDetail();
		detail.setDescription("this is a test");
		return detail;
	}
	
	public static Comment createComment(){
		Comment comment = new Comment();
		comment.setAuthor("Jack Doe");
		comment.setBody("This post wasn't so great");
		comment.setEmail("jack.doe@gmail.com");
		comment.setPostedDt(new Date());
		comment.setRating(2);
		comment.setSite("www.google.com");
		return comment;
	}
	
	public static Commit createCommit(){
		Commit commit = new Commit();
		commit.setApiUrl("https://api.github.com/repos/kmb385/SimplePersist/commits/c289a4f2d3b199df8488da93634f3b77e3b41324");
		commit.setHtmlUrl("https://github.com/kmb385/SimplePersist/commits/c289a4f2d3b199df8488da93634f3b77e3b41324");
		commit.setSha("c5cd6d3ae2e93c8af3fcc41cd5816d7e0d549c03");
		commit.setTitle("Saving Entities");
		return commit;
	}
	
	public static DataLoadLogEntry createDataLoadLogEntry(){
		DataLoadLogEntry dlle = new DataLoadLogEntry();
		dlle.setDataCurrentDt(new Date());
		dlle.setRunDt(new Date());
		dlle.setLoadName("GITHUB");
		dlle.setRecordsAdded(33);
		return dlle;
	}
}
