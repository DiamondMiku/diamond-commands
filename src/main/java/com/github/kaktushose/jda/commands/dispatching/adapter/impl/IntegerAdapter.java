package com.github.kaktushose.jda.commands.dispatching.adapter.impl;

import com.github.kaktushose.jda.commands.dispatching.CommandContext;
import com.github.kaktushose.jda.commands.dispatching.adapter.TypeAdapter;

import java.util.Optional;

public class IntegerAdapter implements TypeAdapter<Integer> {

    @Override
    public Optional<Integer> parse(String raw, CommandContext context) {
        try {
            return Optional.of(Integer.valueOf(raw));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }
}
