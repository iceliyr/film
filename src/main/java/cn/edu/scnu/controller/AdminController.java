package cn.edu.scnu.controller;

import cn.edu.scnu.entity.Admin;
import cn.edu.scnu.entity.Movie;
import cn.edu.scnu.entity.TbMember;
import cn.edu.scnu.service.AdminService;
import cn.edu.scnu.service.MemberService;
import cn.edu.scnu.service.MovieService;
import cn.edu.scnu.util.MyExcelExportUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//后台管理控制器
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MovieService movieService;

    @RequestMapping("/admin/toAdminLogin")
    public String toAdminLogin() {
        return "admin_login";
    }

    @RequestMapping("/admin/doAdminLogin")
    @ResponseBody
    public String doLogin(String id, String password, HttpSession session) {
        Admin admin = adminService.login(id, password);
        if (admin != null) {
            System.out.println(id + "：登录成功");
            admin.setPassword(""); // 防止密码泄露
            session.setAttribute("admin", admin);
            return "success";
        } else {
            System.out.println(id + "：登录失败");
            return "fail";
        }
    }

    @RequestMapping("/admin/user")
    public String user(@RequestParam(name="pageNo",defaultValue = "1")Integer pageNo,
                       @RequestParam(name="pageSize",defaultValue = "10")Integer pageSize,
                       HttpSession httpSession, Model model) {
        Admin admin=(Admin)httpSession.getAttribute("admin");
        if(admin==null){
            return "admin_login";
        }
        List<TbMember> members = memberService.queryPage(pageNo, pageSize);
        Integer count = memberService.list().size();
        int pageCount = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
        model.addAttribute("members", members);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("currentPage",pageNo);
        return "admin_user";
    }



    @RequestMapping("/admin/film")
    public String film(@RequestParam(name="pageNo",defaultValue = "1")Integer pageNo,
                        @RequestParam(name="pageSize",defaultValue = "10")Integer pageSize, //每页展示10条数据
                        Model model,HttpSession httpSession){
        Admin admin=(Admin)httpSession.getAttribute("admin");
        if(admin==null){
            return "admin_login";
        }
        Map<String,Object> map = movieService.queryPage(null,null,null,null,pageNo,pageSize,null,null);
        Integer count = (Integer) map.get("count");
        List<Movie> movielist = (List<Movie>) map.get("recourds");
        int pageCount = (count%pageSize==0)?(count/pageSize):(count/pageSize + 1);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("movielist",movielist);

        return "admin_film";
    }

    @RequestMapping("/admin/toAdminLogout")
    public String logOut( HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/index";
    }

    @RequestMapping("/admin/excel")
    public void exel(String type,HttpServletResponse response,HttpSession httpSession) {
        Admin admin=(Admin)httpSession.getAttribute("admin");
        if(admin==null){
            return;
        }
        if(type.equals("user")) {
            try {
                List<TbMember> tbMembers = memberService.list();
                MyExcelExportUtil.exportExcel(tbMembers, TbMember.class, "用户信息", "", response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                List<Movie> movies=movieService.list();
                MyExcelExportUtil.exportExcel(movies, Movie.class, "电影信息", "", response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/admin/echarts")
    public String echarts(Integer type, ModelMap modelMap){
        List<Movie> movies=movieService.list();
        String[] arr={"中国大陆", "中国香港", "中国台湾", "日本", "韩国", "美国", "英国", "法国", "德国", "意大利", "西班牙", "印度", "泰国", "俄罗斯", "加拿大", "澳大利亚", "巴西", "丹麦"};
        int[] nums=new int[arr.length];

        for(Movie movie:movies){
           for(int i=0; i<arr.length; i++){
               if(movie.getRegion().contains(arr[i])){
                   nums[i]++;
               }
           }
        }
       for(int i=0; i<arr.length; i++){
           System.out.println(arr[i]);
           System.out.println(nums[i]);
       }
        modelMap.put("data1Json",arr);
        modelMap.put("data2Json",nums);

        if(type==1){
            return "admin_bar_charts";
        }else {
            return "admin_line_charts";
        }

    }

    @RequestMapping("/admin/addMovie")
    public String addMovie(HttpSession httpSession){
        Admin admin=(Admin)httpSession.getAttribute("admin");
        if(admin==null){
            return "admin_login";
        }
        return "admin_add_movie";
    }

}

