package cn.edu.scnu.controller;

import cn.edu.scnu.entity.Movie;
import cn.edu.scnu.entity.TbMember;
import cn.edu.scnu.service.MemberService;
import cn.edu.scnu.service.MovieService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileFilter;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping("/delete")
    public String delete(String movieId) {
        System.out.println("id: "+movieId);
        QueryWrapper<Movie> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("movie_id",movieId);
        movieService.remove(queryWrapper);
        return "success";
    }



    @RequestMapping("/addImage")
    public String addImage(MultipartFile image){
        movieService.uploadfile(image);
        return "success";
    }

    @RequestMapping("/add")
    public String add(Movie movie){
        movieService.add(movie);
        return "success";
    }


    @RequestMapping("/update")
    public String update(Movie movie){
        movieService.add(movie);
        return "success";
    }

}
