package com.alexdft.youtubeRestApi;

import com.alexdft.youtubeRestApi.item.YouTubeCommentItem;
import com.alexdft.youtubeRestApi.item.YouTubeSearchItem;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Comment;
import com.google.api.services.youtube.model.CommentListResponse;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Service
public class YoutubeService {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();

    private static final String YOUTUBE_SEARCH_URL = "https://www.youtube.com/watch?v=";

    private ResourceBundle propertiesBundle = ResourceBundle.getBundle("youtube");

    YouTube youTube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
        @Override
        public void initialize(HttpRequest httpRequest) throws IOException {
        }
    }).build();

    public List<YouTubeCommentItem> getYouTubeComments(String commentId) throws IOException {

        YouTube.Comments.List search = youTube.comments().list("snippet");

        search.setKey(propertiesBundle.getString("youtube.key"));
        search.setFields("items(id,snippet/authorDisplayName,snippet/textOriginal,snippet/likeCount,snippet/publishedAt)");
        search.setId(commentId);

        List<YouTubeCommentItem> result = new ArrayList<>();

        CommentListResponse response = search.execute();
        List<Comment> searchResultList = response.getItems();

        if (searchResultList != null && searchResultList.size() > 0) {
            for (Comment searchResult : searchResultList) {
                YouTubeCommentItem item = new YouTubeCommentItem(
                        searchResult.getSnippet().getAuthorDisplayName(),
                        searchResult.getSnippet().getTextOriginal(),
                        searchResult.getSnippet().getLikeCount().toString(),
                        searchResult.getSnippet().getPublishedAt().toString());
                result.add(item);
            }
        }
        return result;
    }

    public List<YouTubeSearchItem> getYoutubeSearch(String searchQuery) throws IOException {

        YouTube.Search.List search = youTube.search().list("id,snippet");

        search.setKey(propertiesBundle.getString("youtube.key"));
        search.setFields("items(id/kind,id/videoId,snippet/title,snippet/description,snippet/thumbnails/default/url)");
        search.setQ(searchQuery);

        List<YouTubeSearchItem> result = new ArrayList<>();

        SearchListResponse searchResponse = search.execute();
        List<SearchResult> searchResultList = searchResponse.getItems();

        if (searchResultList != null && searchResultList.size() > 0) {

            for (SearchResult searchResult : searchResultList) {
                YouTubeSearchItem item = new YouTubeSearchItem(
                        YOUTUBE_SEARCH_URL + searchResult.getId().getVideoId(),
                        searchResult.getSnippet().getTitle(),
                        searchResult.getSnippet().getThumbnails().getDefault().getUrl(),
                        searchResult.getSnippet().getDescription());
                result.add(item);
            }
        }
        return result;
    }
}
