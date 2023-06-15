package dev.dagore.contentcalendar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.dagore.contentcalendar.model.Content;
import dev.dagore.contentcalendar.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {
  private final ContentCollectionRepository contentCollectionRepository;
  
  public ContentController(ContentCollectionRepository contentCollectionRepository) {
    this.contentCollectionRepository = contentCollectionRepository;
  }

  @GetMapping("")
  public List<Content> findAll() {
    return this.contentCollectionRepository.findAll();
  }

  @GetMapping("/{id}")
  public Content findById(@PathVariable Integer id) {
    return contentCollectionRepository
      .findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void create(@RequestBody Content content) {
    contentCollectionRepository.save(content);
  }
}
