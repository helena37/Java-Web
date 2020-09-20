package bg.hristoskova.blog.service.impl;

import bg.hristoskova.blog.exception.PostNotFoundException;
import bg.hristoskova.blog.model.Post;
import bg.hristoskova.blog.model.binding.PostDto;
import bg.hristoskova.blog.repository.PostRepository;
import bg.hristoskova.blog.service.AuthService;
import bg.hristoskova.blog.service.PostService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final AuthService authService;
    private final PostRepository postRepository;

    public PostServiceImpl(AuthService authService, PostRepository postRepository) {
        this.authService = authService;
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User username = this.authService
                .getCurrentUser()
                .orElseThrow(() -> new IllegalArgumentException("No user logged in"));
        post.setUsername(username.getUsername());
        post.setCreatedOn(Instant.now());

        this.postRepository.save(post);
    }

    @Override
    public List<PostDto> showAllPosts() {
        List<Post> posts = this.postRepository.findAll();

        return posts
                .stream()
                .map(this::mapFromPostToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUsername(post.getUsername());

        return postDto;
    }

    @Override
    public Post mapFromDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        User loggedInUser = this.authService
                .getCurrentUser()
                .orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        post.setCreatedOn(Instant.now());
        post.setUsername(loggedInUser.getUsername());
        post.setUpdatedOn(Instant.now());

        return post;
    }

    @Override
    public Post findById(Long id) {
        return this.postRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        this.postRepository.deleteById(id);
    }


    @Override
    public PostDto readSinglePost(Long id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));

        return mapFromPostToDto(post);
    }
}
