package com.nhnacademy.minidooray.taskapi.controller;

import com.nhnacademy.minidooray.taskapi.domain.Tag;
import com.nhnacademy.minidooray.taskapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    @GetMapping
    public List<Tag> getTags() {
        return tagService.getTags();
    }

    @GetMapping("/{id}")
    public Tag getTag(@PathVariable Integer id) {
        return tagService.getTag(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Integer id) {
        tagService.deleteTag(id);
        return "{\"result\":\"s OK\"}";
    }
}
