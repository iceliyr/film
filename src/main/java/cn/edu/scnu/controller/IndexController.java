package cn.edu.scnu.controller;

import cn.edu.scnu.util.MD5Util;
import cn.edu.scnu.entity.Comment;
import cn.edu.scnu.entity.Movie;
import cn.edu.scnu.entity.TbMember;
import cn.edu.scnu.service.CommentService;
import cn.edu.scnu.service.MovieService;
import cn.edu.scnu.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("")
    public String index_first(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(@RequestParam(name="pageNo",defaultValue = "1")Integer pageNo,
                        @RequestParam(name="pageSize",defaultValue = "10")Integer pageSize, //每页展示10条数据
                        String genre,
                        String year,
                        String region,
                        String vipClass,
                        String keyword,
                        String order,
                        Model model){
        Map<String,Object> map = movieService.queryPage(genre,year,region,vipClass,pageNo,pageSize,keyword,order);
        Integer count = (Integer) map.get("count");
        List<Movie> movielist = (List<Movie>) map.get("recourds");
        int pageCount = (count%pageSize==0)?(count/pageSize):(count/pageSize + 1);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("currentPage",pageNo);

        model.addAttribute("title",keyword);
        model.addAttribute("director",keyword);
        model.addAttribute("major",keyword);

        model.addAttribute("genre",genre);
        model.addAttribute("year",year);
        model.addAttribute("region",region);
        model.addAttribute("vip_class",vipClass);

        model.addAttribute("movielist",movielist);
        model.addAttribute("moviesByGenre",movieService.findGenre());
        model.addAttribute("moviesByYear",movieService.findYear());
        model.addAttribute("moviesByRegion",movieService.findRegion());
        model.addAttribute("moviesByVipClass",movieService.findVipClass());

        return "index";
    }



    @RequestMapping("index/movieDetail")
    public String movieDetail(String movieId, Model model){
        Movie movie = movieService.findMovieById(movieId);
        List<Comment> commentList = commentService.showComment(movieId);
        model.addAttribute("movie",movie);
        model.addAttribute("commentList",commentList);
        return "moviedetail";
    }

    @RequestMapping("index/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/index/doLogin")
    @ResponseBody
    public String doLogin(String email, String password, HttpSession session) {
        TbMember member = memberService.login(email, password);
        member.setPassword(""); // 防止密码泄露
        if (member != null) {
            session.setAttribute("memberLogin", member);
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/index/logOut")
    public String logOut( HttpSession session){
        session.removeAttribute("memberLogin");
        return "redirect:/index";
    }

    @RequestMapping("/index/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/index/doRegister")
    @ResponseBody
    public String doRegister(String email, String passw1){
        TbMember member = memberService.findMemberById(email);
        if(member!=null){
            return "用户名已存在";
        } else{
            TbMember member1 = new TbMember();
            member1.setEmail(email);
            passw1 = MD5Util.md5(passw1); // MD5加密
            member1.setPassword(passw1);
            memberService.add(member1);
            return "success";
        }
    }

    @RequestMapping("/index/submitVip")
    @ResponseBody
    public String submitVip(String email, HttpSession session){
        TbMember member = memberService.findMemberById(email);
        if (member.isVip()){
            member.setVip(false);
            memberService.updateMember(member);
            session.setAttribute("memberLogin", member);
            return "cancel";
        } else{
            member.setVip(true);
            memberService.updateMember(member);
            session.setAttribute("memberLogin", member);
            return "success";
        }
    }
}
