package com.main.medula.dtos;

import com.main.medula.models.LoginModel;
import org.antlr.v4.runtime.misc.NotNull;

public record LoginDto(@NotNull String email, @NotNull String pswrd) {
    public LoginModel materialize() {
        return new LoginModel(email, pswrd);
    }
}
