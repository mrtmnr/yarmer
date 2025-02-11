package com.example.yarmer.Service;

import com.example.yarmer.Model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{
    private final List<Question> questions = List.of(
            new Question("İlk randevumuz nerede oldu?", List.of("Sinema", "Kafe", "Park", "Restoran"), 0),
            new Question("Beni en çok ne mutlu eder?", List.of("Kahve içmek", "Sarılmak", "Film izlemek", "Küçük sürprizler"), 0),
            new Question("En sevdiğim yemek hangisi?", List.of("Lahmacun", "Pizza", "Hamburger", "Makarna"), 0),
            new Question("Birlikte izlediğimiz ilk film neydi?", List.of("Interstellar", "Inception", "Titanic", "Harry Potter"), 0)
    );

    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null;
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}
