package cn.edu.scnu.service;

import cn.edu.scnu.entity.Comment;
import cn.edu.scnu.mapper.CommentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CommentService extends ServiceImpl<CommentMapper, Comment> {
    @Autowired
    private CommentMapper commentMapper;

    public String addComment(Comment comment) {
        comment.setEmail(comment.getEmail());
        comment.setMovieId(comment.getMovieId());
        comment.setContent(comment.getContent());
        commentMapper.insert(comment);
        return "success";
    }

    public String deleteComment(Comment comment) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",comment.getId());
        Comment _comment = commentMapper.selectOne(queryWrapper);
        if (_comment==null){
            return "fail";
        }else{
            commentMapper.deleteById(_comment.getId());
            return "success";
        }
    }

    public List<Comment> showComment(String movieId) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("movie_id",movieId);
        List<Comment> commentList = commentMapper.selectList(queryWrapper);
//        按时间排序
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o2.getSubmitDate().compareTo(o1.getSubmitDate());
            }
        });
        return commentList;
    }
}
