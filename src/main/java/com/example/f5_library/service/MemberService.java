
package com.example.f5_library.service;

import java.util.List;
import java.util.Optional;
import com.example.f5_library.model.Member;
import com.example.f5_library.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* CRUD */

    // Create
    public Member addMember(Member newMember) {
        return memberRepository.save(newMember);
    }

    // Read
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    // Update
    public Member updatedMember(int id, Member updatedMember) {

        Optional<Member> foundUser = memberRepository.findById(id);

        if (foundUser.isPresent()) {

            // GATHER MEMBER DATA
            Member resultMember = foundUser.get();

            // SET DNI
            resultMember.setDni(updatedMember.getDni());

            // SET TAG
            resultMember.setMemberTag(updatedMember.getMemberTag());

            // SET FIRST NAME
            resultMember.setFirstName(updatedMember.getFirstName());

            // SET LAST NAME
            resultMember.setLastName(updatedMember.getLastName());

            // SET EMAIL
            resultMember.setMemberEmail(updatedMember.getMemberEmail());

            // SET PHONE
            resultMember.setMemberPhone(updatedMember.getMemberPhone());

            return memberRepository.save(resultMember);
        } else throw new RuntimeException("Member not found!");
    }

    // Delete
    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }


    /* FILTERS */

    // ID
    public Optional<Member> findMemberById(int id) {
        return memberRepository.findById(id);
    }
}