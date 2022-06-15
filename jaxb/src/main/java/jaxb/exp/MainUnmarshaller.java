package jaxb.exp;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import jaxb.exp.model.User;

import java.io.File;

public class MainUnmarshaller {

    public static void main(String[] args) {
        try {
            File file = new File("user_jaxb.xml");
            JAXBContext context = JAXBContext.newInstance(User.class);

            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
            User user = (User) jaxbUnmarshaller.unmarshal(file);

            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
