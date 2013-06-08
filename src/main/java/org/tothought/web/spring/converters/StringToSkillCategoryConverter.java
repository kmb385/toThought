package org.tothought.web.spring.converters;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.tothought.data.entities.SkillCategory;
import org.tothought.data.repositories.SkillCategoryRepository;

public class StringToSkillCategoryConverter implements Converter<String, SkillCategory> {

	@Autowired
	SkillCategoryRepository repository;
	
	@Override
	public SkillCategory convert(String source) {
		SkillCategory skillCategory;
		if(StringUtils.isNumber(source)){
			skillCategory = repository.findOne(new Integer(source));
		}else{
			skillCategory = new SkillCategory();
			skillCategory.setName(source);
		}
		return skillCategory;
	}

}
