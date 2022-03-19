package br.mba.fiap.abctech.abctechservice.service.impl;

import br.mba.fiap.abctech.abctechservice.model.Assistance;
import br.mba.fiap.abctech.abctechservice.repository.AssistanceRepository;
import br.mba.fiap.abctech.abctechservice.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistanceServiceImpl implements AssistanceService {

    private final AssistanceRepository repository;

    public AssistanceServiceImpl(@Autowired AssistanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Assistance> getAssistsList() {
        return this.repository.findAll();
    }
}
