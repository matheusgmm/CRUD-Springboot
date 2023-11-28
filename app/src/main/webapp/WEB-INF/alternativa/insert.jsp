<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Nova Alternativa</title>
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
            <h1>Nova Alternativa</h1>
            <form action="/alternativa/insert" method="post">
                <div class="form-gorup">
                    <label for="questao">Questão</label>
                    <select name="questao" class="form-select">
                        <c:forEach var="c" items="${questoes}">
                            <option value="${c.id}">${c.enunciado}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="texto">Texto</label>
                    <input type="text" name="texto" class="form-control">
                </div>

                <div class="form-group">
                    <label for="isCorreta">Correta ?</label>
                    <select name="isCorreta" class="form-select">
                        <option value="true">Sim</option>
                        <option value="false">Não</option>
                    </select>
                </div>

                <br />
                <a href="/alternativa/list" class="btn btn-primary">Voltar</a>
                <button type="submit" class="btn btn-success">Salvar</button>            
            </form>
        </div>
    </body>
</html>