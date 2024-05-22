package com.example.its.dataClassDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PIRelationDB {
    private int ID;
    private int projectID;
    private int issueID;

    public PIRelationDB(int projectID, int issueID)
    {
        this.projectID = projectID;
        this.issueID = issueID;
    }

}
