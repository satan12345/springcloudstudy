package com.able.springcloud.service.impl;

import cn.hutool.core.convert.impl.UUIDConverter;
import cn.hutool.core.lang.UUID;
import com.able.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/** 定义消息推送管道 源
 * @param
 * @author jipeng
 * @date 2020-03-31 18:39
 */

@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {
    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String serial= UUID.fastUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("serial= {}",serial);
        return null;
    }
}

