import api.factories.ApiFactory;
import api.Api;
import client.Client;

public class App {
    public static void main(String[] args) {
        Api api = ApiFactory.create();
        Client client = new Client(api);

        client.sayHello();
    }
}
