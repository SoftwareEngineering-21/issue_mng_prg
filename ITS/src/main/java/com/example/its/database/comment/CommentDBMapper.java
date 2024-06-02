package com.example.its.database.comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.its.dataClassDB.CommentDB;

@Mapper
public interface CommentDBMapper {
    Integer createComment(@Param("comment") CommentDB comment);
    Integer createCommentTime(@Param("comment") CommentDB comment);
    CommentDB readComment(int ID);
    List<CommentDB> readCommentList(int IssueID);
    void updateComment(@Param("ID") int ID, @Param("text") String text);
    void deleteComment(int ID);
    
}
