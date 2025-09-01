package com.samlportal.samlportal.controller;

import com.samlportal.samlportal.DTO.ConversationDTO;
import com.samlportal.samlportal.DTO.PostReq;
import com.samlportal.samlportal.DTO.ReplyDTO;
import com.samlportal.samlportal.model.Post;
import com.samlportal.samlportal.model.Users;
import com.samlportal.samlportal.repository.PostRepository;
import com.samlportal.samlportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/conversation")
public class ConversationController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsersRepository userRepository;


    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody PostReq request) {
        Users user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setId(UUID.randomUUID());
        post.setUser(user);
        post.setMessage(request.getMessage());
        post.setPostRef(request.getParentId());
        post.setCreatedAt(Instant.now());
        postRepository.save(post);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/all")
    public ResponseEntity<List<ConversationDTO>> getAllTopLevelPosts() {
        List<Post> topLevelPosts = postRepository.findByPostRefIsNullOrderByCreatedAtDesc();

        List<ConversationDTO> response = topLevelPosts.stream().map(post -> {
            List<ReplyDTO> replies = postRepository.findByPostRefOrderByCreatedAtAsc(post.getId())
                    .stream().map(reply -> new ReplyDTO(
                            reply.getId(),
                            reply.getMessage(),
                            reply.getCreatedAt(),
                            reply.getUser().getId(),
                            reply.getUser().getName(),
                            reply.getUser().getRole()
                    )).toList();

            return new ConversationDTO(
                    post.getId(),
                    post.getMessage(),
                    post.getCreatedAt(),
                    post.getUser().getId(),
                    post.getUser().getName(),
                    post.getUser().getRole(),
                    replies
            );
        }).toList();

        return ResponseEntity.ok(response);
    }




}

