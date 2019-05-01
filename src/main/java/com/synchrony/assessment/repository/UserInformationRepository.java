package com.synchrony.assessment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.synchrony.assessment.beans.UserInformation;

@Repository
public interface UserInformationRepository extends CrudRepository<UserInformation, Long> {
	@Query(name = "SELECT * FROM USER_DETAILS WHERE USER_NAME = :userName")
	public UserInformation findByUserName(@Param("userName") String userName);

}
