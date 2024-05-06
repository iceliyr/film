package cn.edu.scnu.service;

import cn.edu.scnu.entity.Movie;
import cn.edu.scnu.mapper.MovieMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

@Service
public class MovieService extends ServiceImpl<MovieMapper, Movie> {
    @Autowired
    private MovieMapper movieMapper;


    // 查询所有电影
    public List<Movie> findAll(){
        return movieMapper.selectList(null);
    }

    // 统计数据库中电影的题材
    public List<String> findGenre() {
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct genre");
        List<Movie> movies = movieMapper.selectList(queryWrapper);
        List<String> movies1 = new ArrayList<>();
        for (Movie movie: movies){
            movies1.add(movie.getGenre());
        }
        return movies1;
    }

    // 统计数据库中电影的年份
    public List<String> findYear() {
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct year");
        List<Movie> movies = movieMapper.selectList(queryWrapper);
        List<String> movies1 = new ArrayList<>();
        for (Movie movie: movies){
            movies1.add(movie.getYear());
        }
        return movies1;
    }

    // 统计数据库中电影的地区
    public List<String> findRegion() {
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct region");
        List<Movie> movies = movieMapper.selectList(queryWrapper);
        List<String> movies1 = new ArrayList<>();
        for (Movie movie: movies){
            movies1.add(movie.getRegion());
        }
        return movies1;
    }

    // 统计数据库中电影的会员等级
    public List<String> findVipClass() {
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct vip_class");
        List<Movie> movies = movieMapper.selectList(queryWrapper);
        List<String> movies1 = new ArrayList<>();
        for (Movie movie: movies){
            movies1.add(movie.getVipClass());
        }
        return movies1;
    }

    // 分页查询电影
    public Map<String,Object> queryPage(String genre,
                                        String year,
                                        String region,
                                        String vipClass,
                                        Integer pageNo,
                                        Integer pageSize,
                                        String keyword,
                                        String order) {
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
        System.out.println("keyword:"+keyword);
        if(!"".equals(keyword) && keyword !=null) {
            queryWrapper.like("title", keyword)
                    .or().like("director", keyword).
                    or().like("major", keyword);
        }
        System.out.println("genre:"+genre);
        if(!"".equals(genre) && genre!=null)
            queryWrapper.like("genre",genre);
        if(!"".equals(year) && year!=null)
            queryWrapper.eq("year",year);
        if(!"".equals(region) && region!=null)
            queryWrapper.like("region",region);
        if(!"".equals(vipClass) && vipClass!=null)
            queryWrapper.eq("vip_class",vipClass);

        int count = movieMapper.selectCount(queryWrapper).intValue();
        if (order==null || "".equals(order)){
            order = "movie_id";
        }

        queryWrapper.orderByDesc(order);
        //构建分页对象（第一个参数是当前页数，第二个参数是每页条数
        Page<Movie> page = new Page<Movie>(pageNo,pageSize);
        Page<Movie> moviePage = movieMapper.selectPage(page,queryWrapper);
        Map<String,Object> map = new HashMap<>();
        map.put("count",count);
        map.put("recourds",page.getRecords());
        return map;
    }

    // 查询电影详情
    public Movie findMovieById(String movieid) {

        return movieMapper.selectById(movieid);
    }

    public void add(Movie movie){
        movieMapper.insert(movie);
    }

    public String uploadfile(MultipartFile file){
        // 1.判断后缀是否合法
        // 获取图名称，后缀名称
        // 截取后缀substring split (".png" ".jgp")
        String originName = file.getOriginalFilename();
        String extName = originName.substring(originName.lastIndexOf("."));
        if (!(extName.equalsIgnoreCase(".jpg") || extName.equalsIgnoreCase(".png")
                || extName.equalsIgnoreCase(".gif"))) {// 图片后缀不合法
            return "图片后缀不合法!";
        }
        // 判断木马(java的类判断是否是图片属性，也可以引入第三方jar包判断)
        try {
            BufferedImage bufImage = ImageIO.read(file.getInputStream());
            bufImage.getHeight();
            bufImage.getWidth();
        } catch (Exception e) {
            return "该文件不是图片！";
        }
        String dir="/static/pictures";
        File _file = new File(dir, originName);
        if (!_file.exists()) {
            _file.mkdirs();
        }

        // 上传文件
        try {
            file.transferTo(_file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "success";
    }

//    @CacheEvict(cacheNames = "movie")
//    public void delete(String movieid) {
//        movieMapper.deleteById(movieid);
//    }
//
//    @Cacheable(cacheNames = "movie")
//    public Movie findById(String movieid) {
//        return movieMapper.selectById(movieid);
//    }
//
//    @CachePut(cacheNames = "movie")
//    public void update(Movie movie) {
//        movieMapper.updateById(movie);
//    }


//    上传电影
//    public String savemovie(Mymovie mymovie) {
//        //1.创建movie对象
//        Movie movie = new Movie();
//        //生成UUID
//        String movieid = UUID.randomUUID().toString();
//        movie.setmovieid(movieid);
//        movie.setFname(mymovie.getFname());
//        movie.setMyclass(mymovie.getMyclass());
//        movie.setFclass(mymovie.getFclass());
//        movie.setFclass1(mymovie.getFclass1());
//        movie.setCailiao(mymovie.getCailiao());
//        movie.setBaozhuang(mymovie.getBaozhuang());
//        movie.setHuayu(mymovie.getHuayu());
//        movie.setShuoming(mymovie.getShuoming());
//        movie.setPrice(mymovie.getPrice());
//        movie.setYourprice(mymovie.getYourprice());
//        movie.setTejia(mymovie.getTejia());
//        movie.setSellednum(0);
//
//        // 2.生成多级路径
//        String imgurl = "";
//        //   /a/2/e/a/2/3/b/e/f
//        for (int i = 0; i < 8; i++) {
//            imgurl += "/"+Integer.toHexString(new Random().nextInt(16));
//        }
//        //获取resources文件夹路径
//        String realpath = System.getProperty("user.dir")+"/src/main/resources";
//
//        String dir = realpath + "/static/picture" + imgurl+"/";
//        System.out.println(dir);
//        //处理pictures
//        MultipartFile pictures = mymovie.getPictures();
//        String message ="";
//        if(!"".equals(pictures.getOriginalFilename())){
//            message = uploadfile(pictures,dir);
//            if(!"".equals(message)){
//                return message;
//            }else{
//                movie.setPictures(imgurl+"/"+pictures.getOriginalFilename());
//            }}
//        //处理picturem
//        MultipartFile picturem = mymovie.getPicturem();
//        if(!"".equals(picturem.getOriginalFilename())){
//            message = uploadfile(picturem,dir);
//            if(!"".equals(message)){
//                return message;
//            }else{
//                movie.setPicturem(imgurl+"/"+picturem.getOriginalFilename());
//            }}
//        //处理pictureb
//        MultipartFile pictureb = mymovie.getPictureb();
//        if(!"".equals(pictureb.getOriginalFilename())){
//            message = uploadfile(pictureb,dir);
//            if(!"".equals(message)){
//                return message;
//            }else{
//                movie.setPictureb(imgurl+"/"+pictureb.getOriginalFilename());
//            }}
//        //处理pictured
//        MultipartFile pictured = mymovie.getPictured();
//        if(!"".equals(pictured.getOriginalFilename())){
//            message = uploadfile(pictured,dir);
//            if(!"".equals(message)){
//                return message;
//            }else{
//                movie.setPictured(imgurl+"/"+pictured.getOriginalFilename());
//                System.out.println("数据库图片路径"+imgurl+pictured.getOriginalFilename());
//            }}
//        //处理bzpicture
//        MultipartFile bzpicture = mymovie.getBzpicture();
//        if(!"".equals(bzpicture.getOriginalFilename())){
//            message = uploadfile(bzpicture,dir);
//            if(!"".equals(message)){
//                return message;
//            }else{
//                movie.setBzpicture(imgurl+"/"+bzpicture.getOriginalFilename());
//            }}
//        //处理cailiaopicture
//        MultipartFile cailiaopicture = mymovie.getCailiaopicture();
//        if(!"".equals(cailiaopicture.getOriginalFilename())){
//            message = uploadfile(cailiaopicture,dir);
//            if(!"".equals(message)){
//                return message;
//            }else{
//                movie.setCailiaopicture(imgurl+"/"+cailiaopicture.getOriginalFilename());
//            }}
//
//        movieMapper.insert(movie);
//
//        return "商品添加成功";
//    }
}
