package com.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.demo.model.Approval;
import com.demo.model.Article;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ArticuloWorkflowService
 */
@Service
public class ArticuloWorkflowService {

    private RuntimeService runtimeService;
    private TaskService taskService;

    public ArticuloWorkflowService(RuntimeService runtimeService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    @Transactional
    public void iniciarProceso(Article article) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("author", article.getAuthor());
        variables.put("url", article.getUrl());
        runtimeService.startProcessInstanceByKey("articleReview", variables);
    }

    @Transactional
    public List<Article> getTareas(String asignado) {
        List<Task> tareas = taskService.createTaskQuery()
            //.taskCandidateGroup(asignado)
            .list();
        return tareas.stream().map(task -> {
            Map<String, Object> variables = taskService.getVariables(task.getId());
            return new Article(task.getId(), (String) variables.get("author"), (String) variables.get("url"));
        }).collect(Collectors.toList());
    }

    @Transactional
    public void submitReview(Approval approval) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("approved", approval.isStatus());
        taskService.complete(approval.getId(), variables);
    }

}
