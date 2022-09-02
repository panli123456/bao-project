package com.lp.bao.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum UserTypeEnum {
    USER_1("user1", 1),
    USER_2("user2", 2);
    private final String name;
    private final Integer type;
}
