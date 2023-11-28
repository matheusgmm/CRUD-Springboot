package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Quiz;
import application.repository.QuizRepository;

@Controller
@RequestMapping("/quiz")
public class QuizController{
    @Autowired
    private QuizRepository quizRepo;

    private static final String REDIRECT_LIST = "redirect:/quiz/list";

    //Método para listar todos os Quizzes -----
    @RequestMapping("/list")
    public String list(Model ui){
        ui.addAttribute("quiz", quizRepo.findAll());
        return "quiz/list";
    }

    //Método para chamar a rota para criar um novo Quiz -----
    @RequestMapping("/insert")
    public String insert() {
        return "quiz/insert";
    }

    //Método para criar um novo Quiz -----
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome, Model model){
        try{
            Quiz quiz = new Quiz();
            quiz.setNome(nome);

            quizRepo.save(quiz);

            return REDIRECT_LIST;
        }catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("erro", "Erro ao salvar o quiz. Por favor, tente novamente.");
            
            return "quiz/insert";
        }
        
    }

    //Método para chamar a rota para atualizar um Quiz -----
    @RequestMapping("/update")
    public String update(
        @RequestParam("id") long id,
        Model ui
    ){
        Optional<Quiz> quiz = quizRepo.findById(id);

        if(quiz.isPresent()){
            ui.addAttribute("quiz", quiz.get());
            return "quiz/update";
        }
        return REDIRECT_LIST;
    }

    //Método para atualizar um Quiz -----
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("nome") String nome 
    ) {
        
        Optional<Quiz> quiz = quizRepo.findById(id);

        if(quiz.isPresent()) {
            quiz.get().setNome(nome);

            quizRepo.save(quiz.get());
        }
            
        return REDIRECT_LIST;
    }

    //Método para chamar a rota para deletar um Quiz -----
    @RequestMapping("/delete")
    public String delete(
        @RequestParam("id") long id,
        Model ui
    ){
        Optional<Quiz> quiz = quizRepo.findById(id);

        if(quiz.isPresent()){
            ui.addAttribute("quiz", quiz.get());
            return("quiz/delete");
        }

        return REDIRECT_LIST;
    }

    //Método para deletar um Quiz -----
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id){
        quizRepo.deleteById(id);
        return REDIRECT_LIST;
    }
}