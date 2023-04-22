package de.johannj.deta;

import de.johannj.deta.module.Base;

public class Main {
    public static void main(String[] args) {
        Deta deta = new Deta("a0yR6s5fyJXW_zhkYoXg8fbuQ3nUwXZvx8weC87GAGmYC");
        Base base = new Base(deta, "Java");

        //System.out.println(base.put(new JsonParser().parse("{\"key\": \"main\", \"value\": \"Hello from Java\"}").getAsJsonObject()));
        //System.out.println(base.get("main"));
        System.out.println(base.delete("vugz5a92us62"));
    }
}

