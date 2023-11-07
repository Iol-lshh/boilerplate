package com.lshh.userserver.service;

import com.lshh.userserver.model.dto.UserBasic;
import com.lshh.userserver.model.dto.UserRequest;
import com.lshh.userserver.model.entity.User;
import com.lshh.userserver.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

@Service
public class UserServiceBasic implements UserService{
    @Autowired
    TransactionalOperator transactionalOperator;
    @Autowired
    UserRepository userRepository;
    @Override
    public Mono<Integer> createUser(UserRequest user) {
        return userRepository.save(new User()
                .setLoginId(user.getLoginId())
                .setPassword(user.getPassword())
                .setName(user.getName()))
            .map(User::getId);
    }

    @Override
    public Mono<UserBasic> findUser(int id) {
        return userRepository.findById(id).map(user ->
            new UserBasic()
                .setId(user.getId())
                .setLoginId(user.getLoginId())
                .setName(user.getName()));
    }

    @Override
    public Mono<UserBasic> findUser(String loginId, String password) {
        return userRepository.findByLoginIdAndPassword(loginId, password).map(user->
            new UserBasic()
                .setId(user.getId())
                .setLoginId(user.getLoginId())
                .setName(user.getName()));
    }
}
