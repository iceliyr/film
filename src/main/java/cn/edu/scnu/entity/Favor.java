package cn.edu.scnu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Favor {
    private static final long serialVersionUID = 1L;
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String email;
    private String movieId;
}
