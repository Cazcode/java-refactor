package com.example.refactor.mapper;

public interface Mapper <I, O> {
    O map(I input);
}
