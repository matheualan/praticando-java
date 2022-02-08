package br.com.lojaonline.controller;

import br.com.lojaonline.model.User;
import br.com.lojaonline.repository.UserRepository;
import br.com.lojaonline.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DateUtil dateUtil;

    @PostMapping("/insertUser")
    public ResponseEntity<User> insertUser(@RequestBody User newUser) {
        User user = userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
        try {
            Optional<User> findId = userRepository.findById(id);
            return ResponseEntity.ok().body(findId);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updateUser.getName());
                    user.setCpf(updateUser.getCpf());
                    User userChanged = userRepository.save(user);
                    return ResponseEntity.status(HttpStatus.OK).body(userChanged);
                }).orElse(ResponseEntity.notFound().build());
    }

}
