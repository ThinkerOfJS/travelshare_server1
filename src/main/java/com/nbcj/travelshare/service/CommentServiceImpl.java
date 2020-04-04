package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.Comment;
import com.nbcj.travelshare.mapper.CommentMapper;

import javax.annotation.Resource;
import java.util.List;

public class CommentServiceImpl implements CommentService{
    @Resource
    CommentMapper commentMapper;

    @Override
    public void addComment(String content, String nickname, Integer uid, Integer tid) {
        commentMapper.addComment(content, nickname, uid, tid);
    }

    @Override
    public void deleteComment(Integer cmid) {
        commentMapper.deleteComment(cmid);
    }

    @Override
    public List<Comment> getComment(Integer tid, Integer start, Integer end) {
        return commentMapper.getComment(tid, start, end);
    }
}
