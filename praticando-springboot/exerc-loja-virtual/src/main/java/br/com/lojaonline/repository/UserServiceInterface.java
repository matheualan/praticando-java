package br.com.lojaonline.repository;


import br.com.lojaonline.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserServiceInterface {

    UserModel save(UserModel userModel);
    List<UserModel> listAllUsers();
    Optional<UserModel> getUserById(UUID id);
    void deleteUserById(UUID id);

}
