package guice.moreimpl;

import javax.inject.Singleton;

@Singleton
public class SmsNoticeService implements NoticeService {

    @Override
    public void notice() {
        System.out.println("短信通知");
    }
}
