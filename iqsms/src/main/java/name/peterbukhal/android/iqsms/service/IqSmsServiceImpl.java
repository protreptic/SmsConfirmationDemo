package name.peterbukhal.android.iqsms.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on 15/09/16 by
 *
 * @author Peter Bukhal (petr@taxik.ru)
 */
public final class IqSmsServiceImpl {

    private static IqSmsService sService;

    public static IqSmsService getService() {
        if (sService == null) {
            sService =
                    new Retrofit.Builder()
                            .baseUrl("http://json.gate.iqsms.ru/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create(IqSmsService.class);
        }

        return sService;
    }

}
