package com.example.its.logic;

import com.example.its.dataClass.Comment;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.UserID;
import com.example.its.database.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final DBService service;

    public List<Comment> readCommentsByIssueID(IssueID issueId) {
        return service.readCommentList(issueId);
    }

    public void createComment(UserID userID, IssueID issueID, String desc, Date date) {
        service.createComment(issueID, desc, userID, date);
    }

    public Date getCurrentDate() {
        return new Date();
    }
}
