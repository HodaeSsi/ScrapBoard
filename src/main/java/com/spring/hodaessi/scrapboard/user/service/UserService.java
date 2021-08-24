package com.spring.hodaessi.scrapboard.user.service;

import com.spring.hodaessi.scrapboard.user.UserRepository;
import com.spring.hodaessi.scrapboard.user.config.auth.OAuthAttributes;
import com.spring.hodaessi.scrapboard.user.config.auth.dto.SessionUser;
import com.spring.hodaessi.scrapboard.user.domain.Role;
import com.spring.hodaessi.scrapboard.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final ApplicationEventPublisher eventPublisher;

    private final UserRepository userRepository;

    public User loginOrJoin(String email, String name, String picture) {
        //sessionUser를 매개변수로 ??? >> 책보고 어노테이션 다시 확인좀;;;

//        return userRepository.findByEmail(attributes.getEmail())
//                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
//                .orElse(this.join(attributes));

        User user = userRepository.findByEmail(email);

        if(user == null) {
            user = join(email, name, picture);
        } else {
            user.update(name, picture);
            userRepository.save(user);
        }

        return user;
    }

    public User join(String email, String name, String picture) {

        User user = User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();

        userRepository.save(user);

//        System.out.println("i'm first!!!");
        eventPublisher.publishEvent(new UserRegisteredEvent(user));

        return user;
    }
}
