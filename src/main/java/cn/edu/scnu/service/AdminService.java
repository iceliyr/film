package cn.edu.scnu.service;

import cn.edu.scnu.entity.Admin;
import cn.edu.scnu.mapper.AdminMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends ServiceImpl<AdminMapper, Admin> {
    @Autowired
    private AdminMapper adminMapper;

    public Admin login(String adminId, String password){
        Admin admin=adminMapper.selectById(adminId);
        if(password.equals(password)){
            return admin;
        }else {
            return null;
        }
    }


}
