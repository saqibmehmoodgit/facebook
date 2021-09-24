package com.example.demo.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.NotifcationDto;
import com.example.demo.dtos.UserNamesDto;
import com.example.demo.dtos.UserPostDto;
import com.example.demo.model.Users;
import com.example.demo.posting.UserMakesPostComments;
import com.example.demo.web.UserCotroller;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")

//@Component
//@Mapper(componentModel = "spring")
//@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface NotificationDtoMapper 
{

	
	 
	///@Mapping(target = "picture", ignore = true)
	/// List<UserNamesDto>  findAllUser(List<Users> users);

	NotifcationDto giveNotifcationDto(UserMakesPostComments userMakesPostComments);
	
	
}
