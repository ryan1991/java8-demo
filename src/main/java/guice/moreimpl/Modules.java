package guice.moreimpl;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * 配置
 */
public class Modules extends AbstractModule {

    @Override
    protected void configure() {
        bind(NoticeService.class).annotatedWith(Names.named("email")).to(EmailNoticeService.class);
        bind(NoticeService.class).annotatedWith(Names.named("sms")).to(SmsNoticeService.class);


    }
}
