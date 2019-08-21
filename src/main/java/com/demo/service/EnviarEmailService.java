package com.demo.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * SendMailService
 */
public class EnviarEmailService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Enviar rechazo al autor");
	}

}
