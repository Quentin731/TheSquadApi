package projet.thesquad.web;

import org.springframework.web.bind.annotation.*;
import projet.thesquad.domain.Member;
import projet.thesquad.service.MemberService;
import projet.thesquad.web.VM.MemberVM;
import projet.thesquad.web.VM.ModifyFirstnameVM;
import projet.thesquad.web.VM.ModifyJobVM;
import projet.thesquad.web.VM.ModifyLastnameVM;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member/add")
    public int addMember (@RequestBody Member payload) throws Exception {
        return memberService.addMember(payload);
    }

    @GetMapping("/member/{id}")
    public MemberVM getMemberById(@PathVariable int id) throws Exception {
        return memberService.getMemberById(id);
    }

    @GetMapping("/member/all")
    public List<MemberVM> getAllMembers() throws Exception {
        return memberService.getAllMembers();
    }

    @PostMapping("/member/delete/{id}")
    public int deleteMemberById(@PathVariable int id) throws Exception {
        return memberService.deleteMemberById(id);
    }

    @PostMapping("/member/modify-job/{id}")
    public int modifyMemberJob(@PathVariable int id, @RequestBody ModifyJobVM payload) throws Exception {
        return memberService.updateMemberJob(id, payload.getIntJobValue());
    }

    @PostMapping("/member/modify-firstname/{id}")
    public int modifyMemberFirstname(@PathVariable int id, @RequestBody ModifyFirstnameVM payload) throws Exception {
        return memberService.updateMemberFirstname(id, payload.getNewFistname());
    }

    @PostMapping("/member/modify-lastname/{id}")
    public int modifyMemberLastname(@PathVariable int id, @RequestBody ModifyLastnameVM payload) throws Exception {
        return memberService.updateMemberLastname(id, payload.getNewLastname());
    }
}
