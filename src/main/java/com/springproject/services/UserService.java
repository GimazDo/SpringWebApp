package com.springproject.services;

import com.springproject.entities.User;

import java.util.List;

/**
 * Service interface for class {@link User}.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    void addRoleToUser(String username, String roleName);

    User findById(Long id);

    void delete(Long id);
}
