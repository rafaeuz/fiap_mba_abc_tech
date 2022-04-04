package br.mba.fiap.abctech.abctechservice.application;

import br.mba.fiap.abctech.abctechservice.application.dto.AssistDto;

import java.util.List;

public interface AssistanceApplication {

    public List<AssistDto> getAssists();
}
