package cn.edu.scnu.mapper;

import cn.edu.scnu.entity.Movie;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface MovieMapper extends BaseMapper<Movie> {


}
