package br.com.lojaonline.repository;


import br.com.lojaonline.model.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {

    UserModel insertUser(UserModel userModel);
    List<UserModel> listAllUsers();
    void getUserById(UUID id);
    void deleteUserById(UUID id);

}
