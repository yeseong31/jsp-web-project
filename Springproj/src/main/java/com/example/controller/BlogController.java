package com.example.controller;

import com.example.dto.CategoryDTO;
import com.example.dto.CommentDTO;
import com.example.dto.PostDTO;
import com.example.service.CategoryService;
import com.example.service.CommentService;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    PostService postService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CommentService commentService;

    @GetMapping("")
    public String blog_home(HttpServletRequest req, @RequestParam(required = false) String category) {
        List<PostDTO> list;
        if (category == null)
            list = postService.getList(-1);
        else {
            list = postService.getList(Integer.parseInt(category));
            req.setAttribute("category", categoryService.get(Integer.parseInt(category)));
        }
        List<CategoryDTO> categories = categoryService.getList();
        req.setAttribute("post_list", list);
        req.setAttribute("categories", categories);
        return "blog/post_list";
    }

    @GetMapping("/detail")
    public String blog_detail(HttpServletRequest req, @RequestParam int id) {
        PostDTO post = postService.get(id);
        CategoryDTO category = categoryService.get(post.getCategory());
        List<CategoryDTO> categories = categoryService.getList();
        List<CommentDTO> comments = commentService.getList(id);
        req.setAttribute("category", category);
        req.setAttribute("post", post);
        req.setAttribute("categories", categories);
        req.setAttribute("comments", comments);
        return "blog/post_detail";
    }

    @PostMapping("/comment_write")
    public String blog_comment_write(HttpServletRequest req, @ModelAttribute CommentDTO dto) {
        int res = commentService.insert(dto);
        if (res > 0)
            req.setAttribute("msg", "답변을 등록했습니다.");
        else
            req.setAttribute("msg", "답변을 등록하지 못했습니다. 다시 시도해 주세요.");
        req.setAttribute("url", "/blog/detail?id=" + dto.getPost() + "#comment");
        return "message";
    }

    @GetMapping("/comment_delete")
    public String blog_comment_delete(HttpServletRequest req, @RequestParam int post, @RequestParam int id) {
        int res = commentService.delete(id);
        if (res > 0)
            req.setAttribute("msg", "답변을 삭제했습니다.");
        else
            req.setAttribute("msg", "답변을 삭제하지 못했습니다. 다시 시도해 주세요.");
        req.setAttribute("url", "/blog/detail?id=" + post + "#comment");
        return "message";
    }

}
