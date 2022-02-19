package br.com.lojaonline.controller;

import br.com.lojaonline.dto.UserDTO;
import br.com.lojaonline.model.UserModel;
import br.com.lojaonline.repository.UserRepository;
import br.com.lojaonline.service.UserService;
import br.com.lojaonline.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final UserRepository userRepository;
    private final UserService userService;
    private final DateUtil dateUtil;

    public UserController(UserService userService, DateUtil dateUtil, UserRepository userRepository) {
        this.userService = userService;
        this.dateUtil = dateUtil;
        this.userRepository = userRepository;
    }

    @PostMapping()
    public ResponseEntity<UserModel> insertUser(@RequestBody UserDTO userDTO) {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" POST /insertUser"));
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);
        userModel.setEntryDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> findById(@PathVariable(value = "id") UUID id) {
        try {
            Optional<UserModel> findId = userRepository.findById(id);
            return ResponseEntity.ok().body(findId);
        } catch (NoSuchElementException nsee) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody UserDTO userDTO) {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /PUT update"));
        Optional<UserModel> userModelOptional = userService.getUserById(id);
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);
        userModel.setEntryDate(userModelOptional.get().getEntryDate());
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(userModel));
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable UUID id, @RequestBody UserModel updateUserModel) {
        return userRepository.findById(id)
                .map(userModel -> {
                    userModel.setName(updateUserModel.getName());
                    userModel.setCpf(updateUserModel.getCpf());
                    UserModel userModelChanged = userRepository.save(userModel);
                    return ResponseEntity.status(HttpStatus.OK).body(userModelChanged);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> deleteUser(@PathVariable(value = "id") UUID id) {
        try {
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
