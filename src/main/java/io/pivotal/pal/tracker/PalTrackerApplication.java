
package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.List;

@SpringBootApplication
    public class PalTrackerApplication {

        @Bean
        TimeEntryRepository getTimeEntryRepository(DataSource ds){
            return new JdbcTimeEntryRepository(ds);
        }

        public static void main(String[] args) {
            SpringApplication.run(PalTrackerApplication.class, args);
        }

    }

