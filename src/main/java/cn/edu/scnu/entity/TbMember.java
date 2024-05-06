package cn.edu.scnu.entity;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="tb_member")
public class TbMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    @Excel(name = "邮箱", width = 20, orderNum = "1")
    private String email;
    @Excel(name = "密码", width = 50, orderNum = "2")
    private String password;
    @Excel(name = "电话", width = 20, orderNum = "3")
    private String mobile;
    @Excel(name = "会员", width = 20, orderNum = "4")
    private boolean vip;
}
