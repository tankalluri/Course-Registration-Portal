package com.webtools.courseRegistration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.webtools.dao.AdminDAO;
import com.webtools.dao.CourseDAO;
import com.webtools.dao.ProfessorDAO;
import com.webtools.dao.SemesterDAO;
import com.webtools.dao.StudentDAO;
import com.webtools.email.SendEmail;
import com.webtools.exception.StudentException;
import com.webtools.pdf.PdfViewForBilling;
import com.webtools.pojo.Courses;
import com.webtools.pojo.Professor;
import com.webtools.pojo.Student;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Welcome to Northeastern Course Registration System! ");
		return "student-registration";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {//once submit is hit on sign up page
		return "student-login";
	}
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String adminLogin(HttpServletRequest request) {//once submit is hit on sign up page
		return "admin-login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String studentRegistrationSuccessGet(Student s, HttpServletRequest request, ModelMap md) throws StudentException {//once submit is hit on sign up page
		s = new Student();
		md.addAttribute("student",s);
		return "student-registration-page";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView studentRegistrationSuccessPost(@ModelAttribute("student") @Valid Student s, BindingResult result, StudentDAO sd, HttpServletRequest request) throws StudentException {//once submit is hit on sign up page
		if(s == null)
			return new ModelAndView("student-registration-page");//go to login page
		else {
			if(result.hasErrors()) {
				return new ModelAndView("student-registration-page");
			}
			else {
			boolean check = sd.checkIfAlreadyExists();
			boolean emailCheck = sd.checkIfEmailExists(request.getParameter("email"));
			if(emailCheck==false) {
			if(check==false) {
				sd.register(s);
				return new ModelAndView("student-login");
			}
			else {
						Set<Courses> courses = new HashSet<Courses>();
						courses.add(new Courses("Career Management", 3, "Monday - 12pm-2.15pm")); 
						courses.add(new Courses("Database Management and Database Design", 6, "Wednesday - 2pm-4.15pm")); 
						courses.add(new Courses("Network Structures and Cloud Computing", 8, "Thursday - 6pm-9.15pm")); 
						courses.add(new Courses("Web Tools", 1, "Monday - 11.45pm-1.25pm")); 
						courses.add(new Courses("Multithreading and Parallel Programming", 9, "Saturday - 1.15pm-4.25pm")); 
						courses.add(new Courses("Application Engineering Design", 7, "Sunday - 11.45pm-1.25pm")); 
						courses.add(new Courses("Big Data", 2, "Wednesday - 6.pm-9.25pm")); 
						s.setCourses(courses);
						sd.register(s);
						return new ModelAndView("student-login");
		  }
			}//if ends here
			else {
				return new ModelAndView("student-registration-page", "message", "Email already exists");
			}
		}
	}
}
	
	@RequestMapping(value = "/courseSelection", method = RequestMethod.POST)
	public ModelAndView loginStudent(HttpServletRequest req, StudentDAO sd) throws StudentException {	//to open login page with username and password as fields	
		HttpSession session = (HttpSession) req.getSession();
		Student s = sd.fetchStudent(req.getParameter("username"), req.getParameter("password"));
		if (s == null) {
			return new ModelAndView("student-registration");
		}
		session.setAttribute("student", s);
		return new ModelAndView("course-selection", "student", s);//go to drop downs
	}
	
	@RequestMapping(value = "/adminHomePage", method = RequestMethod.POST)
	public ModelAndView loginAdmin(HttpServletRequest req) throws StudentException {
		if(req.getParameter("adminusername").equalsIgnoreCase("admin")&&(req.getParameter("adminpassword").equalsIgnoreCase("admin"))){
			return new ModelAndView("admin-landing-page");
		}else {
			return new ModelAndView("admin-login");
		}
	}
	
	@RequestMapping(value = "/adminAddCourse", method = RequestMethod.GET)
	public ModelAndView adminAddCourse(HttpServletRequest req) throws StudentException {
		return new ModelAndView("admin-add-course");
	}
	
	@RequestMapping(value = "/adminRemoveCourse", method = RequestMethod.GET)
	public ModelAndView adminRemoveCourse(HttpServletRequest req) throws StudentException {
		return new ModelAndView("admin-remove-course");
	}
	
	@RequestMapping(value = "/adminUpdateCourse", method = RequestMethod.GET)
	public ModelAndView adminUpdateCourse(HttpServletRequest req) throws StudentException {
		return new ModelAndView("admin-update-course");
	}
	
	@RequestMapping(value = "/adminEnterCourseDetails", method = RequestMethod.GET)
	public ModelAndView adminAddCourseDetails(HttpServletRequest req, AdminDAO ad, Courses c) throws StudentException {
		c= new Courses(Integer.parseInt(req.getParameter("crsId")),req.getParameter("crsName"), Integer.parseInt(req.getParameter("sec")), req.getParameter("tim"));
		ad.addCourse(c);
		return new ModelAndView("success");
	}
	
	@RequestMapping(value = "/adminRemoveCourseDetails", method = RequestMethod.GET)
	public ModelAndView adminRemoveCourseDetails(HttpServletRequest req, AdminDAO ad, Courses c) throws StudentException {
		ad.removeCourse(req.getParameter("crsId"));
		return new ModelAndView("success");
	}
	
	@RequestMapping(value = "/adminUpdateCourseDetails", method = RequestMethod.GET)
	public ModelAndView adminUpdateCourseDetails(HttpServletRequest req, AdminDAO ad, Courses c) throws StudentException {
		ad.updateCourse(req.getParameter("crsName"), req.getParameter("crsId"));
		return new ModelAndView("success");
	}

	@RequestMapping(value = "/showcourses", method = RequestMethod.POST)
	public ModelAndView addCourses(HttpServletRequest req, SemesterDAO sdao) throws StudentException, ClassNotFoundException, SQLException {
		HttpSession session = (HttpSession) req.getSession();
		String semm = req.getParameter("sem");
		sdao.buildSemesters();
		return new ModelAndView("course-add");
	}
	
	@RequestMapping(value = "/courseResult", method = RequestMethod.POST)
	public ModelAndView searchCourses(HttpServletRequest req, CourseDAO cd){
		HttpSession session = (HttpSession) req.getSession();
		String val= req.getParameter("search");
		List<Courses> c= new ArrayList<Courses>();
		String keyword = req.getParameter("searchBox");
		if(val.equalsIgnoreCase("coursename")) {
			c= cd.searchCourseByCourseName(keyword);
			if(c.get(0).getCourseName().equalsIgnoreCase("")) {
				session.setAttribute("cf", "Course Not Found");
				return new ModelAndView("course-result-display", "cf","Course Not Found");
			}
			else {
				session.setAttribute("courselist", c);
			}
		}
		else if(val.equalsIgnoreCase("courseId")) {
			c= cd.searchCourseByCourseId(keyword);
			if(c.get(0).getCourseName().equalsIgnoreCase("")) {
				session.setAttribute("cf", "Course Not Found");
				return new ModelAndView("course-result-display", "cf","Course Not Found");
			}
			else {
				session.setAttribute("courselist", c);
			}
		}
		return new ModelAndView("course-result-display");
	}
	
	@RequestMapping(value = "/courseInfo", method = RequestMethod.GET)
	public ModelAndView courseInfo(HttpServletRequest req,CourseDAO cd, ProfessorDAO p, Professor pf){
		int cid= Integer.parseInt(req.getParameter("courseId"));
		Courses sc=cd.getCurrentSelectedCourse(cid);
		HttpSession session = (HttpSession) req.getSession();
		cd.buildCourseData(sc, p);
		List<Professor> prof = new ArrayList<Professor>();
		prof  = cd.getProfessorDetails(cid);
		session.setAttribute("professorDetails", prof.get(0));
		return new ModelAndView("course-info", "course", sc);
	}
	
	@RequestMapping(value = "/registerForCourse", method = RequestMethod.POST)
	public ModelAndView registerForCourse(HttpServletRequest req,CourseDAO cd, SendEmail se, StudentDAO sd) throws EmailException, StudentException{
		int cid= Integer.parseInt(req.getParameter("courseId"));
		HttpSession session = (HttpSession) req.getSession();
		Courses sc=cd.getCurrentSelectedCourse(cid);
		Set<Courses> courseSet = new HashSet<Courses>();
		Student s = (Student) session.getAttribute("student");
		courseSet.add(sc);
		s.setCourses(courseSet);
		se.sendEmailToStudent(sc,s.getEmail());
		return new ModelAndView("email-success");
	}
	
	@RequestMapping(value = "/closeSession", method = RequestMethod.GET)
	public ModelAndView closeSession(HttpServletRequest req) {
		HttpSession session = (HttpSession) req.getSession();
		session.invalidate();
		return new ModelAndView("student-registration");
	}
	
	@RequestMapping(value = "/pdfView", method = RequestMethod.GET)
	public View pdfView(HttpServletRequest req) {
		HttpSession session = (HttpSession) req.getSession();
		Student s = (Student) session.getAttribute("student");
		View view = new PdfViewForBilling(s);
		return view;
	}
}