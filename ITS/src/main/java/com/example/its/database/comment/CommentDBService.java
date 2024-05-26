package com.example.its.database.comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.Comment;
import com.example.its.dataClass.CommentID;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.UserID;
import com.example.its.dataClassDB.CommentDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentDBService {
    private final CommentDBManager manager;

    private Comment CDBtoComment(CommentDB cdb){
        Comment newC = new Comment(new CommentID(cdb.getID()), cdb.getText(), cdb.getCreatedAt(), new UserID(cdb.getReporterComment()));
        return newC;
    }

    public CommentID createCommentService(String text ,UserID reporterComment){
        CommentID commentID = new CommentID(manager.createCommentManager(text, reporterComment.getID()));
        return commentID;
    }


    // 이후에 안쓰이면 지우기
    public Comment readCommentService(CommentID commentID){
        CommentDB cdb = manager.readCommentManager(commentID.getID());
        Comment c = CDBtoComment(cdb);
        return c;
    }


    public List<Comment> readCommentListService(IssueID issueID){
        List<CommentDB> cList = manager.readCommentListManager(issueID.getID());
        List<Comment> comments = new ArrayList<>();
        for (CommentDB cdb : cList){
            comments.add(CDBtoComment(cdb));
        }
        return comments;

    }

    public void updateCommentService(CommentID ID, String text){
        manager.updateCommentManager(ID.getID(), text);
    }
    
    public void deleteCommentService(CommentID ID){
        manager.deleteCommentManager(ID.getID());
    }
}
