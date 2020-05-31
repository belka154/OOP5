import java.io.Serializable;

public class Request implements Serializable {

    private Type type;
    private Serializable payload;

    public Request (Type type, Serializable payload){
        this.type = type;
        this.payload = payload;
    }

    public Type getType() {
        return type;
    }

    public Serializable getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type=" + type +
                ", payload=" + payload +
                '}';
    }
}
