package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PIRelationDB {
    private int projectId;
    private int issueId;

    public PIRelationDB(int projectId, int issueId)
    {
        this.projectId = projectId;
        this.issueId = issueId;
    }

}
