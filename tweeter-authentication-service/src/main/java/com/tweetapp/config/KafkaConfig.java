package com.tweetapp.config;


//import com.tweetapp.model.User;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaConfig {
//
//    @Bean
//    public KafkaTemplate<String, String> tweetKafkaTemplate() {
//        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerConfigs()));
//    }
//
//    @Bean
//    public KafkaTemplate<String, User> userKafkaTemplate() {
//        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerConfigs()));
//    }
//
//
//    private Map<String, Object> producerConfigs() {
//
//        System.out.println("\n\n------successfully connected---------\n\n");
//
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return props;
//    }
//}
