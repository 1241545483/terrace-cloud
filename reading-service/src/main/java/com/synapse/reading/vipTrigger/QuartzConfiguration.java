package com.synapse.reading.vipTrigger;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;




@Configuration
@ConditionalOnProperty(name = "task.switch", havingValue = "true")
public class QuartzConfiguration {

    // 配置定时任务
    @Bean(name = "vipDetail")
    public MethodInvokingJobDetailFactoryBean vipDetail(Vip vip) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        // 是否并发执行
        jobDetail.setConcurrent(true);
        // 为需要执行的实体类对应的对象
        jobDetail.setTargetObject(vip);
        // 需要执行的方法
        jobDetail.setTargetMethod("task");
        return jobDetail;
    }

    // 配置触发器
    @Bean(name = "vipTrigger")
    public CronTriggerFactoryBean vipTrigger(JobDetail vipDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(vipDetail);
        // cron表达式
//       trigger.setCronExpression("30 10 1 * * ?");
        trigger.setCronExpression("0 */1 * * * ?");
        return trigger;
    }

    // 配置Scheduler
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger vipTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 延时启动，应用启动1秒后
        bean.setStartupDelay(1);
        // 注册触发器
        bean.setTriggers(vipTrigger);
        return bean;
    }
}
