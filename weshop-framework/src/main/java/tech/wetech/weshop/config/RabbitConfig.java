package tech.wetech.weshop.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${message.queue.footprint}")
    private String footprintQueue;

    /**
     * 用户足迹的队列
     *
     * @return
     */
    @Bean
    public Queue footprintQueue() {
        return new Queue(footprintQueue);
    }

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

}
