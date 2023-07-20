package SpringBootDev.service;

import SpringBootDev.domain.Article;
import SpringBootDev.dto.AddArticleRequest;
import SpringBootDev.dto.UpdateArticleRequest;
import SpringBootDev.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article save(AddArticleRequest request) {
        return articleRepository.save(request.toEntity());
    }

    // 글 전체 리스트 조회
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    // 글 하나 조회
    public Article findById(long id) {
        return articleRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found" + id));
    }

    // 글 삭제
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }

    //글 수정
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = articleRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
