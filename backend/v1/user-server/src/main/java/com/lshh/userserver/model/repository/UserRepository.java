package com.lshh.userserver.model.repository;

import com.lshh.userserver.model.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
    Mono<User> findByLoginIdAndPassword(String loginId, String password);
}
