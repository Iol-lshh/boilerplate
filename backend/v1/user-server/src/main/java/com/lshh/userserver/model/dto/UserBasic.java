package com.lshh.userserver.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
public class UserBasic {
    int id;
    String loginId;
    String name;
}
