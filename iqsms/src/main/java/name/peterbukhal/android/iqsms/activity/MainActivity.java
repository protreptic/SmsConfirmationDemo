package name.peterbukhal.android.iqsms.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import name.peterbukhal.android.iqsms.R;
import name.peterbukhal.android.iqsms.service.IqSmsServiceImpl;
import name.peterbukhal.android.iqsms.service.iqsms.Message;
import name.peterbukhal.android.iqsms.service.iqsms.SendMessagesRequest;
import name.peterbukhal.android.iqsms.service.iqsms.SendMessagesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created on 15/09/16 by
 *
 * @author Peter Bukhal (petr@taxik.ru)
 */
public final class MainActivity extends AppCompatActivity {

    private EditText mEtPhoneNumber;
    private EditText mEtText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.a_main);

        mEtPhoneNumber = (EditText) findViewById(R.id.phone);
        mEtText = (EditText) findViewById(R.id.text);
    }

    private Call<SendMessagesResponse> mSendMessageRequest;

    public void sendMessage(View v) {
        final String phoneNumber = mEtPhoneNumber.getText().toString();
        final String text = mEtText.getText().toString();

        if (!TextUtils.isEmpty(phoneNumber) && !TextUtils.isEmpty(text)) {
            final List<Message> messages = new ArrayList<>();
            messages.add(new Message(phoneNumber, phoneNumber, text));

            mSendMessageRequest = IqSmsServiceImpl.getService().sendMessages(
                    new SendMessagesRequest("z1473873799861", "842746", messages));
            mSendMessageRequest.enqueue(new Callback<SendMessagesResponse>() {

                @Override
                public void onResponse(Call<SendMessagesResponse> call, Response<SendMessagesResponse> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, R.string.message_sent, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, R.string.message_not_sent, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<SendMessagesResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, R.string.message_not_sent, Toast.LENGTH_SHORT).show();
                }

            });
        } else {
            Toast.makeText(MainActivity.this, R.string.enter_phone_number_and_message_text, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mSendMessageRequest != null) {
            mSendMessageRequest.cancel();
        }
    }

}
