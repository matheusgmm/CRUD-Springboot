<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Alternativas</title>
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
                  <a class="nav-link active" aria-current="page" href="../quiz/list">Quizzes</a>
                  <a class="nav-link active" aria-current="page" href="../questao/list">Questões</a>
                  <a class="nav-link active" aria-current="page" href="../alternativa/list">Alternativas</a>
                </div>
              </div>
            </div>
        </nav>
        <div class="container">
            <h1>Lita de Alternativas</h1>
            <a href="/alternativa/insert" class="btn btn-primary">Nova Alternativa</a>

            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Questão</th>
                    <th>Texto</th>
                    <th>Correta</th>
                    <th>&nbsp;</th>
                </tr>

                <c:forEach var="item" items="${alternativas}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.questao.enunciado}</td>
                        <td>${item.texto}</td>
                        <td>${item.isCorreta}</td>
                        <td>
                            <a href="/alternativa/update?id=${item.id}" class="btn btn-warning">Editar</a>
                            <a href="/alternativa/delete?id=${item.id}" class="btn btn-danger">Excluir</a>
                        </td>
                    </tr>          
                </c:forEach>
            </table>
        </div>
    </body>
</html>