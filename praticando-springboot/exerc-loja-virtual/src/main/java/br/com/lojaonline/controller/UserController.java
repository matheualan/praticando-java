package br.com.lojaonline.controller;

import br.com.lojaonline.model.UserModel;
import br.com.lojaonline.repository.UserRepository;
import br.com.lojaonline.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DateUtil dateUtil;

    @PostMapping("/insertUser")
    public ResponseEntity<UserModel> insertUser(@RequestBody UserModel newUserModel) {
        UserModel userModel = userRepository.save(newUserModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<UserModel>> findById(@PathVariable UUID id) {
        try {
            Optional<UserModel> findId = userRepository.findById(id);
            return ResponseEntity.ok().body(findId);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable UUID id, @RequestBody UserModel updateUserModel) {
        return userRepository.findById(id)
                .map(userModel -> {
                    userModel.setName(updateUserModel.getName());
                    userModel.setCpf(updateUserModel.getCpf());
                    UserModel userModelChanged = userRepository.save(userModel);
                    return ResponseEntity.status(HttpStatus.OK).body(userModelChanged);
                }).orElse(ResponseEntity.notFound().build());
    }

}
