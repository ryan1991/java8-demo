package guice.moreimpl;

import javax.inject.Singleton;

@Singleton
public class EmailNoticeService implements NoticeService{

    @Override
    public void notice() {
        System.out.println("邮件通知");
    }
}
