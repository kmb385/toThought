package org.tothought.data.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.data.entities.Image;
import org.tothought.data.entities.Skill;
import org.tothought.data.entities.SkillCategory;
import org.tothought.data.repositories.utils.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/test-context.xml"})
@Transactional
public class SkillRepositoryTest {
	
	@Autowired
	SkillRepository repository;
	
	@Test
	public void findOneTest(){
		Skill skill = repository.findOne(1);
		assertNotNull(skill);
		assertEquals("Java", skill.getName());
	}
	
	@Test
	public void insertBasicTest() {
		Skill skill = TestUtil.createSkill();
		
		repository.save(skill);
		
		Skill dbSkill = repository.findOne(skill.getSkillId());
		assertNotNull(dbSkill);
		assertEquals("Spring", dbSkill.getName());
	}
	
	@Test
	public void insertAdvancedTest(){
		Image image = TestUtil.createImage();
		SkillCategory category = TestUtil.createSkillCategory();
		
		Skill skill = TestUtil.createSkill();
		
		skill.setSkillCategory(category);
		skill.setImage(image);
		
		repository.save(skill);
		
		Skill dbSkill = repository.findOne(skill.getSkillId());
		assertNotNull(dbSkill);
		assertNotNull(dbSkill.getImage());
		assertNotNull(dbSkill.getSkillCategory());
		assertEquals("Spring", skill.getName());
	}
	
	@Test
	public void updateSkill(){
		Skill skill = repository.findOne(1);
		skill.setName("C++");
		skill.setRating(2);
		
		repository.save(skill);
		
		Skill dbSkill = repository.findOne(skill.getSkillId());
		assertNotNull(dbSkill);
		assertEquals("C++", skill.getName());
		assertEquals(new Integer(2), skill.getRating());
	}
	
	@Test
	public void deleteSkill(){
		Skill skill = repository.findOne(1);
		repository.delete(skill);
		
		Skill dbSkill = repository.findOne(1);
		assertNull(dbSkill);
	}
	
	
}
