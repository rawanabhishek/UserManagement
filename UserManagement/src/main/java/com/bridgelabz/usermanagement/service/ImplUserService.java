

/******************************************************************************
 
 *  Purpose: This is a service class for user management implementing user
             management interface methods
 *  @author  Abhishek Rawat
 *  @version 1.0
 *  @since   17-12-2019
 *
 ******************************************************************************/
package com.bridgelabz.usermanagement.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.usermanagement.configuration.UserConfiguration;
import com.bridgelabz.usermanagement.dto.LoginDTO;
import com.bridgelabz.usermanagement.dto.UserDTO;
import com.bridgelabz.usermanagement.entity.LoginHistory;
import com.bridgelabz.usermanagement.entity.User;
import com.bridgelabz.usermanagement.exception.custom.UserException;
import com.bridgelabz.usermanagement.repository.UserRepository;
import com.bridgelabz.usermanagement.response.Response;
import com.bridgelabz.usermanagement.utility.CommonFiles;



@Service
public class ImplUserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConfiguration userConfiguration;

	@Autowired
	private ModelMapper modelMapper;

	

	public static final Logger LOG = LoggerFactory.getLogger(ImplUserService.class);


	@Override
	public Response userLogin(LoginDTO loginDTO) {
		LOG.info(CommonFiles.SERVICE_LOGIN_METHOD);

		User user = userRepository.findByUserName(loginDTO.getUserName()).orElse(null);
		if (user == null) {
			throw new UserException(CommonFiles.USER_FOUND_FAILED);
		}
		if (!userRepository.findAll().stream()
				.anyMatch(i -> i.getUserName().equals(loginDTO.getUserName())
						&& userConfiguration.passwordEncoder().matches(loginDTO.getPassword(), i.getPassword())
						)) {
			throw new UserException(CommonFiles.LOGIN_FAILED);
		}
		LoginHistory logs =new LoginHistory();
		logs.setLoginHistory(new Date());
		user.getLogins().add(logs);
		user.setLastLogin(new Date());
		userRepository.save(user);
		
		
		return new Response(200, CommonFiles.LOGIN_SUCCESS,user);

	}


	
	@Override
	public Response userRegister( MultipartFile file,UserDTO register) {
		LOG.info(CommonFiles.SERVICE_REGISTER_METHOD);

		if (userRepository.findByEmailAndUserName(register.getEmail(), register.getUserName())) {
			throw new UserException(register.getEmail() + CommonFiles.REGISTER_EMAIL_FOUND);

		}
		
		User user = modelMapper.map(register, User.class);
		if (file != null && file.getContentType() != null
				&& !file.getContentType().toLowerCase().startsWith("image"))
			throw new UserException(CommonFiles.USER_FOUND_FAILED);

		byte[] bytes;
		try {
			bytes = file.getBytes();
			String extension = file.getContentType().replace("image/", "");
			String fileLocation = CommonFiles.PROFILE_PIC_PATH + user.getEmail() + "." + extension;
			Path path = Paths.get(fileLocation);
			Files.write(path, bytes);
			user.setProfilePicture(fileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

	

		register.setPassword(userConfiguration.passwordEncoder().encode(register.getPassword()));



		return new Response(200, CommonFiles.REGISTER_SUCCESS, userRepository.save(user));

	}

	
	@Override
	public Response userForgotPassword(String email) {
		LOG.info(CommonFiles.SERVICE_FORGOTPASSWORD_METHOD);

		if (userRepository.findByEmail(email) == null) {
			throw new UserException(email + CommonFiles.EMAIL_FAILED);

		}


		return new Response(200, CommonFiles.EMAIL_SUCCESS, true);

	}






	
	@Override
	public User addProfilePic(String email, MultipartFile file) throws IOException {
		
		User user = userRepository.findByEmail(email).orElse(null);

		if (user == null) {
			throw new UserException(CommonFiles.USER_FOUND_FAILED);
		}

		byte[] bytes = file.getBytes();
		String extension = file.getContentType().replace("image/", "");
		Path path = Paths.get(CommonFiles.PROFILE_PIC_PATH + email + "." + extension);
		Files.write(path, bytes);

		user.setProfilePicture(CommonFiles.PROFILE_PIC_PATH + email + "." + extension);

		return  userRepository.save(user);

	}



	@Override
	public User removeProfilePic(String email) throws IOException {
		
		User user = userRepository.findByEmail(email).orElse(null);

		if (user == null) {
			throw new UserException(CommonFiles.USER_FOUND_FAILED);
		}
		Path path = Paths.get(user.getProfilePicture());

		Files.delete(path);
		user.setProfilePicture(null);
		return  userRepository.save(user);
	}


	@Override
	public User updateProfilePic(String email, MultipartFile file) throws IOException {
	
		User user = userRepository.findByEmail(email).orElse(null);
		System.out.println("Update profile pic service");
		if (user == null) {
			throw new UserException(CommonFiles.USER_FOUND_FAILED);
		}
//		if (user.getProfilePic() == null) {
//			throw new UserException(CommonFiles.NO_PROFILE_PIC);
//		}

		byte[] bytes = file.getBytes();
		String extension = file.getContentType().replace("image/", "");
		Path path = Paths.get(CommonFiles.PROFILE_PIC_PATH + email + "." + extension);
		Files.write(path, bytes);

		user.setProfilePicture(CommonFiles.PROFILE_PIC_PATH + email + "." + extension);

		return  userRepository.save(user);
	}

	@Override
	public Response getProfilePic(String email) {
		
		User user = userRepository.findByEmail(email).orElse(null);
		if (user == null) {
			throw new UserException(CommonFiles.USER_FOUND_FAILED);
		}
		String profilePic = "";
		String filePath = CommonFiles.PROFILE_PIC_PATH;
		File fileFolder = new File(filePath);
		if (fileFolder != null) {
			for (final File file : fileFolder.listFiles()) {
				if (!file.isDirectory()) {
					String encodeBase64 = null;
					try {
						if ((CommonFiles.PROFILE_PIC_PATH + file.getName()).equals(user.getProfilePicture())) {
							String extension = FilenameUtils.getExtension(file.getName());
							FileInputStream fileInputStream = new FileInputStream(file);
							byte[] bytes = new byte[(int) file.length()];
							fileInputStream.read(bytes);
							encodeBase64 = Base64.getEncoder().encodeToString(bytes);
							profilePic = ("data:image/" + extension + ";base64," + encodeBase64);
							fileInputStream.close();
							break;
						}

					} catch (Exception e) {

					}
				}
			}
		}

		return new Response(200, CommonFiles.PATH_FEATCHED, profilePic);

	}

	
	@Override
	public Response getAllUser() {
		
		return new Response(200 , CommonFiles.GET_ALL_USER, userRepository.findAll().stream().collect(Collectors.toList()));
	}



	
	@Override
	public User getUser(String email) {
		LOG.info(CommonFiles.GET_USER);
		return userRepository.findByEmail(email).get();
		
	}

}
