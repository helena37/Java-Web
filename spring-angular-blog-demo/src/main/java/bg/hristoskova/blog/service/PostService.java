package bg.hristoskova.blog.service;

import bg.hristoskova.blog.model.Post;
import bg.hristoskova.blog.model.binding.PostDto;

import java.util.List;

public interface PostService {
    void createPost(PostDto postDto);
    List<PostDto> showAllPosts();
    PostDto readSinglePost(Long id);

    PostDto mapFromPostToDto(Post post);
    Post mapFromDtoToPost(PostDto postDto);
}