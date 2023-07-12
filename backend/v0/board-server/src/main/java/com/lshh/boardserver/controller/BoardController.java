package com.lshh.boardserver.controller;

import com.lshh.boardserver.model.dto.BoardBasic;
import com.lshh.boardserver.model.dto.BoardRequest;
import com.lshh.boardserver.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/test")
    public ResponseEntity test(){
        return new ResponseEntity<>("test OK", HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<BoardBasic> list(){
        return boardService.findAll();
    }
    @GetMapping("/list/{pageSize}/{pageNo}")
    public List<BoardBasic> list(@PathVariable int pageSize, @PathVariable int pageNo){
        return boardService.findList(pageSize, pageNo);
    }

    @GetMapping("/view/{idx}")
    public BoardBasic view(@PathVariable int idx){
        return boardService.find(idx);
    }

    @PostMapping("/new")
    public int create(@RequestBody BoardRequest boardRequest){
        return boardService.create(boardRequest);
    }

    @PostMapping("/up")
    public int update(@RequestBody BoardRequest boardRequest){
        return boardService.update(boardRequest);
    }

    @DeleteMapping("/{idx}")
    public int delete(@PathVariable int idx){
        return boardService.delete(idx);
    }
}
