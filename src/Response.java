import java.io.Serializable;

public class Response implements Serializable{
    private Serializable payload;

    public Response(Serializable payload) {
        this.payload = payload;
    }

    public Serializable getPayload() {
        return payload;
    }

}
