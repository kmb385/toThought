package org.tothought.web.spring.controllers.resume;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.tothought.data.entities.Experience;
import org.tothought.data.entities.Skill;
import org.tothought.data.repositories.CommitRepository;
import org.tothought.data.repositories.DegreeRepository;
import org.tothought.data.repositories.ExperienceRepository;
import org.tothought.data.repositories.SkillCategoryRepository;
import org.tothought.data.repositories.SkillRepository;
import org.tothought.web.json.JsonUtil;
import org.tothought.web.pdf.PDF;
import org.tothought.web.spring.annotations.PageableRequestMapping;

@Controller
@RequestMapping("/resume")
public class ResumeController {

	Logger logger = LoggerFactory.getLogger(ResumeController.class);
	
	@Autowired
	private WebApplicationContext context;

	@Autowired
	SkillCategoryRepository skillCategoryRepository;

	@Autowired
	SkillRepository skillRepository;

	@Autowired
	ExperienceRepository experienceRepository;

	@Autowired
	DegreeRepository degreeRepository;
	
	@Autowired
	CommitRepository commitRepository;
	
	private Sort sort = new Sort(Direction.DESC, "commitDt");	
	private int pageSize = 5;

	@RequestMapping("/profile")
	public String profile() {
		return "resume/profile";
	}

//	@RequestMapping("/skills")
//	public String getAllSkills(Model model) {
//		model.addAttribute("categories", skillCategoryRepository.findAll());
//		return "resume/skills";
//	}
//
//	@RequestMapping("/skills/{skillId}")
//	public String getSkill(Model model, @PathVariable Integer skillId) {
//		Skill skill = skillRepository.findOne(skillId);
//		model.addAttribute("skill", skill);
//		model.addAttribute("commits", commitRepository.findByTag(skill.getTag().getName()));
//		return "resume/skill";
//	}
//
//	@RequestMapping("/skills/{skillId}/commitpage/{commitpage}")
//	@PageableRequestMapping(pathVariable="commitpage")
//	public String getSkill(Model model, @PathVariable Integer skillId, @PathVariable Integer commitpage) {
//
//		Skill skill = skillRepository.findOne(skillId);
//		PageRequest pageRequest = new PageRequest(commitpage, this.pageSize, this.sort);
//
//		model.addAttribute("skill", skill);
//		model.addAttribute("commits", commitRepository.pageByTag(skill.getTag().getName(), pageRequest).getContent());
//		
//		return "resume/skill";
//	}

	@RequestMapping("/experience")
	public String getExperience(Model model) {
		model.addAttribute("experiences", experienceRepository.findAll());
		return "resume/experience";
	}

	@RequestMapping("/experience/{experienceId}/tags")
	@ResponseBody
	public String getTags(@PathVariable Integer experienceId) {
		Experience experience = experienceRepository.findOne(experienceId);
		return JsonUtil.getJson(experience.getTags());
	}

	@RequestMapping("/degree")
	public String getDegrees(Model model) {
		model.addAttribute("degrees", degreeRepository.findAll());
		return "resume/degrees";
	}
	
	@RequestMapping("/full")
	public String getFullResume(Model model){
		model.addAttribute("categories", skillCategoryRepository.findAll());
		model.addAttribute("degrees", degreeRepository.findAll());
		model.addAttribute("experiences", experienceRepository.findAll());
		return "resume/full_resume";
	}

	@RequestMapping(value = "/full/generatePDF")
	public void generatePdf(HttpServletRequest req, HttpServletResponse res) {
		String applicationUrl =  req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort(); 
		String requestUrl = req.getHeader("referer");
		requestUrl = req.getRequestURL().substring(0, req.getRequestURL().lastIndexOf("/"));

		res.setContentType("text/html;charset=UTF-8");
		res.setContentType("application/pdf");
		res.setHeader("Content-Disposition", "attachment;filename=report.pdf");

		try {
			String resourceDirectory = context.getServletContext().getRealPath("/") + "/resources/";
			new PDF(requestUrl, res.getOutputStream(), resourceDirectory, applicationUrl).generate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
