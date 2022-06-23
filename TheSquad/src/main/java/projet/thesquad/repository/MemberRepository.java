package projet.thesquad.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import projet.thesquad.domain.Member;
import projet.thesquad.service.MemberRowMapper;
import projet.thesquad.web.VM.MemberVM;

import java.util.List;

@Repository
public class MemberRepository {

    private final String ADD_MEMBER_REQUEST = "INSERT INTO TheSquad.Member (firstname, lastname, pseudo, password, job) VALUES (?, ?, ?, ?, ?)";
    private final String GET_MEMBER_BY_ID = "SELECT * FROM TheSquad.Member WHERE id = ?";
    private final String GET_ALL_MEMBERS = "SELECT * FROM TheSquad.Member";
    private final String DELETE_MEMBER = "DELETE FROM TheSquad.Member WHERE id = ?";
    private final String UPDATE_JOB = "UPDATE TheSquad.Member SET job = ? WHERE id = ?";
    private final String UPDATE_FIRSTNAME = "UPDATE TheSquad.Member SET firstname = ? WHERE id = ?";
    private final String UPDATE_LASTNAME = "UPDATE TheSquad.Member SET lastname = ? WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addMember(MemberVM member) {
        return jdbcTemplate.update(
                ADD_MEMBER_REQUEST,
                member.getFirstname(),
                member.getLastname(),
                member.getPseudo(),
                member.getPassword(),
                member.getJob());
    }

    public Member getMemberById(int id) {
        return jdbcTemplate.queryForObject(
                GET_MEMBER_BY_ID,
                new Object[]{id}, new MemberRowMapper());
    }

    public List<Member> getAllMembers() {
        return jdbcTemplate.query(
                GET_ALL_MEMBERS, new MemberRowMapper());
    }

    public int deleteMemberById(int id) {
        return jdbcTemplate.update(DELETE_MEMBER, id);
    }

    public int modifyMemberJob(int id, int jobIntValue) {
        return jdbcTemplate.update(
                UPDATE_JOB, jobIntValue, id);
    }

    public int modifyMemberFirstname(int id, String newFirstname) {
        return jdbcTemplate.update(
                UPDATE_FIRSTNAME, newFirstname, id);
    }

    public int modifyLastname(int id, String newLastname) {
        return jdbcTemplate.update(
                UPDATE_LASTNAME, newLastname, id);
    }
}
