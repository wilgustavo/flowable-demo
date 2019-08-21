package com.demo.controller;

import java.util.List;

import com.demo.model.Approval;
import com.demo.model.Article;
import com.demo.service.ArticuloWorkflowService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * ArticuloWorkflowController
 */
@RestController
public class ArticuloWorkflowController {

    private ArticuloWorkflowService workflowService;

    public ArticuloWorkflowController(ArticuloWorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping("/iniciar")
    public void submit(@RequestBody Article article) {
        workflowService.iniciarProceso(article);
    }

    @GetMapping("/tareas")
    public List<Article> listarTareas(@RequestParam String asignado) {
        return workflowService.getTareas(asignado);
    }

    @PostMapping("/revisar")
    public void revisar(@RequestBody Approval approval) {
        workflowService.submitReview(approval);
    }

}
