public class ProjectDetailDB {
    private int id;
    private String title;
    private String description;
    private String adminId;

    public ProjectDetailDB(int id, String title, String description, String adminId)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.adminId = adminId
    }

    public int readId() {return this.id}
    public String readTitle() {return this.title}
    public String readDescription() {return this.description}
    public String readAdminId() {return this.adminId}

    public void updateId(int id) {this.id=id;}
    public void updatePw(String title) {this.title=title;}
    public void updateDescription(String description) {this.description=description;}
    public void updatePw(String adminId) {this.adminId=ad;}
    
}
