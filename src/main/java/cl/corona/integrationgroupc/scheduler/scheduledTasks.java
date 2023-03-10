package cl.corona.integrationgroupc.scheduler;

import cl.corona.integrationgroupc.setService.setDownload;
import cl.corona.integrationgroupc.setService.setUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class scheduledTasks {
    private static final Logger LOG = LoggerFactory.getLogger(scheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    private setDownload setdownload;

    @Autowired
    private setUpload setupload;

    @Scheduled(cron = "${cron.expression}")
    public void scheduledJob() throws InterruptedException, IOException {

        LOG.info("{} : Inicio transferencia de archivos",
                dateTimeFormatter.format(LocalDateTime.now()));

        setdownload.DownloadFile();
        setupload.UploadFile();

        LOG.info("{} : Fin transferencia de archivos",
                dateTimeFormatter.format(LocalDateTime.now()));

    }
}
