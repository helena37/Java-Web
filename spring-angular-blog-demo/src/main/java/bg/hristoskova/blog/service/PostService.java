package bg.hristoskova.blog.service;

import bg.hristoskova.blog.model.Post;
import bg.hristoskova.blog.model.binding.PostDto;

import java.util.List;

public interface PostService {
    void createPost(PostDto postDto);
    List<PostDto> showAllPosts();
    PostDto readSinglePost(Long id);
    Post save(Post post);

    PostDto mapFromPostToDto(Post post);
    Post mapFromDtoToPost(PostDto postDto);

    Post findById(Long id);

    void deleteById(Long id);
}
