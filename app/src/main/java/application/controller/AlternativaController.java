package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Alternativa;
import application.model.Questao;
import application.repository.AlternativaRepository;
import application.repository.QuestaoRepository;

@Controller
@RequestMapping("/alternativa")
public class AlternativaController{
    @Autowired
    private AlternativaRepository alternativaRepo;
    @Autowired
    private QuestaoRepository questaoRepo;

    private static final String REDIRECT_LIST = "redirect:/alternativa/list";

    // Método para listar todas as Alternativas -----
    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("alternativas", alternativaRepo.findAll());
        return "alternativa/list";
    }

    //Método para prepar os dados da Questão para criar uma nova Alternativa -----
    @RequestMapping("/insert")
    public String insert(Model ui){
        ui.addAttribute("questoes", questaoRepo.findAll());
        return "alternativa/insert";
    }

    // Método para criar uma nova Alternativa -----
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
            @RequestParam("questao") long questao,
            @RequestParam("texto") String texto,
            @RequestParam("isCorreta") String isCorreta
    ) {
        boolean isCorretaBoolean = Boolean.parseBoolean(isCorreta);
        
        Alternativa alternativa = new Alternativa();
        alternativa.setTexto(texto);
        alternativa.setIsCorreta(isCorretaBoolean);
        alternativa.setQuestao(questaoRepo.findById(questao).get());
        
        alternativaRepo.save(alternativa);
        
        return REDIRECT_LIST;
    }

    //Método para chamara a rota para atualizar uma Alternativa -----
    @RequestMapping("/update")
    public String update(
        @RequestParam("id") long id,
        Model ui
    ) {  
        Optional<Alternativa> alternativa = alternativaRepo.findById(id);
        if(alternativa.isPresent()) {
            ui.addAttribute("alternativa", alternativa.get());
            return "alternativa/update";
        }
        return REDIRECT_LIST;
    }

    // Método para atualizar uma Alternativa -----
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
            @RequestParam("id") long id,
            @RequestParam("texto") String texto,
            @RequestParam("isCorreta") String isCorreta
    ) {
        Optional<Alternativa> alternativaOptional = alternativaRepo.findById(id);

        alternativaOptional.ifPresent(alternativa -> {
            boolean isCorretaBoolean = Boolean.parseBoolean(isCorreta);
            alternativa.setTexto(texto);
            alternativa.setIsCorreta(isCorretaBoolean);

            alternativaRepo.save(alternativa);
        });

        return REDIRECT_LIST;
    }

    // Método para chamar a rota para deletar uma Alternativa -----
    @RequestMapping("/delete")
    public String delete(
            @RequestParam("id") long id,
            Model ui
    ) {
        Optional<Alternativa> alternativa = alternativaRepo.findById(id);

        if (alternativa.isPresent()) {
            ui.addAttribute("alternativa", alternativa.get());
            return "alternativa/delete";
        }

        return REDIRECT_LIST;
    }

    // Método para deletar uma Alternativa -----
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        alternativaRepo.deleteById(id);
        return REDIRECT_LIST;
    }
}