package fpt.edu.vn.controller;

import fpt.edu.vn.entities.Member;
import fpt.edu.vn.entities.Training;
import fpt.edu.vn.service.MemberService;
import fpt.edu.vn.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/training")
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    
    @GetMapping
    public String showTraining(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("lists", trainingService.findByMember(memberService.findByUsername(username)));
        model.addAttribute("totalValue", trainingService.getTotalDurations(memberService.findByUsername(username)));
           return "training/listTraining";
    }

    @GetMapping("/create")
    public String createTraining(Model model) {
        model.addAttribute("training", new Training());
        return "training/createTraining";
    }

    @Autowired
    private MemberService memberService;

    @PostMapping("/save")
    public String saveTraining(@ModelAttribute("training") Training training) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Member member = memberService.findByUsername(username);
        training.setMember(member);
        trainingService.saveTraining(training);
        return "redirect:/training";
    }


}
