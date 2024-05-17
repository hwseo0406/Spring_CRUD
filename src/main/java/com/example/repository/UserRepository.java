package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.EntityUser;

public interface UserRepository extends CrudRepository <EntityUser, Integer>{

	
//	@Query(value = "select * from Entity_User where username = :userName", nativeQuery = true)
//	List<EntityUser> findUserData(String userName);
//
//	@Query("SELECT u FROM EntityUser  u WHERE u.username = :userName")
//	List<EntityUser> findDataQuery(String userName);
//
//	@Query(value = "select * from Entity_User where username = :userName", nativeQuery = true)
//	List<EntityUser> findUserDataQuery(String userName);
	
	@Query(value = "select * from Entity_User where UserName = :userName and UserAge =:userAge", nativeQuery = true)
	List<EntityUser> findByUsernameAndUserage(@Param("userName") String userName, @Param("userAge") String userAge);
}
