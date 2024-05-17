public class AuthorityDB {
    private String userId;
    private int projectId;
    private int auth;

    public AuthorityDB(String userId, int projectId, int auth)
    {
        this.userId = userId;
        this.private = projectId;
        this.auth = auth;
    }

    public String readUserId() {return this.userId}
    public int readProjectId() {return this.projectId}
    public int readAuth() {return this.auth}
    public void updateUserId(String userId){this.userId = userId}
    public void updateProjectId(int projectId){this.projectId = projectId}
    public void updateAuth(String auth){this.auth = auth}
}
