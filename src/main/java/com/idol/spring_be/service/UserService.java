// package com.idol.spring_be.service;
// import com.idol.spring_be.model.User;
// import com.idol.spring_be.repository.UserRepository;

// public class UserService {
    
//     private final UserRepository userRepository;

//     public UserService(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     public User createUser(User user) {
//         return userRepository.save(user);
//     }

//     public User getUserById(Long id) {
//         return userRepository.findById(id).orElse(null);
//     }

//     public void deleteUser(Long id) {
//         userRepository.deleteById(id);
//     }
// }