package client;

import api.Api;

public class Client {
    private Api api;

    public Client(Api api) {
        this.api = api;
    }

    public void sayHello() {
        this.api
                .variety("[-5, 5] U [6, 10]")
                .variety("(3, 7)")
                .variety("[-2, 4]")
                .variety("");

        System.out.println(this.api.intersection());
        System.out.println(this.api.closestTo(5f));
    }
}
