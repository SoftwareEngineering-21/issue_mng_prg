package com.example.its.database.comment;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.CommentID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentDBService {
    private final CommentDBManager manager;

    public CommentID createCommentService(String text ,String reporterComment){
        CommentID commentID = new CommentID(manager.createCommentManager(text, reporterComment));
        return commentID;
    }

    // TODO read함수들은 comment java 형식 바뀌면 넣기

    public void updateCommentService(CommentID ID, String text){
        manager.updateCommentManager(ID.getID(), text);
    }
    
    public void deleteCommentService(CommentID ID){
        manager.deleteCommentManager(ID.getID());
    }
}
