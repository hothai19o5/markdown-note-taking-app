package learn.markdownnotetakingapp.controller

import learn.markdownnotetakingapp.dto.GrammarCheckRequest
import learn.markdownnotetakingapp.service.GrammarCheckService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class GrammarController {
    @Autowired
    GrammarCheckService grammarCheckService

    @PostMapping("/check-grammar")
    ResponseEntity checkGrammar(@RequestBody GrammarCheckRequest request) {
        if (!request) {
            return ResponseEntity.badRequest().body("Invalid request")
        }

        return ResponseEntity.ok("Grammar check feature is under development.")
    }
}
