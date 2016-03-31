public class Project {

    private String name;
    private String description;
    private String supervisor;
    private Member[] members;
	ArrayList<Member> m=new ArrayList();
    
    public void addMember(Member member){
            m.add(member);
    }
    public void removeMember(int a){
        m.remove(a);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Member[] getMembers() {
        return members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }
}
