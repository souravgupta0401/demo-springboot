package io.javabrains.springbootstarter.topic;


import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;


@Configuration
	@EnableDynamoDBRepositories
	    (basePackages = "TopicRepository.java")
	public class DynamoDBConfig {
	@Value("${amazon.dynamodb.endpoint}")
    String endpoint;
    @Value("${amazon.aws.accesskey}")
    String accesskey;
    @Value("${amazon.aws.secretkey}")
    String secretkey;
    @Value("${amazon.aws.region}")
    String region;

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(amazonDynamoDB1());
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB1() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(endpointConfiguration())
                .withCredentials(awsCredentialsProvider())
                .build();
    }
	  @Bean(destroyMethod = "shutdown")
	    public AmazonDynamoDB amazonDynamoDB() {
	        return AmazonDynamoDBClientBuilder.standard()
	                .withEndpointConfiguration(endpoint("localhost", "us-east-1", 4569))
	                .build();
	    }

	  public AwsClientBuilder.EndpointConfiguration endpointConfiguration() {
	        return new AwsClientBuilder.EndpointConfiguration(endpoint, region);
	    }

	    public AWSCredentialsProvider awsCredentialsProvider() {
	        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accesskey, secretkey));
	    }
	    private AwsClientBuilder.EndpointConfiguration endpoint(String host, String region, int port) {
	        return new AwsClientBuilder.EndpointConfiguration("http://" + host + ":" + port, region);
	    }
}