package learn.markdownnotetakingapp.controller

import learn.markdownnotetakingapp.dto.NoteDto
import learn.markdownnotetakingapp.entity.Note
import learn.markdownnotetakingapp.service.MarkdownService
import learn.markdownnotetakingapp.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class NoteController {
    @Autowired
    NoteService noteService

    @Autowired
    MarkdownService markdownService

    @GetMapping("/notes")
    ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes()
        if (notes.isEmpty()) {
            return ResponseEntity.noContent().build()
        }
        return ResponseEntity.ok(notes)
    }

    @GetMapping("/note/{id}/html")
    ResponseEntity<String> renderToHtml(@PathVariable("id") Long id) {
        Note note = noteService.getNoteById(id)
        if (note == null) {
            return ResponseEntity.notFound().build()
        }
        String htmlContent = markdownService.convertToHtml(note.content)
        return ResponseEntity.ok(htmlContent)
    }

    @PostMapping("/save")
    ResponseEntity<Note> saveNote(@RequestBody NoteDto noteDto) {
        if (!noteDto) {
            return ResponseEntity.badRequest().body(null)
        }
        Note savedNote = noteService.saveNote(noteDto)
        return ResponseEntity.ok(savedNote)
    }
}
