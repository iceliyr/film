package cn.edu.scnu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Comment {
    @TableId
    private Integer id;
    private String email;
    private String movieId;
    private String content;
    private String submitDate;
}
