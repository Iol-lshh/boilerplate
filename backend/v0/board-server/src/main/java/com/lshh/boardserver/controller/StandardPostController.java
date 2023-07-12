package com.lshh.boardserver.controller;

import com.lshh.boardserver.model.dto.StandardPostBasic;
import com.lshh.boardserver.model.dto.StandardPostRequest;
import com.lshh.boardserver.service.StandardPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/standard_post")
public class StandardPostController {

    @Autowired
    StandardPostService postService;

    @PostMapping("/new")
    public int create(@RequestBody StandardPostRequest standardPostRequest){
        return postService.create(standardPostRequest);
    }

    @PostMapping("/up")
    public int update(@RequestBody StandardPostRequest standardPostRequest){
        return postService.update(standardPostRequest);
    }

    @DeleteMapping("/{idx}")
    public int delete(@PathVariable int idx){
        return postService.delete(idx);
    }

    @GetMapping("/list/{boardIdx}")
    public List<StandardPostBasic> list(@PathVariable int boardIdx){
        return postService.findList(boardIdx);
    }

    @GetMapping("/list/{boardIdx}/{pageSize}/{pageNo}")
    public List<StandardPostBasic> list(@PathVariable int boardIdx, @PathVariable int pageSize, @PathVariable int pageNo){
        return postService.findList(boardIdx, pageSize, pageNo);
    }

    @GetMapping("/view/{idx}")
    public StandardPostBasic view(@PathVariable int idx){
        return postService.find(idx);
    }
}
