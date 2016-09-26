package name.peterbukhal.android.iqsms.service.iqsms;

import java.util.Collections;
import java.util.List;

/**
 * Created on 15/09/16 by
 *
 * @author Peter Bukhal (petr@taxik.ru)
 */
public final class SendMessagesRequest {

    private final String login;
    private final String password;
    private final List<Message> messages;

    public SendMessagesRequest(String login, String password, List<Message> messages) {
        this.login = login;
        this.password = password;
        this.messages = Collections.unmodifiableList(messages);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SendMessagesRequest that = (SendMessagesRequest) o;

        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null)
            return false;
        return messages != null ? messages.equals(that.messages) : that.messages == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (messages != null ? messages.hashCode() : 0);
        return result;
    }

}
