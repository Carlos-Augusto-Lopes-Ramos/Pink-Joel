package com.main.medula.dtos;

import com.main.medula.models.CommentsModel;
import com.main.medula.models.PostsModel;
import com.main.medula.models.UsersModel;
import org.antlr.v4.runtime.misc.NotNull;

public record CommentDto (@NotNull UsersModel user, @NotNull PostsModel post, String image, String content) {

    public CommentsModel materialize() {
        CommentsModel comment = new CommentsModel();
        comment.setUser(user);
        comment.setPost(post);
        comment.setImage(image);
        comment.setContent(content);
        return comment;
    }

}
