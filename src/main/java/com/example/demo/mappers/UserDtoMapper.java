package com.example.demo.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.UserNamesDto;
import com.example.demo.dtos.UserPostDto;
import com.example.demo.model.Users;
import com.example.demo.web.UserCotroller;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")

//@Component
//@Mapper(componentModel = "spring")
//@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface UserDtoMapper 
{

	
	UserPostDto toProductDTO(Users product);
	 
	///@Mapping(target = "picture", ignore = true)
	 List<UserNamesDto>  findAllUser(List<Users> users);

}
