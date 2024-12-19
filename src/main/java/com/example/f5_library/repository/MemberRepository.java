
package com.example.f5_library.repository;

import com.example.f5_library.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberTag(String memberTag);
    Optional<Member> findByDni(String dni);
    Optional<Member> findByMemberEmail(String memberEmail);
}
