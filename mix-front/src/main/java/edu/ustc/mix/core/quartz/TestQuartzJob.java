package edu.ustc.mix.core.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestQuartzJob extends QuartzJobBean {
	
	private Logger logger = LoggerFactory.getLogger(QuartzJobBean.class);
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("execute TestQuartzJob ...");
	}
}
