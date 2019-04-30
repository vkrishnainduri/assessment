package com.synchrony.assessment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.synchrony.assessment.beans.UserInformation;

@Repository
public interface UserInformationRepository extends CrudRepository<UserInformation, Long> {
	
}
