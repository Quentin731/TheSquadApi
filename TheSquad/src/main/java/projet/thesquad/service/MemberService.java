package projet.thesquad.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projet.thesquad.domain.Member;
import projet.thesquad.repository.MemberRepository;
import projet.thesquad.web.VM.MemberVM;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public int addMember (Member member) throws Exception {
        if (member != null) {
            try {
                MemberVM memberVM = mapMemberToMemberVM(member);
                return memberRepository.addMember(memberVM);
            } catch (Exception e) {
                throw new Exception("Erreur lors de l'ajout du membre." + e);
            }
        } else {
            throw new NullPointerException("Add member is impossible because member is null.");
        }
    }

    public MemberVM getMemberById(int id) throws Exception {
        try {
            Member member = memberRepository.getMemberById(id);
            return mapMemberToMemberVM(member);
        } catch (Exception e) {
            throw new Exception("This member id doesn't exist in database.");
        }
    }

    public List<MemberVM> getAllMembers() throws Exception {
        try {
            List<Member> members = memberRepository.getAllMembers();
            List<MemberVM> memberVMList = new ArrayList<>();
            for (Member member : members) {
                memberVMList.add(mapMemberToMemberVM(member));
            }
            return memberVMList;
        } catch (Exception e) {
            throw new Exception("Error during recuperation of all members.");
        }
    }

    public int deleteMemberById(int id) throws Exception {
        try {
            return memberRepository.deleteMemberById(id);
        } catch (Exception e) {
            throw new Exception("Error during delete of member.");
        }
    }

    public int updateMemberJob(int id, int jobIntValue) throws Exception {
        try {
            return memberRepository.modifyMemberJob(id, jobIntValue);
        } catch (Exception e) {
            throw new Exception("Error during update of job.");
        }
    }

    public int updateMemberFirstname(int id, String newFirstName) throws Exception {
        try {
            return memberRepository.modifyMemberFirstname(id, newFirstName);
        } catch (Exception e) {
            throw new Exception("Error during update of firstname.");
        }
    }

    public int updateMemberLastname(int id, String newLastname) throws Exception {
        try {
            return memberRepository.modifyLastname(id, newLastname);
        } catch (Exception e) {
            throw new Exception("Error during update of firstname.");
        }
    }

    private MemberVM mapMemberToMemberVM(Member member) {
        if (member != null) {
            return new MemberVM(
                    member.getFirstname(),
                    member.getLastname(),
                    member.getPseudo(),
                    encoder().encode(member.getPassword()),
                    member.getJob().value
            );
        } else {
            throw new NullPointerException("Map member to memberVM is impossible because member is null.");
        }
    }
}
