import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class MySpringBatchMain {

    @Bean
    public ItemReader<Integer> reader() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        return new ListItemReader<>(data);
    }

    @Bean
    public ItemProcessor<Integer, Integer> processor() {
        return item -> item * 2;
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory, ItemReader<Integer> reader, ItemProcessor<Integer, Integer> processor) {
        return stepBuilderFactory
                .get("step1")
                .<Integer, Integer>chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(list -> {
                    for (Integer item : list) {
                        System.out.println("Processed: " + item);
                    }
                })
                .build();
    }

    @Bean
    public Job simpleJob(JobBuilderFactory jobBuilderFactory, Step step) {
        return jobBuilderFactory
                .get("simpleJob")
                .start(step)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(BatchConfiguration.class, args);
    }
}
