package com.nhnacademy.minidooray.taskapi.service;

import com.nhnacademy.minidooray.taskapi.domain.Tag;
import com.nhnacademy.minidooray.taskapi.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTag(Integer id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Integer id) {
        if(!tagRepository.existsById(id)) {
            throw new IllegalArgumentException("id : 태그 " + id + "는 찾을 수 없습니다.");
        }
        tagRepository.deleteById(id);
    }
}
