package fpt.edu.vn.service;

import fpt.edu.vn.entities.Member;
import fpt.edu.vn.entities.Training;
import fpt.edu.vn.repositories.TrainingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {
    @Autowired
    private final TrainingRepository trainingRepository;


    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Transactional
    public List<Training> findAll() {
        return trainingRepository.findAll();
    }

    @Transactional
    public void saveTraining(Training training) {
        trainingRepository.save(training);
    }

    @Transactional
    public String getTotalDurations(Member member) {
        double total = trainingRepository.findTrainingsByMember(member)
                .stream()
                .mapToDouble(Training::getDurationMinutes)
                .sum();
        return String.format("%,.0f", total);
    }

    public List<Training> findByMember(Member member) {
        return trainingRepository.findTrainingsByMember(member);
    }

}
