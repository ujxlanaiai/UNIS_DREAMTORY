package SpringBootDev.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Entity 설정: id, title, content
@Entity     // DB 이름은 ARTICLE
@Getter     // Getter, protected 생성자 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // nullable 허용 여부
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    // Builder 패턴 사용; 그냥 개발 편의
    @Builder
    public Article(Long id, String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}

