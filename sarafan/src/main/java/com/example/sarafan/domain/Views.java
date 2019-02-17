package com.example.sarafan.domain;

public final class Views {
//    Используется для @JsonView. Поля, помеченные данной аннотацией, будут выводиться.
    public interface IdName{}
    public interface FullMessage extends IdName{}
}
