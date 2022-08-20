package com.example.controller;

import com.example.dto.CategoryDTO;
import com.example.dto.CommentDTO;
import com.example.dto.PostDTO;
import com.example.service.CategoryService;
import com.example.service.CommentService;
import com.example.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/blog")
@Log4j2
public class AdminBlogController {
    @Autowired
    PostService postService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CommentService commentService;

    @GetMapping("")
    public String admin_post_home() {
        return "admin/blog/base";
    }

    @GetMapping("/post_list")
    public String admin_post_list(HttpServletRequest req) {
        List<PostDTO> list = postService.getList(-1);
        req.setAttribute("post_list", list);
        return "admin/blog/post_list";
    }

    @GetMapping("/post_write")
    public String admin_post_write(HttpServletRequest req) {
        List<CategoryDTO> list = categoryService.getList();
        req.setAttribute("categories", list);
        return "admin/blog/post_write";
    }

    @PostMapping("/post_write")
    public String admin_post_write(HttpServletRequest req, PostDTO dto) {
        int res = postService.insert(dto);
        if (res > 0)
            req.setAttribute("msg", "게시물 등록 성공! 게시물 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "게시물 등록 실패... 게시물 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/blog/post_list");
        return "message";
    }

    @GetMapping("/post_detail")
    public String admin_post_detail(HttpServletRequest req, @RequestParam int id) {
        PostDTO post = postService.get(id);
        CategoryDTO category = categoryService.get(post.getCategory());
        req.setAttribute("post", post);
        req.setAttribute("category", category);
        return "admin/blog/post_detail";
    }

    @GetMapping("/post_update")
    public String admin_post_update(HttpServletRequest req, @RequestParam int id) {
        PostDTO post = postService.get(id);
        List<CategoryDTO> categories = categoryService.getList();
        req.setAttribute("post", post);
        req.setAttribute("categories", categories);
        return "admin/blog/post_update";
    }

    @PostMapping("/post_update")
    public String admin_post_update(HttpServletRequest req, @ModelAttribute PostDTO dto) {
        int res = postService.update(dto);
        if (res > 0)
            req.setAttribute("msg", "게시물 수정 성공! 게시물 상세 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "게시물 수정 실패... 게시물 상세 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/blog/post_detail?id=" + dto.getId());
        return "message";
    }

    @GetMapping("/post_delete")
    public String admin_post_delete(HttpServletRequest req, @RequestParam int id) {
        int res = postService.delete(id);
        if (res > 0)
            req.setAttribute("msg", "게시물 삭제 성공! 게시물 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "게시물 수정 실패... 게시물 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/blog/post_list");
        return "message";
    }

    @GetMapping("/comment_list")
    public String admin_comment_list(HttpServletRequest req) {
        List<CommentDTO> comment_list = commentService.getList();
        req.setAttribute("comment_list", comment_list);
        return "admin/blog/comment_list";
    }

    @GetMapping("/comment_write")
    public String admin_comment_write() {
        return "admin/blog/comment_write";
    }

    @PostMapping("/comment_write")
    public String admin_comment_write(HttpServletRequest req, @ModelAttribute CommentDTO dto) {
        int res = commentService.insert(dto);
        if (res > 0)
            req.setAttribute("msg", "답변 등록 성공! 답변 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "답변 등록 실패... 답변 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/blog/comment_list");
        return "message";
    }

    @GetMapping("/comment_detail")
    public String admin_comment_detail(HttpServletRequest req, @RequestParam int id) {
        CommentDTO comment = commentService.get(id);
        req.setAttribute("comment", comment);
        return "admin/blog/comment_detail";
    }

    @GetMapping("/comment_update")
    public String admin_comment_update(HttpServletRequest req, @RequestParam int id) {
        CommentDTO comment = commentService.get(id);
        req.setAttribute("comment", comment);
        return "admin/blog/comment_update";
    }

    @PostMapping("/comment_update")
    public String admin_comment_update(HttpServletRequest req, @ModelAttribute CommentDTO dto) {
        int res = commentService.update(dto);
        if (res > 0)
            req.setAttribute("msg", "답변 수정 성공! 답변 상세 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "답변 수정 실패... 답변 상세 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/blog/comment_detail?id=" + dto.getId());
        return "message";
    }

    @GetMapping("/comment_delete")
    public String admin_comment_delete(HttpServletRequest req, @RequestParam int id) {
        int res = commentService.delete(id);
        if (res > 0)
            req.setAttribute("msg", "답변 삭제 성공! 답변 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "답변 수정 실패... 답변 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/blog/comment_list");
        return "message";
    }
}
