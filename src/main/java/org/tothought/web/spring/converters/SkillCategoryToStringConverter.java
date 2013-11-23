package org.tothought.web.spring.converters;

import org.springframework.core.convert.converter.Converter;
import org.tothought.data.entities.SkillCategory;

public class SkillCategoryToStringConverter implements Converter<SkillCategory, String> {

	@Override
	public String convert(SkillCategory source) {
		return source.getSkillCategoryId().toString();
	}

}
