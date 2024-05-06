package cn.edu.scnu.controller;

import cn.edu.scnu.entity.Comment;
import cn.edu.scnu.entity.TbMember;
import cn.edu.scnu.service.CommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/addComment")
    @ResponseBody
    public String addComment(String movieId,String content, HttpSession session){
        if (content==null||content.equals("")){
            return "内容为空";
        }
        TbMember member = (TbMember)session.getAttribute("memberLogin");
        Comment comment = new Comment();
        comment.setEmail(member.getEmail());
        comment.setMovieId(movieId);
        comment.setContent(content);
        return commentService.addComment(comment);
    }

    @RequestMapping("/deleteComment")
    @ResponseBody
    public String delete(String id) {
        Comment comment = new Comment();
        comment.setId(Integer.valueOf(id));
        return commentService.deleteComment(comment);
    }

    @RequestMapping("/showComment")
    public String showComment(String movieId, Model model){
        List<Comment> commentList = commentService.showComment(movieId);
        System.out.println("commentList:"+commentList);
        model.addAttribute("commentList",commentList);
        return "redirect:/index/movieDetail?movieId="+movieId;
    }
}
