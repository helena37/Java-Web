package bg.hristoskova.blog.web;

import bg.hristoskova.blog.model.Post;
import bg.hristoskova.blog.model.binding.PostDto;
import bg.hristoskova.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts/")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity createBlogPost(@RequestBody PostDto postDto) {
        this.postService.createPost(postDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(this.postService.showAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(this.postService.readSinglePost(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable @RequestBody Long id) {
        Post post = this.postService.findById(id);

        if (post == null) {
            return ResponseEntity.notFound().build();
        }

        this.postService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
