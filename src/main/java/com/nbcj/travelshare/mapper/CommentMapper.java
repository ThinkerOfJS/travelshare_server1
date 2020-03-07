package com.nbcj.travelshare.mapper;

import com.nbcj.travelshare.domain.Comment;

import java.util.List;

public interface CommentMapper {
    void addComment(String content, String nickname, Integer uid, Integer tid); // 添加评论
    void deleteComment(Integer cmid); // 删除评论
    List<Comment> getComment(Integer tid); // 获取游记下所有评论
}
