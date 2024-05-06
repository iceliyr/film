package cn.edu.scnu.controller;

import cn.edu.scnu.entity.TbMember;
import cn.edu.scnu.service.MemberService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteMember(String email) {
        System.out.println("email: "+email);
        QueryWrapper<TbMember> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("email",email);
        memberService.remove(queryWrapper);
        return "success";
    }

}
