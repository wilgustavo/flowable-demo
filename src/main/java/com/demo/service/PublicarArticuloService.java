package com.demo.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * PublishArticleService
 */
public class PublicarArticuloService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Publicar articulo aprobado");
	}


}
