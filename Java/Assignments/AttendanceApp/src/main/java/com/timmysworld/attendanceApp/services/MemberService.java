package com.timmysworld.attendanceApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.timmysworld.attendanceApp.models.Member;
import com.timmysworld.attendanceApp.repositories.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository mRepo;
	
	public List<Member> allMembers(){
		return mRepo.findAll();
	}
	
	
	
	//CREATE:
	public Member addMember(Member newMember, BindingResult result) {
		Optional<Member> m = mRepo.findByfName(newMember.getfName());
		
		if(m.isPresent()) {
			result.rejectValue("fName", "match","Theres someone with the same name already!");
			System.out.println("Name Match");
		}
		if(result.hasErrors()) {
			System.out.println("other error");
			return null;
		}
		System.out.println("no error");
		return mRepo.save(newMember);
		
	}
	
	public Member findMemberById(Long id) {
		Optional<Member> m = mRepo.findById(id);
		if(m.isPresent()) {
			return m.get();
		}else {
			return null;
		}
	}
	
	//DELETE:
	public void deleteMember(long id) {
		Optional<Member> m = mRepo.findById(id);
		if(m.isPresent()) {
			mRepo.deleteById(id);
		}
	}

}
