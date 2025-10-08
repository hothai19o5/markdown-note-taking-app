package learn.markdownnotetakingapp.repository

import learn.markdownnotetakingapp.entity.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository extends JpaRepository<Note, Long> {

}