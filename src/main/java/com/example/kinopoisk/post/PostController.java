package com.example.kinopoisk.post;

import com.example.kinopoisk.utils.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper = PostMapper.INSTANCE;

    @GetMapping("/all")
    public List<PostDTO> getAll() {
        return postService.getAll().stream()
                .map(postMapper::convertToPostDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PostDTO getById(@PathVariable("id") long id) throws PostNotFoundException {
        return postMapper.convertToPostDTO(postService.getById(id));
    }

    @PostMapping("/add")
    public void saveNewPost(@RequestBody NewPostDTO newPostDTO) throws PostAlreadyExistException {
        postService.save(postMapper.convertNewPostDTOToPost(newPostDTO));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
        postService.delete(id);
    }

    @PatchMapping("/edit/{id}")
    public void edit(@PathVariable("id") long id, @RequestBody NewPostDTO newPostDTO) throws PostAlreadyExistException {
        Post post = postMapper.convertNewPostDTOToPost(newPostDTO);
        post.setId(id);
        postService.save(post);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> postNotFound(PostNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> postAlreadyExist(PostAlreadyExistException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
