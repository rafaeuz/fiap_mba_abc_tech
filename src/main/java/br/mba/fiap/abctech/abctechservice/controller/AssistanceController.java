package br.mba.fiap.abctech.abctechservice.controller;

import br.mba.fiap.abctech.abctechservice.model.Assistance;
import br.mba.fiap.abctech.abctechservice.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3306")
@RestController
@RequestMapping("/assistance")
public class AssistanceController {

    private final AssistanceService assistanceService;
    public AssistanceController (
            @Autowired
                    AssistanceService assistanceService
    ){
        this.assistanceService = assistanceService;
    }

    @GetMapping()
    public ResponseEntity<List<Assistance>> getAssists() {
        List<Assistance> list = this.assistanceService.getAssistsList();
        return ResponseEntity.ok(list);
    }
}