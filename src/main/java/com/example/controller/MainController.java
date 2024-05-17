package com.example.controller;

import com.example.dto.DTOUser;
import com.example.entity.EntityUser;
import com.example.repository.BoardRepository;
import com.example.repository.UserRepository;
import com.example.service.ServiceUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

	@Autowired
	ServiceUser _serviceUser;

	@Autowired
	BoardRepository bRepo;
    @Autowired
    private UserRepository userRepository;

	@GetMapping("/Home")
    public String loginHome(Model m,  HttpSession session)
    {
       if(session.getAttribute("LoginOK") == "LoginOK") {
          m.addAttribute("tableList", _serviceUser.getAllUser());
          return "MyPage";
       } else {
          return "Login";
       }
    }

	@GetMapping("/MakeUserDummy")
	public String makeUserDummy() {
		for (int i = 0; i < 10; i++) {
			DTOUser user = new DTOUser();
			user.User_Name = String.valueOf(i);
			user.User_Age = String.valueOf(i);
			_serviceUser.Join(user);
		}
		return "Login";
	}

	@GetMapping("/Logout")
	public String logout(HttpSession session) {
		session.removeAttribute("LoginOK");
		return "Login";
	}

	@PostMapping("/register")
	public String userRegister(DTOUser user, HttpSession session) {
		_serviceUser.Join(user);
		return "Login";
	}

	@GetMapping("PassChange/{id}/{pass}/{repass}")
	public String userPassChange(
			@PathVariable String id,
			@PathVariable String pass,
			@PathVariable String repass,
			HttpSession session
	)
	{
		_serviceUser.RePass(id, pass, repass);
		List<EntityUser> list = userRepository.findByUsernameAndUserage(id,repass);
		if (list.isEmpty()){
			return "MyPage";
		}else{
			session.invalidate();
			System.out.println("REPASS Success");
			return "Login";
		}
	}

	@PostMapping("/Login")
	public String userLogin(DTOUser user, Model m, HttpSession session) {

		if (session.getAttribute("LoginOK") == "True") {
			m.addAttribute("tableList", _serviceUser.getAllUser());
			return "MyPage";
		} else {

			boolean b = _serviceUser.Login(user);

			if (b) {
				session.setAttribute("LoginOK", "True");
				m.addAttribute("tableList", _serviceUser.getAllUser());
				return "MyPage";
			} else
				return "Login";
		}
	}

	@GetMapping("/delete")
	public String delete(HttpSession session,String User_Name,String User_Age, Model m) {
		_serviceUser.Delete(User_Name, User_Age);
		m.addAttribute("tableList", _serviceUser.getAllUser()); // 삭제 후에도 tableList 다시 설정
		return "Mypage";
	}
//	@PostMapping("/deletePost")
//	public String userDelete(DTOUser user, Model m){
//		_serviceUser.Delete(user.User_Name, user.User_Age);
//		m.addAttribute("tableList",_serviceUser.getAllUser());
//		return "Mypage";
//	}

}