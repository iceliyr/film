package cn.edu.scnu.service;

import cn.edu.scnu.util.MD5Util;
import cn.edu.scnu.entity.TbMember;
import cn.edu.scnu.mapper.MemberMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService extends ServiceImpl<MemberMapper, TbMember> {
    @Autowired
    private MemberMapper memberMapper;

    public void add(TbMember tbMember) {
        memberMapper.insert(tbMember);
    }

    public TbMember login(String email,String password) {
        // 进入数据库查询
        TbMember member=memberMapper.selectById(email);
        if(member.getPassword().equals(MD5Util.md5(password))) {
            return member;
        }else{
            return null;
        }
    }

    public TbMember findMemberById(String email) {
        return memberMapper.selectById(email);
    }

    public void updateMember(TbMember member) {
        memberMapper.updateById(member);
    }

    public List queryPage(Integer pageNo,Integer pageSize){
        Page<TbMember> page = new Page<TbMember>(pageNo,pageSize);
        QueryWrapper<TbMember> queryWrapper=new QueryWrapper<>();
        Page<TbMember> tbMemberPage = memberMapper.selectPage(page,queryWrapper);
        List<TbMember> list=tbMemberPage.getRecords();
        return list;
    }
}
