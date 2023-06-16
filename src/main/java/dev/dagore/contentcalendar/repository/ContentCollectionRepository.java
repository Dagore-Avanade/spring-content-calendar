package dev.dagore.contentcalendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.dagore.contentcalendar.model.Content;
import dev.dagore.contentcalendar.model.Status;
import dev.dagore.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {
  private final List<Content> contentList = new ArrayList<>();

  public ContentCollectionRepository() {
  }

  public List<Content> findAll() {
    return contentList;
  }

  public Optional<Content> findById(Integer id) {
    return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
  }

  @PostConstruct
  private void init() {
    Content c = new Content(
      1,
      "My first blog post",
      "My first blog post",
      Status.IDEA,
      Type.ARTICLE,
      LocalDateTime.now(),
      null,
      "");
    contentList.add(c);
  }

  public void save(Content content) {
    contentList.removeIf(c -> content.id().equals(c.id()));
    contentList.add(content);
  }

  public boolean exist(Integer id) {
    return contentList
    .stream()
    .filter(content -> content.id().equals(id))
    .count() == 1;
  }

  public void delete(Integer id) {
    contentList.removeIf(content -> content.id().equals(id));
  }
}
