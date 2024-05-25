package com.example.its.database.comment;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.CommentDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentDBManager {
    private final CommentDBMapper mapper;

    public Integer createCommentManager(String text ,String reporterComment){
        CommentDB comment = new CommentDB(text, reporterComment);
        mapper.createComment(comment);
        return comment.getID();
    }

    public CommentDB readCommentManager(int ID){
        return mapper.readComment(ID);
    }

    public List<CommentDB> readCommentListManager(int IssueID){
        return mapper.readCommentList(IssueID);
    }

    public void updateCommentManager(int ID, String text){
        mapper.updateComment(ID, text);
    }
    
    public void deleteCommentManager(int ID){
        mapper.deleteComment(ID);
    }
}
