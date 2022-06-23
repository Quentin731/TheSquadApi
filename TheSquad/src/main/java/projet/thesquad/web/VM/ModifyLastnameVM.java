package projet.thesquad.web.VM;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ModifyLastnameVM {

    private final String newLastname;

    @JsonCreator
    public ModifyLastnameVM(String newLastname) {
        this.newLastname = newLastname;
    }

    public String getNewLastname() {
        return newLastname;
    }
}
