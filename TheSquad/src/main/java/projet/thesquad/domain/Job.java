package projet.thesquad.domain;

public enum Job {
    BACKEND (1),
    FRONTEND (2),
    FULLSTACK (3),
    MANAGER (4),
    PO (5),
    TESTEUR (6);

    public final int value;

    Job(int value) {
        this.value = value;
    }
}
