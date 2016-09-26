package name.peterbukhal.android.iqsms.service;

import name.peterbukhal.android.iqsms.service.iqsms.SendMessagesRequest;
import name.peterbukhal.android.iqsms.service.iqsms.SendMessagesResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created on 15/09/16 by
 *
 * @author Peter Bukhal (petr@taxik.ru)
 */

public interface IqSmsService {

    @POST("send")
    Call<SendMessagesResponse> sendMessages(@Body SendMessagesRequest request);

}
