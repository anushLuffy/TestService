/**
 * 
 */
package com.company.testService.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.company.testService.dto.ResponseEntity;
import com.company.testService.model.User;
import com.company.testService.repository.UserRepository;
import com.company.testService.utils.GenerateEncryptionPassword;
import com.company.testService.utils.GeneratePlainPassword;
import com.company.testService.utils.Util;

/**
 * @author anush
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Value("${keyGen.key}")
	private String genKey ;

	@Transactional
	public ResponseEntity<User> register(@Valid User user) {
		ResponseEntity<User> response = new ResponseEntity<>();
		response.setStatusCode(500);
		//create bare minimal validations 
		String val = Util.validations(user); 
		if(val !=null) {
			response.setErrorResponse(val);
		}
		else {
			try {
				User userRec =  userRepository.getuserByEmailId(user.getEmailId());
				if(null== userRec) {
					// lets create the user because user does not exists 
					//generate the encrypt pass with key 
					String pas = GenerateEncryptionPassword.genPass(genKey, user.getPassword());
					user.setPassword(pas);
					userRepository.save(user);
					response.setResponse(user);
					response.setStatusCode(200);
				}else {
					response.setErrorResponse("Already exists please login");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.setErrorResponse("Error in registering user !! please try again ");
			}
		}
		return response;
	}

	@Transactional
	public ResponseEntity<User> login(@Valid User user) {
		ResponseEntity<User> response = new ResponseEntity<>();
		response.setStatusCode(500);
		//create bare minimal validations 
		String val = Util.loginValidations(user); 
		if(Util.loginValidations(user) !=null) {
			response.setErrorResponse(val);
		}
		else {
			try {
				User userRec =  userRepository.validateUser(user.getEmailId(),GenerateEncryptionPassword.genPass(genKey, user.getPassword()));
				if(null!=userRec) {
					// dont send back the password 
					userRec.setPassword(null);
					response.setResponse(userRec);
					response.setStatusCode(200);
				}else {
					response.setErrorResponse("User does not exits / Password not correct");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.setErrorResponse("Error in login!! please try again ");
			}
		}
		return response;
	}

}
