package com.main.medula.dtos;

import com.main.medula.models.PostsModel;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

public record PostDto(@NotNull String title, @NotNull String content, @NotNull String image) {

    public PostsModel materialize() {
        return new PostsModel(title, content, image);
    };

}
