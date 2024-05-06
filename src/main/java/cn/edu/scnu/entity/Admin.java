package cn.edu.scnu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value="admin")
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private String adminId;
    private String password;
}
