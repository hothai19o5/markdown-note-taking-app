package learn.markdownnotetakingapp.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

import java.time.LocalDateTime

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @Column(nullable = false, name="title")
    String title
    @Column(nullable = false, name="content", columnDefinition = "TEXT")
    String content
    @Column(nullable = false, name="created_at")
    LocalDateTime createdAt
    @Column(nullable = false, name="updated_at")
    LocalDateTime updatedAt

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now()
        updatedAt = LocalDateTime.now()
    }

    @PreUpdate
    void onUpdate() {
        updatedAt = LocalDateTime.now()
    }
}
