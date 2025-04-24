package com.hacker.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hacker.profile.entity.Profile;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
}