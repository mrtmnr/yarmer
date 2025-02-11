package com.example.yarmer.Controller;

import com.example.yarmer.Service.MemoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private MemoryService memoryService;

    public HomeController(MemoryService memoryService) {
        this.memoryService = memoryService;
    }

    @GetMapping("/home")
    public String returnToHomePage(){

        return "home/index";

    }

    @GetMapping("/gallery")
    public String gallery(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            Model model) {

        model.addAttribute("memories", memoryService.getPaginatedMemories(page, size));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", memoryService.getTotalPages(size));

        return "gallery";
    }
}
