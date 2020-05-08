package com.alexdft.youtubeRestApi;

import com.alexdft.youtubeRestApi.item.YoutubeCommentsItem;
import com.alexdft.youtubeRestApi.item.YoutubeSearchItem;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping
public class YoutubeRestController {

    private YoutubeService service;

    public YoutubeRestController() {
        service = new YoutubeService();
    }

    @GetMapping("/search")
    public List<YoutubeSearchItem> searchVideo(@RequestParam String request) throws IOException {
        return service.getYoutubeSearch(request);
    }

    @GetMapping("/comments/{commentId}")
    public List<YoutubeCommentsItem> searchComments(@PathVariable String commentId) throws IOException {
        return service.getYouTubeComments(commentId);
    }
}