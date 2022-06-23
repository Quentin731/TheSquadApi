package projet.thesquad.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Member {

    private final int id;
    private final String firstname;
    private final String lastname;
    private final String pseudo;
    private final String password;
    private final Job job;

    @JsonCreator
    public Member(int id, String firstname, String lastname, String pseudo, String password, Job job) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pseudo = pseudo;
        this.password = password;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Job getJob() {
        return job;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }
}
