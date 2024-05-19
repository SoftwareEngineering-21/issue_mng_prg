package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PIRelationDB {
    private int projectID;
    private int issueID;

    public PIRelationDB(int projectID, int issueID)
    {
        this.projectID = projectID;
        this.issueID = issueID;
    }

}
