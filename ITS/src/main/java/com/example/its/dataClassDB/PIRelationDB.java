package com.example.its.dataClassDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PIRelationDB {
    private int ID;
    private int projectIDFK;
    private int issueIDFK;

    public PIRelationDB(int projectIDFK, int issueIDFK)
    {
        this.projectIDFK = projectIDFK;
        this.issueIDFK = issueIDFK;
    }

}
