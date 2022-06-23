package projet.thesquad.web.VM;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ModifyFirstnameVM {

    private final String newFistname;

    @JsonCreator
    public ModifyFirstnameVM(String newFistname) {
        this.newFistname = newFistname;
    }

    public String getNewFistname() {
        return newFistname;
    }
}
