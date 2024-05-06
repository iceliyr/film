package cn.edu.scnu.mapper;

import cn.edu.scnu.entity.TbMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper extends BaseMapper<TbMember> {


}
