
package com.example.f5_library.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.f5_library.model.Member;
import com.example.f5_library.service.MemberService;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /* CRUD */

    // Create
    @PostMapping("/members")
    public void createMember(@RequestBody Member newMember) {
        memberService.addMember(newMember);
    }

    // Read
    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberService.getMembers();
    }

    // Update
    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateMembers(@PathVariable int id, @RequestBody Member updatedMember) {
        try {
            Member updatingMember = memberService.updatedMember(id, updatedMember);
            return new ResponseEntity<>(updatingMember, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/members/{id}")
    public void deleteMemberById(@PathVariable int id) {
        memberService.deleteMember(id);
    }


    /* FILTERS */

    // ID
    @GetMapping("/members/id/{id}")
    public ResponseEntity<Member> findMemberWithId(@PathVariable int id) {

        Optional<Member> foundUserWithId = memberService.findUserById(id);

        if(foundMemberWithId.isPresent()) {
            return new ResponseEntity<>(foundMemberWithId.get(), HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
