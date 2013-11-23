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
import org.tothought.data.entities.SkillCategory;
import org.tothought.data.repositories.utils.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/test-context.xml"})
@Transactional
public class SkillCategoryRepositoryTest {

	@Autowired
	SkillCategoryRepository repository;
	
	@Test
	public void findOneTest() {
		SkillCategory skillCategory = repository.findOne(1);
		assertNotNull(skillCategory);
		assertEquals("Programming Skills", skillCategory.getName());
		assertNotNull(skillCategory.getSkills());
	}
	
	@Test
	public void testInsert(){
		SkillCategory skillCategory = TestUtil.createSkillCategory();
		
		repository.save(skillCategory);
		
		SkillCategory dbSkillCategory = repository.findOne(skillCategory.getSkillCategoryId());
		assertNotNull(dbSkillCategory);
		assertEquals("Software", dbSkillCategory.getName());
	}
	
	@Test
	public void testUpdate(){
		SkillCategory skillCategory = repository.findOne(2);
		skillCategory.setName("Expertise");
		repository.save(skillCategory);
		
		SkillCategory dbSkillCategory = repository.findOne(2);
		assertNotNull(dbSkillCategory);
		assertEquals("Expertise", dbSkillCategory.getName());
	}
	
	@Test
	public void testDelete(){
		SkillCategory skillCategory = repository.findOne(2);
		repository.delete(skillCategory);
		
		SkillCategory dbSkillCategory = repository.findOne(2);
		assertNull(dbSkillCategory);
	}

}
