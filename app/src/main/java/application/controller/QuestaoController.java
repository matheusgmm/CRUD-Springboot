package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Questao;
import application.model.Quiz;
import application.repository.QuestaoRepository;
import application.repository.QuizRepository;


@Controller
@RequestMapping("/questao")
public class QuestaoController{
    @Autowired
    private QuestaoRepository questaoRepo;
    @Autowired
    private QuizRepository quizRepo;

    private static final String REDIRECT_LIST = "redirect:/questao/list";

    //Método para listar todas as Questões -----
    @RequestMapping("/list")
    public String list(Model ui){
        ui.addAttribute("questao", questaoRepo.findAll());
        return "questao/list";
    }

    //Método para prepar os dados do quiz para criar uma nova Questão -----
    @RequestMapping("/insert")
    public String insert(Model ui) {
        ui.addAttribute("quiz", quizRepo.findAll());
        return "questao/insert";
    }

    //Método para criar uma nova Questão -----
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("enunciado") String enunciado,
        @RequestParam("quiz") long quiz,
        Model model
    ){
        try {
            Questao questao = new Questao();
            questao.setEnunciado(enunciado);
            questao.setQuiz(quizRepo.findById(quiz).get());

            questaoRepo.save(questao);

            return ":/questao/list";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("erro", "Erro ao salvar o quiz. Por favor, tente novamente.");
            
            return "/questao/insert";
        }     
    }

    //Método para chamar a rota para atualizar uma Questão -----
    @RequestMapping("/update")
    public String update(
        @RequestParam("id") long id,
        Model ui
    ) {  
        Optional<Questao> questao = questaoRepo.findById(id);
        if(questao.isPresent()) {
            ui.addAttribute("questao", questao.get());
            return "questao/update";
        }
        return REDIRECT_LIST;
    }

    //Método para atualizar uma Questão -----
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("enunciado") String enunciado,
        Model model
    ){
        Optional<Questao> questao = questaoRepo.findById(id);

        if(questao.isPresent()){
            questao.get().setEnunciado(enunciado);  
            questaoRepo.save(questao.get());
        }         

        return REDIRECT_LIST;
    }

    //Método para chamar a rota de deletar uma Questão -----
    @RequestMapping("/delete")
    public String delete(
        @RequestParam("id") long id,
        Model ui
    ){
        Optional<Questao> questao = questaoRepo.findById(id);
        
        if(questao.isPresent()){
            ui.addAttribute("questao", questao.get());
            return("questao/delete");
        }

        return REDIRECT_LIST;
    }

    //Método para deletar uma Questão -----
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id){
        questaoRepo.deleteById(id);

        return REDIRECT_LIST;
    }
}