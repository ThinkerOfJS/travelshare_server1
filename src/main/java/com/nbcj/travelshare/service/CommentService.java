package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.Comment;

import java.util.List;

public interface CommentService {
    void addComment(String content, String nickname, Integer uid, Integer tid);
    void deleteComment(Integer cmid); // 删除评论
    List<Comment> getComment(Integer tid, Integer start, Integer end); // 获取游记下所有评论
}
