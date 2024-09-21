package com.jornada.mentoria.mentoriaapi.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component // quem vai gerenciar é o spring
@Slf4j // Logs
public class AgendamentoTeste {

    private static final SimpleDateFormat dateFormart = new SimpleDateFormat("HH:mm:ss");
//    @Scheduled(fixedRate = 5000)
//    public void notificarNaoPagamento() {
//       log.info("Notificação de não pagamento... {}", dateFormart.format(new Date()));
//    }
//
//    @Scheduled(fixedDelay = 5000)
//    public void notificarNaoPagamentoDelay() throws InterruptedException {
//        Thread.sleep((3000));
//        log.info("Notificação de não pagamento com delay... {}", dateFormart.format(new Date()));
//    }
//
//    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
//    public void notificarNaoPagamentoInicialDelay() throws InterruptedException {
//        log.info("Notificação de não pagamento inicial com delay... {}", dateFormart.format(new Date()));
//    }
//
//    @Scheduled(cron = "*/10 * * * * *")
//    public void notificarNaoPagamentoInicialCron() throws InterruptedException {
//        log.info("Notificação de não pagamento inicial com delay... {}", dateFormart.format(new Date()));
//    }

}
