package com.example.yarmer.Controller;

import com.example.yarmer.Model.Question;
import com.example.yarmer.Service.QuizService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public String showQuestion(@RequestParam(defaultValue = "0") int questionIndex, Model model, HttpSession session) {
        if (questionIndex >= quizService.getTotalQuestions()) {
            Integer score = (Integer) session.getAttribute("score");
            if (score == null) {
                score = 0;
            }
            model.addAttribute("score", score);
            model.addAttribute("totalQuestions", quizService.getTotalQuestions());
            session.removeAttribute("score"); // Puanı sıfırla
            return "result";
        }

        model.addAttribute("question", quizService.getQuestion(questionIndex));
        model.addAttribute("questionIndex", questionIndex);
        model.addAttribute("totalQuestions", quizService.getTotalQuestions());

        return "quiz";
    }

    @PostMapping("/answer")
    public String processAnswer(@RequestParam(required = false) Integer selectedOption,
                                @RequestParam int questionIndex, HttpSession session) {

        if (selectedOption == null) {
            return "redirect:/quiz?questionIndex=" + questionIndex; // Kullanıcı bir şık seçmezse aynı sayfaya yönlendir
        }

        Question question = quizService.getQuestion(questionIndex);

        if (question != null) {
            Integer score = (Integer) session.getAttribute("score");
            if (score == null) {
                score = 0;
            }

            if (selectedOption == question.getCorrectIndex()) {
                score++;
            }

            session.setAttribute("score", score);
        }

        return "redirect:/quiz?questionIndex=" + (questionIndex + 1);
    }
}
