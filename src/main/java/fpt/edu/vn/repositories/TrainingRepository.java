package fpt.edu.vn.repositories;

import fpt.edu.vn.entities.Member;
import fpt.edu.vn.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {
    List<Training> findTrainingsByMember(Member member);
}
