package cn.edu.scnu.entity;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    @Excel(name = "id", width = 20, orderNum = "1")
    private String movieId;
    @Excel(name = "电影名", width = 20, orderNum = "2")
    private String title;
    @Excel(name = "上映年份", width = 20, orderNum = "3")
    private String year;
    @Excel(name = "导演", width = 20, orderNum = "4")
    private String director;
    @Excel(name = "主演", width = 30, orderNum = "5")
    private String major;
    @Excel(name = "类型", width = 20, orderNum = "6")
    private String genre;
    @Excel(name = "地区", width = 20, orderNum = "7")
    private String region;
    @Excel(name = "热度", width = 20, orderNum = "8")
    private Double rating;
    @Excel(name = "观看次数", width = 20, orderNum = "9")
    private Integer viewCount;
    @Excel(name = "限制", width = 20, orderNum = "10")
    private String vipClass;
    @Excel(name = "图片", width = 20, orderNum = "11")
    private String pictures;
    @Excel(name = "描述", width = 50, orderNum = "12")
    private String description;
}
