package cn.edu.scnu.service;

import cn.edu.scnu.entity.Favor;
import cn.edu.scnu.entity.Movie;
import cn.edu.scnu.mapper.FavorMapper;
import cn.edu.scnu.mapper.MovieMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavorService extends ServiceImpl<FavorMapper, Favor>{
    @Autowired
    private FavorMapper favorMapper;

    @Autowired
    private MovieMapper movieMapper;

    public String addFavor(Favor favor) {
        QueryWrapper<Favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",favor.getEmail());
        queryWrapper.eq("movie_id",favor.getMovieId());
        Favor _favor = favorMapper.selectOne(queryWrapper);
        if (_favor==null){
            favor.setEmail(favor.getEmail());
            favor.setMovieId(favor.getMovieId());
            favorMapper.insert(favor);
            return "add";
        }else{
            favorMapper.deleteById(_favor.getId());
            return "cancel";
        }
    }

    public List<Movie> showFavor(String email) {
        QueryWrapper<Favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",email);
        List<Favor> favors = favorMapper.selectList(queryWrapper);
        List<String> movieIds = new ArrayList<>();
        for (Favor favor : favors) {
            movieIds.add(String.valueOf(favor.getMovieId()));
        }
        List<Movie> movies = movieMapper.selectBatchIds(movieIds);
        return movies;
    }

    public void clearFavor(String email) {
        QueryWrapper<Favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",email);
        favorMapper.delete(queryWrapper);
    }

    public String checkFavor(Favor favor) {
        QueryWrapper<Favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",favor.getEmail());
        queryWrapper.eq("movie_id",favor.getMovieId());
        Favor _favor = favorMapper.selectOne(queryWrapper);
        if (_favor==null){
            return "no";
        }else{
            return "yes";
        }
    }
}
