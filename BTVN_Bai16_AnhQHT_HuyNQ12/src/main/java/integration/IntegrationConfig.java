package integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;

import javax.sql.DataSource;
import java.io.File;

@Configuration
public class IntegrationConfig {

    @Autowired
    private Transformer transformer;

    @Bean(name = "fileHandle")
    public IntegrationFlow integrationFlow() {
        return IntegrationFlows.from(fileReadingMessageSource(),
                spec -> spec.poller(Pollers.fixedDelay(500)))
                .transform(transformer, "transform")
                .handle(fileWriter())
                .get();
    }

    @Bean
    public IntegrationFlow pollingFlow() {
        return IntegrationFlows.from(jdbcAdapter(),
                c -> c.poller(Pollers.fixedDelay(5000)))
                .transform(transformer,"transformFromDB")
                .handle(SQLWriter())
                .get();
    }

    @ConfigurationProperties(prefix = "datasource.postgres")
    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("trunganh")
                .password("ta781996")
                .url("jdbc:postgresql://localhost:5432/jdbctestdb")
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean
    @InboundChannelAdapter(value = "dbChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<?> jdbcAdapter() {
        return new JdbcPollingChannelAdapter(dataSource(),"SELECT name FROM public.person");
    }
//
//    @Bean
//    @ServiceActivator(inputChannel= "fileChannel")
//    public FileWritingMessageHandler fileWriter() {
//        FileWritingMessageHandler handler = new FileWritingMessageHandler(
//                new File("BTVN_Bai16_AnhQHT_HuyNQ12/outputFolder")
//        );
//        handler.setFileNameGenerator(message -> "outputFile.txt");
//        handler.setFileExistsMode(FileExistsMode.REPLACE);
//        handler.setExpectReply(false);
//        return handler;
//    }
//
//
//    @Bean
//    @ServiceActivator(inputChannel= "dbChannel")
//    public FileWritingMessageHandler SQLWriter() {
//        FileWritingMessageHandler handler = new FileWritingMessageHandler(
//                new File("BTVN_Bai16_AnhQHT_HuyNQ12/outputFolder")
//        );
//        handler.setExpectReply(false);
//        handler.setFileNameGenerator(message -> "outputFromDB.txt");
//        return handler;
//    }

    @Bean
    @ServiceActivator(inputChannel= "fileChannel")
    public FileWritingMessageHandler fileWriter() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(
                new File("BTVN_Bai16_AnhQHT_HuyNQ12/outputFolder")
        );
        handler.setExpectReply(false);
        return handler;
    }

    @Bean
    @ServiceActivator(inputChannel= "dbChannel")
    public FileWritingMessageHandler SQLWriter() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(
                new File("BTVN_Bai16_AnhQHT_HuyNQ12/outputFolder")
        );
        handler.setExpectReply(false);
        return handler;
    }


//    @Bean
//    public FileReadingMessageSource fileReader() {
//        FileReadingMessageSource source = new FileReadingMessageSource();
//        source.setDirectory(new File("BTVN_Bai16_AnhQHT_HuyNQ12/inputFolder"));
//        return source;
//    }

    @Bean
    @InboundChannelAdapter(value = "fileChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> fileReadingMessageSource() {
        FileReadingMessageSource sourceReader= new FileReadingMessageSource();
        sourceReader.setDirectory(new File("BTVN_Bai16_AnhQHT_HuyNQ12/inputFolder/"));
        sourceReader.setFilter(new SimplePatternFileListFilter("input1.txt"));
        return sourceReader;
    }

}
