package com.synchrony.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synchrony.assessment.beans.UserInformation;

@Repository
public interface MyUserInformationRepository extends JpaRepository<UserInformation, Long> {
	public UserInformation findByUserName(String userName);
}
