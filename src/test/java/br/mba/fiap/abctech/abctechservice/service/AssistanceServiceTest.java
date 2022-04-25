package br.mba.fiap.abctech.abctechservice.service;

import static org.mockito.Mockito.*;

import br.mba.fiap.abctech.abctechservice.handler.exception.MaxAssistsException;
import br.mba.fiap.abctech.abctechservice.handler.exception.MinimumAssistsRequiredException;
import br.mba.fiap.abctech.abctechservice.model.Assistance;
import br.mba.fiap.abctech.abctechservice.model.Order;
import br.mba.fiap.abctech.abctechservice.repository.AssistanceRepository;
import br.mba.fiap.abctech.abctechservice.service.impl.AssistanceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AssistanceServiceTest {

    @Mock
    private AssistanceRepository assistanceRepository;
    private AssistanceService assistanceService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImpl(assistanceRepository);
    }

    @Test
    public void test_list_success(){
        Assistance itemAssist = new Assistance(1L, "Mock Name", "Mock Description");
        Assistance itemAssist2 = new Assistance(2L, "Mock Name 2", "Mock Description 2");

        when(assistanceRepository.findAll()).thenReturn(List.of(itemAssist,itemAssist2));

        List<Assistance> values = assistanceService.getAssistsList();

        Assertions.assertEquals(values.size(), 2);
        Assertions.assertSame(values.get(0), itemAssist);
        Assertions.assertSame(values.get(1), itemAssist2);
    }

    @Test
    public void test_list_id_not_null(){
        Assistance itemAssist = new Assistance(1L, "Mock Name", "Mock Description");
        when(assistanceRepository.findAll()).thenReturn(List.of(itemAssist));
        List<Assistance> values = assistanceService.getAssistsList();
        Assertions.assertNotNull(values.get(0).getId());
    }

    @Test
    public void test_list_name_not_null(){
        Assistance itemAssist = new Assistance(1L, "Mock Name", "Mock Description");
        when(assistanceRepository.findAll()).thenReturn(List.of(itemAssist));
        List<Assistance> values = assistanceService.getAssistsList();
        Assertions.assertNotNull(values.get(0).getName());
    }

    @Test
    public void test_list_description_not_null(){
        Assistance itemAssist = new Assistance(1L, "Mock Name", "Mock Description");
        when(assistanceRepository.findAll()).thenReturn(List.of(itemAssist));
        List<Assistance> values = assistanceService.getAssistsList();
        Assertions.assertNotNull(values.get(0).getDescription());
    }

    @Test
    public void assistance_max_length_name() throws Exception {
        Assistance itemAssist = new Assistance(1L, "M".repeat(100), "Mock Description");
        when(assistanceRepository.findAll()).thenReturn(List.of(itemAssist));
        List<Assistance> values = assistanceService.getAssistsList();
        Assertions.assertTrue(values.get(0).getName().length() <= 100);
    }

    @Test
    public void assistance_max_length_description() throws Exception {
        Assistance itemAssist = new Assistance(1L, "Mock Name", "M".repeat(300));
        when(assistanceRepository.findAll()).thenReturn(List.of(itemAssist));
        List<Assistance> values = assistanceService.getAssistsList();
        Assertions.assertTrue(values.get(0).getDescription().length() <= 300);
    }
}