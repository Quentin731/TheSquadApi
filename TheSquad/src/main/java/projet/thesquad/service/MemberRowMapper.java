package projet.thesquad.service;

import org.springframework.jdbc.core.RowMapper;
import projet.thesquad.domain.Job;
import projet.thesquad.domain.Member;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<Member> {

    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        int jobIntValue = rs.getInt("job");

        Job jobStringValue = switch (jobIntValue) {
            case 1 -> Job.BACKEND;
            case 2 -> Job.FRONTEND;
            case 3 -> Job.FULLSTACK;
            case 4 -> Job.MANAGER;
            case 5 -> Job.PO;
            case 6 -> Job.TESTEUR;
            default -> null;
        };
        return new Member(
                rs.getInt("id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("pseudo"),
                rs.getString("password"),
                jobStringValue
        );
    }
}
