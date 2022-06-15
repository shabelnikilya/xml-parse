package jaxb.exp;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jaxb.exp.model.User;

import java.io.File;

public class MainMarshaller {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("Ilya");
        user.setSecondName("Sh");

        try {
            File file = new File("user_jaxb.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(user, file);
            jaxbMarshaller.marshal(user, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
