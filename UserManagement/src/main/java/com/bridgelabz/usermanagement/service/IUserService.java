

/******************************************************************************
 
 *  Purpose: This is interface of User Management class  it handles  all the 
 *           request coming from controller and  then process   in service 
 *           implementation class where all the method of this service is 
 *           implemented .
 *  		 
 *  @author  Abhishek Rawat
 *  @version 1.0
 *  @since   17-12-2019
 *
 ******************************************************************************/
package com.bridgelabz.usermanagement.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.usermanagement.dto.AuthenticationDTO;
import com.bridgelabz.usermanagement.dto.LoginDTO;
import com.bridgelabz.usermanagement.dto.UserDTO;
import com.bridgelabz.usermanagement.entity.User;
import com.bridgelabz.usermanagement.response.Response;




public interface IUserService {


	

	/**
	 * Purpose: Method for user login into the UserManagement.
	 * 
	 * @param login object containing user emailId and user password (in encoded
	 *              format ).
	 * @return Response which contains the response of the method .
	 */
	public Response userLogin(LoginDTO login);
	
	
	/**
	 *Purpose: Method for user logout
	 * @param email of user which is needed to be logout
	 * @return
	 */
	public Response userLogout(String email);
	
	
	

	/**
	 * Purpose: Method for registration of new user into  UserManagement.
	 * 
	 * @param register object contains users firstName, lastName ,contact , emailId
	 *                 and password (in encoded format) and then mapping it to user
	 *                 Model .
	 * @return Response which contains the response of the method.
	 */
	public Response userRegister( MultipartFile file,UserDTO register);
	
	

	/**
	 * Purpose: Method for send mail to the user emailId if he/she has forgot
	 * his/her password.
	 * 
	 * @param email to which the mail has to send the mail will contains a link to
	 *              reset new password.
	 * @return Response which contains the response of the method.
	 */
	public Response userForgotPassword(String email);
	
	
	

     /**: Method for resetting user password
     * Purpose
     * @param password uers new password
     * @param email of user which we have to reset the password
     * @return
     */
    public User userSetPassword(String password, String email);
	
	


	
	/**
	 * Purpose: Method for adding profile picture to user of UserManagement using multi part
	 *          file
	 * @param emailIdToken
	 * @param file containing image for adding profile picture
	 * @return Response which contains the response of the method
	 * @throws IOException 
	 */
	public User addProfilePic( String email , MultipartFile file ) throws IOException;
	

	 /**
	 *  Purpose: Method for removing profile picture of user of  UserManagement
	 * @param emailIdToken to verify the user and granting him/her the authorization to
	 *              access the userServices.
	 * @return Response which contains the response of the method
	 * @throws IOException
	 */
	public User removeProfilePic(String email) throws IOException;
	
	
	/**
	 * Purpose: Method for updating profile picture of user of  UserManagement
	 * @param emailIdToken to verify the user and granting him/her the authorization to
	 *              access the userServices.
	 * @param file containing image  for updating profile picture
	 * @return Response which contains the response of the method
	 * @throws IOException
	 */
	public User updateProfilePic( String email , MultipartFile file)throws IOException;
	
	
	/**
	 * Purpose: Method for getting profile picture of particular user
	 * @param emailIdToken  to verify the user and granting him/her the authorization to
	 *              access the userServices.
	 * @return Response which contains the response of the method
	 */
	public Response getProfilePic(String email , String userEmail);
	

	
	/**
	 * Purpose: Method for getting all user present in the database
	 * @return  Response which contains the response of the method
	 */
	public Response getAllUser();
	
	
	/**
	 * Purpose: Method for getting particular user in database 
	 * @param email   of particular user
	 * @return Response which contains the response of the method
	 */
	public User getUser(String email);
	
	
	/**
	 * Purpose: Method for getting the list of login history of particular user
	 * @param email of particular user
	 * @return
	 */
	public Response loginHistory(String email);
	
	/**
	 * Purpose: Method for getting the list of registration in ascending order
	 * @param email of particular user
	 * @return Response which contains the response of the method
	 */
	public Response latestRegistration(String email);
	
	/**
	 * Purpose: Method for getting the total count of user in the database
	 * @param email of particular user
	 * @return
	 */
	public Response totalUser(String email);
	
	/**
	 * Purpose: Method for getting the percentage of male and female in database
	 * @param email of particular user
	 * @return Response which contains the response of the method
	 */
	public Response gender(String email);
	
	/**
	 * Purpose: Method for removing user from   UserManagement
	 * @param email of particular user
	 * @return Response which contains the response of the method
	 */
	public Response deleteUser(String email);
	
	
	/**
	 * Purpose: Method for adding authentication setting  of user of  UserManagement
	 * @param email of particular user
	 * @param authencticationDto
	 * @return Response which contains the response of the method
	 */
	public Response authenticationSetting(String email , AuthenticationDTO authencticationDto);
	
	
	/**
	 * Purpose: Method for updating  of user of  UserManagement
	 * @param email of particular user
	 * @param file containing image  for updating profile picture
	 * @param userDTO
	 * @return Response which contains the response of the method
	 */
	public Response updateUser(String email,MultipartFile file ,UserDTO userDTO);
	 
	

}
