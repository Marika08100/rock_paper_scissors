package hu.progmatic.rock_paper_scrissors.controller;

import hu.progmatic.rock_paper_scrissors.model.GameElement;
import hu.progmatic.rock_paper_scrissors.model.GameResult;
import hu.progmatic.rock_paper_scrissors.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {
    private final GameService basicGameService;

    @GetMapping("/play")
    public String getHome() {
        return "home";
    }

    @Autowired
    public GameController(
            GameService basicGameService) {
        this.basicGameService = basicGameService;
    }

    @PostMapping("/play")
    public String playGame(String userChoice, Model model) {
        GameElement userElement = GameElement.valueOf(userChoice);
        GameElement computerElement = basicGameService.generateComputerChoice();
        GameResult gameResult = basicGameService.determineWinner(userElement, computerElement);
        model.addAttribute("userChoice", userElement.getDisplayName());
        model.addAttribute("computerChoice", computerElement.getDisplayName());
        model.addAttribute("result", gameResult.getMessage());
        return "redirect:/result";
    }
}
