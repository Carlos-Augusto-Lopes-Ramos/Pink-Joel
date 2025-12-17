package com.main.medula.dtos;

import com.main.medula.models.UsersModel;
import org.antlr.v4.runtime.misc.NotNull;

public record UserDto(@NotNull String email, @NotNull String name, @NotNull String pswrd) {

    public UsersModel materialize() {
        return new UsersModel(email, name, pswrd, false);
    }

}
