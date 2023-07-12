package com.lshh.userserver.service;

import com.lshh.userserver.model.dto.UserBasic;
import com.lshh.userserver.model.dto.UserRequest;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<Integer> createUser(UserRequest User);
    Mono<UserBasic> findUser(int id);
    Mono<UserBasic> findUser(String loginId, String password);
}
