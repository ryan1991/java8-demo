package guice.moreimpl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class BizService {

    @Inject
    @Named("sms")
    private NoticeService noticeService;

    public void process(){
        noticeService.notice();
    }


}
