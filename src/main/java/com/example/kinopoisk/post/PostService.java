package com.example.kinopoisk.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Transactional
    public void save(Post post) throws PostAlreadyExistException {
        if (postRepository.findByNameIgnoreCase(post.getName()).isPresent())
            throw new PostAlreadyExistException("Post with name=" + post.getName() + " already exist");
        postRepository.save(post);
    }

    @Transactional
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    public Post getById(long id) throws PostNotFoundException {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty())
            throw new PostNotFoundException("Post with id=" + id + " not found");
        return optionalPost.get();
    }
}
