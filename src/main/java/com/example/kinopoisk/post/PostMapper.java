package com.example.kinopoisk.post;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostDTO convertToPostDTO(Post post);

    NewPostDTO convertToNewPostDTO(Post post);

    Post convertNewPostDTOToPost(NewPostDTO newPostDTO);
}
