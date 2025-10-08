package learn.markdownnotetakingapp.service

import learn.markdownnotetakingapp.dto.NoteDto
import learn.markdownnotetakingapp.entity.Note
import learn.markdownnotetakingapp.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NoteService {
    @Autowired
    NoteRepository noteRepository

    List<Note> getAllNotes() {
        return noteRepository.findAll()
    }

    Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null)
    }

    Note saveNote(NoteDto noteDto) {
        Note note = Note.builder()
                .title(noteDto.title)
                .content(noteDto.content)
                .build()

        return noteRepository.save(note)
    }
}
