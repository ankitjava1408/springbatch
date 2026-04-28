package com.ankitjava.springbatch.config;

import com.ankitjava.springbatch.entity.Customer;
import com.ankitjava.springbatch.repository.CustomerRepository;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.batch.infrastructure.item.data.RepositoryItemWriter;
import org.springframework.batch.infrastructure.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.LineMapper;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.infrastructure.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.infrastructure.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.infrastructure.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    private final CustomerRepository customerRepository;

    public SpringBatchConfig(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Bean
    public FlatFileItemReader<Customer> reader(LineMapper<Customer> lineMapper) {
        return new FlatFileItemReaderBuilder<Customer>()
                .name("csvReader")

                // ✅ FIX: FileSystemResource → ClassPathResource
                .resource(new ClassPathResource("customers.csv"))

                .linesToSkip(1)
                .lineMapper(lineMapper)
                .build();
    }

    @Bean
    public LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        tokenizer.setStrict(false);
        tokenizer.setNames(
                "id",
                "firstName",
                "lastName",
                "email",
                "gender",
                "contactNo",
                "country",
                "dob"
        );

        BeanWrapperFieldSetMapper<Customer> mapper = new BeanWrapperFieldSetMapper<>();
        mapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(mapper);

        return lineMapper;
    }

    @Bean
    public CustomerProcessor processor() {
        return new CustomerProcessor();
    }

    @Bean
    public RepositoryItemWriter<Customer> writer() {
        return new RepositoryItemWriterBuilder<Customer>()
                .repository(customerRepository)
                .methodName("save")
                .build();
    }

    @Bean("batchTaskExecutor")
    public AsyncTaskExecutor batchTaskExecutor() {
        SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor("batch-");
        executor.setConcurrencyLimit(10);
        return executor;
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      FlatFileItemReader<Customer> reader,
                      ItemProcessor<Customer, Customer> processor,
                      RepositoryItemWriter<Customer> writer,
                      @Qualifier("batchTaskExecutor") AsyncTaskExecutor taskExecutor) {
        return new StepBuilder("csv-step", jobRepository)
                .<Customer, Customer>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .taskExecutor(taskExecutor)
                .build();
    }

    @Bean
    public Job runJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("importCustomers", jobRepository)
                .start(step1)
                .build();
    }
}