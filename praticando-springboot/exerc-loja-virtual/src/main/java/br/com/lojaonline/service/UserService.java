package br.com.lojaonline.service;

import br.com.lojaonline.model.UserModel;
import br.com.lojaonline.repository.UserRepository;
import br.com.lojaonline.repository.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public List<UserModel> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void getUserById(UUID id) {
        userRepository.findById(id);
    }

    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }

}
