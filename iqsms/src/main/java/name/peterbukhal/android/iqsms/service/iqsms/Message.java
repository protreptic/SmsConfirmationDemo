package name.peterbukhal.android.iqsms.service.iqsms;

/**
 * Created on 15/09/16 by
 *
 * @author Peter Bukhal (petr@taxik.ru)
 */
public final class Message {

    private final String clientId;
    private final String phone;
    private final String text;

    public Message(String clientId, String phone, String text) {
        this.clientId = clientId;
        this.phone = phone;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (clientId != null ? !clientId.equals(message.clientId) : message.clientId != null)
            return false;
        if (phone != null ? !phone.equals(message.phone) : message.phone != null) return false;
        return text != null ? text.equals(message.text) : message.text == null;

    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    public String getClientId() {

        return clientId;
    }

    public String getPhone() {
        return phone;
    }

    public String getText() {
        return text;
    }

}
