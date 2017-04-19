package com.bs.poetry.controller;

import com.bs.poetry.common.Pager;
import com.bs.poetry.entity.Poetry;
import com.bs.poetry.service.PoetryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ben on 2017/4/16.
 */
@Controller
public class IndexController {

    @Resource
    private PoetryService poetryService;
    @Resource
    private HttpServletRequest request;

    private int currentPage =1;

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 根据诗人名字搜索
     * @param search
     * @return
     */
    @RequestMapping("/byPoetName")
    public String searchByPoetName(@RequestParam String search){
        String currentPageString = request.getParameter("currentPage");
        if (currentPageString != null){
            currentPage = Integer.parseInt(currentPageString);
        }
        int totalSize = poetryService.getTotalByPoetName(search);
        Pager pager = new Pager(currentPage,totalSize);
        List<Poetry> poetries = poetryService.searchByPoetNamePaging(search,currentPage,pager.getPageSize());

        //页面类型
        request.setAttribute("type","poet");

        request.setAttribute("poetName",search);
        request.setAttribute("total",totalSize);
        request.setAttribute("pager",pager);
        request.setAttribute("poetries",poetries);

        return "poetries";
    }

    /**
     * 根据诗名分页查询
     * @param search
     * @return
     */
    @RequestMapping("/byTitle")
    public String searchByTitle(@RequestParam String search){
        String currentPageString = request.getParameter("currentPage");
        if (currentPageString != null){
            currentPage = Integer.parseInt(currentPageString);
        }
        int totalSize = poetryService.getTotalByTitle(search);
        Pager pager = new Pager(currentPage,totalSize);
        List<Poetry> poetries = poetryService.searchByTitlePaging(search,currentPage,pager.getPageSize());

        //页面类型
        request.setAttribute("type","title");

        request.setAttribute("title",search);
        request.setAttribute("total",totalSize);
        request.setAttribute("pager",pager);
        request.setAttribute("poetries",poetries);

        return "poetries";
    }

    @RequestMapping("/byContent")
    public String searchByContent(@RequestParam String search){
        String currentPageString = request.getParameter("currentPage");
        if (currentPageString != null){
            currentPage = Integer.parseInt(currentPageString);
        }
        int totalSize = poetryService.getTotalByContent(search);
        Pager pager = new Pager(currentPage,totalSize);
        List<Poetry> poetries = poetryService.searchByContentPaging(search,currentPage,pager.getPageSize());

        //页面类型
        request.setAttribute("type","content");

        request.setAttribute("content",search);
        request.setAttribute("total",totalSize);
        request.setAttribute("pager",pager);
        request.setAttribute("poetries",poetries);

        return "poetries";
    }

    @RequestMapping("/getById")
    public String getPoetryById(@RequestParam int id){
        Poetry poetry = poetryService.getByPoetryId(id);

        request.setAttribute("poetry",poetry);

        return "poetry";
    }



//    ----------------------------get set-----------------------------

    public PoetryService getPoetryService() {
        return poetryService;
    }

    public void setPoetryService(PoetryService poetryService) {
        this.poetryService = poetryService;
    }
}
