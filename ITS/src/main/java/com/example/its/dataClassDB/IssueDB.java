public class IssueDB {
    private int id;
    private String title;
    private String description;
    private String reporter;
    private String assignee;
    private String fixer;
    private int type;
    private int priority;
    private int status;
    private String date;

    public static class Builder
    {
        // 필수 매개변수
        private int id;
        private String title;
        private String description;
        private String reporter;
        private int type;
        private int priority;
        private int status;
        private String date;

        //선택 매개변수
        private String assignee = null;
        private String fixer = null;

        public Builder assignee(String assignee)
        {
            this.assignee = assignee;
            return this;
        }

        public Builder fixer(String fixer)
        {
            this.fixer = fixer;
            return this;
        }

        public IssueDB build()
        {
            return new IssueDB(this):
        }
    }

    private IssueDB(Builder Builder)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.reporter = reporter;
        this.type = type;
        this.priority = priority;
        this.status = status;
        this.date = date;
    }

    public int readId() {return this.id}
    public String readTitle() {return this.title}
    public String readDesription() {return this.description}
    public String readReporter() {return this.reporter}
    public String readAssignee() {return this.assignee}
    public String readFixer() {return this.fixer}
    public int readType() {return this.type}
    public int readPriority() {return this.priority}
    public int readstatus() {return this.status}
    public String readDate() {return this.date}
    public void updateId(int id) {this.id=id;}
    public void updateTitle(String title) {this.title=title;}
    public void updateDescription(String description) {this.description=description;}
    public void updateReporter(String reporter) {this.reporter=reporter;}
    public void updateAssignee(String assignee) {this.assignee=assignee;}
    public void updateFixer(String fixer) {this.fixer=fixer;}
    public void updateType(int type) {this.type=type;}
    public void updatePriority(int priority) {this.priority=priority;}
    public void updateStatus(int status) {this.status=status;}
    public void updateType(String date) {this.date=date;}
}
