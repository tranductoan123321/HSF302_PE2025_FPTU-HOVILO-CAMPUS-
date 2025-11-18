package fpt.edu.vn.repositories;

import fpt.edu.vn.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByUsername(String username); // luu y
    Member getMemberByUsername(String username);
}
