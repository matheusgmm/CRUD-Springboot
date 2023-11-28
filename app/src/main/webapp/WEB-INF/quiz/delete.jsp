<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Remover Quiz</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">P2 - Java II</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                  <a class="nav-link active" aria-current="page" href="quiz/list">Quizzes</a>
                  <a class="nav-link active" aria-current="page" href="questao/list">Questões</a>
                  <a class="nav-link active" aria-current="page" href="alternativa/list">Alternativas</a>
                </div>
              </div>
            </div>
        </nav>
        
        <div class="container">
            <h1>Remover Quiz</h1>
            <p>Tem certeza que deseja remover o Quiz "${quiz.nome}" ?</p>
            <form action="/quiz/delete" method="post">
                <input type="hidden" name="id" value="${quiz.id}" />
                <br />
                <a href="/quiz/list" class="btn btn-primary">Voltar</a>
                <button type="submit" class="btn btn-danger">Excluir</button>
            </form>
        </div>
    </body>
</html>