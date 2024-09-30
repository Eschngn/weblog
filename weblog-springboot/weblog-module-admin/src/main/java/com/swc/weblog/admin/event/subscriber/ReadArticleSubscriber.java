package com.swc.weblog.admin.event.subscriber;

import com.swc.weblog.admin.event.ReadArticleEvent;
import com.swc.weblog.common.domain.mapper.ArticleMapper;
import com.swc.weblog.common.domain.mapper.StatisticsArticlePVMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDate;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/23 1:57
 */
@Component
@Slf4j
public class ReadArticleSubscriber  {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private StatisticsArticlePVMapper articlePVMapper;


    @Async("threadPoolTaskExecutor")
    @EventListener
    public void onApplicationEvent(ReadArticleEvent event) {
        // 在这里处理收到的事件，可以是任何逻辑操作
        Long articleId = event.getArticleId();

        // 获取当前线程名称
        String threadName = Thread.currentThread().getName();

        log.info("==> threadName: {}", threadName);
        log.info("==> 文章阅读事件消费成功，articleId: {}", articleId);

        // 执行文章阅读量 +1
        articleMapper.increaseReadNum(articleId);
        log.info("==> 文章阅读量 +1 操作成功，articleId: {}", articleId);

        // 当日文章 PV 访问量 +1
        LocalDate currDate = LocalDate.now();
        articlePVMapper.increasePVCount(currDate);
        log.info("==> 当日文章 PV 访问量 +1 操作成功，date: {}", currDate);
    }


}
