package projet.thesquad.web.VM;

import com.fasterxml.jackson.annotation.JsonCreator;

public class MemberVM {

    private final String firstname;
    private final String lastname;
    private final String pseudo;
    private final String password;
    private final int job;

    @JsonCreator
    public MemberVM(String firstname, String lastname, String pseudo, String password, int job) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pseudo = pseudo;
        this.password = password;
        this.job = job;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getJob() {
        return job;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }
}
