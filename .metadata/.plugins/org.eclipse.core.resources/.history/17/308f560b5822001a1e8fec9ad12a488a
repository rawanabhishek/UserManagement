package com.bridgelabz.usermanagement.utility;



import com.bridgelabz.usermanagement.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {
	

	
	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}
	
	
	public static Object readMapper(String json , UserDTO userDTO) throws JsonMappingException, JsonProcessingException {
		System.out.println("Json"+json+"userDTO"+userDTO);
		return mapper.readValue(json, userDTO.getClass());
		
	}
	

}
