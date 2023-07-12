package com.lshh.userserver.model.dto;

import lombok.Data;

@Data
public class UserRequest {
    String loginId;
    String name;
    String password;
}
