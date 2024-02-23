package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.domain.Tag;

import java.util.List;

public interface TagService {

    List<Tag> getTags();

    Tag getTag(Integer id);

    Tag createTag(Tag tag);

    Tag updateTag(Tag tag);

    void deleteTag(Integer id);
}
