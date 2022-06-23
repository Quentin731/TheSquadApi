package projet.thesquad.web.VM;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ModifyJobVM {

    private final int intJobValue;

    @JsonCreator
    public ModifyJobVM(int intJobValue) {
        this.intJobValue = intJobValue;
    }

    public int getIntJobValue() {
        return intJobValue;
    }
}
