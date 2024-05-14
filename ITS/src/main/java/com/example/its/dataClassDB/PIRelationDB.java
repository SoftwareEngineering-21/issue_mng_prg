public class PIRelationDB {
    private int projectId;
    private int issueId;

    public PIRelationDB(int projectId, int issueId)
    {
        this.projectId = projectId;
        this.issueId = issueId;
    }

    public int readProjectId() {return this.projectId}
    public int readIssueId() {return this.issueId}
    public void updateProjectId(int projectId) {this.projectId=projectId}
    public void updateIssueId(int issueId) {this.issueId=issueId}
}
