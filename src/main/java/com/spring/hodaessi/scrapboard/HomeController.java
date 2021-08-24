package com.spring.hodaessi.scrapboard;

import com.spring.hodaessi.scrapboard.board.BoardRepository;
import com.spring.hodaessi.scrapboard.user.UserRepository;
import com.spring.hodaessi.scrapboard.user.config.auth.LoginUser;
import com.spring.hodaessi.scrapboard.user.config.auth.dto.SessionUser;
import com.spring.hodaessi.scrapboard.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @RequestMapping("/") //requestMapping??? get, post가 아니라???
    public String home(Model model, @LoginUser SessionUser user) {
        //user에 왠 null? 브라우저에 session값있었는데??? 어노테이션 어떻게 작동하는겨야;;???

        if(user != null) {
            User joinedUser = userRepository.findByEmail(user.getEmail());
            if(joinedUser != null) {
                model.addAttribute("userName", user.getName());
                model.addAttribute("userBoardId", boardRepository.findByUser(joinedUser).getId());

                return "privatePage";
            }
        } //>> "spring security login success url" ???

        return "home";
    }
}
