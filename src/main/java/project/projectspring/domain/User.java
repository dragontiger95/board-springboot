package project.projectspring.domain;

public class User {
    
    // sequence
    private Long id;

    private String pw;

    // 중복 가능
    private String name;

    // 중복 불가
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
