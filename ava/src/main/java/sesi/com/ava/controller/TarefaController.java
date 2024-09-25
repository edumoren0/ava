package sesi.com.ava.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sesi.com.ava.model.Tarefa;
import sesi.com.ava.repository.TarefaRepository;


@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public String getAllTarefas(Model model) {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        model.addAttribute("tarefas", tarefas);
        return "tarefas";  
    }

    @GetMapping("/nova")
    public String novaTarefaForm(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        return "nova_tarefa"; 
    }

    @PostMapping
    public String createTarefa(@ModelAttribute Tarefa tarefa) {
        tarefa.setDataCriacao(LocalDate.now());
        tarefaRepository.save(tarefa);
        return "redirect:/tarefas";  
    }

    @GetMapping("/excluir/{id}")
    public String deleteTarefa(@PathVariable Long id) {
        tarefaRepository.deleteById(id);
        return "redirect:/tarefas";
    }
}