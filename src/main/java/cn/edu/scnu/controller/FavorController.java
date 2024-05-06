package cn.edu.scnu.controller;

import cn.edu.scnu.entity.Favor;
import cn.edu.scnu.entity.Movie;
import cn.edu.scnu.entity.TbMember;
import cn.edu.scnu.service.FavorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FavorController {
    @Autowired(required = false)
    private FavorService favorService;

    @RequestMapping("/favor/addFavor")
    @ResponseBody
    public String addFavor(String movieId, HttpSession session){
        TbMember member = (TbMember)session.getAttribute("memberLogin");
        Favor favor = new Favor();
        favor.setEmail(member.getEmail());
        favor.setMovieId(movieId);
        return favorService.addFavor(favor);
    }

    @RequestMapping("/favor/checkFavor")
    @ResponseBody
    public String checkFavor(String movieId, HttpSession session){
        TbMember member = (TbMember)session.getAttribute("memberLogin");
        Favor favor = new Favor();
        favor.setEmail(member.getEmail());
        favor.setMovieId(movieId);
        return favorService.checkFavor(favor);
    }

    @RequestMapping("/favor/showFavor")
    public String showFavor(Model model,HttpSession session){
        TbMember member=(TbMember)session.getAttribute("memberLogin");
        List<Movie> favors = favorService.showFavor(member.getEmail());
        model.addAttribute("favors", favors);
        return "showfavor";
    }


    @RequestMapping("/favor/deleteFavor")
    public String deleteFavor(Integer favorId){
        favorService.removeById(favorId);
        return "redirect:/favor/showFavor";
    }

    @RequestMapping("/favor/clearFavor")
    public String clearFavor(HttpSession session){
        TbMember member=(TbMember)session.getAttribute("memberLogin");
        favorService.clearFavor(member.getEmail());
        return "redirect:/favor/showFavor";
    }
}
