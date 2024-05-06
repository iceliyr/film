package cn.edu.scnu.entity;
import lombok.Data;
@Data
public class MyMovie {
    private String movieId;
    private String title;
    private String year;
    private String director;
    private String major;
    private String genre;
    private String region;
    private Double rating;
    private Integer viewCount;
    private String vipClass;
    private String pictures;
    private String description;
}
