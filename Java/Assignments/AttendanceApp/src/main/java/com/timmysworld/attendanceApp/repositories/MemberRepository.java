package com.timmysworld.attendanceApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.timmysworld.attendanceApp.models.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
	List<Member> findAll();
	Optional<Member> findByfName(String fName);
}
