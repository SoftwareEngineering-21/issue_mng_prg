package com.example.its.swingUI;

import java.util.ArrayList;

import com.example.its.dataClass.Issue;

public class TestProjCon extends ProjSceneController {
    ArrayList<Issue> issueList = new ArrayList<>();

    TestProjCon(BaseController baseCon) {
        super(baseCon);
    }
    
    public Issue[] getIssueList(){
        if(issueList == null){
            return null;
        }

        return issueList.toArray(new Issue[issueList.size()]);
    }
}
