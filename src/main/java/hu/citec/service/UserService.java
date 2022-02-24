package hu.citec.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.citec.entity.Subject;
import hu.citec.entity.SubjectGrade;
import hu.citec.entity.User;
import hu.citec.entity.UserRole;
import hu.citec.entity.UserSubject;
import hu.citec.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserSubject> findGrade(String username) {
		return userRepository.findGrade(username);
	}
	public User findUser(String username) {
		return userRepository.findUser(username);
	}
	public List <UserRole> findAllDiak(){
		return userRepository.findAllDiak();
	}
	public List <UserRole> adminShow(){
		return userRepository.adminShow();
	}
	public List<SubjectGrade> grade(String subjectName,String username){
		return userRepository.grade(subjectName,username);
	}
	public List <Subject> findSubject (){
		return userRepository.findSubject();
	}
	public void registrateUser(User user) {
		userRepository.registrateUser(user);
	}
	public void deleteUser(String username	) {
		userRepository.deleteUser(username);
	}
	public void blockUser(String username) {
		userRepository.blockUser(username);
	}
	
	
	
	
	
//	public List <SubjectGrade> findSubGrade(List<String > grade){
//		return userRepository.findSubGrade(grade);
//	}
}
